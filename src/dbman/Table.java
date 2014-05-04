/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbman;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;

/**
 *
 * @author Ben
 */
public class Table implements MetaTable {
    private String name;
    private HashMap<String,JSONObject> columns ; //JSONObject es un HashMap, puede tratarse como tal. El string es el nombre
    private JSONObject meta;
    private String database;
    
    public Table (String name,String database){
        this.name=name;
        this.database = database;
        
    }
    
    public void setColumns(HashMap<String, JSONObject> columns){
        this.columns = columns;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String physicalLocation() {
        return "src/db/"+database+"/"+name+".csv";//To change body of generated methods, choose Tools | Templates.
    }
    
}
