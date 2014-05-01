
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

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

       if(nuevo.exists())
           mensajes+="No puede renombrarlo. Ya existe una BD con el nombre de "+ctx.ID(1);
       if(!viejo.exists())
           mensajes+="No existe la BD con el nombre de "+ctx.ID(0);
      
//       String[]entries = viejo.list();
//        for(String s: entries){
//            File currentFile = new File(viejo.getPath(),s);
//            currentFile.delete();
//        }
       viejo.renameTo(nuevo);
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
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
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
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
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
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
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

       if(!f.mkdir())
           mensajes+="Ya existe una base de datos con ese nombre";
       
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
       visitChildren(ctx);  return null;  //To change body of generated methods, choose Tools | Templates.
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
