/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbman;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.json.simple.JSONObject;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvMapReader;
import org.supercsv.io.CsvMapWriter;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.io.ICsvMapWriter;
import org.supercsv.prefs.CsvPreference;

/**
 * DMLManager
 * @author Jorge Lainfiesta 11142
 * @since Apr 29, 2014
 * @version 1
 */
public class DMLManager {
    private DBObject db;
    private Map<String,MetaTable> currTables = new HashMap<>();
    private LinkedHashMap<String,String> table_aliases = new LinkedHashMap<>();
    /**
     *   
     * @param db 
     */
    public DMLManager(DBObject db){
        this.db = db;
        
        //Create empty files with headers if not already there
        for(MetaTable table : db.getTables().values()){
            File f = new File(table.physicalLocation());
            if(!f.exists()) {
                ICsvMapWriter mapWriter = null;
                try {
                        
                        //Prepare for writing
                        mapWriter = new CsvMapWriter(new FileWriter(table.physicalLocation()),
                                CsvPreference.STANDARD_PREFERENCE);
                        String [] header = table.getColumns().keySet().toArray(new String[table.getColumns().keySet().size()]);

                        CellProcessor[] processors = new CellProcessor[header.length];

                        // write the header
                        mapWriter.writeHeader(header);
                        mapWriter.close();

                } catch (IOException ex) {
                    Logger.getLogger(DMLManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    /**
     * Assumes the tables passed are already validated. If the table
     * does not exists, it will just ignore it without warning.
     * @param tables we'll work with in this transaction
     */
    public void workWithTables(String... tables){
        for(String table : tables){
            if(db.getTables().containsKey(table)){
                currTables.put(table, db.getTables().get(table));
            }
        }
    }
    
    /**
     * 
     * @param table
     * @return True if the table exists on the DB, False if not.
     */
    public boolean existsTable(String table){
        return this.db.getTables().containsKey(table);
    }
    /**
     * Checks for a column existence on the current tables. workWithTables must
     * have been previously called. Assumes table is validated.
     * @param table name of the table for the column, or null if check on any current table
     * @param col name of the column
     * @return -1 if ambiguous column, 0 if does not exists, 1 if it does.
     */
    public int existsColumn(String table, String col){
        int result = 0;
        if(table != null){
            if(table_aliases.containsKey(table)){
                table = table_aliases.get(table);
            }
            MetaTable sel_table = this.currTables.get(table);
            if(sel_table != null && sel_table.getColumns().containsKey(col)){
                result = 1;
            }
        }else {
            for(Map.Entry<String, MetaTable> currTs : currTables.entrySet()){
                if(currTs.getValue().getColumns().containsKey(col)){
                    result += 1;
                }
            }
            result = (result > 1) ? -1 : result;
        }
        return result;
    }
    /**
     * Returns column type on the current tables. workWithTables must
     * have been previously called. Assumes table is validated.
     * @param table name of the table for the column, or null if check on any current table
     * @param col name of the column
     * @return the type as string, null if does not exists, and if col was ambiguous the type of the last found
     */
    public String getColumnType(String table, String col){
        JSONObject result = this.getColumn(table, col);
        return (result == null) ? null : (String) result.get("type");
    }
    
    public JSONObject getColumn(String table, String col){
        JSONObject result = null;
        if(table != null){
            if(table_aliases.containsKey(table)){
                table = table_aliases.get(table);
            }
            result = this.currTables.get(table).getColumns().get(col);
        }else {
            for(Map.Entry<String, MetaTable> currTs : currTables.entrySet()){
                if(currTs.getValue().getColumns().containsKey(col)){
                    result = currTs.getValue().getColumns().get(col);
                }
            }
        }
        return result;
    }
    /**
     * Assumes table is validated.
     * @param talias
     * @param table 
     * @return True if valid, false if talias already existed as an alias or table name in the DB
     */
    public boolean registerTableAlias(String talias, String table){
        if(table_aliases.containsKey(talias) || db.getTables().containsKey(talias)){
            return false;
        }else {
            table_aliases.put(talias, table);
            return true;
        }
    }
    
    private MetaTable getCurrentTable(){
        //Get current table
        MetaTable currTable = null;
        for(MetaTable table : this.currTables.values()){
            currTable = table;
        }
        return currTable;
    }
    
    private String getValType(String val){
        System.out.println("getValType: "+val);
        if(val.matches("[0-9]+")){
            return "INT";
        } else if(val.matches("[0-9]*\\.[0-9]*") && val.length()>1){
            return "FLOAT";
        } else if(val.matches("^(19|20)\\d\\d[\\-\\/.](0[1-9]|1[012])[\\-\\/.](0[1-9]|[12][0-9]|3[01])$")) {
            return "DATE";
        } else {
            return "CHAR";
        }
    }
    
    private String prepareValInsert(String coltype, String value){
        String valtype = this.getValType(value);
        if(coltype.equals(valtype)){
            return value;
        }else if(coltype.equals("INT") && valtype.equals("FLOAT")){
            return value.split("\\.")[0];
        } else if(coltype.equals("FLOAT") && valtype.equals("INT")){
            return value+".00";
        }else {
            return null;
        }
    }
    
    /**
     * Assumes columns are validated and values are type validated.
     * @param columns
     * @param values
     * @return 
     * @throws ConstrainException 
     */
    public int insert(List<String> values, List<String> columns) throws ConstrainException{
        //TODO: check contrains
        int insertedRows = 0;
        if(this.currTables.size() != 1){
            throw new ConstrainException("Invalid working table: "+this.currTables.keySet());
        }else {
            if(columns !=null && columns.size() != values.size()){
                throw new ConstrainException("Mismatch in number of columns and values: ("+columns+")  "+values);
            }else {
                MetaTable currTable = this.getCurrentTable();
                //Locate physical file
                String fileURL = currTable.physicalLocation();
                System.out.println(String.format("Tname: %s, cols: %s", currTable.getName(), currTable.getColumns()));
                String [] header = currTable.getColumns().keySet().toArray(new String[currTable.getColumns().keySet().size()]);
                
                //If it's an implicit column list, we assign them from the originals
                if(columns == null){
                    columns = new LinkedList<>();
                    for(int i = 0; i<values.size(); i++){
                        columns.add(header[i]);
                    }
                }
                //Prepare to store in CSV
                Map<String, String> newRow = new LinkedHashMap<>();
                for(int i = 0; i<columns.size(); i++){
                    String coltype = this.getColumnType(currTable.getName(), columns.get(i));
                    String valinsert = this.prepareValInsert(coltype, values.get(i));
                    if(valinsert == null){
                        throw new ConstrainException(String.format("Incompatible types: column '%s' is type %s and '%s' is %s", columns.get(i), 
                                this.getColumnType(currTable.getName(), columns.get(i)), values.get(i), this.getValType(values.get(i))));
                    }else {
                        newRow.put(columns.get(i),valinsert);
                    }
                    
                }
                
                ICsvMapWriter mapWriter = null;
                try {
                        
                        //Prepare for writing
                        mapWriter = new CsvMapWriter(new FileWriter(fileURL, true),
                                CsvPreference.STANDARD_PREFERENCE);

                        // assign a default value for married (if null), and write numberOfKids as an empty column if null
                        CellProcessor[] processors = new CellProcessor[columns.size()];

                        // write the customer Maps
                        mapWriter.write(newRow, header);
                        mapWriter.close();

                } catch (IOException ex) {
                    Logger.getLogger(DMLManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return insertedRows;
    }
    /**
     * Deletes the rows that evaluate true for the  validation. If the is no validation it deletes every row.
     * @param validation Must be as described
     * @return in the API
     * @throws ConstrainException 
     */
    public int delete(String validation) throws ConstrainException{
        ICsvMapReader mapReader;
        ICsvMapWriter mapWriter;
        int rowsDeleted = 0;
        try {
            MetaTable currTable = getCurrentTable();
            String tempFile = currTable.physicalLocation()+".aux";
            mapReader = new CsvMapReader(new FileReader(currTable.physicalLocation()), CsvPreference.STANDARD_PREFERENCE);
            mapWriter = new CsvMapWriter(new FileWriter(tempFile), CsvPreference.STANDARD_PREFERENCE);
            
            System.out.println(currTable.getName() + currTable.physicalLocation());
            
            // the header columns are used as the keys to the Map
            final String[] header = mapReader.getHeader(true);
            final CellProcessor[] processors =  new CellProcessor[currTable.getColumns().size()];
            mapWriter.writeHeader(header);
            //Si 
            if(validation != null){
                Map<String, Object> rowMap;
                //Mientras haya que leer
                while( (rowMap = mapReader.read(header, processors)) != null ) {
                        System.out.println(String.format("lineNo=%s, rowNo=%s, customerMap=%s", mapReader.getLineNumber(),
                                mapReader.getRowNumber(), rowMap));
                        //Preparamos objeto como lo espera el evalWhere
                        Map<String, Map<String, Object>> data = new HashMap<>();
                        data.put(currTable.getName(), rowMap);
                        //Si no cumple con el while
                        if(!this.evalWhere(validation, data)){
                            mapWriter.write(rowMap, header, processors);
                        }else
                            rowsDeleted++;
                }
            }else{
                Table table = (Table) getCurrentTable();
                rowsDeleted = (int) table.getRecords();
            }
                
            mapWriter.close();
            mapReader.close();
            //Borrar original y Cambiar archivo auxiliar por normal
            File old = new File(currTable.physicalLocation());
            old.delete();
            File newfile = new File(tempFile);
            newfile.renameTo(old);
                
        }
        catch (IOException ex) {
            Logger.getLogger(DMLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsDeleted;
                
    }
    
    public int update(List<String> values, List<String> columns, String validation) throws ConstrainException{
        if(columns.size() != values.size()){
            throw new ConstrainException(String.format("Values passed (%s) do not corresond to the specified columns (%s).", columns.size(), values.size()));
        }
        int updatedRows = 0;
        ICsvMapReader mapReader;
        ICsvMapWriter mapWriter;
        try {
            MetaTable currTable = getCurrentTable();
            String tempFile = currTable.physicalLocation()+".aux";
            mapReader = new CsvMapReader(new FileReader(currTable.physicalLocation()), CsvPreference.STANDARD_PREFERENCE);
            mapWriter = new CsvMapWriter(new FileWriter(tempFile), CsvPreference.STANDARD_PREFERENCE);
            
            System.out.println(currTable.getName() + currTable.physicalLocation());
            
            // the header columns are used as the keys to the Map
            final String[] header = mapReader.getHeader(true);
            final CellProcessor[] processors =  new CellProcessor[currTable.getColumns().size()];
            mapWriter.writeHeader(header);
            
            Map<String, Object> rowMap;
            //Mientras haya que leer
            while( (rowMap = mapReader.read(header, processors)) != null ) {
                    System.out.println(String.format("lineNo=%s, rowNo=%s, customerMap=%s", mapReader.getLineNumber(),
                            mapReader.getRowNumber(), rowMap));

                    //Preparamos objeto como lo espera el evalWhere
                    Map<String, Map<String, Object>> data = new HashMap<>();
                    data.put(currTable.getName(), rowMap);
                    //Si no cumple con el while
                    if(validation == null || this.evalWhere(validation, data)){
                        //Cambiamos los valores de la file para actualizar
                        for(int i = 0; i<columns.size(); i++){
                            if(this.existsColumn(currTable.getName(), columns.get(i))==1){
                                String coltype = this.getColumnType(currTable.getName(), columns.get(i));
                                String valinsert = this.prepareValInsert(coltype, values.get(i));
                                if(valinsert == null){
                                    throw new ConstrainException(String.format("Incompatible types: column '%s' is type %s and '%s' is %s", columns.get(i), 
                                            this.getColumnType(currTable.getName(), columns.get(i)), values.get(i), this.getValType(values.get(i))));
                                }else {
                                    rowMap.put(columns.get(i),valinsert);
                                }
                            }else {
                                throw new ConstrainException(String.format("Columns '%s' does not exists on table '%s'", columns.get(i), currTable.getName()));
                            }
                        }
                    }
                    mapWriter.write(rowMap, header, processors);
            }
            mapWriter.close();
            mapReader.close();
            //Borrar original y Cambiar archivo auxiliar por normal
            File old = new File(currTable.physicalLocation());
            old.delete();
            File newfile = new File(tempFile);
            newfile.renameTo(old);
                
        }
        catch (IOException ex) {
            Logger.getLogger(DMLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return updatedRows;
    }
    
    /**
     * Evaluates a expression according to the API. It evaluates the expression
     * by check the types 
     * @param expr according to the API with full columns name in complete
     * @param values Map got from the DB
     * @return 
     */
    private boolean evalWhere(String expr, Map<String, Map<String, Object>> values) throws ConstrainException{
        
        //We check the patterns in where
        Pattern column_pattern = Pattern.compile( "\\{([^\\. ;]+\\.)?[^\\. ;]+\\}"); //Hace match de cosas como {tabla.columna} o {columna}
        Matcher matcher = column_pattern.matcher(expr);
        //Va a iterar cada elemento que cumpla con patrón
        while(matcher.find()){
            String col = matcher.group();
            String[] col_parts = col.substring(1, col.length()-1).split("\\.");
            //Normalizar col para el regex a reemplazar en la expresión luego
            col = col.replace("{", "\\{").replace("}", "\\}");
            if(col_parts.length == 1){
                //Buscamos en qué tabla está                
                if(this.existsColumn(null, col_parts[0]) == 1){
                    String tname = "";
                    for(Map.Entry<String, MetaTable> currTs : currTables.entrySet()){
                        if(currTs.getValue().getColumns().containsKey(col_parts[0])){
                            tname = currTs.getKey();
                        }
                    }
                    Object replacement = values.get(tname).get(col_parts[0]);
                    expr = expr.replaceAll(col, replacement.toString());
                }else {
                    throw new ConstrainException(String.format("Column '%s' does not exists.", col_parts[0]));
                }
            } else {
                //Vemos por tabla específica
                if(this.existsColumn(col_parts[0], col_parts[1]) == 1){
                    Object replacement = values.get(col_parts[0]).get(col_parts[1]);
                    expr = expr.replaceAll(col, replacement.toString());
                }else {
                    throw new ConstrainException(String.format("Column '%s.%s' does not exists.", col_parts[0], col_parts[1]));
                }
                
            }
        }
        try {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            System.out.println(">>>"+expr);
            Object res = engine.eval(expr);
            System.out.println(res);
            return (boolean) res;
        
        }catch(ScriptException e){
            System.out.println(e);
            throw new ConstrainException("WHERE expression is invalid '"+expr+"'");
        }
    }
    
    public static void main(String[] args){
        DMLManager dbm = new DMLManager(new DB("test"));
        dbm.workWithTables("prueba2");
        
        List<String> cols = new LinkedList<>();
        cols.add("d");
        cols.add("b");
        
        List<String> vals = new LinkedList<>();
        vals.add("15.22");
        vals.add("14");
        
        
        try {
            dbm.update(vals, cols, null);
            //dbm.delete("{MMM.t} < 3");
            //dbm.update(cols, vals, "{a} > 2");
        } catch (ConstrainException ex) {
            Logger.getLogger(DMLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
