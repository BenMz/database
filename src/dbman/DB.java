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
    private HashMap<String,MetaTable> tables;
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
            
            while (iterator2.hasNext()) {
                JSONObject columna = iterator2.next();
                HashMap<String, String> columns = new HashMap();
                columns.put("name", (String) columna.get("name"));
                columns.put("type", (String) columna.get("type"));
                columns.put("notNull", (String) columna.get("notNull"));
                
            }
            
            meta.setColumns(tabla);
            tables.put(meta.getName(), meta);
        }
    }
    
    @Override
    public Map<String, MetaTable> getTables() {
        return tables; //To change body of generated methods, choose Tools | Templates.
    }
    public void createTable(JSONObject table){
        JSONParser parser = new JSONParser();
        
        try {         
            JSONObject obj = (JSONObject) parser.parse(new FileReader("src/db/"+name+".json"));
            JSONArray array = (JSONArray) obj.get("tablas");
            array.add(table);
            obj.put("tablas", array);
            FileWriter file = new FileWriter("src/db/"+name+".json");
            file.write(obj.toJSONString());
            file.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getName(){
        return name;
    }
}
