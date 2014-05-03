
import dbman.DB;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
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
    HashMap<String, LinkedList> constraints ; //se usa al momento de crear tabla

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
           return null;
       }
       if(!viejo.exists()){
           mensajes+="No existe la BD con el nombre de "+ctx.ID(0);
           return null;
           
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
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
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
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
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
    public Object visitDropCon(SQLParser.DropConContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
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
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
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
            columnas.add(column);
        }
        newTable.put("columns", columnas);
        workingDB.createTable(newTable);
       
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
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
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
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitFromClause(SQLParser.FromClauseContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitDropStm(SQLParser.DropStmContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitEmptyMult(SQLParser.EmptyMultContext ctx) {
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitDropDB(SQLParser.DropDBContext ctx) {
       
        File f = new File("src/db/"+ctx.ID()); 

       if(!f.exists())
           mensajes+="No existe la BD "+ctx.ID();
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
           return null;
       }
       JSONObject obj = new JSONObject();
        JSONArray tablas = new JSONArray();
        obj.put("tablas", tablas);
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
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
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
       
visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
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
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
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
            return 1;
        }
        //Vamos a crear una lista de columnas [nombre,tipo,notNull]
        LinkedList datos = new LinkedList();
        datos.add(name); //nombre de tabla
        
        if(ctx.type().getChild(1)!=null){ //ver si es char
            datos.add("CHAR");
        }else
            datos.add(ctx.type().getText()); 
        
        //si puede ser nulo o no
        if (ctx.notNull!=null)
            datos.add("true");
        else
            datos.add("false");
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
