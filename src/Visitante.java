
import dbman.ConstrainException;
import dbman.DB;
import dbman.DMLManager;
import dbman.Table;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.supercsv.io.CsvMapWriter;
import org.supercsv.io.ICsvMapWriter;
import org.supercsv.prefs.CsvPreference;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ben
 */
public class Visitante extends SQLBaseVisitor<Object>{
    private String mensajes="";
    private LinkedList<String> all = new LinkedList();
    private DB workingDB = null;
    private HashMap<String, LinkedList> columns ; //se usa al momento de crear tabla
    private LinkedList columnOrder;
    private HashMap<String, JSONObject> constraints ; //se usa al momento de crear tabla
    private String alterTable = null;
    private LinkedList<LinkedList> alterOperations = new LinkedList();
    private int insertedRows = 0;
    private int deletedRows = 0;
    private int updatedRows = 0;
    private boolean verbose;
    
    public Visitante(boolean verbose ){
        this.verbose=verbose;
    }
    
    @Override
    public Object visitExpression(SQLParser.ExpressionContext ctx) {
    
      String exp = (String) visit(ctx.andExp());
        if(ctx.getChild(1)!=null){
           exp+="||"+visit(ctx.expression());
        }
        
       return exp;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitFKey(SQLParser.FKeyContext ctx) {
        String id = ctx.getParent().getChild(1).getText();//agarra el id del padre, que es Constraint
        String refTable = ctx.ID().getText();
       if(constraints.containsKey(id)){
           mensajes = "The relation "+id+" was already created";
           all.add(mensajes);
          return -1;
       }
       //ver si existe la tabla foranea 
       if(!workingDB.getTables().containsKey(refTable)){
           mensajes = "The table"+refTable+" doesn't exist";
           all.add(mensajes);
           return -1;
       }
       //columnas de la tabla local
       LinkedList columnas = (LinkedList) visit(ctx.idList(0));
       Iterator it = columnas.iterator();
       JSONArray arrayConstraints = new JSONArray();
       JSONObject obj = new JSONObject();
       while(it.hasNext()){
           String col = (String) it.next();
           //determinar si existe la columna
            if(workingDB.getTables().get(alterTable)==null){
                if(!columns.containsKey(col)){
                    mensajes = "Column "+col+" doesn't exist";
                    all.add(mensajes);
                    return -1;
                }
            }else{
                if(!workingDB.getTables().get(alterTable).getColumns().containsKey(col)){
                    mensajes = "Column "+col+" doesn't exist";
                    all.add(mensajes);
                    return -1;                  
                }
            }
           arrayConstraints.add(col);
       }
       obj.put("columns",arrayConstraints);
       obj.put("name", id);
       obj.put("type", "foreign");
       
       //columnas de la tabla foranea
       
       obj.put("referencedTable", refTable);
       columnas = (LinkedList) visit(ctx.idList(1));
       it = columnas.iterator();
       JSONArray arrayRef = new JSONArray();
       int index = 0; //determinar indice de la columna en el array de columns
       while(it.hasNext()){
           String col = (String) it.next();
           //determinar si existe estas columns y si son PK
           
           if(!workingDB.getTables().get(refTable).getPK().contains(col)){
               mensajes = "Column "+col+" is not unique in table "+refTable;
               all.add(mensajes);
               return -1;
           }
           //determinar si son del mismo tipo
           JSONObject refCol = workingDB.getTables().get(refTable).getColumns().get(col);
           
           String tipo ;
           if(workingDB.getTables().get(alterTable)==null){
                tipo = columns.get(arrayConstraints.get(index)).get(1).toString(); //en la posicion 1 esta el tipo de la columna
            }else{
                tipo = (String) workingDB.getTables().get(alterTable).getColumns().get(arrayConstraints.get(index)).get("type");
            }
           if(!(tipo).equals(refCol.get("type"))){
               mensajes = "Column "+arrayConstraints.get(index)+" has different type than "+col;
               all.add(mensajes);
               return -1;              
           }
           arrayRef.add(col);   
           index++;
       }
       obj.put("referencedColumns", arrayRef);
       
       return obj;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitGreaterEqual(SQLParser.GreaterEqualContext ctx) {
        String exp = visit(ctx.addExp(0))+">="+visit(ctx.addExp(1));
        return exp;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitWhereClause(SQLParser.WhereClauseContext ctx) {
       if(ctx.expression()!=null)
           return visit(ctx.expression());
       else
           return null;
    }

    @Override
    public Object visitMult(SQLParser.MultContext ctx) {
       return visit(ctx.negateExp())+"*"+visit(ctx.multExp());
    }

    @Override
    public Object visitLower(SQLParser.LowerContext ctx) {
        String exp = visit(ctx.addExp(0))+">="+visit(ctx.addExp(1));
        return exp;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitGreater(SQLParser.GreaterContext ctx) {
               String exp = visit(ctx.addExp(0))+">"+visit(ctx.addExp(1));
       return exp;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitRenameDB(SQLParser.RenameDBContext ctx) {
        File nuevo = new File("src/db/"+ctx.ID(1)); 
        File viejo = new File("src/db/"+ctx.ID(0)); 

       if(nuevo.exists()){
           mensajes+="No puede renombrarlo. Ya existe una BD con el nombre de "+ctx.ID(1);
           all.add(mensajes);
           return -1;
       }
       if(!viejo.exists()){
           mensajes+="No existe la BD con el nombre de "+ctx.ID(0);
           all.add(mensajes);
           return -1;
           
       }
      
       //ver si no se encuentra en uso la base de datos
       if(workingDB!=null && workingDB.getName().equals(ctx.ID(0))){
           workingDB.setName(ctx.ID(0).getText());
       }
       viejo.renameTo(nuevo);
        nuevo = new File("src/db/"+ctx.ID(1)+".json"); 
        viejo = new File("src/db/"+ctx.ID(0)+".json"); 
        viejo.renameTo(nuevo);
        mensajes = "Se ha cambiado de nombre a "+ctx.ID(1);
        all.add(mensajes);
       return null;
    }

    @Override
    public Object visitSuma(SQLParser.SumaContext ctx) {
       
       return visit(ctx.multExp())+"+"+visit(ctx.addExp());  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitNotExp(SQLParser.NotExpContext ctx) {
       String exp; 
       
        if(ctx.not!=null)           
           exp = "!("+visit(ctx.getChild(1))+")";
        else
            exp = ""+ visit(ctx.getChild(0));
        
       return exp;  //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public Object visitDeleteStm(SQLParser.DeleteStmContext ctx) {
       if(workingDB==null){
           mensajes = "Not using any database";
           all.add(mensajes);
           return -1;
       }
       DMLManager dbm = new DMLManager(workingDB);
       dbm.workWithTables(ctx.ID().getText());
       String where = (String) visit(ctx.whereClause());
       int result = 0;
        try {
            result = dbm.delete(where);
            
        } catch (ConstrainException ex) {
            mensajes = "Unable to delete "+ex.getMessage();
            all.add(mensajes);
            return -1;
        }
        deletedRows+=result;
        workingDB.removeRecord(result, (Table) workingDB.getTables().get(ctx.ID().getText()));
       return null;
       
    }
    
    @Override
    public Object visitAlterStm(SQLParser.AlterStmContext ctx) {
        alterOperations = new LinkedList();
        alterTable = ctx.ID().getText();
        constraints = new HashMap();
        columns = new HashMap();
        for(int i=0;i<ctx.alterStm2().size();i++){
            if(visit(ctx.alterStm2(i))!=null)
                return -1;
           
        }
        
        for (LinkedList result : alterOperations) {
            switch (result.get(0).toString()) {
                case "dropCol":
                    workingDB.dropColumn(alterTable, (String) result.get(1));
                    mensajes = "Column "+ result.get(1)+" from table "+alterTable+" has been deleted.";
                    all.add(mensajes);
                    break;
                case "dropCon":
                    workingDB.dropConstraint(alterTable, (String) result.get(1));
                    mensajes = "Constraint "+result.get(1)+" deleted";
                    all.add(mensajes);
                    break;
                case "addCon":
                    workingDB.addConstraint(alterTable, (JSONObject) result.get(1));
                    mensajes = "Constraint "+result.get(1)+" added";
                    all.add(mensajes);
                    break;
                case "addCol":
                    workingDB.addColumn(alterTable, (JSONObject) result.get(1));  
                    mensajes = "Column "+result.get(2)+" added to table "+alterTable;
                    all.add(mensajes);
                    break;
                case "addColCon":
                    LinkedList<JSONObject> allConstraints = (LinkedList<JSONObject>) result.get(1);
                    for (JSONObject constraint : allConstraints) 
                        workingDB.addConstraint(alterTable,constraint); 
                    
                    
                    
            }
        }
        alterTable = "";
        return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitIdMember(SQLParser.IdMemberContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitType(SQLParser.TypeContext ctx) {
        
        if(ctx.getChild(1).equals("(")){ //saber si es char
            return "CHAR";
        }
        else return ctx.getText();
    }

    @Override
    public Object visitAddCol(SQLParser.AddColContext ctx) {
       
       
        String table =alterTable;
        String colID = ctx.ID().getText();
        
        if(!workingDB.getTables().containsKey(table)){
            mensajes = "Table "+table+" doesn't exist";
            all.add(mensajes);
            return -1;
        }
        if(workingDB.getTables().get(table).getColumns().containsKey(colID) || columns.containsKey(colID)){
            mensajes = "Column "+colID+" already exists";
            all.add(mensajes);
            return -1;
        }
        
        
       columns.put(colID, null); //solo es para tener referencia de que se ha creado la nueva columna
       
        JSONObject datos = new JSONObject();
        datos.put("name",colID);
        
        if(ctx.type().getChild(1)!=null){ //ver si es char
            datos.put("type","CHAR");
        }else
            datos.put("type",ctx.type().getText());
        
        //si puede ser nulo o no
        if (ctx.not!=null)
            datos.put("notNull","true");
        else
            datos.put("notNull","false");
        //si es char agregar tamano
        if(datos.get("type").equals("CHAR"))
            datos.put("size",Integer.parseInt(ctx.type().NUM().getText()));
      /*constraints*/
        if(ctx.con!=null){
            for (SQLParser.ConstraintContext constraint : ctx.constraint()) {
                if(visit(constraint)!=null)
                    return -1;
           } 
           Iterator<String> it = constraints.keySet().iterator();
           LinkedList<JSONObject> newConstraints = new LinkedList();
           while(it.hasNext()){
               JSONObject constraint = constraints.get(it.next());
               constraint.put("table",table);
               newConstraints.add(constraint);
               
           }
           LinkedList resultCon = new LinkedList();
           resultCon.add("addColCon");
           resultCon.add(newConstraints);
           alterOperations.add(resultCon);    
        }
        LinkedList resultCol = new LinkedList();
        resultCol.add("addCol");
        resultCol.add(datos);
        resultCol.add(colID);
        alterOperations.add(resultCol);           

      return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitMulExp(SQLParser.MulExpContext ctx) {
       LinkedList lista = new LinkedList();
       lista.push(ctx.expression().getText()); //agregar el id;
       LinkedList result = (LinkedList) visitChildren(ctx);
       Iterator it = result.iterator();
       while(it.hasNext())
           lista.push(it.next());
       return lista;  //To change body of generated methods, choose Tools | Templates.
    }
    


    @Override
    public Object visitNada(SQLParser.NadaContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitMulDef(SQLParser.MulDefContext ctx) {
       
        return visitChildren(ctx);   //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitDataStm(SQLParser.DataStmContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitTableStm(SQLParser.TableStmContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitMulOrder(SQLParser.MulOrderContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitValue(SQLParser.ValueContext ctx) {
        
        if(ctx.getChild(0).equals("(")) //si es otra expresion
            return visit(ctx.expression());
        if(ctx.ID(0)!=null){ //si es un ID
            if(ctx.ID(1)!=null) //si es un ID.ID
                return "{"+ctx.ID(0).getText()+"."+ctx.ID(1).getText()+"} ";
            else
                return "{"+ctx.ID(0)+"} ";
        }
        if(ctx.STRING()!=null)
            return "\""+ctx.getText()+"\"";
       
       return ctx.getText();  
    }

   @Override
    public Object visitSingleMember(SQLParser.SingleMemberContext ctx) {
       LinkedList lista = new LinkedList();
       lista.add(ctx.idMember().getText()); //agregar el id;
       return lista;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitAvg(SQLParser.AvgContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitMulAss(SQLParser.MulAssContext ctx) {
       LinkedList lista = new LinkedList();
       lista.push(visit(ctx.expression())); //agregar el id;
       HashMap result = new HashMap();
       result.put(ctx.ID().getText(), lista);
//       System.out.println(lista);
       return result;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitDropCon(SQLParser.DropConContext ctx)   {
       if(!workingDB.existsConstrain(ctx.ID().getText())){
           mensajes = "The constraint "+ctx.ID().getText()+" doesn't exist";
           all.add(mensajes);
           return -1;
       }
       LinkedList<String> result = new LinkedList();
       result.add("dropCon");
       result.add(ctx.ID().getText());
       alterOperations.add(result);
       return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitRefTbl(SQLParser.RefTblContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSingleTable(SQLParser.SingleTableContext ctx) {
       HashMap lista = new HashMap();
       if(ctx.idMember(1)==null)
           lista.put(ctx.idMember(0).getText(), null);     
       else
           lista.put(ctx.idMember(0).getText(), ctx.idMember(1));
       return lista;
    }

    @Override
    public Object visitDropCol(SQLParser.DropColContext ctx) {
        
        //verificar que exista
        if(!workingDB.getTables().get(alterTable).getColumns().containsKey(ctx.ID().getText())){
            mensajes = "Column "+ ctx.ID().getText()+" doesn't exist";
            all.add(mensajes);
            return -1;             
        }
        
        //ver que no haya un constraint usando la columna
        String result = workingDB.usingCol(alterTable, ctx.ID().getText());
        if(result!=null){
            mensajes = "Constraint "+result+" references column "+ ctx.ID().getText();
            all.add(mensajes);
            return -1;           
        }

        LinkedList add = new LinkedList();
        add.add("dropCol");
        add.add(ctx.ID().getText());
        alterOperations.add(add);
        
      /*  */
        return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitEquals(SQLParser.EqualsContext ctx) {
        String exp = visit(ctx.addExp(0))+"=="+visit(ctx.addExp(1));
       return exp;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitShowDB(SQLParser.ShowDBContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitUseDB(SQLParser.UseDBContext ctx) {      
        workingDB = new DB(ctx.ID().getText());
        mensajes = "Usando la base de datos "+workingDB.getName();
        all.add(mensajes);
        return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitNotEquals(SQLParser.NotEqualsContext ctx) {
        String exp = visit(ctx.addExp(0))+"!="+visit(ctx.addExp(1));
       return exp;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitUpdateStm(SQLParser.UpdateStmContext ctx) {
       if(workingDB==null){
           mensajes = "Not using any database";
           all.add(mensajes);
           return -1;
       }
       if(!workingDB.getTables().containsKey(ctx.ID().getText())){
           mensajes = "Table "+ctx.ID().getText()+" doesn't exist";
           all.add(mensajes);
           return -1;
       }
       DMLManager dbm = new DMLManager(workingDB);
       dbm.workWithTables(ctx.ID().getText());
       HashMap assignments = null;
       try{
           assignments = (HashMap) visit(ctx.getChild(3)); //child 3 = assignlist
       }catch(Exception e){
           mensajes = "Error in update: "+e.getMessage();
           all.add(mensajes);
       }
       
       System.out.println(assignments);
       List<String> columns = new LinkedList();
       List<String> values = new LinkedList();
       Iterator<Map.Entry> it = assignments.entrySet().iterator();
       while(it.hasNext()){
           Map.Entry pair = it.next();
           columns.add((String) pair.getKey());
           LinkedList val = (LinkedList) pair.getValue();
           values.add((String) val.get(0));
       }
        
       String where = (String) visit(ctx.whereClause());
       int result = 0;
        try {
            result = dbm.update(values,columns,where);
            
        } catch (ConstrainException ex) {
            mensajes = "Unable to update "+ex.getMessage();
            all.add(mensajes);
            return -1;
        }
        updatedRows+=result;
       return null;
    }

    @Override
    public Object visitLike(SQLParser.LikeContext ctx) {
       String exp = visit(ctx.addExp())+".contains(\""+ctx.STRING().getText()+"\"";
       return exp;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSingleQ(SQLParser.SingleQContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override
    public Object visitCreateStm(SQLParser.CreateStmContext ctx) {
       columns = new HashMap ();
       columnOrder = new LinkedList();
       constraints = new HashMap ();
     if(workingDB.getTables().containsKey(ctx.ID().getText())){
         mensajes = "Table "+ctx.ID().getText()+" already exists";
         all.add(mensajes);
         return -1;
     }
     
    
        if(visitChildren(ctx)!=null)
            return -1;
        
       JSONObject newTable = new JSONObject();
       newTable.put("name", ctx.ID().getText());
       JSONArray columnas = new JSONArray();
      
       Iterator<String> keys = columnOrder.descendingIterator();
       
        while (keys.hasNext()) {
            
            String key = keys.next();
            LinkedList datos = columns.get(key);
            JSONObject column = new JSONObject();
            column.put("name", datos.get(0));
            column.put("type", datos.get(1));
            column.put("notNull", datos.get(2));
            if(datos.get(1).equals("CHAR"))
                column.put("size",datos.get(3));
            columnas.add(column);
        }
        newTable.put("columns", columnas);
        long records = 0;
        newTable.put("records", records);
        
        //constraints
        
        keys = constraints.keySet().iterator();
        JSONArray arrayConstraints = new JSONArray();
        while(keys.hasNext())
            arrayConstraints.add(constraints.get(keys.next()));
        
        
        workingDB.createTable(newTable,arrayConstraints);
	try {
 
		FileWriter file = new FileWriter("src/db/"+workingDB.getName()+"/"+ctx.ID().getText()+".csv");
		
                 ICsvMapWriter mapWriter = null;
                 mapWriter = new CsvMapWriter(file,
                        CsvPreference.STANDARD_PREFERENCE);
                 String[] header = new String[columnas.size()];
                 for(int i=0;i<columnas.size();i++){
                     JSONObject temp = (JSONObject) columnas.get(i);
                     header[i]=(String) temp.get("name");
                 }
                 mapWriter.writeHeader(header);
                 mapWriter.close();
                 
 
	} catch (IOException e) {
		e.printStackTrace();
	}  
       
       return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitLowerEqual(SQLParser.LowerEqualContext ctx) {
        String exp = visit(ctx.addExp(0))+">="+visit(ctx.addExp(1));
        return exp;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitExp(SQLParser.ExpContext ctx) {
       
        return visit(ctx.addExp());  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitAddCon(SQLParser.AddConContext ctx) {
        
        String table = alterTable;
        if(!workingDB.getTables().containsKey(table)){
            mensajes = "Table "+table+" doesn't exist";
            all.add(mensajes);
            return -1;
        }
        
        if(visit(ctx.constraint())!=null)
            return -1;
        
       
       

        JSONObject constraint = constraints.get("addCon"); //como sabemos que solo hay uno 
        constraint.put("table",table);
        LinkedList result = new LinkedList();
        result.add("addCon");
        result.add(constraint);
            alterOperations.add(result);              
           
        

        

        return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitAsc(SQLParser.AscContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitColumn(SQLParser.ColumnContext ctx) { 
       return ctx.getText();  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSingleAss(SQLParser.SingleAssContext ctx) {
       LinkedList lista = new LinkedList();
       lista.push(ctx.expression().getText()); //agregar el id;
       HashMap result = (HashMap) visitChildren(ctx);
       if(result.containsKey(ctx.ID().getText())){
           mensajes = "Double assignment in column "+ctx.ID().getText();
           all.add(mensajes);
           return -1;
       }
       result.put(ctx.ID().getText(), lista);
       return result;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitNotNull(SQLParser.NotNullContext ctx) {
       
       String exp = visit(ctx.value())+"!=null";
       return exp;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitMulQ(SQLParser.MulQContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override
    public Object visitShowTbl(SQLParser.ShowTblContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitMulMember(SQLParser.MulMemberContext ctx) {
       LinkedList lista = new LinkedList();
       lista.add(ctx.idMember().getText()); //agregar el id;
        LinkedList result ;
       try{
            result = (LinkedList) visit(ctx.idList());
       }catch(Exception e){
           return -1;
       }
       if(result.contains(ctx.idMember().getText())){
           mensajes = "Column "+ctx.idMember().getText()+" repeated twice";
           all.add(mensajes);
           return -1;
       }
       Iterator it = result.iterator();
       while(it.hasNext())
           lista.add(it.next());
       return lista;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitFromClause(SQLParser.FromClauseContext ctx) {
       return(visitChildren(ctx)); 
    }

    @Override
    public Object visitDropStm(SQLParser.DropStmContext ctx) {
       
        if(!workingDB.getTables().containsKey(ctx.ID().getText())){
            mensajes = "Table "+ctx.ID().getText()+" doesn't exist";
            all.add(mensajes);
            return -1;
        }
       
        String result = workingDB.usingTable(ctx.ID().getText());
        if(result!=null){
            mensajes = result;
            all.add(mensajes);
            return -1;
        }
        workingDB.dropTable(ctx.ID().getText());
        mensajes = "Table "+ctx.ID().getText()+" deleted";
        all.add(mensajes);
        File f = new File("src/db/"+workingDB.getName()+"/"+ctx.ID().getText()+".csv");
        f.delete();
        return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitEmptyMult(SQLParser.EmptyMultContext ctx) {
       
        return(visit(ctx.negateExp()));
    }

    @Override
    public Object visitDropDB(SQLParser.DropDBContext ctx) {
       
        File f = new File("src/db/"+ctx.ID()); 

       if(!f.exists()){
           mensajes="No existe la BD "+ctx.ID();
           all.add(mensajes);
           return -1;
       }
       
       //ver si no se esta usando
       if(workingDB!=null && workingDB.getName().equals(ctx.ID().getText())){
           mensajes = "La BD "+ctx.ID().getText()+" se esta usando";
           all.add(mensajes);
       }
      // prompt si esta seguro de borrarlo 
      int prompt = JOptionPane.showConfirmDialog(null, "Esta seguro que quiere borrar la base de datos "+ctx.ID().getText()+"?","Borrar?",  JOptionPane.YES_NO_OPTION);
      if(prompt!=JOptionPane.YES_OPTION)
          return null;
      
       String[]entries = f.list();
       //borrar todos los archivos 
        for(String s: entries){
            File currentFile = new File(f.getPath(),s);
            currentFile.delete();
        }
       f.delete();
       f = new File("src/db/"+ctx.ID()+".json"); 
       f.delete();
       mensajes+="Se ha borrado la BD "+ctx.ID();
       all.add(mensajes);
       return null;
    }

    @Override
    public Object visitIsNull(SQLParser.IsNullContext ctx) {
       String exp = visit(ctx.value())+"==null";
       return exp;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitDesc(SQLParser.DescContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitCreateDB(SQLParser.CreateDBContext ctx) {
        
       File f = new File("src/db/"+ctx.ID()); 

       if(!f.mkdir()){
           mensajes="Ya existe una base de datos con ese nombre";
           all.add(mensajes);
           return -1;
       }
       JSONObject obj = new JSONObject();
        obj.put("tablas",  new JSONArray());
        obj.put("constraints",  new JSONObject());
        obj.put("records", 0);
	try {
 
		FileWriter file = new FileWriter("src/db/"+ctx.ID()+".json");
		file.write(obj.toJSONString());
		file.close();
 
	} catch (IOException e) {
		e.printStackTrace();
	}  
       mensajes="Se ha creado la base de datos";
       all.add(mensajes);
       return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitInsertStm(SQLParser.InsertStmContext ctx) {
       if(workingDB==null){
           mensajes = "Not using any database";
           all.add(mensajes);
           return -1;
       }
       DMLManager dbm = new DMLManager(workingDB);
       dbm.workWithTables(ctx.ID().getText());
       LinkedList columns = (LinkedList) visit(ctx.idList());
       LinkedList values = (LinkedList) visit(ctx.exprList());
//       System.out.println(values);
        try {
            dbm.insert(values, columns);
        } catch (ConstrainException ex) {
           mensajes = "Unable to insert "+ex.getMessage();
           all.add(mensajes);
           return -1;
        }
       insertedRows++;
       return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitMulTable(SQLParser.MulTableContext ctx) {
       HashMap lista = new HashMap();
       if(ctx.idMember(1)==null)
           lista.put(ctx.idMember(0).getText(), null);     
       else
           lista.put(ctx.idMember(0).getText(), ctx.idMember(1));
       
       HashMap<String,String> result = (HashMap) visitChildren(ctx);
       for(Map.Entry pair : result.entrySet()){
           lista.put(pair.getKey(), pair.getValue());
       }
       return lista;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitDiv(SQLParser.DivContext ctx) {
        return visit(ctx.negateExp())+"/"+visit(ctx.multExp());
    }

    @Override
    public Object visitConstraint(SQLParser.ConstraintContext ctx) {
       String id = ctx.ID().getText();
       if(workingDB.existsConstrain(id) || constraints.containsKey(id)){
           mensajes = "The relation "+id+" already exists";
           all.add(mensajes);
           return -1;
       }
       
       JSONObject constraint;
       
       try{
       constraint = (JSONObject) visit(ctx.getChild(2)); //child 2 = constraintType
       }catch(Exception e){
           
           return -1;
       }
       
       
       if(constraint.get("type").equals("primary"))
           constraints.put("_pk", constraint); //esto indicara que ya no se puede crear otra primary key
       
       constraints.put("addCon", constraint);
       return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSelectStm(SQLParser.SelectStmContext ctx) {
       if(workingDB==null){
           mensajes = "Not using any database";
           all.add(mensajes);
           return -1;
       }

       DMLManager dbm = new DMLManager(workingDB);
       Map<String,String> listTables = null;
       try{
           listTables = (Map<String,String>) visit(ctx.fromClause());
       }catch(Exception e){
           mensajes = "Error in tables in select: "+e.getMessage();
           all.add(mensajes);
           return -1;
       }
       
       String[] tables = new String[listTables.size()];
       int i = 0;
       for(Map.Entry table: listTables.entrySet()){
           if(!workingDB.getTables().containsKey(table.getKey())){
               mensajes = "Table "+table.getKey()+" doesn't exist";
               all.add(mensajes);
               return -1;
           }
           tables[i]=table.getKey().toString();
           i++;
       }
       dbm.workWithTables(tables);
       
       List<String> columns = null;
       if(ctx.columnas.getText().equals("*")){
           for(String table: tables){
               Table tabla = (Table) workingDB.getTables().get(table);
               columns.addAll(tabla.getAllCol());
           }
       }
       else{
        try{
            columns = (List<String>) visit(ctx.columns());
        }catch(Exception e){

        }
       }
              String where = (String) visit(ctx.whereClause());
        try {
            System.out.println(dbm.select(columns,where,null,0));
        } catch (ConstrainException ex) {
            Logger.getLogger(Visitante.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSum(SQLParser.SumContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitEmptyAdd(SQLParser.EmptyAddContext ctx) {
    
        return visit(ctx.multExp());
    }

    @Override
    public Object visitRenameTbl(SQLParser.RenameTblContext ctx) {
       String newID = ctx.ID(1).getText();
       String oldID = ctx.ID(0).getText();
       if(workingDB.getTables().containsKey(newID)){
           mensajes = "Table "+newID+" already exists.";
           all.add(mensajes);
           return -1;
       }
       if(!workingDB.getTables().containsKey(oldID)){
           mensajes = "Table "+newID+" doesn't exists.";
           all.add(mensajes);
           return -1;
       }
       workingDB.renameTable(oldID,newID);
        return null;  
    }

    @Override
    public Object visitMulCol(SQLParser.MulColContext ctx) {
             LinkedList lista = new LinkedList();
       lista.push(ctx.columnItem().getText()); //agregar el id;
       LinkedList result = (LinkedList) visitChildren(ctx);
       Iterator it = result.iterator();
       while(it.hasNext())
           lista.push(it.next());
       return lista;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSingleOrder(SQLParser.SingleOrderContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitCreateDef(SQLParser.CreateDefContext ctx) {
      return visitChildren(ctx);    //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitOrderClause(SQLParser.OrderClauseContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitTblStm(SQLParser.TblStmContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitCountAll(SQLParser.CountAllContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitShowCol(SQLParser.ShowColContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitPKey(SQLParser.PKeyContext ctx) {
       String id = ctx.getParent().getChild(1).getText();//agarra el id del padre, que es Constraint
       if(constraints.containsKey(id)){
           mensajes = "The relation "+id+" was already created";
           all.add(mensajes);
          return -1;
       }
       
       if(constraints.containsKey("_pk") ||  workingDB.hasPK(alterTable)){
           mensajes = "Table already has primary key";
           all.add(mensajes);
           return -1;
       }
       
       LinkedList lista = (LinkedList) visit(ctx.idList());
       Iterator it = lista.iterator();
       JSONArray arrayConstraints = new JSONArray();
       JSONObject obj = new JSONObject();
       while(it.hasNext()){
           String col = (String) it.next();
           if(workingDB.getTables().containsKey(alterTable)){
               if(!workingDB.getTables().get(alterTable).getColumns().containsKey(col)){
                   mensajes = "The column "+col+" doesn't exist";
                   all.add(mensajes);
                   return -1;
               }
           }else{
               if(!columns.containsKey(col)){
                   mensajes = "The column "+col+" doesn't exist";
                   all.add(mensajes);
                   return -1;                  
               }
           }
           arrayConstraints.add(col);
       }
       obj.put("columns",arrayConstraints);
       obj.put("name", id);
       obj.put("type", "primary");
       
       return obj;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSingleCol(SQLParser.SingleColContext ctx) {
              LinkedList lista = new LinkedList();
       lista.push(visit(ctx.columnItem())); //agregar el id;
//       System.out.println(lista);
       return lista;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitMin(SQLParser.MinContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSelectCol(SQLParser.SelectColContext ctx) {
      return(visitChildren(ctx));  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitNegate(SQLParser.NegateContext ctx) {
        
        return visit(ctx.value());
    }

    @Override
    public Object visitColumnAs(SQLParser.ColumnAsContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitMax(SQLParser.MaxContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitCheck(SQLParser.CheckContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSingleExp(SQLParser.SingleExpContext ctx) {
       LinkedList lista = new LinkedList();
       lista.push(visit(ctx.expression())); //agregar el id;
//       System.out.println(lista);
       return lista;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitNotNegate(SQLParser.NotNegateContext ctx) {
      return visit(ctx.value());
    }

    @Override
    public Object visitCountExp(SQLParser.CountExpContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitFieldDef(SQLParser.FieldDefContext ctx) {
       //ver si no se ha creado la lista
        
        String name = ctx.ID().getText();
        
        if(columns.containsKey(name)){
            mensajes = "Column "+name+" is already created";
            all.add(mensajes);
            return -1;
        }
        //Vamos a crear una lista de columnas [nombre,tipo,notNull]
        LinkedList datos = new LinkedList();
        datos.add(name); //nombre de columna
        
        if(ctx.type().getChild(1)!=null){ //ver si es char
            datos.add("CHAR");
        }else
            datos.add(ctx.type().getText()); 
        
        //si puede ser nulo o no
        if (ctx.notNull!=null)
            datos.add("true");
        else
            datos.add("false");
        //si es char agregar tamano
        if(datos.get(1).equals("CHAR"))
            datos.add(Integer.parseInt(ctx.type().NUM().getText()));
       
        columns.put(name, datos);
        columnOrder.add(name);
        

       return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSelectAll(SQLParser.SelectAllContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitAndExp(SQLParser.AndExpContext ctx) {
       
       String exp = (String) visit(ctx.notExp());
       
        if(ctx.getChild(1)!=null){
           exp+="&&"+visit(ctx.andExp());
        }
        
       return exp;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSingleDef(SQLParser.SingleDefContext ctx) {
       if(visit(ctx.createList())!=null)
           return -1;
       return visit(ctx.createDef());    //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitColAgg(SQLParser.ColAggContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitResta(SQLParser.RestaContext ctx) {
       return visit(ctx.multExp())+"-"+visit(ctx.addExp());
    }

    public String getMensajes(){
        String mensajes = this.mensajes;
        if(insertedRows>0)
            mensajes+="\nInserted rows: "+insertedRows;
        if(updatedRows>0)
            mensajes+="\nUpdated rows: "+updatedRows;
        if(deletedRows>0)
            mensajes+="\nDeleted rows: "+deletedRows;
        return this.mensajes;
    }
    
    public LinkedList getAll(){
        if(insertedRows>0)
            all.add("\nInserted rows: "+insertedRows);
        if(updatedRows>0)
            all.add("\nUpdated rows: "+updatedRows);
        if(deletedRows>0)
            all.add("\nDeleted rows: "+deletedRows);
        return all;
    }
    
    
}
