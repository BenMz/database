// Generated from D:\cole x_x\Base de datos\SQL.g4 by ANTLR 4.1
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SQLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull SQLParser.ExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#fKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFKey(@NotNull SQLParser.FKeyContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#greaterEqual}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterEqual(@NotNull SQLParser.GreaterEqualContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(@NotNull SQLParser.WhereClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#mult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(@NotNull SQLParser.MultContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#lower}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLower(@NotNull SQLParser.LowerContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#greater}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreater(@NotNull SQLParser.GreaterContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#renameDB}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameDB(@NotNull SQLParser.RenameDBContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#suma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuma(@NotNull SQLParser.SumaContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#notExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExp(@NotNull SQLParser.NotExpContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#deleteStm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteStm(@NotNull SQLParser.DeleteStmContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#idMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdMember(@NotNull SQLParser.IdMemberContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull SQLParser.TypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#addCol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddCol(@NotNull SQLParser.AddColContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#mulExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExp(@NotNull SQLParser.MulExpContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#nada}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNada(@NotNull SQLParser.NadaContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#mulDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDef(@NotNull SQLParser.MulDefContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#dataStm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataStm(@NotNull SQLParser.DataStmContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#tableStm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableStm(@NotNull SQLParser.TableStmContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#mulOrder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulOrder(@NotNull SQLParser.MulOrderContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(@NotNull SQLParser.ValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#singleMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleMember(@NotNull SQLParser.SingleMemberContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#avg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAvg(@NotNull SQLParser.AvgContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#mulAss}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulAss(@NotNull SQLParser.MulAssContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#dropCon}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropCon(@NotNull SQLParser.DropConContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#refTbl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefTbl(@NotNull SQLParser.RefTblContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#singleTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleTable(@NotNull SQLParser.SingleTableContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#dropCol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropCol(@NotNull SQLParser.DropColContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#equals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquals(@NotNull SQLParser.EqualsContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#showDB}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowDB(@NotNull SQLParser.ShowDBContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#useDB}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUseDB(@NotNull SQLParser.UseDBContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#notEquals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEquals(@NotNull SQLParser.NotEqualsContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#updateStm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateStm(@NotNull SQLParser.UpdateStmContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#like}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLike(@NotNull SQLParser.LikeContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#singleQ}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleQ(@NotNull SQLParser.SingleQContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#createStm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateStm(@NotNull SQLParser.CreateStmContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#lowerEqual}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLowerEqual(@NotNull SQLParser.LowerEqualContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(@NotNull SQLParser.ExpContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#addCon}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddCon(@NotNull SQLParser.AddConContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#asc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsc(@NotNull SQLParser.AscContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#column}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn(@NotNull SQLParser.ColumnContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#singleAss}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleAss(@NotNull SQLParser.SingleAssContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#notNull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotNull(@NotNull SQLParser.NotNullContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#mulQ}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulQ(@NotNull SQLParser.MulQContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#showTbl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowTbl(@NotNull SQLParser.ShowTblContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#mulMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulMember(@NotNull SQLParser.MulMemberContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#fromClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromClause(@NotNull SQLParser.FromClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#dropStm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropStm(@NotNull SQLParser.DropStmContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#emptyMult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyMult(@NotNull SQLParser.EmptyMultContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#dropDB}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropDB(@NotNull SQLParser.DropDBContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#isNull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsNull(@NotNull SQLParser.IsNullContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#desc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesc(@NotNull SQLParser.DescContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#createDB}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDB(@NotNull SQLParser.CreateDBContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#insertStm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertStm(@NotNull SQLParser.InsertStmContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#mulTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulTable(@NotNull SQLParser.MulTableContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#div}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(@NotNull SQLParser.DivContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint(@NotNull SQLParser.ConstraintContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#selectStm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectStm(@NotNull SQLParser.SelectStmContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#sum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSum(@NotNull SQLParser.SumContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#emptyAdd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyAdd(@NotNull SQLParser.EmptyAddContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#renameTbl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameTbl(@NotNull SQLParser.RenameTblContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#mulCol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulCol(@NotNull SQLParser.MulColContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#singleOrder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleOrder(@NotNull SQLParser.SingleOrderContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#createDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDef(@NotNull SQLParser.CreateDefContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#orderClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderClause(@NotNull SQLParser.OrderClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#tblStm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblStm(@NotNull SQLParser.TblStmContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#countAll}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCountAll(@NotNull SQLParser.CountAllContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#showCol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCol(@NotNull SQLParser.ShowColContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#pKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPKey(@NotNull SQLParser.PKeyContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#singleCol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleCol(@NotNull SQLParser.SingleColContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#min}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMin(@NotNull SQLParser.MinContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#selectCol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectCol(@NotNull SQLParser.SelectColContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#negate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegate(@NotNull SQLParser.NegateContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#columnAs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnAs(@NotNull SQLParser.ColumnAsContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#max}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMax(@NotNull SQLParser.MaxContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#check}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheck(@NotNull SQLParser.CheckContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#singleExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleExp(@NotNull SQLParser.SingleExpContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#notNegate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotNegate(@NotNull SQLParser.NotNegateContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#countExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCountExp(@NotNull SQLParser.CountExpContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#fieldDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDef(@NotNull SQLParser.FieldDefContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#selectAll}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectAll(@NotNull SQLParser.SelectAllContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#andExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExp(@NotNull SQLParser.AndExpContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#singleDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleDef(@NotNull SQLParser.SingleDefContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#colAgg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColAgg(@NotNull SQLParser.ColAggContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLParser#resta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResta(@NotNull SQLParser.RestaContext ctx);
}