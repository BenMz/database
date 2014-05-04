/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbman;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
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
    JSONObject jsonObject ;
    String name;
    
    
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
        JSONArray msg = (JSONArray) jsonObject.get("tablas");
        
        Iterator<JSONObject> iterator = msg.iterator();
        
        while (iterator.hasNext()) {
           
            JSONObject tabla = iterator.next();
            Table meta = new Table((String) tabla.get("name"),name); 
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
        
    }
    
    @Override
    public Map<String, MetaTable> getTables() {
        return tables; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void createTable(JSONObject table){
        JSONObject obj = readFile();
        JSONArray array = (JSONArray) obj.get("tablas");
            array.add(table);
            obj.put("tablas", array);
            writeFile("src/db/"+name+".json", obj.toJSONString());
            //agregarlo a la variable
            Table meta = new Table((String) table.get("name"),name); 
            
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
    
    public void dropTable(String table){
        JSONObject obj = readFile();
        JSONArray array = (JSONArray) obj.get("tablas");
        JSONArray nuevo = new JSONArray();
        Iterator<JSONObject> iterator = array.iterator();
        while (iterator.hasNext()) {
            JSONObject tabla = iterator.next();
            if(!tabla.get("name").equals(table))
                nuevo.add(tabla);
        }      
        obj.put("tablas", nuevo);
        writeFile("src/db/"+name+".json", obj.toJSONString());
       //quitarlo de la variable
        tables.remove(table);
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
}
