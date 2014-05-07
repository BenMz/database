/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbman;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Ben
 */
public class Table implements MetaTable {
    private String name;
    private HashMap<String,JSONObject> columns ; //JSONObject es un HashMap, puede tratarse como tal. El string es el nombre
    private LinkedList<String> PK;
    private String[] orderedColumns;
    private String database;
    private long records;
    private HashMap<String,HashMap<String,String>> pk;
    
    public Table (String name,String database, long records){
        this.name=name;
        this.database = database;
        this.records = records;
        this.PK = new LinkedList();
        
    }
    
    public void setColumns(HashMap<String, JSONObject> columns){
        this.columns = columns;
    }
    
    public List<String> getAllCol(){
        List<String> result = new LinkedList();
        for(Map.Entry<String,JSONObject> pair: this.columns.entrySet()){
            result.add(pair.getKey());
        }
        return result;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addRecord(){
        this.records++;
    }
    
    public void removeRecord(long num){
        this.records-=num;
    }

    public void setDatabase(String database){
        this.database = database;
    }
    
    public long getRecords(){
        return this.records;
    }
    
    @Override
    public String getName() {
       return name; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, JSONObject> getColumns() {
       return columns; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getPK() {
        return PK;//To change body of generated methods, choose Tools | Templates.
    }

    public void setPK(JSONArray columns){
        for (Object column : columns) 
            PK.add((String) column);
    }
    
    @Override
    public String physicalLocation() {
        return "src/db/"+database+"/"+name+".csv";//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getOrderedColumns() {
        return orderedColumns;
        
    }
    
    @Override
    public void setOrderedColumns(JSONArray cols){
       String [] columnas = new String[cols.size()];
       int i = 0;
        for (Iterator it = cols.iterator(); it.hasNext();) {
            JSONObject column = (JSONObject) it.next();
            columnas[i] = (String) column.get("name");
            i++;
        }
        orderedColumns = columnas;
    }

    @Override
    public boolean hasPK(String column, String value) {
       return pk.get(column).containsKey(value); //To change body of generated methods, choose Tools | Templates.
    }
    
}
