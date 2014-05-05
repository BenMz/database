/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbman;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Ben
 */
public class DB implements DBObject {
    private HashMap<String,MetaTable> tables = new HashMap();
    /*
        String-> nombre de la tabla
        LinkedList-> lista de constraints. Cada constraint se guarda como jsonObject
    */
    private HashMap<String,LinkedList<JSONObject>> constraints = new HashMap(); 
    JSONObject jsonObject ;
    String name;
    long records;
    
    
    public DB(String id){
        this.name=id;
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/db/"+id+".json"));  
            this.jsonObject = (JSONObject) obj;
        } catch (IOException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*llenar las tablas*/
        this.records = (long) jsonObject.get("records");
        JSONArray msg = (JSONArray) jsonObject.get("tablas");
        
        Iterator<JSONObject> iterator = msg.iterator();
        
        while (iterator.hasNext()) {
           
            JSONObject tabla = iterator.next();
            Table meta = new Table((String) tabla.get("name"),name, (long) tabla.get("records")); 
            JSONArray columnas = (JSONArray) tabla.get("columns");
            Iterator<JSONObject> iterator2 = columnas.iterator();
             HashMap<String, JSONObject> columns = new HashMap();
            while (iterator2.hasNext()) { 
                JSONObject columna = iterator2.next();
                columns.put((String) columna.get("name"),columna);
            }
            meta.setColumns(columns);
            tables.put(meta.getName(), meta);
        }
        
        //llenar los constraints
        JSONObject allConstraints = (JSONObject) jsonObject.get("constraints");
        Iterator<String> it = allConstraints.keySet().iterator();
        while(it.hasNext()){
            JSONObject constraint = (JSONObject) allConstraints.get(it.next());
            if(!constraints.containsKey(constraint.get("table")))
                constraints.put((String) constraint.get("table"), new LinkedList());
            constraints.get(constraint.get("table")).add(constraint);
            if(constraint.get("type").equals("primary")){ //asignar las primary key
               Table tabla =  (Table) this.tables.get(constraint.get("table"));
               tabla.setPK((JSONArray) constraint.get("columns"));
            }
        }
            
        
    }
    
    @Override
    public Map<String, MetaTable> getTables() {
        return tables; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void createTable(JSONObject table,JSONArray arrayConstraints){
        JSONObject obj = readFile();
        JSONArray array = (JSONArray) obj.get("tablas");
        array.add(table);
        obj.put("tablas", array);
        //constraints
        JSONObject fileConstraints = (JSONObject) obj.get("constraints");
        LinkedList<JSONObject> constraints = new LinkedList();
        Iterator<JSONObject> it = arrayConstraints.iterator();
        while(it.hasNext()){
            JSONObject constraint = it.next();
            constraint.put("table", table.get("name"));
            constraints.add(constraint);
            fileConstraints.put(constraint.get("name"), constraint); 
        }
        obj.put("constraints", fileConstraints);
        this.constraints.put((String) table.get("name"),constraints);
        writeFile("src/db/"+name+".json", obj.toJSONString());
        //agregarlo a la variable
        Table meta = new Table((String) table.get("name"),name, (long) table.get("records")); 

        JSONArray columnas = (JSONArray) table.get("columns");
        Iterator<JSONObject> iterator = columnas.iterator();
        HashMap<String, JSONObject> columns = new HashMap();
        while (iterator.hasNext()) { 
            JSONObject columna = iterator.next();
            columns.put((String) columna.get("name"),columna);
        }

        
        meta.setColumns(columns);
        tables.put(meta.getName(), meta);   
            
 
    }
    
    public void addColumn(String table, JSONObject column){
        JSONObject obj = readFile();
        JSONArray array = (JSONArray) obj.get("tablas");
        JSONArray nuevo = new JSONArray();
        Iterator<JSONObject> iterator = array.iterator();
        while(iterator.hasNext()){
            JSONObject tabla = iterator.next();
            if(tabla.get("name").equals(table)){
                JSONArray columnas = (JSONArray) tabla.get("columns");
                columnas.add(column);
                tabla.put("columns", columnas);
            }
            nuevo.add(tabla);
        }
        obj.put("tablas",nuevo);
        writeFile("src/db/"+name+".json", obj.toJSONString());
        //agreagar a variable
        tables.get(table).getColumns().put((String) column.get("name"), column);
    }
    
    public void dropTable(String table){
        JSONObject obj = readFile();
        JSONArray array = (JSONArray) obj.get("tablas");
        JSONArray nuevo = new JSONArray();
        JSONObject deleted = new JSONObject();
        Iterator<JSONObject> iterator = array.iterator();
        while (iterator.hasNext()) {
            JSONObject tabla = iterator.next();
            if(!tabla.get("name").equals(table))
                nuevo.add(tabla);
            else
                deleted=tabla;
        }      
        
        obj.put("tablas", nuevo);
        
        //restar registros
        long records = (long) obj.get("records");
        obj.put("records",records-(long)deleted.get("records"));
        //borrar constraints de la tabla
        JSONObject allConstraints = (JSONObject) obj.get("constraints");
        Iterator<String> keys = allConstraints.keySet().iterator();
        
        while(keys.hasNext()){
            String key = keys.next();
            JSONObject constraint = (JSONObject) allConstraints.get(key);
            if(constraint.get("table").equals(table))
                allConstraints.remove(key);
            
        }
        obj.put("constraints", allConstraints);
       
        writeFile("src/db/"+name+".json", obj.toJSONString());
       //quitarlo de la variable
        tables.remove(table);
    }
    
    public void dropColumn(String table,String column){
        JSONObject obj = readFile();
        JSONArray array = (JSONArray) obj.get("tablas");
        Iterator<JSONObject> iterator = array.iterator();
        while (iterator.hasNext()) {
            JSONObject tabla = iterator.next();
            if(tabla.get("name").equals(table)){
                JSONArray columnas = (JSONArray) tabla.get("columns");
                JSONArray nuevo = new JSONArray();
                Iterator<JSONObject> iterator2 = columnas.iterator();
                while(iterator2.hasNext()){
                    JSONObject columna = iterator2.next();
                    if(!columna.get("name").equals(column))
                        nuevo.add(columna);
                }
                tabla.put("columns", nuevo);
            }
                
        }  
        //iterar para borrar constraints
        JSONObject allConstraints = (JSONObject) obj.get("constraints");
        Iterator it = allConstraints.keySet().iterator();
        JSONObject newConstraints = (JSONObject) allConstraints.clone();
        LinkedList<JSONObject> nuevaLista = new LinkedList();
        while(it.hasNext()){
            JSONObject constraint = (JSONObject) allConstraints.get(it.next());
            JSONArray columns = (JSONArray) constraint.get("columns");
            if(constraint.get("table").equals(table)){
                if(columns.contains(column)){
                    columns.remove(column);
                    if(columns.size()==0){
                        newConstraints.remove(constraint.get("name"));
                        constraints.remove(constraint.get("name"));
                    }
                }
                    
            }else
                nuevaLista.add(constraint);
        }
        if(nuevaLista.size()>0)
            constraints.put(table, nuevaLista);
        
        obj.put("constraints", newConstraints);
        writeFile("src/db/"+name+".json", obj.toJSONString());
       //quitarlo de la variable
        tables.get(table).getColumns().remove(column);
    }
    
    public void renameTable(String oldID,String newID){
        JSONObject obj = readFile();
        JSONArray array = (JSONArray) obj.get("tablas");
        Iterator<JSONObject> iterator = array.iterator();
        while (iterator.hasNext()) {
            JSONObject tabla = iterator.next();
            if(tabla.get("name").equals(oldID))   {
                tabla.put("name", newID);
                Table meta = (Table) tables.get(oldID);
                meta.setName(newID);
                tables.put(newID,meta);
                break;
            }
        }
        writeFile("src/db/"+name+".json", obj.toJSONString());
        tables.remove(oldID);
    }
    public void addConstraint(String table,JSONObject constraint){
        JSONObject obj = readFile();
        JSONObject constraints = (JSONObject) obj.get("constraints");
        constraints.put(constraint.get("name"), constraint);
        obj.put("constraints",constraints);
        writeFile("src/db/"+name+".json", obj.toJSONString());  
        //agregarlo a la variable
        if(!this.constraints.containsKey(table))
            this.constraints.put(table, new LinkedList());
        this.constraints.get(table).add(constraint);
        if(constraint.get("type").equals("primary")){
            Table tabla = (Table) this.tables.get(table);
            tabla.setPK((JSONArray) constraint.get("columns"));
        }
           
    }
    
    public void dropConstraint(String table, String constraint){
        JSONObject obj = readFile();
        JSONObject constraints = (JSONObject) obj.get("constraints");
        //quitarlo de la variable
        this.constraints.get(table).remove(constraints.get(constraint));
        constraints.remove(constraint);
        obj.put("constraints",constraints);
        writeFile("src/db/"+name+".json", obj.toJSONString());    
        

    }
    
    public JSONObject readFile(){
        JSONParser parser = new JSONParser();
       
        try {
            JSONObject obj = (JSONObject) parser.parse(new FileReader("src/db/"+name+".json"));
            return obj;
        } catch (IOException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;   
        
    }
    
    public void writeFile(String path,String text){
      FileWriter file = null;
        try {
            file = new FileWriter(path);      
            file.write(text);
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public String getName(){
        return name;
    }
    /**
       Primero cambia el nombre de la base de datos, y despues actualiza cada tabla con esta info.
    */
    public void setName(String name){
        this.name=name;
        //renombrar para todas las tablas
        for(Map.Entry<String, MetaTable> table : tables.entrySet()){
           Table tabla = (Table) table.getValue();
           tabla.setDatabase(name);
        }
    }
    
    public boolean checkFK(){
        return false;
    }
    
    public boolean existsConstrain(String id){
        jsonObject = readFile();
        JSONObject listConstraints = (JSONObject) jsonObject.get("constraints");
        return listConstraints.containsKey(id);
    }
    /**
       Mira si hay una columna en uso por un constraint 
     * @param table name of the table
     * @param col name of the column
     * @return returns null if is not in use. Returns the constraint name otherwise.
    */
    public String usingCol(String table,String col){
        if(!constraints.containsKey(table))
            return null;
        LinkedList lista = constraints.get(table);
        Iterator<JSONObject> it = lista.iterator();
        while(it.hasNext()){
            JSONObject obj =it.next();
            String type = (String) obj.get("type");
//            if(type.equals("primary")){
//                JSONArray columnas = (JSONArray) obj.get("columns");
//                if(columnas.contains(col))
//                    return (String) obj.get("name");
//            }
            if(type.equals("foreign") && obj.get("referencedTable").equals(table)){
                JSONArray refCols = (JSONArray) obj.get("referencedColumns");
                if(refCols.contains(col))
                    return (String) obj.get("name");
            }
            // TODO comprobacion para check y foreign
        
        }
        
        return null;
    }
    
    public String usingTable(String table){
        jsonObject = readFile();
        JSONObject allConstraints = (JSONObject) jsonObject.get("constraints");
        Iterator<JSONObject> it = allConstraints.keySet().iterator();
        while(it.hasNext()){
            JSONObject obj =(JSONObject) allConstraints.get(it.next());
            String type = (String) obj.get("type");
//            if(type.equals("primary")){
//                JSONArray columnas = (JSONArray) obj.get("columns");
//                if(columnas.contains(col))
//                    return (String) obj.get("name");
//            }
            if(type.equals("foreign") && obj.get("referencedTable").equals(table)){
                return "Columns "+obj.get("columns")+" references columns "+obj.get("referencedColumns")+" of table "+table;
            }
            // TODO comprobacion para check y foreign
        
        }
        
        return null;
    }
    
    public boolean hasPK(String table){
        if(!tables.containsKey(table))
            return false;
        return (tables.get(table).getPK().size()>0);
    }
}
