// Generated from D:\cole x_x\Base de datos\SQL.g4 by ANTLR 4.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__63=1, T__62=2, T__61=3, T__60=4, T__59=5, T__58=6, T__57=7, T__56=8, 
		T__55=9, T__54=10, T__53=11, T__52=12, T__51=13, T__50=14, T__49=15, T__48=16, 
		T__47=17, T__46=18, T__45=19, T__44=20, T__43=21, T__42=22, T__41=23, 
		T__40=24, T__39=25, T__38=26, T__37=27, T__36=28, T__35=29, T__34=30, 
		T__33=31, T__32=32, T__31=33, T__30=34, T__29=35, T__28=36, T__27=37, 
		T__26=38, T__25=39, T__24=40, T__23=41, T__22=42, T__21=43, T__20=44, 
		T__19=45, T__18=46, T__17=47, T__16=48, T__15=49, T__14=50, T__13=51, 
		T__12=52, T__11=53, T__10=54, T__9=55, T__8=56, T__7=57, T__6=58, T__5=59, 
		T__4=60, T__3=61, T__2=62, T__1=63, T__0=64, ID=65, NUM=66, STRING=67, 
		REAL=68, COMMENT=69, WS=70;
	public static final String[] tokenNames = {
		"<INVALID>", "'WHERE'", "'*'", "'DELETE'", "'CONSTRAINT'", "'<'", "'!='", 
		"'<='", "'AS'", "'PRIMARY'", "'RENAME'", "'ORDER'", "'SET'", "'COLUMNS'", 
		"'MAX'", "'AND'", "')'", "'CHAR'", "'TABLE'", "'SUM'", "'DESC'", "'='", 
		"'ADD'", "'SHOW'", "'DATABASES'", "'REFERENCES'", "'IS'", "'FLOAT'", "'DROP'", 
		"'USE'", "'FROM'", "'LIKE'", "'COUNT'", "'INSERT'", "'CHECK'", "'NOT'", 
		"'SELECT'", "'INT'", "'TO'", "'BY'", "','", "'ASC'", "'-'", "'('", "'TABLES'", 
		"'FOREIGN'", "'AVG'", "'OR'", "'VALUES'", "'DATE'", "'INTO'", "'.'", "'NULL'", 
		"'+'", "'UPDATE'", "'COLUMN'", "'ALTER'", "';'", "'KEY'", "'CREATE'", 
		"'MIN'", "'>'", "'DATABASE'", "'/'", "'>='", "ID", "NUM", "STRING", "REAL", 
		"COMMENT", "WS"
	};
	public static final int
		RULE_queries = 0, RULE_query = 1, RULE_databaseStm = 2, RULE_tableStm = 3, 
		RULE_showStm = 4, RULE_alterStm = 5, RULE_createStm = 6, RULE_createList = 7, 
		RULE_createDef = 8, RULE_fieldDef = 9, RULE_type = 10, RULE_constraint = 11, 
		RULE_constraintType = 12, RULE_dropStm = 13, RULE_insertStm = 14, RULE_updateStm = 15, 
		RULE_assignList = 16, RULE_deleteStm = 17, RULE_selectStm = 18, RULE_columns = 19, 
		RULE_columnList = 20, RULE_columnItem = 21, RULE_columnSource = 22, RULE_aggregate = 23, 
		RULE_fromClause = 24, RULE_whereClause = 25, RULE_orderClause = 26, RULE_orderList = 27, 
		RULE_orderType = 28, RULE_expression = 29, RULE_andExp = 30, RULE_notExp = 31, 
		RULE_predExp = 32, RULE_addExp = 33, RULE_multExp = 34, RULE_negateExp = 35, 
		RULE_value = 36, RULE_exprList = 37, RULE_idListFrom = 38, RULE_idList = 39, 
		RULE_idMember = 40;
	public static final String[] ruleNames = {
		"queries", "query", "databaseStm", "tableStm", "showStm", "alterStm", 
		"createStm", "createList", "createDef", "fieldDef", "type", "constraint", 
		"constraintType", "dropStm", "insertStm", "updateStm", "assignList", "deleteStm", 
		"selectStm", "columns", "columnList", "columnItem", "columnSource", "aggregate", 
		"fromClause", "whereClause", "orderClause", "orderList", "orderType", 
		"expression", "andExp", "notExp", "predExp", "addExp", "multExp", "negateExp", 
		"value", "exprList", "idListFrom", "idList", "idMember"
	};

	@Override
	public String getGrammarFileName() { return "SQL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public SQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class QueriesContext extends ParserRuleContext {
		public QueriesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queries; }
	 
		public QueriesContext() { }
		public void copyFrom(QueriesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MulQContext extends QueriesContext {
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public MulQContext(QueriesContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitMulQ(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleQContext extends QueriesContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public SingleQContext(QueriesContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitSingleQ(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueriesContext queries() throws RecognitionException {
		QueriesContext _localctx = new QueriesContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_queries);
		int _la;
		try {
			setState(94);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new SingleQContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(82); query();
				setState(84);
				_la = _input.LA(1);
				if (_la==57) {
					{
					setState(83); match(57);
					}
				}

				}
				break;

			case 2:
				_localctx = new MulQContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(86); query();
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==57) {
					{
					{
					setState(87); match(57);
					setState(88); query();
					}
					}
					setState(93);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryContext extends ParserRuleContext {
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
	 
		public QueryContext() { }
		public void copyFrom(QueryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DataStmContext extends QueryContext {
		public DatabaseStmContext databaseStm() {
			return getRuleContext(DatabaseStmContext.class,0);
		}
		public DataStmContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitDataStm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TblStmContext extends QueryContext {
		public TableStmContext tableStm() {
			return getRuleContext(TableStmContext.class,0);
		}
		public TblStmContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitTblStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_query);
		try {
			setState(98);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new DataStmContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(96); databaseStm();
				}
				break;

			case 2:
				_localctx = new TblStmContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(97); tableStm();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatabaseStmContext extends ParserRuleContext {
		public DatabaseStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_databaseStm; }
	 
		public DatabaseStmContext() { }
		public void copyFrom(DatabaseStmContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DropDBContext extends DatabaseStmContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public DropDBContext(DatabaseStmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitDropDB(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RenameDBContext extends DatabaseStmContext {
		public List<TerminalNode> ID() { return getTokens(SQLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SQLParser.ID, i);
		}
		public RenameDBContext(DatabaseStmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitRenameDB(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateDBContext extends DatabaseStmContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public CreateDBContext(DatabaseStmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitCreateDB(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShowDBContext extends DatabaseStmContext {
		public ShowDBContext(DatabaseStmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitShowDB(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UseDBContext extends DatabaseStmContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public UseDBContext(DatabaseStmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitUseDB(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatabaseStmContext databaseStm() throws RecognitionException {
		DatabaseStmContext _localctx = new DatabaseStmContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_databaseStm);
		try {
			setState(117);
			switch (_input.LA(1)) {
			case 59:
				_localctx = new CreateDBContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(100); match(59);
				setState(101); match(62);
				setState(102); match(ID);
				}
				break;
			case 56:
				_localctx = new RenameDBContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(103); match(56);
				setState(104); match(62);
				setState(105); match(ID);
				setState(106); match(10);
				setState(107); match(38);
				setState(108); match(ID);
				}
				break;
			case 28:
				_localctx = new DropDBContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(109); match(28);
				setState(110); match(62);
				setState(111); match(ID);
				}
				break;
			case 23:
				_localctx = new ShowDBContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(112); match(23);
				setState(113); match(24);
				}
				break;
			case 29:
				_localctx = new UseDBContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(114); match(29);
				setState(115); match(62);
				setState(116); match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableStmContext extends ParserRuleContext {
		public CreateStmContext createStm() {
			return getRuleContext(CreateStmContext.class,0);
		}
		public ShowStmContext showStm() {
			return getRuleContext(ShowStmContext.class,0);
		}
		public SelectStmContext selectStm() {
			return getRuleContext(SelectStmContext.class,0);
		}
		public InsertStmContext insertStm() {
			return getRuleContext(InsertStmContext.class,0);
		}
		public DeleteStmContext deleteStm() {
			return getRuleContext(DeleteStmContext.class,0);
		}
		public AlterStmContext alterStm() {
			return getRuleContext(AlterStmContext.class,0);
		}
		public DropStmContext dropStm() {
			return getRuleContext(DropStmContext.class,0);
		}
		public UpdateStmContext updateStm() {
			return getRuleContext(UpdateStmContext.class,0);
		}
		public TableStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableStm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitTableStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableStmContext tableStm() throws RecognitionException {
		TableStmContext _localctx = new TableStmContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tableStm);
		try {
			setState(127);
			switch (_input.LA(1)) {
			case 56:
				enterOuterAlt(_localctx, 1);
				{
				setState(119); alterStm();
				}
				break;
			case 59:
				enterOuterAlt(_localctx, 2);
				{
				setState(120); createStm();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(121); deleteStm();
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 4);
				{
				setState(122); dropStm();
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 5);
				{
				setState(123); insertStm();
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 6);
				{
				setState(124); selectStm();
				}
				break;
			case 54:
				enterOuterAlt(_localctx, 7);
				{
				setState(125); updateStm();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 8);
				{
				setState(126); showStm();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShowStmContext extends ParserRuleContext {
		public ShowStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_showStm; }
	 
		public ShowStmContext() { }
		public void copyFrom(ShowStmContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ShowTblContext extends ShowStmContext {
		public ShowTblContext(ShowStmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitShowTbl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShowColContext extends ShowStmContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public ShowColContext(ShowStmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitShowCol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShowStmContext showStm() throws RecognitionException {
		ShowStmContext _localctx = new ShowStmContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_showStm);
		try {
			setState(135);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new ShowTblContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(129); match(23);
				setState(130); match(44);
				}
				break;

			case 2:
				_localctx = new ShowColContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(131); match(23);
				setState(132); match(13);
				setState(133); match(30);
				setState(134); match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlterStmContext extends ParserRuleContext {
		public AlterStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alterStm; }
	 
		public AlterStmContext() { }
		public void copyFrom(AlterStmContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DropConContext extends AlterStmContext {
		public List<TerminalNode> ID() { return getTokens(SQLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SQLParser.ID, i);
		}
		public DropConContext(AlterStmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitDropCon(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddConContext extends AlterStmContext {
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public AddConContext(AlterStmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitAddCon(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropColContext extends AlterStmContext {
		public List<TerminalNode> ID() { return getTokens(SQLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SQLParser.ID, i);
		}
		public DropColContext(AlterStmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitDropCol(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RenameTblContext extends AlterStmContext {
		public List<TerminalNode> ID() { return getTokens(SQLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SQLParser.ID, i);
		}
		public RenameTblContext(AlterStmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitRenameTbl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddColContext extends AlterStmContext {
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(SQLParser.ID); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID(int i) {
			return getToken(SQLParser.ID, i);
		}
		public AddColContext(AlterStmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitAddCol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlterStmContext alterStm() throws RecognitionException {
		AlterStmContext _localctx = new AlterStmContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_alterStm);
		int _la;
		try {
			setState(174);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new RenameTblContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(137); match(56);
				setState(138); match(18);
				setState(139); match(ID);
				setState(140); match(10);
				setState(141); match(38);
				setState(142); match(ID);
				}
				break;

			case 2:
				_localctx = new AddColContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(143); match(56);
				setState(144); match(18);
				setState(145); match(ID);
				setState(146); match(22);
				setState(147); match(55);
				setState(148); match(ID);
				setState(149); type();
				setState(152);
				_la = _input.LA(1);
				if (_la==35) {
					{
					setState(150); match(35);
					setState(151); match(52);
					}
				}

				setState(155);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(154); constraint();
					}
				}

				}
				break;

			case 3:
				_localctx = new AddConContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(157); match(56);
				setState(158); match(18);
				setState(159); match(ID);
				setState(160); match(22);
				setState(161); constraint();
				}
				break;

			case 4:
				_localctx = new DropColContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(162); match(56);
				setState(163); match(18);
				setState(164); match(ID);
				setState(165); match(28);
				setState(166); match(55);
				setState(167); match(ID);
				}
				break;

			case 5:
				_localctx = new DropConContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(168); match(56);
				setState(169); match(18);
				setState(170); match(ID);
				setState(171); match(28);
				setState(172); match(4);
				setState(173); match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateStmContext extends ParserRuleContext {
		public CreateListContext createList() {
			return getRuleContext(CreateListContext.class,0);
		}
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public CreateStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createStm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitCreateStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateStmContext createStm() throws RecognitionException {
		CreateStmContext _localctx = new CreateStmContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_createStm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176); match(59);
			setState(177); match(18);
			setState(178); match(ID);
			setState(179); match(43);
			setState(181);
			_la = _input.LA(1);
			if (_la==4 || _la==ID) {
				{
				setState(180); createList();
				}
			}

			setState(183); match(16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateListContext extends ParserRuleContext {
		public CreateListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createList; }
	 
		public CreateListContext() { }
		public void copyFrom(CreateListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MulDefContext extends CreateListContext {
		public CreateDefContext createDef() {
			return getRuleContext(CreateDefContext.class,0);
		}
		public MulDefContext(CreateListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitMulDef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleDefContext extends CreateListContext {
		public CreateListContext createList() {
			return getRuleContext(CreateListContext.class,0);
		}
		public CreateDefContext createDef() {
			return getRuleContext(CreateDefContext.class,0);
		}
		public SingleDefContext(CreateListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitSingleDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateListContext createList() throws RecognitionException {
		CreateListContext _localctx = new CreateListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_createList);
		try {
			setState(190);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new SingleDefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(185); createDef();
				setState(186); match(40);
				setState(187); createList();
				}
				break;

			case 2:
				_localctx = new MulDefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(189); createDef();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateDefContext extends ParserRuleContext {
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public FieldDefContext fieldDef() {
			return getRuleContext(FieldDefContext.class,0);
		}
		public CreateDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitCreateDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateDefContext createDef() throws RecognitionException {
		CreateDefContext _localctx = new CreateDefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_createDef);
		try {
			setState(194);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(192); fieldDef();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 2);
				{
				setState(193); constraint();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDefContext extends ParserRuleContext {
		public Token notNull;
		public Token ref;
		public Token refTable;
		public Token refID;
		public List<TerminalNode> ID() { return getTokens(SQLParser.ID); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID(int i) {
			return getToken(SQLParser.ID, i);
		}
		public FieldDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitFieldDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDefContext fieldDef() throws RecognitionException {
		FieldDefContext _localctx = new FieldDefContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_fieldDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196); match(ID);
			setState(197); type();
			setState(200);
			_la = _input.LA(1);
			if (_la==35) {
				{
				setState(198); ((FieldDefContext)_localctx).notNull = match(35);
				setState(199); match(52);
				}
			}

			setState(207);
			_la = _input.LA(1);
			if (_la==25) {
				{
				setState(202); ((FieldDefContext)_localctx).ref = match(25);
				setState(203); ((FieldDefContext)_localctx).refTable = match(ID);
				setState(204); match(43);
				setState(205); ((FieldDefContext)_localctx).refID = match(ID);
				setState(206); match(16);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(SQLParser.NUM, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type);
		try {
			setState(216);
			switch (_input.LA(1)) {
			case 37:
				enterOuterAlt(_localctx, 1);
				{
				setState(209); match(37);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 2);
				{
				setState(210); match(27);
				}
				break;
			case 49:
				enterOuterAlt(_localctx, 3);
				{
				setState(211); match(49);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 4);
				{
				setState(212); match(17);
				setState(213); match(43);
				setState(214); match(NUM);
				setState(215); match(16);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public ConstraintTypeContext constraintType() {
			return getRuleContext(ConstraintTypeContext.class,0);
		}
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_constraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218); match(4);
			setState(219); match(ID);
			setState(220); constraintType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintTypeContext extends ParserRuleContext {
		public ConstraintTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintType; }
	 
		public ConstraintTypeContext() { }
		public void copyFrom(ConstraintTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FKeyContext extends ConstraintTypeContext {
		public IdListContext idList(int i) {
			return getRuleContext(IdListContext.class,i);
		}
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public List<IdListContext> idList() {
			return getRuleContexts(IdListContext.class);
		}
		public FKeyContext(ConstraintTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitFKey(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CheckContext extends ConstraintTypeContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CheckContext(ConstraintTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitCheck(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PKeyContext extends ConstraintTypeContext {
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public PKeyContext(ConstraintTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitPKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintTypeContext constraintType() throws RecognitionException {
		ConstraintTypeContext _localctx = new ConstraintTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_constraintType);
		try {
			setState(244);
			switch (_input.LA(1)) {
			case 9:
				_localctx = new PKeyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(222); match(9);
				setState(223); match(58);
				setState(224); match(43);
				setState(225); idList();
				setState(226); match(16);
				}
				break;
			case 45:
				_localctx = new FKeyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(228); match(45);
				setState(229); match(58);
				setState(230); match(43);
				setState(231); idList();
				setState(232); match(16);
				setState(233); match(25);
				setState(234); match(ID);
				setState(235); match(43);
				setState(236); idList();
				setState(237); match(16);
				}
				break;
			case 34:
				_localctx = new CheckContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(239); match(34);
				setState(240); match(43);
				setState(241); expression();
				setState(242); match(16);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DropStmContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public DropStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dropStm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitDropStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DropStmContext dropStm() throws RecognitionException {
		DropStmContext _localctx = new DropStmContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_dropStm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246); match(28);
			setState(247); match(18);
			setState(248); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsertStmContext extends ParserRuleContext {
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public InsertStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertStm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitInsertStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertStmContext insertStm() throws RecognitionException {
		InsertStmContext _localctx = new InsertStmContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_insertStm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250); match(33);
			setState(251); match(50);
			setState(252); match(ID);
			setState(257);
			_la = _input.LA(1);
			if (_la==43) {
				{
				setState(253); match(43);
				setState(254); idList();
				setState(255); match(16);
				}
			}

			setState(259); match(48);
			setState(260); match(43);
			setState(262);
			_la = _input.LA(1);
			if (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & ((1L << (35 - 35)) | (1L << (42 - 35)) | (1L << (43 - 35)) | (1L << (52 - 35)) | (1L << (ID - 35)) | (1L << (NUM - 35)) | (1L << (STRING - 35)) | (1L << (REAL - 35)))) != 0)) {
				{
				setState(261); exprList();
				}
			}

			setState(264); match(16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UpdateStmContext extends ParserRuleContext {
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public AssignListContext assignList() {
			return getRuleContext(AssignListContext.class,0);
		}
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public UpdateStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateStm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitUpdateStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdateStmContext updateStm() throws RecognitionException {
		UpdateStmContext _localctx = new UpdateStmContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_updateStm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266); match(54);
			setState(267); match(ID);
			setState(268); match(12);
			setState(269); assignList();
			setState(270); whereClause();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignListContext extends ParserRuleContext {
		public AssignListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignList; }
	 
		public AssignListContext() { }
		public void copyFrom(AssignListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MulAssContext extends AssignListContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MulAssContext(AssignListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitMulAss(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleAssContext extends AssignListContext {
		public AssignListContext assignList() {
			return getRuleContext(AssignListContext.class,0);
		}
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SingleAssContext(AssignListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitSingleAss(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignListContext assignList() throws RecognitionException {
		AssignListContext _localctx = new AssignListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_assignList);
		try {
			setState(281);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new SingleAssContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(272); match(ID);
				setState(273); match(21);
				setState(274); expression();
				setState(275); match(40);
				setState(276); assignList();
				}
				break;

			case 2:
				_localctx = new MulAssContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(278); match(ID);
				setState(279); match(21);
				setState(280); expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeleteStmContext extends ParserRuleContext {
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public DeleteStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteStm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitDeleteStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeleteStmContext deleteStm() throws RecognitionException {
		DeleteStmContext _localctx = new DeleteStmContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_deleteStm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283); match(3);
			setState(284); match(30);
			setState(285); match(ID);
			setState(286); whereClause();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectStmContext extends ParserRuleContext {
		public ColumnsContext columnas;
		public OrderClauseContext orderClause() {
			return getRuleContext(OrderClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public ColumnsContext columns() {
			return getRuleContext(ColumnsContext.class,0);
		}
		public FromClauseContext fromClause() {
			return getRuleContext(FromClauseContext.class,0);
		}
		public SelectStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitSelectStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectStmContext selectStm() throws RecognitionException {
		SelectStmContext _localctx = new SelectStmContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_selectStm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288); match(36);
			setState(289); ((SelectStmContext)_localctx).columnas = columns();
			setState(290); fromClause();
			setState(291); whereClause();
			setState(292); orderClause();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnsContext extends ParserRuleContext {
		public ColumnsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columns; }
	 
		public ColumnsContext() { }
		public void copyFrom(ColumnsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SelectColContext extends ColumnsContext {
		public ColumnListContext columnList() {
			return getRuleContext(ColumnListContext.class,0);
		}
		public SelectColContext(ColumnsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitSelectCol(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SelectAllContext extends ColumnsContext {
		public SelectAllContext(ColumnsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitSelectAll(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnsContext columns() throws RecognitionException {
		ColumnsContext _localctx = new ColumnsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_columns);
		try {
			setState(296);
			switch (_input.LA(1)) {
			case 2:
				_localctx = new SelectAllContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(294); match(2);
				}
				break;
			case 14:
			case 19:
			case 32:
			case 46:
			case 60:
			case ID:
				_localctx = new SelectColContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(295); columnList();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnListContext extends ParserRuleContext {
		public ColumnListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnList; }
	 
		public ColumnListContext() { }
		public void copyFrom(ColumnListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SingleColContext extends ColumnListContext {
		public ColumnListContext columnList() {
			return getRuleContext(ColumnListContext.class,0);
		}
		public ColumnItemContext columnItem() {
			return getRuleContext(ColumnItemContext.class,0);
		}
		public SingleColContext(ColumnListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitSingleCol(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulColContext extends ColumnListContext {
		public ColumnItemContext columnItem() {
			return getRuleContext(ColumnItemContext.class,0);
		}
		public MulColContext(ColumnListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitMulCol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnListContext columnList() throws RecognitionException {
		ColumnListContext _localctx = new ColumnListContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_columnList);
		try {
			setState(303);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new SingleColContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(298); columnItem();
				setState(299); match(40);
				setState(300); columnList();
				}
				break;

			case 2:
				_localctx = new MulColContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(302); columnItem();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnItemContext extends ParserRuleContext {
		public ColumnItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnItem; }
	 
		public ColumnItemContext() { }
		public void copyFrom(ColumnItemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ColumnAsContext extends ColumnItemContext {
		public Token as;
		public ColumnSourceContext columnSource() {
			return getRuleContext(ColumnSourceContext.class,0);
		}
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public ColumnAsContext(ColumnItemContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitColumnAs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ColumnContext extends ColumnItemContext {
		public ColumnSourceContext columnSource() {
			return getRuleContext(ColumnSourceContext.class,0);
		}
		public ColumnContext(ColumnItemContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitColumn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnItemContext columnItem() throws RecognitionException {
		ColumnItemContext _localctx = new ColumnItemContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_columnItem);
		try {
			setState(310);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new ColumnContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(305); columnSource();
				}
				break;

			case 2:
				_localctx = new ColumnAsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(306); columnSource();
				setState(307); ((ColumnAsContext)_localctx).as = match(8);
				setState(308); match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnSourceContext extends ParserRuleContext {
		public ColumnSourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnSource; }
	 
		public ColumnSourceContext() { }
		public void copyFrom(ColumnSourceContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RefTblContext extends ColumnSourceContext {
		public List<TerminalNode> ID() { return getTokens(SQLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SQLParser.ID, i);
		}
		public RefTblContext(ColumnSourceContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitRefTbl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ColAggContext extends ColumnSourceContext {
		public AggregateContext aggregate() {
			return getRuleContext(AggregateContext.class,0);
		}
		public ColAggContext(ColumnSourceContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitColAgg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnSourceContext columnSource() throws RecognitionException {
		ColumnSourceContext _localctx = new ColumnSourceContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_columnSource);
		int _la;
		try {
			setState(318);
			switch (_input.LA(1)) {
			case 14:
			case 19:
			case 32:
			case 46:
			case 60:
				_localctx = new ColAggContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(312); aggregate();
				}
				break;
			case ID:
				_localctx = new RefTblContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(313); match(ID);
				setState(316);
				_la = _input.LA(1);
				if (_la==51) {
					{
					setState(314); match(51);
					setState(315); match(ID);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AggregateContext extends ParserRuleContext {
		public AggregateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregate; }
	 
		public AggregateContext() { }
		public void copyFrom(AggregateContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MinContext extends AggregateContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MinContext(AggregateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitMin(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MaxContext extends AggregateContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MaxContext(AggregateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitMax(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CountAllContext extends AggregateContext {
		public CountAllContext(AggregateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitCountAll(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SumContext extends AggregateContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SumContext(AggregateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitSum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AvgContext extends AggregateContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AvgContext(AggregateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitAvg(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CountExpContext extends AggregateContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CountExpContext(AggregateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitCountExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AggregateContext aggregate() throws RecognitionException {
		AggregateContext _localctx = new AggregateContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_aggregate);
		try {
			setState(349);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new CountAllContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(320); match(32);
				setState(321); match(43);
				setState(322); match(2);
				setState(323); match(16);
				}
				break;

			case 2:
				_localctx = new CountExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(324); match(32);
				setState(325); match(43);
				setState(326); expression();
				setState(327); match(16);
				}
				break;

			case 3:
				_localctx = new AvgContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(329); match(46);
				setState(330); match(43);
				setState(331); expression();
				setState(332); match(16);
				}
				break;

			case 4:
				_localctx = new MinContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(334); match(60);
				setState(335); match(43);
				setState(336); expression();
				setState(337); match(16);
				}
				break;

			case 5:
				_localctx = new MaxContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(339); match(14);
				setState(340); match(43);
				setState(341); expression();
				setState(342); match(16);
				}
				break;

			case 6:
				_localctx = new SumContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(344); match(19);
				setState(345); match(43);
				setState(346); expression();
				setState(347); match(16);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FromClauseContext extends ParserRuleContext {
		public IdListFromContext idListFrom() {
			return getRuleContext(IdListFromContext.class,0);
		}
		public FromClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitFromClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FromClauseContext fromClause() throws RecognitionException {
		FromClauseContext _localctx = new FromClauseContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_fromClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351); match(30);
			setState(352); idListFrom();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereClauseContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitWhereClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_whereClause);
		try {
			setState(357);
			switch (_input.LA(1)) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(354); match(1);
				setState(355); expression();
				}
				break;
			case EOF:
			case 11:
			case 57:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderClauseContext extends ParserRuleContext {
		public OrderListContext orderList() {
			return getRuleContext(OrderListContext.class,0);
		}
		public OrderClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitOrderClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderClauseContext orderClause() throws RecognitionException {
		OrderClauseContext _localctx = new OrderClauseContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_orderClause);
		try {
			setState(363);
			switch (_input.LA(1)) {
			case 11:
				enterOuterAlt(_localctx, 1);
				{
				setState(359); match(11);
				setState(360); match(39);
				setState(361); orderList();
				}
				break;
			case EOF:
			case 57:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderListContext extends ParserRuleContext {
		public OrderListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderList; }
	 
		public OrderListContext() { }
		public void copyFrom(OrderListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SingleOrderContext extends OrderListContext {
		public OrderTypeContext orderType() {
			return getRuleContext(OrderTypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(SQLParser.ID); }
		public OrderListContext orderList() {
			return getRuleContext(OrderListContext.class,0);
		}
		public TerminalNode ID(int i) {
			return getToken(SQLParser.ID, i);
		}
		public SingleOrderContext(OrderListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitSingleOrder(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulOrderContext extends OrderListContext {
		public OrderTypeContext orderType() {
			return getRuleContext(OrderTypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(SQLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SQLParser.ID, i);
		}
		public MulOrderContext(OrderListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitMulOrder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderListContext orderList() throws RecognitionException {
		OrderListContext _localctx = new OrderListContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_orderList);
		int _la;
		try {
			setState(380);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				_localctx = new SingleOrderContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(365); match(ID);
				setState(368);
				_la = _input.LA(1);
				if (_la==51) {
					{
					setState(366); match(51);
					setState(367); match(ID);
					}
				}

				setState(370); orderType();
				setState(371); match(40);
				setState(372); orderList();
				}
				break;

			case 2:
				_localctx = new MulOrderContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(374); match(ID);
				setState(377);
				_la = _input.LA(1);
				if (_la==51) {
					{
					setState(375); match(51);
					setState(376); match(ID);
					}
				}

				setState(379); orderType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderTypeContext extends ParserRuleContext {
		public OrderTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderType; }
	 
		public OrderTypeContext() { }
		public void copyFrom(OrderTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DescContext extends OrderTypeContext {
		public DescContext(OrderTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitDesc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AscContext extends OrderTypeContext {
		public AscContext(OrderTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitAsc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NadaContext extends OrderTypeContext {
		public NadaContext(OrderTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitNada(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderTypeContext orderType() throws RecognitionException {
		OrderTypeContext _localctx = new OrderTypeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_orderType);
		try {
			setState(385);
			switch (_input.LA(1)) {
			case 41:
				_localctx = new AscContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(382); match(41);
				}
				break;
			case 20:
				_localctx = new DescContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(383); match(20);
				}
				break;
			case EOF:
			case 40:
			case 57:
				_localctx = new NadaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AndExpContext andExp() {
			return getRuleContext(AndExpContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_expression);
		try {
			setState(392);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(387); andExp();
				setState(388); match(47);
				setState(389); expression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(391); andExp();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndExpContext extends ParserRuleContext {
		public NotExpContext notExp() {
			return getRuleContext(NotExpContext.class,0);
		}
		public AndExpContext andExp() {
			return getRuleContext(AndExpContext.class,0);
		}
		public AndExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitAndExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExpContext andExp() throws RecognitionException {
		AndExpContext _localctx = new AndExpContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_andExp);
		try {
			setState(399);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(394); notExp();
				setState(395); match(15);
				setState(396); andExp();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(398); notExp();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotExpContext extends ParserRuleContext {
		public Token not;
		public PredExpContext predExp() {
			return getRuleContext(PredExpContext.class,0);
		}
		public NotExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitNotExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotExpContext notExp() throws RecognitionException {
		NotExpContext _localctx = new NotExpContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_notExp);
		try {
			setState(404);
			switch (_input.LA(1)) {
			case 35:
				enterOuterAlt(_localctx, 1);
				{
				setState(401); ((NotExpContext)_localctx).not = match(35);
				setState(402); predExp();
				}
				break;
			case 42:
			case 43:
			case 52:
			case ID:
			case NUM:
			case STRING:
			case REAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(403); predExp();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredExpContext extends ParserRuleContext {
		public PredExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predExp; }
	 
		public PredExpContext() { }
		public void copyFrom(PredExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LowerEqualContext extends PredExpContext {
		public List<AddExpContext> addExp() {
			return getRuleContexts(AddExpContext.class);
		}
		public AddExpContext addExp(int i) {
			return getRuleContext(AddExpContext.class,i);
		}
		public LowerEqualContext(PredExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitLowerEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterEqualContext extends PredExpContext {
		public List<AddExpContext> addExp() {
			return getRuleContexts(AddExpContext.class);
		}
		public AddExpContext addExp(int i) {
			return getRuleContext(AddExpContext.class,i);
		}
		public GreaterEqualContext(PredExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitGreaterEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpContext extends PredExpContext {
		public AddExpContext addExp() {
			return getRuleContext(AddExpContext.class,0);
		}
		public ExpContext(PredExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsNullContext extends PredExpContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public IsNullContext(PredExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitIsNull(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterContext extends PredExpContext {
		public List<AddExpContext> addExp() {
			return getRuleContexts(AddExpContext.class);
		}
		public AddExpContext addExp(int i) {
			return getRuleContext(AddExpContext.class,i);
		}
		public GreaterContext(PredExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitGreater(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LowerContext extends PredExpContext {
		public List<AddExpContext> addExp() {
			return getRuleContexts(AddExpContext.class);
		}
		public AddExpContext addExp(int i) {
			return getRuleContext(AddExpContext.class,i);
		}
		public LowerContext(PredExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitLower(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualsContext extends PredExpContext {
		public List<AddExpContext> addExp() {
			return getRuleContexts(AddExpContext.class);
		}
		public AddExpContext addExp(int i) {
			return getRuleContext(AddExpContext.class,i);
		}
		public EqualsContext(PredExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitEquals(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotEqualsContext extends PredExpContext {
		public List<AddExpContext> addExp() {
			return getRuleContexts(AddExpContext.class);
		}
		public AddExpContext addExp(int i) {
			return getRuleContext(AddExpContext.class,i);
		}
		public NotEqualsContext(PredExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitNotEquals(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotNullContext extends PredExpContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public NotNullContext(PredExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitNotNull(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LikeContext extends PredExpContext {
		public AddExpContext addExp() {
			return getRuleContext(AddExpContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SQLParser.STRING, 0); }
		public LikeContext(PredExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitLike(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredExpContext predExp() throws RecognitionException {
		PredExpContext _localctx = new PredExpContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_predExp);
		try {
			setState(444);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				_localctx = new NotNullContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(406); value();
				setState(407); match(26);
				setState(408); match(35);
				setState(409); match(52);
				}
				break;

			case 2:
				_localctx = new IsNullContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(411); value();
				setState(412); match(26);
				setState(413); match(52);
				}
				break;

			case 3:
				_localctx = new LikeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(415); addExp();
				setState(416); match(31);
				setState(417); match(STRING);
				}
				break;

			case 4:
				_localctx = new EqualsContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(419); addExp();
				setState(420); match(21);
				setState(421); addExp();
				}
				break;

			case 5:
				_localctx = new NotEqualsContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(423); addExp();
				setState(424); match(6);
				setState(425); addExp();
				}
				break;

			case 6:
				_localctx = new GreaterContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(427); addExp();
				setState(428); match(61);
				setState(429); addExp();
				}
				break;

			case 7:
				_localctx = new GreaterEqualContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(431); addExp();
				setState(432); match(64);
				setState(433); addExp();
				}
				break;

			case 8:
				_localctx = new LowerContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(435); addExp();
				setState(436); match(5);
				setState(437); addExp();
				}
				break;

			case 9:
				_localctx = new LowerEqualContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(439); addExp();
				setState(440); match(7);
				setState(441); addExp();
				}
				break;

			case 10:
				_localctx = new ExpContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(443); addExp();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddExpContext extends ParserRuleContext {
		public AddExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExp; }
	 
		public AddExpContext() { }
		public void copyFrom(AddExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SumaContext extends AddExpContext {
		public AddExpContext addExp() {
			return getRuleContext(AddExpContext.class,0);
		}
		public MultExpContext multExp() {
			return getRuleContext(MultExpContext.class,0);
		}
		public SumaContext(AddExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitSuma(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RestaContext extends AddExpContext {
		public AddExpContext addExp() {
			return getRuleContext(AddExpContext.class,0);
		}
		public MultExpContext multExp() {
			return getRuleContext(MultExpContext.class,0);
		}
		public RestaContext(AddExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitResta(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyAddContext extends AddExpContext {
		public MultExpContext multExp() {
			return getRuleContext(MultExpContext.class,0);
		}
		public EmptyAddContext(AddExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitEmptyAdd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddExpContext addExp() throws RecognitionException {
		AddExpContext _localctx = new AddExpContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_addExp);
		try {
			setState(455);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				_localctx = new SumaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(446); multExp();
				setState(447); match(53);
				setState(448); addExp();
				}
				break;

			case 2:
				_localctx = new RestaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(450); multExp();
				setState(451); match(42);
				setState(452); addExp();
				}
				break;

			case 3:
				_localctx = new EmptyAddContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(454); multExp();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultExpContext extends ParserRuleContext {
		public MultExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multExp; }
	 
		public MultExpContext() { }
		public void copyFrom(MultExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EmptyMultContext extends MultExpContext {
		public NegateExpContext negateExp() {
			return getRuleContext(NegateExpContext.class,0);
		}
		public EmptyMultContext(MultExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitEmptyMult(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultContext extends MultExpContext {
		public NegateExpContext negateExp() {
			return getRuleContext(NegateExpContext.class,0);
		}
		public MultExpContext multExp() {
			return getRuleContext(MultExpContext.class,0);
		}
		public MultContext(MultExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitMult(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivContext extends MultExpContext {
		public NegateExpContext negateExp() {
			return getRuleContext(NegateExpContext.class,0);
		}
		public MultExpContext multExp() {
			return getRuleContext(MultExpContext.class,0);
		}
		public DivContext(MultExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitDiv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultExpContext multExp() throws RecognitionException {
		MultExpContext _localctx = new MultExpContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_multExp);
		try {
			setState(466);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				_localctx = new MultContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(457); negateExp();
				setState(458); match(2);
				setState(459); multExp();
				}
				break;

			case 2:
				_localctx = new DivContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(461); negateExp();
				setState(462); match(63);
				setState(463); multExp();
				}
				break;

			case 3:
				_localctx = new EmptyMultContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(465); negateExp();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NegateExpContext extends ParserRuleContext {
		public NegateExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negateExp; }
	 
		public NegateExpContext() { }
		public void copyFrom(NegateExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NegateContext extends NegateExpContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public NegateContext(NegateExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitNegate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotNegateContext extends NegateExpContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public NotNegateContext(NegateExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitNotNegate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegateExpContext negateExp() throws RecognitionException {
		NegateExpContext _localctx = new NegateExpContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_negateExp);
		try {
			setState(471);
			switch (_input.LA(1)) {
			case 42:
				_localctx = new NegateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(468); match(42);
				setState(469); value();
				}
				break;
			case 43:
			case 52:
			case ID:
			case NUM:
			case STRING:
			case REAL:
				_localctx = new NotNegateContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(470); value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SQLParser.ID); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode REAL() { return getToken(SQLParser.REAL, 0); }
		public TerminalNode STRING() { return getToken(SQLParser.STRING, 0); }
		public TerminalNode NUM() { return getToken(SQLParser.NUM, 0); }
		public TerminalNode ID(int i) {
			return getToken(SQLParser.ID, i);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_value);
		int _la;
		try {
			setState(486);
			switch (_input.LA(1)) {
			case 43:
				enterOuterAlt(_localctx, 1);
				{
				setState(473); match(43);
				setState(474); expression();
				setState(475); match(16);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(477); match(ID);
				setState(480);
				_la = _input.LA(1);
				if (_la==51) {
					{
					setState(478); match(51);
					setState(479); match(ID);
					}
				}

				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(482); match(NUM);
				}
				break;
			case REAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(483); match(REAL);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(484); match(STRING);
				}
				break;
			case 52:
				enterOuterAlt(_localctx, 6);
				{
				setState(485); match(52);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprListContext extends ParserRuleContext {
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
	 
		public ExprListContext() { }
		public void copyFrom(ExprListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MulExpContext extends ExprListContext {
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MulExpContext(ExprListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitMulExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleExpContext extends ExprListContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SingleExpContext(ExprListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitSingleExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_exprList);
		try {
			setState(493);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				_localctx = new MulExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(488); expression();
				setState(489); match(40);
				setState(490); exprList();
				}
				break;

			case 2:
				_localctx = new SingleExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(492); expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdListFromContext extends ParserRuleContext {
		public IdListFromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idListFrom; }
	 
		public IdListFromContext() { }
		public void copyFrom(IdListFromContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SingleTableContext extends IdListFromContext {
		public IdMemberContext idMember(int i) {
			return getRuleContext(IdMemberContext.class,i);
		}
		public List<IdMemberContext> idMember() {
			return getRuleContexts(IdMemberContext.class);
		}
		public SingleTableContext(IdListFromContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitSingleTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulTableContext extends IdListFromContext {
		public IdListFromContext idListFrom() {
			return getRuleContext(IdListFromContext.class,0);
		}
		public IdMemberContext idMember(int i) {
			return getRuleContext(IdMemberContext.class,i);
		}
		public List<IdMemberContext> idMember() {
			return getRuleContexts(IdMemberContext.class);
		}
		public MulTableContext(IdListFromContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitMulTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdListFromContext idListFrom() throws RecognitionException {
		IdListFromContext _localctx = new IdListFromContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_idListFrom);
		int _la;
		try {
			setState(506);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				_localctx = new MulTableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(495); idMember();
				setState(497);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(496); idMember();
					}
				}

				setState(499); match(40);
				setState(500); idListFrom();
				}
				break;

			case 2:
				_localctx = new SingleTableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(502); idMember();
				setState(504);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(503); idMember();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdListContext extends ParserRuleContext {
		public IdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idList; }
	 
		public IdListContext() { }
		public void copyFrom(IdListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SingleMemberContext extends IdListContext {
		public IdMemberContext idMember() {
			return getRuleContext(IdMemberContext.class,0);
		}
		public SingleMemberContext(IdListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitSingleMember(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulMemberContext extends IdListContext {
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public IdMemberContext idMember() {
			return getRuleContext(IdMemberContext.class,0);
		}
		public MulMemberContext(IdListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitMulMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdListContext idList() throws RecognitionException {
		IdListContext _localctx = new IdListContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_idList);
		try {
			setState(513);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				_localctx = new MulMemberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(508); idMember();
				setState(509); match(40);
				setState(510); idList();
				}
				break;

			case 2:
				_localctx = new SingleMemberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(512); idMember();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdMemberContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public IdMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idMember; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitIdMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdMemberContext idMember() throws RecognitionException {
		IdMemberContext _localctx = new IdMemberContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_idMember);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3H\u0208\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\5\2W\n\2\3\2\3\2\3\2\7\2\\\n\2\f\2\16\2_\13\2\5\2a\n\2\3\3\3\3\5\3e\n"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\5\4x\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0082\n\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\5\6\u008a\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\5\7\u009b\n\7\3\7\5\7\u009e\n\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00b1\n\7\3\b\3\b\3\b"+
		"\3\b\3\b\5\b\u00b8\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\5\t\u00c1\n\t\3\n\3"+
		"\n\5\n\u00c5\n\n\3\13\3\13\3\13\3\13\5\13\u00cb\n\13\3\13\3\13\3\13\3"+
		"\13\3\13\5\13\u00d2\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00db\n\f\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00f7\n\16"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0104\n\20"+
		"\3\20\3\20\3\20\5\20\u0109\n\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u011c\n\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\5\25\u012b\n\25"+
		"\3\26\3\26\3\26\3\26\3\26\5\26\u0132\n\26\3\27\3\27\3\27\3\27\3\27\5\27"+
		"\u0139\n\27\3\30\3\30\3\30\3\30\5\30\u013f\n\30\5\30\u0141\n\30\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5"+
		"\31\u0160\n\31\3\32\3\32\3\32\3\33\3\33\3\33\5\33\u0168\n\33\3\34\3\34"+
		"\3\34\3\34\5\34\u016e\n\34\3\35\3\35\3\35\5\35\u0173\n\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\5\35\u017c\n\35\3\35\5\35\u017f\n\35\3\36\3\36"+
		"\3\36\5\36\u0184\n\36\3\37\3\37\3\37\3\37\3\37\5\37\u018b\n\37\3 \3 \3"+
		" \3 \3 \5 \u0192\n \3!\3!\3!\5!\u0197\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u01bf\n\"\3#"+
		"\3#\3#\3#\3#\3#\3#\3#\3#\5#\u01ca\n#\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u01d5"+
		"\n$\3%\3%\3%\5%\u01da\n%\3&\3&\3&\3&\3&\3&\3&\5&\u01e3\n&\3&\3&\3&\3&"+
		"\5&\u01e9\n&\3\'\3\'\3\'\3\'\3\'\5\'\u01f0\n\'\3(\3(\5(\u01f4\n(\3(\3"+
		"(\3(\3(\3(\5(\u01fb\n(\5(\u01fd\n(\3)\3)\3)\3)\3)\5)\u0204\n)\3*\3*\3"+
		"*\2+\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@"+
		"BDFHJLNPR\2\2\u022e\2`\3\2\2\2\4d\3\2\2\2\6w\3\2\2\2\b\u0081\3\2\2\2\n"+
		"\u0089\3\2\2\2\f\u00b0\3\2\2\2\16\u00b2\3\2\2\2\20\u00c0\3\2\2\2\22\u00c4"+
		"\3\2\2\2\24\u00c6\3\2\2\2\26\u00da\3\2\2\2\30\u00dc\3\2\2\2\32\u00f6\3"+
		"\2\2\2\34\u00f8\3\2\2\2\36\u00fc\3\2\2\2 \u010c\3\2\2\2\"\u011b\3\2\2"+
		"\2$\u011d\3\2\2\2&\u0122\3\2\2\2(\u012a\3\2\2\2*\u0131\3\2\2\2,\u0138"+
		"\3\2\2\2.\u0140\3\2\2\2\60\u015f\3\2\2\2\62\u0161\3\2\2\2\64\u0167\3\2"+
		"\2\2\66\u016d\3\2\2\28\u017e\3\2\2\2:\u0183\3\2\2\2<\u018a\3\2\2\2>\u0191"+
		"\3\2\2\2@\u0196\3\2\2\2B\u01be\3\2\2\2D\u01c9\3\2\2\2F\u01d4\3\2\2\2H"+
		"\u01d9\3\2\2\2J\u01e8\3\2\2\2L\u01ef\3\2\2\2N\u01fc\3\2\2\2P\u0203\3\2"+
		"\2\2R\u0205\3\2\2\2TV\5\4\3\2UW\7;\2\2VU\3\2\2\2VW\3\2\2\2Wa\3\2\2\2X"+
		"]\5\4\3\2YZ\7;\2\2Z\\\5\4\3\2[Y\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2"+
		"^a\3\2\2\2_]\3\2\2\2`T\3\2\2\2`X\3\2\2\2a\3\3\2\2\2be\5\6\4\2ce\5\b\5"+
		"\2db\3\2\2\2dc\3\2\2\2e\5\3\2\2\2fg\7=\2\2gh\7@\2\2hx\7C\2\2ij\7:\2\2"+
		"jk\7@\2\2kl\7C\2\2lm\7\f\2\2mn\7(\2\2nx\7C\2\2op\7\36\2\2pq\7@\2\2qx\7"+
		"C\2\2rs\7\31\2\2sx\7\32\2\2tu\7\37\2\2uv\7@\2\2vx\7C\2\2wf\3\2\2\2wi\3"+
		"\2\2\2wo\3\2\2\2wr\3\2\2\2wt\3\2\2\2x\7\3\2\2\2y\u0082\5\f\7\2z\u0082"+
		"\5\16\b\2{\u0082\5$\23\2|\u0082\5\34\17\2}\u0082\5\36\20\2~\u0082\5&\24"+
		"\2\177\u0082\5 \21\2\u0080\u0082\5\n\6\2\u0081y\3\2\2\2\u0081z\3\2\2\2"+
		"\u0081{\3\2\2\2\u0081|\3\2\2\2\u0081}\3\2\2\2\u0081~\3\2\2\2\u0081\177"+
		"\3\2\2\2\u0081\u0080\3\2\2\2\u0082\t\3\2\2\2\u0083\u0084\7\31\2\2\u0084"+
		"\u008a\7.\2\2\u0085\u0086\7\31\2\2\u0086\u0087\7\17\2\2\u0087\u0088\7"+
		" \2\2\u0088\u008a\7C\2\2\u0089\u0083\3\2\2\2\u0089\u0085\3\2\2\2\u008a"+
		"\13\3\2\2\2\u008b\u008c\7:\2\2\u008c\u008d\7\24\2\2\u008d\u008e\7C\2\2"+
		"\u008e\u008f\7\f\2\2\u008f\u0090\7(\2\2\u0090\u00b1\7C\2\2\u0091\u0092"+
		"\7:\2\2\u0092\u0093\7\24\2\2\u0093\u0094\7C\2\2\u0094\u0095\7\30\2\2\u0095"+
		"\u0096\79\2\2\u0096\u0097\7C\2\2\u0097\u009a\5\26\f\2\u0098\u0099\7%\2"+
		"\2\u0099\u009b\7\66\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u009d\3\2\2\2\u009c\u009e\5\30\r\2\u009d\u009c\3\2\2\2\u009d\u009e\3"+
		"\2\2\2\u009e\u00b1\3\2\2\2\u009f\u00a0\7:\2\2\u00a0\u00a1\7\24\2\2\u00a1"+
		"\u00a2\7C\2\2\u00a2\u00a3\7\30\2\2\u00a3\u00b1\5\30\r\2\u00a4\u00a5\7"+
		":\2\2\u00a5\u00a6\7\24\2\2\u00a6\u00a7\7C\2\2\u00a7\u00a8\7\36\2\2\u00a8"+
		"\u00a9\79\2\2\u00a9\u00b1\7C\2\2\u00aa\u00ab\7:\2\2\u00ab\u00ac\7\24\2"+
		"\2\u00ac\u00ad\7C\2\2\u00ad\u00ae\7\36\2\2\u00ae\u00af\7\6\2\2\u00af\u00b1"+
		"\7C\2\2\u00b0\u008b\3\2\2\2\u00b0\u0091\3\2\2\2\u00b0\u009f\3\2\2\2\u00b0"+
		"\u00a4\3\2\2\2\u00b0\u00aa\3\2\2\2\u00b1\r\3\2\2\2\u00b2\u00b3\7=\2\2"+
		"\u00b3\u00b4\7\24\2\2\u00b4\u00b5\7C\2\2\u00b5\u00b7\7-\2\2\u00b6\u00b8"+
		"\5\20\t\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2"+
		"\u00b9\u00ba\7\22\2\2\u00ba\17\3\2\2\2\u00bb\u00bc\5\22\n\2\u00bc\u00bd"+
		"\7*\2\2\u00bd\u00be\5\20\t\2\u00be\u00c1\3\2\2\2\u00bf\u00c1\5\22\n\2"+
		"\u00c0\u00bb\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\21\3\2\2\2\u00c2\u00c5"+
		"\5\24\13\2\u00c3\u00c5\5\30\r\2\u00c4\u00c2\3\2\2\2\u00c4\u00c3\3\2\2"+
		"\2\u00c5\23\3\2\2\2\u00c6\u00c7\7C\2\2\u00c7\u00ca\5\26\f\2\u00c8\u00c9"+
		"\7%\2\2\u00c9\u00cb\7\66\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00d1\3\2\2\2\u00cc\u00cd\7\33\2\2\u00cd\u00ce\7C\2\2\u00ce\u00cf\7-"+
		"\2\2\u00cf\u00d0\7C\2\2\u00d0\u00d2\7\22\2\2\u00d1\u00cc\3\2\2\2\u00d1"+
		"\u00d2\3\2\2\2\u00d2\25\3\2\2\2\u00d3\u00db\7\'\2\2\u00d4\u00db\7\35\2"+
		"\2\u00d5\u00db\7\63\2\2\u00d6\u00d7\7\23\2\2\u00d7\u00d8\7-\2\2\u00d8"+
		"\u00d9\7D\2\2\u00d9\u00db\7\22\2\2\u00da\u00d3\3\2\2\2\u00da\u00d4\3\2"+
		"\2\2\u00da\u00d5\3\2\2\2\u00da\u00d6\3\2\2\2\u00db\27\3\2\2\2\u00dc\u00dd"+
		"\7\6\2\2\u00dd\u00de\7C\2\2\u00de\u00df\5\32\16\2\u00df\31\3\2\2\2\u00e0"+
		"\u00e1\7\13\2\2\u00e1\u00e2\7<\2\2\u00e2\u00e3\7-\2\2\u00e3\u00e4\5P)"+
		"\2\u00e4\u00e5\7\22\2\2\u00e5\u00f7\3\2\2\2\u00e6\u00e7\7/\2\2\u00e7\u00e8"+
		"\7<\2\2\u00e8\u00e9\7-\2\2\u00e9\u00ea\5P)\2\u00ea\u00eb\7\22\2\2\u00eb"+
		"\u00ec\7\33\2\2\u00ec\u00ed\7C\2\2\u00ed\u00ee\7-\2\2\u00ee\u00ef\5P)"+
		"\2\u00ef\u00f0\7\22\2\2\u00f0\u00f7\3\2\2\2\u00f1\u00f2\7$\2\2\u00f2\u00f3"+
		"\7-\2\2\u00f3\u00f4\5<\37\2\u00f4\u00f5\7\22\2\2\u00f5\u00f7\3\2\2\2\u00f6"+
		"\u00e0\3\2\2\2\u00f6\u00e6\3\2\2\2\u00f6\u00f1\3\2\2\2\u00f7\33\3\2\2"+
		"\2\u00f8\u00f9\7\36\2\2\u00f9\u00fa\7\24\2\2\u00fa\u00fb\7C\2\2\u00fb"+
		"\35\3\2\2\2\u00fc\u00fd\7#\2\2\u00fd\u00fe\7\64\2\2\u00fe\u0103\7C\2\2"+
		"\u00ff\u0100\7-\2\2\u0100\u0101\5P)\2\u0101\u0102\7\22\2\2\u0102\u0104"+
		"\3\2\2\2\u0103\u00ff\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\3\2\2\2\u0105"+
		"\u0106\7\62\2\2\u0106\u0108\7-\2\2\u0107\u0109\5L\'\2\u0108\u0107\3\2"+
		"\2\2\u0108\u0109\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\7\22\2\2\u010b"+
		"\37\3\2\2\2\u010c\u010d\78\2\2\u010d\u010e\7C\2\2\u010e\u010f\7\16\2\2"+
		"\u010f\u0110\5\"\22\2\u0110\u0111\5\64\33\2\u0111!\3\2\2\2\u0112\u0113"+
		"\7C\2\2\u0113\u0114\7\27\2\2\u0114\u0115\5<\37\2\u0115\u0116\7*\2\2\u0116"+
		"\u0117\5\"\22\2\u0117\u011c\3\2\2\2\u0118\u0119\7C\2\2\u0119\u011a\7\27"+
		"\2\2\u011a\u011c\5<\37\2\u011b\u0112\3\2\2\2\u011b\u0118\3\2\2\2\u011c"+
		"#\3\2\2\2\u011d\u011e\7\5\2\2\u011e\u011f\7 \2\2\u011f\u0120\7C\2\2\u0120"+
		"\u0121\5\64\33\2\u0121%\3\2\2\2\u0122\u0123\7&\2\2\u0123\u0124\5(\25\2"+
		"\u0124\u0125\5\62\32\2\u0125\u0126\5\64\33\2\u0126\u0127\5\66\34\2\u0127"+
		"\'\3\2\2\2\u0128\u012b\7\4\2\2\u0129\u012b\5*\26\2\u012a\u0128\3\2\2\2"+
		"\u012a\u0129\3\2\2\2\u012b)\3\2\2\2\u012c\u012d\5,\27\2\u012d\u012e\7"+
		"*\2\2\u012e\u012f\5*\26\2\u012f\u0132\3\2\2\2\u0130\u0132\5,\27\2\u0131"+
		"\u012c\3\2\2\2\u0131\u0130\3\2\2\2\u0132+\3\2\2\2\u0133\u0139\5.\30\2"+
		"\u0134\u0135\5.\30\2\u0135\u0136\7\n\2\2\u0136\u0137\7C\2\2\u0137\u0139"+
		"\3\2\2\2\u0138\u0133\3\2\2\2\u0138\u0134\3\2\2\2\u0139-\3\2\2\2\u013a"+
		"\u0141\5\60\31\2\u013b\u013e\7C\2\2\u013c\u013d\7\65\2\2\u013d\u013f\7"+
		"C\2\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0141\3\2\2\2\u0140"+
		"\u013a\3\2\2\2\u0140\u013b\3\2\2\2\u0141/\3\2\2\2\u0142\u0143\7\"\2\2"+
		"\u0143\u0144\7-\2\2\u0144\u0145\7\4\2\2\u0145\u0160\7\22\2\2\u0146\u0147"+
		"\7\"\2\2\u0147\u0148\7-\2\2\u0148\u0149\5<\37\2\u0149\u014a\7\22\2\2\u014a"+
		"\u0160\3\2\2\2\u014b\u014c\7\60\2\2\u014c\u014d\7-\2\2\u014d\u014e\5<"+
		"\37\2\u014e\u014f\7\22\2\2\u014f\u0160\3\2\2\2\u0150\u0151\7>\2\2\u0151"+
		"\u0152\7-\2\2\u0152\u0153\5<\37\2\u0153\u0154\7\22\2\2\u0154\u0160\3\2"+
		"\2\2\u0155\u0156\7\20\2\2\u0156\u0157\7-\2\2\u0157\u0158\5<\37\2\u0158"+
		"\u0159\7\22\2\2\u0159\u0160\3\2\2\2\u015a\u015b\7\25\2\2\u015b\u015c\7"+
		"-\2\2\u015c\u015d\5<\37\2\u015d\u015e\7\22\2\2\u015e\u0160\3\2\2\2\u015f"+
		"\u0142\3\2\2\2\u015f\u0146\3\2\2\2\u015f\u014b\3\2\2\2\u015f\u0150\3\2"+
		"\2\2\u015f\u0155\3\2\2\2\u015f\u015a\3\2\2\2\u0160\61\3\2\2\2\u0161\u0162"+
		"\7 \2\2\u0162\u0163\5N(\2\u0163\63\3\2\2\2\u0164\u0165\7\3\2\2\u0165\u0168"+
		"\5<\37\2\u0166\u0168\3\2\2\2\u0167\u0164\3\2\2\2\u0167\u0166\3\2\2\2\u0168"+
		"\65\3\2\2\2\u0169\u016a\7\r\2\2\u016a\u016b\7)\2\2\u016b\u016e\58\35\2"+
		"\u016c\u016e\3\2\2\2\u016d\u0169\3\2\2\2\u016d\u016c\3\2\2\2\u016e\67"+
		"\3\2\2\2\u016f\u0172\7C\2\2\u0170\u0171\7\65\2\2\u0171\u0173\7C\2\2\u0172"+
		"\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0175\5:"+
		"\36\2\u0175\u0176\7*\2\2\u0176\u0177\58\35\2\u0177\u017f\3\2\2\2\u0178"+
		"\u017b\7C\2\2\u0179\u017a\7\65\2\2\u017a\u017c\7C\2\2\u017b\u0179\3\2"+
		"\2\2\u017b\u017c\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017f\5:\36\2\u017e"+
		"\u016f\3\2\2\2\u017e\u0178\3\2\2\2\u017f9\3\2\2\2\u0180\u0184\7+\2\2\u0181"+
		"\u0184\7\26\2\2\u0182\u0184\3\2\2\2\u0183\u0180\3\2\2\2\u0183\u0181\3"+
		"\2\2\2\u0183\u0182\3\2\2\2\u0184;\3\2\2\2\u0185\u0186\5> \2\u0186\u0187"+
		"\7\61\2\2\u0187\u0188\5<\37\2\u0188\u018b\3\2\2\2\u0189\u018b\5> \2\u018a"+
		"\u0185\3\2\2\2\u018a\u0189\3\2\2\2\u018b=\3\2\2\2\u018c\u018d\5@!\2\u018d"+
		"\u018e\7\21\2\2\u018e\u018f\5> \2\u018f\u0192\3\2\2\2\u0190\u0192\5@!"+
		"\2\u0191\u018c\3\2\2\2\u0191\u0190\3\2\2\2\u0192?\3\2\2\2\u0193\u0194"+
		"\7%\2\2\u0194\u0197\5B\"\2\u0195\u0197\5B\"\2\u0196\u0193\3\2\2\2\u0196"+
		"\u0195\3\2\2\2\u0197A\3\2\2\2\u0198\u0199\5J&\2\u0199\u019a\7\34\2\2\u019a"+
		"\u019b\7%\2\2\u019b\u019c\7\66\2\2\u019c\u01bf\3\2\2\2\u019d\u019e\5J"+
		"&\2\u019e\u019f\7\34\2\2\u019f\u01a0\7\66\2\2\u01a0\u01bf\3\2\2\2\u01a1"+
		"\u01a2\5D#\2\u01a2\u01a3\7!\2\2\u01a3\u01a4\7E\2\2\u01a4\u01bf\3\2\2\2"+
		"\u01a5\u01a6\5D#\2\u01a6\u01a7\7\27\2\2\u01a7\u01a8\5D#\2\u01a8\u01bf"+
		"\3\2\2\2\u01a9\u01aa\5D#\2\u01aa\u01ab\7\b\2\2\u01ab\u01ac\5D#\2\u01ac"+
		"\u01bf\3\2\2\2\u01ad\u01ae\5D#\2\u01ae\u01af\7?\2\2\u01af\u01b0\5D#\2"+
		"\u01b0\u01bf\3\2\2\2\u01b1\u01b2\5D#\2\u01b2\u01b3\7B\2\2\u01b3\u01b4"+
		"\5D#\2\u01b4\u01bf\3\2\2\2\u01b5\u01b6\5D#\2\u01b6\u01b7\7\7\2\2\u01b7"+
		"\u01b8\5D#\2\u01b8\u01bf\3\2\2\2\u01b9\u01ba\5D#\2\u01ba\u01bb\7\t\2\2"+
		"\u01bb\u01bc\5D#\2\u01bc\u01bf\3\2\2\2\u01bd\u01bf\5D#\2\u01be\u0198\3"+
		"\2\2\2\u01be\u019d\3\2\2\2\u01be\u01a1\3\2\2\2\u01be\u01a5\3\2\2\2\u01be"+
		"\u01a9\3\2\2\2\u01be\u01ad\3\2\2\2\u01be\u01b1\3\2\2\2\u01be\u01b5\3\2"+
		"\2\2\u01be\u01b9\3\2\2\2\u01be\u01bd\3\2\2\2\u01bfC\3\2\2\2\u01c0\u01c1"+
		"\5F$\2\u01c1\u01c2\7\67\2\2\u01c2\u01c3\5D#\2\u01c3\u01ca\3\2\2\2\u01c4"+
		"\u01c5\5F$\2\u01c5\u01c6\7,\2\2\u01c6\u01c7\5D#\2\u01c7\u01ca\3\2\2\2"+
		"\u01c8\u01ca\5F$\2\u01c9\u01c0\3\2\2\2\u01c9\u01c4\3\2\2\2\u01c9\u01c8"+
		"\3\2\2\2\u01caE\3\2\2\2\u01cb\u01cc\5H%\2\u01cc\u01cd\7\4\2\2\u01cd\u01ce"+
		"\5F$\2\u01ce\u01d5\3\2\2\2\u01cf\u01d0\5H%\2\u01d0\u01d1\7A\2\2\u01d1"+
		"\u01d2\5F$\2\u01d2\u01d5\3\2\2\2\u01d3\u01d5\5H%\2\u01d4\u01cb\3\2\2\2"+
		"\u01d4\u01cf\3\2\2\2\u01d4\u01d3\3\2\2\2\u01d5G\3\2\2\2\u01d6\u01d7\7"+
		",\2\2\u01d7\u01da\5J&\2\u01d8\u01da\5J&\2\u01d9\u01d6\3\2\2\2\u01d9\u01d8"+
		"\3\2\2\2\u01daI\3\2\2\2\u01db\u01dc\7-\2\2\u01dc\u01dd\5<\37\2\u01dd\u01de"+
		"\7\22\2\2\u01de\u01e9\3\2\2\2\u01df\u01e2\7C\2\2\u01e0\u01e1\7\65\2\2"+
		"\u01e1\u01e3\7C\2\2\u01e2\u01e0\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e9"+
		"\3\2\2\2\u01e4\u01e9\7D\2\2\u01e5\u01e9\7F\2\2\u01e6\u01e9\7E\2\2\u01e7"+
		"\u01e9\7\66\2\2\u01e8\u01db\3\2\2\2\u01e8\u01df\3\2\2\2\u01e8\u01e4\3"+
		"\2\2\2\u01e8\u01e5\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e8\u01e7\3\2\2\2\u01e9"+
		"K\3\2\2\2\u01ea\u01eb\5<\37\2\u01eb\u01ec\7*\2\2\u01ec\u01ed\5L\'\2\u01ed"+
		"\u01f0\3\2\2\2\u01ee\u01f0\5<\37\2\u01ef\u01ea\3\2\2\2\u01ef\u01ee\3\2"+
		"\2\2\u01f0M\3\2\2\2\u01f1\u01f3\5R*\2\u01f2\u01f4\5R*\2\u01f3\u01f2\3"+
		"\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5\u01f6\7*\2\2\u01f6"+
		"\u01f7\5N(\2\u01f7\u01fd\3\2\2\2\u01f8\u01fa\5R*\2\u01f9\u01fb\5R*\2\u01fa"+
		"\u01f9\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u01fd\3\2\2\2\u01fc\u01f1\3\2"+
		"\2\2\u01fc\u01f8\3\2\2\2\u01fdO\3\2\2\2\u01fe\u01ff\5R*\2\u01ff\u0200"+
		"\7*\2\2\u0200\u0201\5P)\2\u0201\u0204\3\2\2\2\u0202\u0204\5R*\2\u0203"+
		"\u01fe\3\2\2\2\u0203\u0202\3\2\2\2\u0204Q\3\2\2\2\u0205\u0206\7C\2\2\u0206"+
		"S\3\2\2\2\60V]`dw\u0081\u0089\u009a\u009d\u00b0\u00b7\u00c0\u00c4\u00ca"+
		"\u00d1\u00da\u00f6\u0103\u0108\u011b\u012a\u0131\u0138\u013e\u0140\u015f"+
		"\u0167\u016d\u0172\u017b\u017e\u0183\u018a\u0191\u0196\u01be\u01c9\u01d4"+
		"\u01d9\u01e2\u01e8\u01ef\u01f3\u01fa\u01fc\u0203";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}