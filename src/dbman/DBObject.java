/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbman;

import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;

/**
 *
 * @author Jorge Lainfiesta 11142
 */
public interface DBObject {
    public Map<String,MetaTable> getTables();
    
    public List<JSONObject> getCH(String table, String column);
}
