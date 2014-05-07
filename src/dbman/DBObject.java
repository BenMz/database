/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbman;

import java.util.Map;

/**
 *
 * @author Jorge Lainfiesta 11142
 */
public interface DBObject {
    public Map<String,MetaTable> getTables();
    
}
