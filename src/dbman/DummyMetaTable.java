/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbman;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DummyMetaTable
 * @author Jorge Lainfiesta 11142
 * @since Apr 30, 2014
 * @version 1
 */
public class DummyMetaTable implements MetaTable {
    private String name;
    private HashMap<String, String> columns = new HashMap<>();
    
    public DummyMetaTable(String name, char startCol, char endCol){
        this.name = name;
        for(char i = startCol; i < endCol; i++){
            columns.put(i+"", "int");
        }
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Map<String, String> getColumns() {
        return columns;
    }

    @Override
    public List<String> getPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String physicalLocation() {
        return "tables_data/"+this.name+".csv";
    }

}
