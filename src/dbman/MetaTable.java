/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbman;

import java.util.List;
import java.util.Map;

/**
 *
 * @author jorgelainfiesta
 */
public interface MetaTable {
    public String getName();
    public Map<String, String> getColumns();
    public List<String> getPK();
    public String physicalLocation();
}
