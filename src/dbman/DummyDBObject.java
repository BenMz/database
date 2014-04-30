/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbman;

import java.util.HashMap;
import java.util.Map;

/**
 * DummyDBObject
 * @author Jorge Lainfiesta 11142
 * @since Apr 30, 2014
 * @version 1
 */
public class DummyDBObject implements DBObject {
    
    private HashMap<String,MetaTable> tables;
    
    public DummyDBObject(){
        tables = new HashMap<>();
        tables.put("ABC",new DummyMetaTable("ABC", 'a', 'c'));
        tables.put("DEF",new DummyMetaTable("DEF", 'd', 'f'));
    }

    @Override
    public Map<String, MetaTable> getTables() {
        return tables;
    }

}
