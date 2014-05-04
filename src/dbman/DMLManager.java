/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbman;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvMapWriter;
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
            if(this.currTables.get(table).getColumns().containsKey(col)){
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
        String result = null;
        if(table != null){
            if(table_aliases.containsKey(table)){
                table = table_aliases.get(table);
            }
            result = (String) this.currTables.get(table).getColumns().get(col).get("name");
        }else {
            for(Map.Entry<String, MetaTable> currTs : currTables.entrySet()){
                if(currTs.getValue().getColumns().containsKey(col)){
                    result = (String) currTs.getValue().getColumns().get(col).get("name");
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
    
    private List<String> coordinateHeaders(String table, List<String> reqheaders){
        //TOOD: implement
        return null;
        
    }
    
    /**
     * Assumes columns are validated and values are type validated.
     * @param columns
     * @param values
     * @throws ConstrainException 
     */
    public void insert(List<String> columns, List<String> values) throws ConstrainException{
        //TODO: check contrains
        if(this.currTables.size() != 1){
            throw new ConstrainException("Invalid working table: "+this.currTables.keySet());
        }else {
            if(columns.size() != values.size()){
                throw new ConstrainException("Mismatch in number of columns and values: ("+columns+")  "+values);
            }else {
                //Prepare to store in CSV
                Map<String, String> newRow = new LinkedHashMap<>();
                for(int i = 0; i<columns.size(); i++){
                    newRow.put(columns.get(i), values.get(i));
                }
                
                ICsvMapWriter mapWriter = null;
                try {
                        //Locate phycial file
                        String fileURL = "";
                        String [] header = null;
                        for(MetaTable table : this.currTables.values()){
                            fileURL = table.physicalLocation();
                            header = table.getColumns().keySet().toArray(new String[table.getColumns().keySet().size()]);
                        }
                        
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
    }
    
    public static void main(String[] args){
        DMLManager dbm = new DMLManager(new DummyDBObject());
        dbm.workWithTables("ABC");
        
        List<String> cols = new LinkedList<>();
        cols.add("a");
        cols.add("b");
        
        List<String> vals = new LinkedList<>();
        vals.add("5");
        vals.add("6");
        try {
            dbm.insert(cols, vals);
        } catch (ConstrainException ex) {
            Logger.getLogger(DMLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
