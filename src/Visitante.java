
import dbman.DB;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
public class Visitante extends
        
        SQLBaseVisitor<Object>{
    String mensajes="";
    DB workingDB = null;
    HashMap<String, LinkedList> columns ; //se usa al momento de crear tabla
    HashMap<String, JSONObject> constraints ; //se usa al momento de crear tabla
    String alterTable = null;
    LinkedList<LinkedList> alterOperations = new LinkedList();

    @Override
    public Object visitExpression(SQLParser.ExpressionContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitFKey(SQLParser.FKeyContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitGreaterEqual(SQLParser.GreaterEqualContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitWhereClause(SQLParser.WhereClauseContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitMult(SQLParser.MultContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitLower(SQLParser.LowerContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitGreater(SQLParser.GreaterContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitRenameDB(SQLParser.RenameDBContext ctx) {
        File nuevo = new File("src/db/"+ctx.ID(1)); 
        File viejo = new File("src/db/"+ctx.ID(0)); 

       if(nuevo.exists()){
           mensajes+="No puede renombrarlo. Ya existe una BD con el nombre de "+ctx.ID(1);
           return -1;
       }
       if(!viejo.exists()){
           mensajes+="No existe la BD con el nombre de "+ctx.ID(0);
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
       return null;
    }

    @Override
    public Object visitSuma(SQLParser.SumaContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitNotExp(SQLParser.NotExpContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitDeleteStm(SQLParser.DeleteStmContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
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
            //TODO si un constraint hace referencia a una columna en dropCol, borrar ese constraint
        }
        
        for (LinkedList result : alterOperations) {
            switch (result.get(0).toString()) {
                case "dropCol":
                    workingDB.dropColumn(alterTable, (String) result.get(1));
                    mensajes = "Column "+ result.get(1)+" from table "+alterTable+" has been deleted.";
                    break;
                case "dropCon":
                    workingDB.dropConstraint(alterTable, (String) result.get(1));
                    break;
                case "addCon":
                    workingDB.addConstraint(alterTable, (JSONObject) result.get(1));
                    break;
                case "addCol":
                    workingDB.addColumn(alterTable, (JSONObject) result.get(1));  
                    mensajes = "Column "+result.get(2)+" added to table "+alterTable;
                    break;
                case "addColCon":
                    LinkedList<JSONObject> allConstraints = (LinkedList<JSONObject>) result.get(1);
                    for (JSONObject constraint : allConstraints) 
                        workingDB.addConstraint(alterTable,constraint); 
                    
                    
                    
            }
        }
        
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
            return -1;
        }
        if(workingDB.getTables().get(table).getColumns().containsKey(colID) || columns.containsKey(colID)){
            mensajes = "Column "+colID+" already exists";
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
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitNada(SQLParser.NadaContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitMulDef(SQLParser.MulDefContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
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
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
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
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitDropCon(SQLParser.DropConContext ctx)   {
       if(!workingDB.existsConstrain(ctx.ID().getText())){
           mensajes = "The constraint "+ctx.ID().getText()+" doesn't exist";
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
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitDropCol(SQLParser.DropColContext ctx) {
        
        //verificar que exista
        if(!workingDB.getTables().get(alterTable).getColumns().containsKey(ctx.ID().getText())){
            mensajes = "Column "+ ctx.ID().getText()+" doesn't exist";
            return -1;             
        }
        
        //ver que no haya un constraint usando la columna
        String result = workingDB.usingCol(alterTable, ctx.ID().getText());
        if(result!=null){
            mensajes = "Constraint "+result+" references column "+ ctx.ID().getText();
            return -1;           
        }
        // TODO ver que no haga referencia desde otra tabla
        
        LinkedList add = new LinkedList();
        add.add("dropCol");
        add.add(ctx.ID().getText());
        alterOperations.add(add);
        
      /*  */
        return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitEquals(SQLParser.EqualsContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitShowDB(SQLParser.ShowDBContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitUseDB(SQLParser.UseDBContext ctx) {      
        workingDB = new DB(ctx.ID().getText());
        mensajes = "Usando la base de datos "+workingDB.getName();
        return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitNotEquals(SQLParser.NotEqualsContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitUpdateStm(SQLParser.UpdateStmContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitLike(SQLParser.LikeContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSingleQ(SQLParser.SingleQContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override
    public Object visitCreateStm(SQLParser.CreateStmContext ctx) {
       columns = new HashMap ();
       constraints = new HashMap ();
     if(workingDB.getTables().containsKey(ctx.ID().getText())){
         mensajes = "Table "+ctx.ID().getText()+" already exists";
         return -1;
     }
        visitChildren(ctx); 
        
       JSONObject newTable = new JSONObject();
       newTable.put("name", ctx.ID().getText());
       JSONArray columnas = new JSONArray();
      
       Iterator<String> keys = columns.keySet().iterator();
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
       
       return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitLowerEqual(SQLParser.LowerEqualContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitExp(SQLParser.ExpContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitAddCon(SQLParser.AddConContext ctx) {
        
        String table = alterTable;
        if(!workingDB.getTables().containsKey(table)){
            mensajes = "Table "+table+" doesn't exist";
            return -1;
        }
        
        if(visit(ctx.constraint())!=null)
            return -1;
        Iterator<String> it = constraints.keySet().iterator();
        JSONObject constraint = constraints.get(it.next()); //como sabemos que solo hay un constraint declarado
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
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSingleAss(SQLParser.SingleAssContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitNotNull(SQLParser.NotNullContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
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
       LinkedList result = (LinkedList) visit(ctx.idList());
       Iterator it = result.iterator();
       while(it.hasNext())
           lista.add(it.next());
       return lista;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitFromClause(SQLParser.FromClauseContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitDropStm(SQLParser.DropStmContext ctx) {
        if(!workingDB.getTables().containsKey(ctx.ID().getText())){
            mensajes = "Table "+ctx.ID().getText()+" doesn't exist";
            return -1;
        }
        // TODO ver constraints si no hay referencias
        workingDB.dropTable(ctx.ID().getText());
        return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitEmptyMult(SQLParser.EmptyMultContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitDropDB(SQLParser.DropDBContext ctx) {
       
        File f = new File("src/db/"+ctx.ID()); 

       if(!f.exists()){
           mensajes="No existe la BD "+ctx.ID();
           return -1;
       }
       
       //ver si no se esta usando
       if(workingDB.getName().equals(ctx.ID().getText())){
           mensajes = "La BD "+ctx.ID().getText()+" se esta usando";
       }
      // TODO: Hay que hacer el prompt si esta seguro de borrarlo 
       
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
       return null;
    }

    @Override
    public Object visitIsNull(SQLParser.IsNullContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
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
       return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitInsertStm(SQLParser.InsertStmContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitMulTable(SQLParser.MulTableContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitDiv(SQLParser.DivContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitConstraint(SQLParser.ConstraintContext ctx) {
       String id = ctx.ID().getText();
       if(workingDB.existsConstrain(id) || constraints.containsKey(id)){
           mensajes = "The relation "+id+" already exists";
           return -1;
       }

       JSONObject constraint = (JSONObject) visit(ctx.getChild(2)); //child 2 = constraintType
       
       constraints.put(id, constraint);
       
       
       return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSelectStm(SQLParser.SelectStmContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSum(SQLParser.SumContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitEmptyAdd(SQLParser.EmptyAddContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitRenameTbl(SQLParser.RenameTblContext ctx) {
       String newID = ctx.ID(1).getText();
       String oldID = ctx.ID(0).getText();
       if(workingDB.getTables().containsKey(newID)){
           mensajes = "Table "+newID+" already exists.";
           return -1;
       }
       if(!workingDB.getTables().containsKey(oldID)){
           mensajes = "Table "+newID+" doesn't exists.";
           return -1;
       }
       workingDB.renameTable(oldID,newID);
        return null;  
    }

    @Override
    public Object visitMulCol(SQLParser.MulColContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSingleOrder(SQLParser.SingleOrderContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitCreateDef(SQLParser.CreateDefContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
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
          return -1;
       }
       
       LinkedList lista = (LinkedList) visit(ctx.idList());
       Iterator it = lista.iterator();
       JSONArray arrayConstraints = new JSONArray();
       JSONObject obj = new JSONObject();
       while(it.hasNext())
           arrayConstraints.add(it.next());
       obj.put("columns",arrayConstraints);
       obj.put("name", id);
       obj.put("type", "primary");
       
       return obj;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSingleCol(SQLParser.SingleColContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitMin(SQLParser.MinContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSelectCol(SQLParser.SelectColContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitNegate(SQLParser.NegateContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
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
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitNotNegate(SQLParser.NotNegateContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitCountExp(SQLParser.CountExpContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitFieldDef(SQLParser.FieldDefContext ctx) {
       //ver si no se ha creado la lista
        
        String name = ctx.ID(0).getText();
        
        if(columns.containsKey(name)){
            mensajes = "Column "+name+" is already created";
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
        
      /*ver si hace referencia a otra tabla*/
        if(ctx.ref!=null){
           // TODO: verificacion de tipo y primary key
        }
       return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSelectAll(SQLParser.SelectAllContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitAndExp(SQLParser.AndExpContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSingleDef(SQLParser.SingleDefContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitColAgg(SQLParser.ColAggContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitResta(SQLParser.RestaContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    public String getMensajes(){
        return this.mensajes;
    }
    
}
