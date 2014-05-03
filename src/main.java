
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ben
 */
public class main {

    /**
     * @param args the command line arguments
     */
    
    public static void print(String msg){
        System.out.println(msg);
    }
    public static void main(String[] args) {
        try {
            JSONObject obj = new JSONObject();
            JSONArray tablas = new JSONArray();
            obj.put("aa", tablas);
            print(obj.toJSONString());
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            int hola = 3;
            print(engine.eval(3+"+4").toString());
        } catch (ScriptException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            FileWriter writer = new FileWriter("src/lol.txt");
            writer.write("aaa");
            writer.close();
            writer = new FileWriter("src/lol.txt",true);
            writer.write("\nbbb");
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
