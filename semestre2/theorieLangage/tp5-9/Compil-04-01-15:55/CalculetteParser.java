// Generated from Calculette.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculetteParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, RETURN=37, COMM=38, 
		COMMLIGNE=39, COMMMULTI=40, NEWLINE=41, WS=42, ENTIER=43, DOUBLE=44, OP=45, 
		TYPE=46, BOOL=47, IDENTIFIANT=48, UNMATCH=49;
	public static final int
		RULE_start = 0, RULE_calcul = 1, RULE_decl = 2, RULE_instruction = 3, 
		RULE_expression = 4, RULE_assignation = 5, RULE_input = 6, RULE_output = 7, 
		RULE_bloc = 8, RULE_bouclewhile = 9, RULE_condition = 10, RULE_operationRationelle = 11, 
		RULE_branchements = 12, RULE_boucleFor = 13, RULE_fonction = 14, RULE_params = 15, 
		RULE_args = 16, RULE_finInstruction = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "calcul", "decl", "instruction", "expression", "assignation", 
			"input", "output", "bloc", "bouclewhile", "condition", "operationRationelle", 
			"branchements", "boucleFor", "fonction", "params", "args", "finInstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'-'", "'*'", "'/'", "'%'", "'+'", "'('", "')'", "'*='", 
			"'/='", "'%='", "'-='", "'+='", "'input('", "'output('", "'{'", "'}'", 
			"'while'", "'not'", "'and'", "'or'", "'True'", "'False'", "'<'", "'>'", 
			"'<='", "'>='", "'!='", "'<>'", "'=='", "'if'", "'then'", "'else'", "'for'", 
			"';'", "','", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "RETURN", "COMM", "COMMLIGNE", "COMMMULTI", "NEWLINE", "WS", "ENTIER", 
			"DOUBLE", "OP", "TYPE", "BOOL", "IDENTIFIANT", "UNMATCH"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Calculette.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	   // instance de la table symbole qui permet de stocker variable globale , locale , fonction et parametres de fonction
	   private TablesSymboles tablesSymboles = new TablesSymboles();


	    private int _cur_label = 1;
	    /** générateur de nom d'étiquettes pour les boucles */
	    private String newLabel(){ return "Label"+(_cur_label++)+"\n"; }; 

	    private String evalexpr (String op,String type) {
	        if ( op.equals("*") ){
	            return !type.equals("double") ? "MUL\n" : "FMUL\n" ;
	        } if ( op.equals("+") ){
	            return !type.equals("double") ? "ADD\n" : "FADD\n";
	        } 
	        if ( op.equals("/") ){
	            return !type.equals("double") ? "DIV\n" : "FDIV\n";
	        } 
	         if ( op.equals("%") ){
	            return !type.equals("double") ? "MOD\n" : "FMOD\n";
	        } 
	        if ( op.equals("-") ){
	            return !type.equals("double") ? "SUB\n" : "FSUB\n";
	        } 
	        if(op.equals("<")){
	            return !type.equals("double") ? "INF\n" : "FINF\n";
	        }
	        if(op.equals(">")){
	            return !type.equals("double") ? "SUP\n" : "FSUP\n";
	        }
	        if(op.equals(">=")){
	            return !type.equals("double") ? "SUPEQ\n" : "FSUPEQ\n";
	        }
	         if(op.equals("<=")){
	            return !type.equals("double") ? "INFEQ\n" : "FINFEQ\n";
	        }
	        if(op.equals("!=") || op.equals("<>")){
	            return !type.equals("double") ? "NEQ\n" : "FNEQ\n";
	        }
	        if(op.equals("==")){
	            return !type.equals("double") ? "EQUAL\n" : "FEQUAL\n";
	        }
	        else {
	           System.err.println("Opérateur arithmétique incorrect : '"+op+"'");
	           throw new IllegalArgumentException("Opérateur arithmétique incorrect : '"+op+"'");
	        }
	    }

	public CalculetteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public CalculContext calcul() {
			return getRuleContext(CalculContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			calcul();
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

	public static class CalculContext extends ParserRuleContext {
		public String code;
		public DeclContext decl;
		public FonctionContext fonction;
		public InstructionContext instruction;
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<FinInstructionContext> finInstruction() {
			return getRuleContexts(FinInstructionContext.class);
		}
		public FinInstructionContext finInstruction(int i) {
			return getRuleContext(FinInstructionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public List<FonctionContext> fonction() {
			return getRuleContexts(FonctionContext.class);
		}
		public FonctionContext fonction(int i) {
			return getRuleContext(FonctionContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public CalculContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calcul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterCalcul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitCalcul(this);
		}
	}

	public final CalculContext calcul() throws RecognitionException {
		CalculContext _localctx = new CalculContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_calcul);
		 ((CalculContext)_localctx).code =  new String(); 
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(38);
					((CalculContext)_localctx).decl = decl();
					setState(39);
					finInstruction();
					 _localctx.code += ((CalculContext)_localctx).decl.code; 
					}
					} 
				}
				setState(46);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			_localctx.code += "JUMP start\n"; 
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(48);
					match(NEWLINE);
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(54);
				((CalculContext)_localctx).fonction = fonction();
				 _localctx.code += ((CalculContext)_localctx).fonction.code ;
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(62);
					match(NEWLINE);
					}
					} 
				}
				setState(67);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			 _localctx.code += "LABEL start\n";
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__30) | (1L << T__33) | (1L << T__34) | (1L << RETURN) | (1L << NEWLINE) | (1L << ENTIER) | (1L << DOUBLE) | (1L << BOOL) | (1L << IDENTIFIANT))) != 0)) {
				{
				{
				setState(69);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.code += "HALT\n"; 
			}
			_ctx.stop = _input.LT(-1);
			 System.out.println(_localctx.code); 
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

	public static class DeclContext extends ParserRuleContext {
		public String code;
		public Token TYPE;
		public Token IDENTIFIANT;
		public ExpressionContext expression;
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		try {
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(80);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				            // declaration de variable

				            tablesSymboles.addVarDecl((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),(((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null));
				            VariableInfo vi = tablesSymboles.getVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null));
				            
				            ((DeclContext)_localctx).code =  !(((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null).equals("double") ? "PUSHI 0\n" : "PUSHF 0.0\n";
				           
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(83);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(84);
				match(T__0);
				setState(85);
				((DeclContext)_localctx).expression = expression(0);

				        tablesSymboles.addVarDecl((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),(((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null));
				        VariableInfo vi = tablesSymboles.getVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null));
				        String storeGorStoreL = (vi.scope == VariableInfo.Scope.GLOBAL) ? "STOREG " :"STOREL ";

				        ((DeclContext)_localctx).code =  (!(((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null).equals("double") ? "PUSHI 0\n" : "PUSHF 0.0\n" ) + ((DeclContext)_localctx).expression.code ;
				        _localctx.code += ( vi.type.equals("double") ? storeGorStoreL + (vi.address+1) + "\n" : "") ;
				        _localctx.code += storeGorStoreL + vi.address + "\n";
				    
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

	public static class InstructionContext extends ParserRuleContext {
		public String code;
		public AssignationContext assignation;
		public ExpressionContext expression;
		public InputContext input;
		public OutputContext output;
		public BlocContext bloc;
		public BouclewhileContext bouclewhile;
		public BranchementsContext branchements;
		public BoucleForContext boucleFor;
		public AssignationContext assignation() {
			return getRuleContext(AssignationContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public OutputContext output() {
			return getRuleContext(OutputContext.class,0);
		}
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public BouclewhileContext bouclewhile() {
			return getRuleContext(BouclewhileContext.class,0);
		}
		public BranchementsContext branchements() {
			return getRuleContext(BranchementsContext.class,0);
		}
		public BoucleForContext boucleFor() {
			return getRuleContext(BoucleForContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(CalculetteParser.RETURN, 0); }
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instruction);
		try {
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				((InstructionContext)_localctx).assignation = assignation();
				setState(91);
				finInstruction();
				 
						// à compléter
				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).assignation.code;
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				((InstructionContext)_localctx).expression = expression(0);
				setState(95);
				finInstruction();
				 
				            // à compléter
				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code;

				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
				((InstructionContext)_localctx).input = input();
				setState(99);
				finInstruction();

				        ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).input.code;
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(102);
				((InstructionContext)_localctx).output = output();
				setState(103);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).output.code;
				        
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(106);
				((InstructionContext)_localctx).bloc = bloc();

				         ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).bloc.code;
				      
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(109);
				((InstructionContext)_localctx).bouclewhile = bouclewhile();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).bouclewhile.code ;
				        
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(112);
				((InstructionContext)_localctx).branchements = branchements();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).branchements.code ;
				        
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(115);
				((InstructionContext)_localctx).boucleFor = boucleFor();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).boucleFor.code;
				        
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(118);
				match(RETURN);
				setState(119);
				((InstructionContext)_localctx).expression = expression(0);
				setState(120);
				finInstruction();


				            VariableInfo vi = tablesSymboles.getReturn();
				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code;
				            _localctx.code += "STOREL " + vi.address + "\n" + (vi.type.equals("double") ? "STOREL "  + (vi.address+1) + "\n": "" ) + "RETURN\n";

				        
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(123);
				finInstruction();

				            ((InstructionContext)_localctx).code =  "";
				        
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

	public static class ExpressionContext extends ParserRuleContext {
		public String code;
		public String type;
		public ExpressionContext exp1;
		public ExpressionContext a;
		public Token IDENTIFIANT;
		public ArgsContext args;
		public Token ENTIER;
		public Token BOOL;
		public Token DOUBLE;
		public Token OP;
		public ExpressionContext exp2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode ENTIER() { return getToken(CalculetteParser.ENTIER, 0); }
		public TerminalNode BOOL() { return getToken(CalculetteParser.BOOL, 0); }
		public TerminalNode DOUBLE() { return getToken(CalculetteParser.DOUBLE, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(129);
				match(T__1);
				setState(130);
				((ExpressionContext)_localctx).a = expression(10);

				        ((ExpressionContext)_localctx).type =  ((ExpressionContext)_localctx).a.type;
				        ((ExpressionContext)_localctx).code =  (!((ExpressionContext)_localctx).a.type.equals("double") ? "PUSHI 0 \n" : "PUSHF 0.0\n") + ((ExpressionContext)_localctx).a.code + evalexpr("-",((ExpressionContext)_localctx).a.type);
				    
				}
				break;
			case 2:
				{
				setState(133);
				match(T__6);
				setState(134);
				((ExpressionContext)_localctx).a = expression(0);
				setState(135);
				match(T__7);

				        ((ExpressionContext)_localctx).type =  ((ExpressionContext)_localctx).a.type;
				        ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code;
				    
				}
				break;
			case 3:
				{
				setState(138);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				            VariableInfo vi = tablesSymboles.getVar((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));
				            String typeOfPushi = (vi.scope == VariableInfo.Scope.GLOBAL ) ? "PUSHG "  : "PUSHL ";
				            ((ExpressionContext)_localctx).code =  typeOfPushi + vi.address +"\n" + (vi.type.equals("double") ? typeOfPushi +(vi.address+1) +"\n" : "" );
				            ((ExpressionContext)_localctx).type =  vi.type;
				        
				}
				break;
			case 4:
				{
				setState(140);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(141);
				match(T__6);
				setState(142);
				match(T__7);
				   
				            ((ExpressionContext)_localctx).type =  tablesSymboles.getFunction((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));
				            ((ExpressionContext)_localctx).code =   !_localctx.type.equals("double") ? "PUSHI 0\n" : "PUSHF 0.0\n" ;
				            _localctx.code += "CALL " + (((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null) + "\n";
				           
				        
				}
				break;
			case 5:
				{
				setState(144);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(145);
				match(T__6);
				setState(146);
				((ExpressionContext)_localctx).args = args();
				setState(147);
				match(T__7);

				            ((ExpressionContext)_localctx).type =  tablesSymboles.getFunction((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));
				            ((ExpressionContext)_localctx).code =   !_localctx.type.equals("double") ? "PUSHI 0\n" : "PUSHF 0.0\n" ;
				            _localctx.code += ((ExpressionContext)_localctx).args.code + "CALL " + (((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null) + "\n";
				            // Ajouter ici le nettoyage de la pile
				            for(int i=0; i<((ExpressionContext)_localctx).args.size;i++){
				                _localctx.code += "POP\n";
				            }
				            
				        
				}
				break;
			case 6:
				{
				setState(150);
				((ExpressionContext)_localctx).ENTIER = match(ENTIER);

				        ((ExpressionContext)_localctx).type =  "int";
				        ((ExpressionContext)_localctx).code =  "PUSHI " + (((ExpressionContext)_localctx).ENTIER!=null?((ExpressionContext)_localctx).ENTIER.getText():null) + "\n";
				    
				}
				break;
			case 7:
				{
				setState(152);
				((ExpressionContext)_localctx).BOOL = match(BOOL);

				        ((ExpressionContext)_localctx).type =  "int";
				        ((ExpressionContext)_localctx).code =  ((((ExpressionContext)_localctx).BOOL!=null?((ExpressionContext)_localctx).BOOL.getText():null)).equals("True") ? "PUSHI 1\n" : "PUSHI 0\n";
				    
				}
				break;
			case 8:
				{
				setState(154);
				((ExpressionContext)_localctx).DOUBLE = match(DOUBLE);

				        ((ExpressionContext)_localctx).type =  "double";
				        ((ExpressionContext)_localctx).code =  "PUSHF " + (((ExpressionContext)_localctx).DOUBLE!=null?((ExpressionContext)_localctx).DOUBLE.getText():null) + "\n";
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(170);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(168);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(158);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(159);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(160);
						((ExpressionContext)_localctx).exp2 = expression(10);

						                        
						                  if(!((ExpressionContext)_localctx).exp1.type.equals(((ExpressionContext)_localctx).exp2.type)){ 
						                      if(((ExpressionContext)_localctx).exp1.type.equals("double")){
						                          ((ExpressionContext)_localctx).type =  ((ExpressionContext)_localctx).exp1.type;

						                          ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).exp1.code  + ((ExpressionContext)_localctx).exp2.code  + "ITOF\n" + evalexpr((((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null),((ExpressionContext)_localctx).exp1.type);
						                      }
						                      else if(((ExpressionContext)_localctx).exp2.type.equals("double")) {
						                          ((ExpressionContext)_localctx).type =  ((ExpressionContext)_localctx).exp2.type;
						                          ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).exp1.code  + "ITOF\n" + ((ExpressionContext)_localctx).exp2.code  + evalexpr((((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null),((ExpressionContext)_localctx).exp2.type);

						                      }
						                  }
						                  else{
						                       ((ExpressionContext)_localctx).type =  "int";
						                      ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).exp1.code + ((ExpressionContext)_localctx).exp2.code + evalexpr((((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null),_localctx.type);

						                   }
						                  
						              
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(163);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(164);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__1 || _la==T__5) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(165);
						((ExpressionContext)_localctx).exp2 = expression(9);

						                   if(!((ExpressionContext)_localctx).exp1.type.equals(((ExpressionContext)_localctx).exp2.type)){ 
						                      if(((ExpressionContext)_localctx).exp1.type.equals("double")){
						                          ((ExpressionContext)_localctx).type =  ((ExpressionContext)_localctx).exp1.type;

						                          ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).exp1.code  + ((ExpressionContext)_localctx).exp2.code  + "ITOF\n" + evalexpr((((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null),((ExpressionContext)_localctx).exp1.type);
						                      }
						                      else if(((ExpressionContext)_localctx).exp2.type.equals("double")) {
						                          ((ExpressionContext)_localctx).type =  ((ExpressionContext)_localctx).exp2.type;
						                          ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).exp1.code  + "ITOF\n" + ((ExpressionContext)_localctx).exp2.code  + evalexpr((((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null),((ExpressionContext)_localctx).exp2.type);

						                      }
						                  }
						                  else{
						                       ((ExpressionContext)_localctx).type = "int";
						                      ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).exp1.code + ((ExpressionContext)_localctx).exp2.code + evalexpr((((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null),_localctx.type);

						                   }
						                  
						              
						}
						break;
					}
					} 
				}
				setState(172);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AssignationContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public ExpressionContext expression;
		public Token OP;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterAssignation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitAssignation(this);
		}
	}

	public final AssignationContext assignation() throws RecognitionException {
		AssignationContext _localctx = new AssignationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignation);
		int _la;
		try {
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(174);
				match(T__0);
				setState(175);
				((AssignationContext)_localctx).expression = expression(0);
				  
				            // à compléter
				            VariableInfo vi = tablesSymboles.getVar((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				            String typeStore =  ((vi.scope != VariableInfo.Scope.GLOBAL) ? "STOREL " : "STOREG ") ;
				            ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expression.code + typeStore + vi.address+"\n" + (vi.type.equals("double") ? 
				               typeStore + (vi.address + 1) +"\n" : "" );
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(179);
				((AssignationContext)_localctx).OP = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) ) {
					((AssignationContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(180);
				((AssignationContext)_localctx).expression = expression(0);


				         VariableInfo vi = tablesSymboles.getVar((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null)); 
				         String typePush = ((vi.scope == VariableInfo.Scope.GLOBAL) ? "PUSHG " : "PUSHL ");
				         ((AssignationContext)_localctx).code =  typePush + vi.address + "\n"+ (vi.type.equals("double") ?  typePush + (vi.address+1) + "\n" : "" );
				         _localctx.code += ((AssignationContext)_localctx).expression.code + evalexpr((Character.toString((((AssignationContext)_localctx).OP!=null?((AssignationContext)_localctx).OP.getText():null).charAt(0))),vi.type);
				         _localctx.code +=  ((vi.scope == VariableInfo.Scope.GLOBAL) ? "STOREG " :"STOREL ") + vi.address +"\n";
				        
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

	public static class InputContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitInput(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__13);
			setState(186);
			((InputContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(187);
			match(T__7);

			        VariableInfo vi = tablesSymboles.getVar((((InputContext)_localctx).IDENTIFIANT!=null?((InputContext)_localctx).IDENTIFIANT.getText():null));
			        ((InputContext)_localctx).code =  (!vi.type.equals("double") ? "READ \n" : "READF\n");
			        String typeStore = ((vi.scope == VariableInfo.Scope.GLOBAL) ? "STOREG " :"STOREL ");
			        _localctx.code += (vi.type.equals("double") ?  typeStore + (vi.address+1) + "\n"  + typeStore + vi.address + "\n" : typeStore + vi.address + "\n" );


			       
			    
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

	public static class OutputContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OutputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_output; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterOutput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitOutput(this);
		}
	}

	public final OutputContext output() throws RecognitionException {
		OutputContext _localctx = new OutputContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_output);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(T__14);
			setState(191);
			((OutputContext)_localctx).expression = expression(0);
			setState(192);
			match(T__7);


			        ((OutputContext)_localctx).code =  ((OutputContext)_localctx).expression.code + (!((OutputContext)_localctx).expression.type.equals("double") ? "WRITE\nPOP\n" : "WRITEF\nPOP\nPOP\n");

			     
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

	public static class BlocContext extends ParserRuleContext {
		public String code;
		public InstructionContext instruction;
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public BlocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterBloc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitBloc(this);
		}
	}

	public final BlocContext bloc() throws RecognitionException {
		BlocContext _localctx = new BlocContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bloc);
		 ((BlocContext)_localctx).code =  new String(); 
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(T__15);
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__30) | (1L << T__33) | (1L << T__34) | (1L << RETURN) | (1L << NEWLINE) | (1L << ENTIER) | (1L << DOUBLE) | (1L << BOOL) | (1L << IDENTIFIANT))) != 0)) {
				{
				{
				setState(196);
				((BlocContext)_localctx).instruction = instruction();
				 _localctx.code += ((BlocContext)_localctx).instruction.code; 
				}
				}
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(204);
			match(T__16);
			setState(208);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(205);
					match(NEWLINE);
					}
					} 
				}
				setState(210);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class BouclewhileContext extends ParserRuleContext {
		public String code;
		public ConditionContext condition;
		public InstructionContext instruction;
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public BouclewhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bouclewhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterBouclewhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitBouclewhile(this);
		}
	}

	public final BouclewhileContext bouclewhile() throws RecognitionException {
		BouclewhileContext _localctx = new BouclewhileContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_bouclewhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(T__17);
			setState(212);
			match(T__6);
			setState(213);
			((BouclewhileContext)_localctx).condition = condition(0);
			setState(214);
			match(T__7);
			setState(215);
			((BouclewhileContext)_localctx).instruction = instruction();

			        String debut = newLabel();
			        String fin = newLabel();
			        ((BouclewhileContext)_localctx).code =  "LABEL " + debut + ((BouclewhileContext)_localctx).condition.code + "JUMPF " + fin + ((BouclewhileContext)_localctx).instruction.code + "JUMP " + debut + "LABEL " + fin ; 
			    
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

	public static class ConditionContext extends ParserRuleContext {
		public String code;
		public ConditionContext a;
		public ConditionContext condition;
		public OperationRationelleContext operationRationelle;
		public ConditionContext b;
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public OperationRationelleContext operationRationelle() {
			return getRuleContext(OperationRationelleContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_condition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				{
				setState(219);
				match(T__18);
				setState(220);
				((ConditionContext)_localctx).condition = condition(6);

				            ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).condition.code + "PUSHI 1\nNEQ\n";
				        
				}
				break;
			case T__21:
				{
				setState(223);
				match(T__21);

				            ((ConditionContext)_localctx).code =   "PUSHI 1\n";
				        
				}
				break;
			case T__22:
				{
				setState(225);
				match(T__22);

				           ((ConditionContext)_localctx).code =   "PUSHI 0\n"; 
				        
				}
				break;
			case T__1:
			case T__6:
			case ENTIER:
			case DOUBLE:
			case BOOL:
			case IDENTIFIANT:
				{
				setState(227);
				((ConditionContext)_localctx).operationRationelle = operationRationelle();

				            ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).operationRationelle.code;
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(244);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(242);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(232);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(233);
						match(T__19);
						setState(234);
						((ConditionContext)_localctx).b = ((ConditionContext)_localctx).condition = condition(6);

						                      ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a.code + ((ConditionContext)_localctx).b.code + "MUL\n";
						                  
						}
						break;
					case 2:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(237);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(238);
						match(T__20);
						setState(239);
						((ConditionContext)_localctx).b = ((ConditionContext)_localctx).condition = condition(5);

						                  ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a.code + ((ConditionContext)_localctx).b.code + "ADD\nPUSHI 0\nSUP\n";
						                  
						}
						break;
					}
					} 
				}
				setState(246);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class OperationRationelleContext extends ParserRuleContext {
		public String code;
		public ExpressionContext exp1;
		public Token OP;
		public ExpressionContext exp2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OperationRationelleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operationRationelle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterOperationRationelle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitOperationRationelle(this);
		}
	}

	public final OperationRationelleContext operationRationelle() throws RecognitionException {
		OperationRationelleContext _localctx = new OperationRationelleContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_operationRationelle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			((OperationRationelleContext)_localctx).exp1 = expression(0);
			setState(248);
			((OperationRationelleContext)_localctx).OP = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
				((OperationRationelleContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(249);
			((OperationRationelleContext)_localctx).exp2 = expression(0);

			            if(!((OperationRationelleContext)_localctx).exp1.type.equals(((OperationRationelleContext)_localctx).exp2.type)){ 
			                if(((OperationRationelleContext)_localctx).exp1.type.equals("double")){
			                    ((OperationRationelleContext)_localctx).code =  ((OperationRationelleContext)_localctx).exp1.code  + ((OperationRationelleContext)_localctx).exp2.code  + "ITOF\n" + evalexpr((((OperationRationelleContext)_localctx).OP!=null?((OperationRationelleContext)_localctx).OP.getText():null),((OperationRationelleContext)_localctx).exp1.type);
			                }
			                else if(((OperationRationelleContext)_localctx).exp2.type.equals("double")) {
			                    ((OperationRationelleContext)_localctx).code =  ((OperationRationelleContext)_localctx).exp1.code  + "ITOF\n" + ((OperationRationelleContext)_localctx).exp2.code  + evalexpr((((OperationRationelleContext)_localctx).OP!=null?((OperationRationelleContext)_localctx).OP.getText():null),((OperationRationelleContext)_localctx).exp2.type);

			                }
			           }

			         else {
			            ((OperationRationelleContext)_localctx).code =  ((OperationRationelleContext)_localctx).exp1.code + ((OperationRationelleContext)_localctx).exp2.code + evalexpr((((OperationRationelleContext)_localctx).OP!=null?((OperationRationelleContext)_localctx).OP.getText():null),((OperationRationelleContext)_localctx).exp1.type);

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

	public static class BranchementsContext extends ParserRuleContext {
		public String code;
		public ConditionContext condition;
		public InstructionContext instruction;
		public InstructionContext a;
		public InstructionContext b;
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public BranchementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branchements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterBranchements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitBranchements(this);
		}
	}

	public final BranchementsContext branchements() throws RecognitionException {
		BranchementsContext _localctx = new BranchementsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_branchements);
		int _la;
		try {
			setState(276);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(252);
				match(T__30);
				setState(253);
				match(T__6);
				setState(254);
				((BranchementsContext)_localctx).condition = condition(0);
				setState(255);
				match(T__7);
				setState(256);
				match(T__31);
				setState(257);
				((BranchementsContext)_localctx).instruction = instruction();

				            String sifaux = newLabel();
				            ((BranchementsContext)_localctx).code =  ((BranchementsContext)_localctx).condition.code + "JUMPF " + sifaux + ((BranchementsContext)_localctx).instruction.code +  "LABEL " + sifaux ;
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				match(T__30);
				setState(261);
				match(T__6);
				setState(262);
				((BranchementsContext)_localctx).condition = condition(0);
				setState(263);
				match(T__7);
				setState(264);
				match(T__31);
				setState(265);
				((BranchementsContext)_localctx).a = instruction();
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(266);
					match(NEWLINE);
					}
					}
					setState(271);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(272);
				match(T__32);
				setState(273);
				((BranchementsContext)_localctx).b = instruction();

				            String sifaux = newLabel();
				            String finIf = newLabel();
				            ((BranchementsContext)_localctx).code =  ((BranchementsContext)_localctx).condition.code + "JUMPF " + sifaux + ((BranchementsContext)_localctx).a.code + "JUMP " + finIf + "LABEL " + sifaux +  ((BranchementsContext)_localctx).b.code + "LABEL " + finIf;
				        
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

	public static class BoucleForContext extends ParserRuleContext {
		public String code;
		public AssignationContext a;
		public ConditionContext condition;
		public AssignationContext b;
		public InstructionContext instruction;
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public List<AssignationContext> assignation() {
			return getRuleContexts(AssignationContext.class);
		}
		public AssignationContext assignation(int i) {
			return getRuleContext(AssignationContext.class,i);
		}
		public BoucleForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boucleFor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterBoucleFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitBoucleFor(this);
		}
	}

	public final BoucleForContext boucleFor() throws RecognitionException {
		BoucleForContext _localctx = new BoucleForContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_boucleFor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(T__33);
			setState(279);
			match(T__6);
			setState(280);
			((BoucleForContext)_localctx).a = assignation();
			setState(281);
			match(T__34);
			setState(282);
			((BoucleForContext)_localctx).condition = condition(0);
			setState(283);
			match(T__34);
			setState(284);
			((BoucleForContext)_localctx).b = assignation();
			setState(285);
			match(T__7);
			setState(286);
			((BoucleForContext)_localctx).instruction = instruction();

			        String fin = newLabel();
			        String debut = newLabel();
			        ((BoucleForContext)_localctx).code =   ((BoucleForContext)_localctx).a.code + "LABEL " + debut + ((BoucleForContext)_localctx).condition.code +"JUMPF " + fin + ((BoucleForContext)_localctx).instruction.code + ((BoucleForContext)_localctx).b.code + "JUMP " + debut + "LABEL " + fin;
			    
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

	public static class FonctionContext extends ParserRuleContext {
		public String code;
		public Token TYPE;
		public Token IDENTIFIANT;
		public DeclContext decl;
		public InstructionContext instruction;
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public List<FinInstructionContext> finInstruction() {
			return getRuleContexts(FinInstructionContext.class);
		}
		public FinInstructionContext finInstruction(int i) {
			return getRuleContext(FinInstructionContext.class,i);
		}
		public FonctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fonction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterFonction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitFonction(this);
		}
	}

	public final FonctionContext fonction() throws RecognitionException {
		FonctionContext _localctx = new FonctionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_fonction);
		  tablesSymboles.enterFunction(); 
		int _la;
		try {
			int _alt;
			setState(357);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(289);
				((FonctionContext)_localctx).TYPE = match(TYPE);
				setState(290);
				((FonctionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				            // enregistrer dans la table de fonction
				            tablesSymboles.addFunction((((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null),(((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null));
				            ((FonctionContext)_localctx).code =  "LABEL " + (((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null) + "\n";
				        
				setState(292);
				match(T__6);
				setState(293);
				match(T__7);
				setState(294);
				match(T__15);
				setState(296);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(295);
					match(NEWLINE);
					}
					break;
				}
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TYPE) {
					{
					{
					setState(298);
					((FonctionContext)_localctx).decl = decl();
					 _localctx.code += ((FonctionContext)_localctx).decl.code; 
					}
					}
					setState(305);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(307);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(306);
					match(NEWLINE);
					}
					break;
				}
				setState(314);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__30) | (1L << T__33) | (1L << T__34) | (1L << RETURN) | (1L << NEWLINE) | (1L << ENTIER) | (1L << DOUBLE) | (1L << BOOL) | (1L << IDENTIFIANT))) != 0)) {
					{
					{
					setState(309);
					((FonctionContext)_localctx).instruction = instruction();
					 _localctx.code += ((FonctionContext)_localctx).instruction.code; 
					}
					}
					setState(316);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				_localctx.code += "RETURN\n";
				setState(318);
				match(T__16);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(319);
				((FonctionContext)_localctx).TYPE = match(TYPE);
				setState(320);
				((FonctionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				   
				        // enregistrer dans la table de fonction
				        tablesSymboles.addFunction((((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null),(((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null));
				        ((FonctionContext)_localctx).code =  "LABEL " + (((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null) + "\n";
				    
				setState(322);
				match(T__6);
				setState(323);
				params();
				setState(324);
				match(T__7);
				setState(325);
				match(T__15);
				setState(327);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(326);
					match(NEWLINE);
					}
					break;
				}
				setState(335);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TYPE) {
					{
					{
					setState(329);
					((FonctionContext)_localctx).decl = decl();
					setState(330);
					finInstruction();
					_localctx.code += ((FonctionContext)_localctx).decl.code;
					}
					}
					setState(337);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(339);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(338);
					match(NEWLINE);
					}
					break;
				}
				setState(346);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__30) | (1L << T__33) | (1L << T__34) | (1L << RETURN) | (1L << NEWLINE) | (1L << ENTIER) | (1L << DOUBLE) | (1L << BOOL) | (1L << IDENTIFIANT))) != 0)) {
					{
					{
					setState(341);
					((FonctionContext)_localctx).instruction = instruction();
					 _localctx.code += ((FonctionContext)_localctx).instruction.code; 
					}
					}
					setState(348);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				_localctx.code += "RETURN\n";
				setState(350);
				match(T__16);
				setState(354);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(351);
						match(NEWLINE);
						}
						} 
					}
					setState(356);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			 tablesSymboles.exitFunction(); 
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

	public static class ParamsContext extends ParserRuleContext {
		public Token TYPE;
		public Token IDENTIFIANT;
		public List<TerminalNode> TYPE() { return getTokens(CalculetteParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CalculetteParser.TYPE, i);
		}
		public List<TerminalNode> IDENTIFIANT() { return getTokens(CalculetteParser.IDENTIFIANT); }
		public TerminalNode IDENTIFIANT(int i) {
			return getToken(CalculetteParser.IDENTIFIANT, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			((ParamsContext)_localctx).TYPE = match(TYPE);
			setState(360);
			((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

			            // code java gérant le premier paramètre
			            tablesSymboles.addParam((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null),(((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));

			        
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__35) {
				{
				{
				setState(362);
				match(T__35);
				setState(363);
				((ParamsContext)_localctx).TYPE = match(TYPE);
				setState(364);
				((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				                // code java gérant un paramètre
				                tablesSymboles.addParam((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null),(((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));

				            
				}
				}
				setState(370);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ArgsContext extends ParserRuleContext {
		public String code;
		public int size;
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_args);
		 ((ArgsContext)_localctx).code =  new String(); ((ArgsContext)_localctx).size =  0; 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << ENTIER) | (1L << DOUBLE) | (1L << BOOL) | (1L << IDENTIFIANT))) != 0)) {
				{
				setState(371);
				((ArgsContext)_localctx).expression = expression(0);

				        // code java pour première expression pour arg
				        ((ArgsContext)_localctx).code =  ((ArgsContext)_localctx).expression.code;
				        _localctx.size += !((ArgsContext)_localctx).expression.type.equals("double") ? 1 : 2;
				    
				setState(379);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__35) {
					{
					{
					setState(373);
					match(T__35);
					setState(374);
					((ArgsContext)_localctx).expression = expression(0);

					        // code java pour expression suivante pour arg
					        _localctx.code += ((ArgsContext)_localctx).expression.code;
					        _localctx.size += !((ArgsContext)_localctx).expression.type.equals("double") ? 1 : 2;


					    
					}
					}
					setState(381);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class FinInstructionContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public FinInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterFinInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitFinInstruction(this);
		}
	}

	public final FinInstructionContext finInstruction() throws RecognitionException {
		FinInstructionContext _localctx = new FinInstructionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(385); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(384);
					_la = _input.LA(1);
					if ( !(_la==T__34 || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(387); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 10:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\63\u0188\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\3\3\3\3\3\3\7\3-\n\3\f\3\16\3\60\13\3\3\3\3\3\7"+
		"\3\64\n\3\f\3\16\3\67\13\3\3\3\3\3\3\3\7\3<\n\3\f\3\16\3?\13\3\3\3\7\3"+
		"B\n\3\f\3\16\3E\13\3\3\3\3\3\3\3\3\3\7\3K\n\3\f\3\16\3N\13\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4[\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0081\n\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u009f\n\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\7\6\u00ab\n\6\f\6\16\6\u00ae\13\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\5\7\u00ba\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\7\n\u00ca\n\n\f\n\16\n\u00cd\13\n\3\n\3\n\7\n\u00d1"+
		"\n\n\f\n\16\n\u00d4\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00e9\n\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\7\f\u00f5\n\f\f\f\16\f\u00f8\13\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\7\16\u010e\n\16\f\16\16\16\u0111\13\16\3\16\3\16\3\16\3\16"+
		"\5\16\u0117\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u012b\n\20\3\20\3\20\3\20\7\20"+
		"\u0130\n\20\f\20\16\20\u0133\13\20\3\20\5\20\u0136\n\20\3\20\3\20\3\20"+
		"\7\20\u013b\n\20\f\20\16\20\u013e\13\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\5\20\u014a\n\20\3\20\3\20\3\20\3\20\7\20\u0150\n"+
		"\20\f\20\16\20\u0153\13\20\3\20\5\20\u0156\n\20\3\20\3\20\3\20\7\20\u015b"+
		"\n\20\f\20\16\20\u015e\13\20\3\20\3\20\3\20\7\20\u0163\n\20\f\20\16\20"+
		"\u0166\13\20\5\20\u0168\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u0171"+
		"\n\21\f\21\16\21\u0174\13\21\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u017c"+
		"\n\22\f\22\16\22\u017f\13\22\5\22\u0181\n\22\3\23\6\23\u0184\n\23\r\23"+
		"\16\23\u0185\3\23\2\4\n\26\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 "+
		"\"$\2\7\3\2\5\7\4\2\4\4\b\b\3\2\13\17\3\2\32 \4\2%%++\2\u01a5\2&\3\2\2"+
		"\2\4.\3\2\2\2\6Z\3\2\2\2\b\u0080\3\2\2\2\n\u009e\3\2\2\2\f\u00b9\3\2\2"+
		"\2\16\u00bb\3\2\2\2\20\u00c0\3\2\2\2\22\u00c5\3\2\2\2\24\u00d5\3\2\2\2"+
		"\26\u00e8\3\2\2\2\30\u00f9\3\2\2\2\32\u0116\3\2\2\2\34\u0118\3\2\2\2\36"+
		"\u0167\3\2\2\2 \u0169\3\2\2\2\"\u0180\3\2\2\2$\u0183\3\2\2\2&\'\5\4\3"+
		"\2\'\3\3\2\2\2()\5\6\4\2)*\5$\23\2*+\b\3\1\2+-\3\2\2\2,(\3\2\2\2-\60\3"+
		"\2\2\2.,\3\2\2\2./\3\2\2\2/\61\3\2\2\2\60.\3\2\2\2\61\65\b\3\1\2\62\64"+
		"\7+\2\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66=\3"+
		"\2\2\2\67\65\3\2\2\289\5\36\20\29:\b\3\1\2:<\3\2\2\2;8\3\2\2\2<?\3\2\2"+
		"\2=;\3\2\2\2=>\3\2\2\2>C\3\2\2\2?=\3\2\2\2@B\7+\2\2A@\3\2\2\2BE\3\2\2"+
		"\2CA\3\2\2\2CD\3\2\2\2DF\3\2\2\2EC\3\2\2\2FL\b\3\1\2GH\5\b\5\2HI\b\3\1"+
		"\2IK\3\2\2\2JG\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MO\3\2\2\2NL\3\2\2"+
		"\2OP\b\3\1\2P\5\3\2\2\2QR\7\60\2\2RS\7\62\2\2S[\b\4\1\2TU\7\60\2\2UV\7"+
		"\62\2\2VW\7\3\2\2WX\5\n\6\2XY\b\4\1\2Y[\3\2\2\2ZQ\3\2\2\2ZT\3\2\2\2[\7"+
		"\3\2\2\2\\]\5\f\7\2]^\5$\23\2^_\b\5\1\2_\u0081\3\2\2\2`a\5\n\6\2ab\5$"+
		"\23\2bc\b\5\1\2c\u0081\3\2\2\2de\5\16\b\2ef\5$\23\2fg\b\5\1\2g\u0081\3"+
		"\2\2\2hi\5\20\t\2ij\5$\23\2jk\b\5\1\2k\u0081\3\2\2\2lm\5\22\n\2mn\b\5"+
		"\1\2n\u0081\3\2\2\2op\5\24\13\2pq\b\5\1\2q\u0081\3\2\2\2rs\5\32\16\2s"+
		"t\b\5\1\2t\u0081\3\2\2\2uv\5\34\17\2vw\b\5\1\2w\u0081\3\2\2\2xy\7\'\2"+
		"\2yz\5\n\6\2z{\5$\23\2{|\b\5\1\2|\u0081\3\2\2\2}~\5$\23\2~\177\b\5\1\2"+
		"\177\u0081\3\2\2\2\u0080\\\3\2\2\2\u0080`\3\2\2\2\u0080d\3\2\2\2\u0080"+
		"h\3\2\2\2\u0080l\3\2\2\2\u0080o\3\2\2\2\u0080r\3\2\2\2\u0080u\3\2\2\2"+
		"\u0080x\3\2\2\2\u0080}\3\2\2\2\u0081\t\3\2\2\2\u0082\u0083\b\6\1\2\u0083"+
		"\u0084\7\4\2\2\u0084\u0085\5\n\6\f\u0085\u0086\b\6\1\2\u0086\u009f\3\2"+
		"\2\2\u0087\u0088\7\t\2\2\u0088\u0089\5\n\6\2\u0089\u008a\7\n\2\2\u008a"+
		"\u008b\b\6\1\2\u008b\u009f\3\2\2\2\u008c\u008d\7\62\2\2\u008d\u009f\b"+
		"\6\1\2\u008e\u008f\7\62\2\2\u008f\u0090\7\t\2\2\u0090\u0091\7\n\2\2\u0091"+
		"\u009f\b\6\1\2\u0092\u0093\7\62\2\2\u0093\u0094\7\t\2\2\u0094\u0095\5"+
		"\"\22\2\u0095\u0096\7\n\2\2\u0096\u0097\b\6\1\2\u0097\u009f\3\2\2\2\u0098"+
		"\u0099\7-\2\2\u0099\u009f\b\6\1\2\u009a\u009b\7\61\2\2\u009b\u009f\b\6"+
		"\1\2\u009c\u009d\7.\2\2\u009d\u009f\b\6\1\2\u009e\u0082\3\2\2\2\u009e"+
		"\u0087\3\2\2\2\u009e\u008c\3\2\2\2\u009e\u008e\3\2\2\2\u009e\u0092\3\2"+
		"\2\2\u009e\u0098\3\2\2\2\u009e\u009a\3\2\2\2\u009e\u009c\3\2\2\2\u009f"+
		"\u00ac\3\2\2\2\u00a0\u00a1\f\13\2\2\u00a1\u00a2\t\2\2\2\u00a2\u00a3\5"+
		"\n\6\f\u00a3\u00a4\b\6\1\2\u00a4\u00ab\3\2\2\2\u00a5\u00a6\f\n\2\2\u00a6"+
		"\u00a7\t\3\2\2\u00a7\u00a8\5\n\6\13\u00a8\u00a9\b\6\1\2\u00a9\u00ab\3"+
		"\2\2\2\u00aa\u00a0\3\2\2\2\u00aa\u00a5\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\13\3\2\2\2\u00ae\u00ac\3\2\2"+
		"\2\u00af\u00b0\7\62\2\2\u00b0\u00b1\7\3\2\2\u00b1\u00b2\5\n\6\2\u00b2"+
		"\u00b3\b\7\1\2\u00b3\u00ba\3\2\2\2\u00b4\u00b5\7\62\2\2\u00b5\u00b6\t"+
		"\4\2\2\u00b6\u00b7\5\n\6\2\u00b7\u00b8\b\7\1\2\u00b8\u00ba\3\2\2\2\u00b9"+
		"\u00af\3\2\2\2\u00b9\u00b4\3\2\2\2\u00ba\r\3\2\2\2\u00bb\u00bc\7\20\2"+
		"\2\u00bc\u00bd\7\62\2\2\u00bd\u00be\7\n\2\2\u00be\u00bf\b\b\1\2\u00bf"+
		"\17\3\2\2\2\u00c0\u00c1\7\21\2\2\u00c1\u00c2\5\n\6\2\u00c2\u00c3\7\n\2"+
		"\2\u00c3\u00c4\b\t\1\2\u00c4\21\3\2\2\2\u00c5\u00cb\7\22\2\2\u00c6\u00c7"+
		"\5\b\5\2\u00c7\u00c8\b\n\1\2\u00c8\u00ca\3\2\2\2\u00c9\u00c6\3\2\2\2\u00ca"+
		"\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ce\3\2"+
		"\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00d2\7\23\2\2\u00cf\u00d1\7+\2\2\u00d0"+
		"\u00cf\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2"+
		"\2\2\u00d3\23\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d6\7\24\2\2\u00d6\u00d7"+
		"\7\t\2\2\u00d7\u00d8\5\26\f\2\u00d8\u00d9\7\n\2\2\u00d9\u00da\5\b\5\2"+
		"\u00da\u00db\b\13\1\2\u00db\25\3\2\2\2\u00dc\u00dd\b\f\1\2\u00dd\u00de"+
		"\7\25\2\2\u00de\u00df\5\26\f\b\u00df\u00e0\b\f\1\2\u00e0\u00e9\3\2\2\2"+
		"\u00e1\u00e2\7\30\2\2\u00e2\u00e9\b\f\1\2\u00e3\u00e4\7\31\2\2\u00e4\u00e9"+
		"\b\f\1\2\u00e5\u00e6\5\30\r\2\u00e6\u00e7\b\f\1\2\u00e7\u00e9\3\2\2\2"+
		"\u00e8\u00dc\3\2\2\2\u00e8\u00e1\3\2\2\2\u00e8\u00e3\3\2\2\2\u00e8\u00e5"+
		"\3\2\2\2\u00e9\u00f6\3\2\2\2\u00ea\u00eb\f\7\2\2\u00eb\u00ec\7\26\2\2"+
		"\u00ec\u00ed\5\26\f\b\u00ed\u00ee\b\f\1\2\u00ee\u00f5\3\2\2\2\u00ef\u00f0"+
		"\f\6\2\2\u00f0\u00f1\7\27\2\2\u00f1\u00f2\5\26\f\7\u00f2\u00f3\b\f\1\2"+
		"\u00f3\u00f5\3\2\2\2\u00f4\u00ea\3\2\2\2\u00f4\u00ef\3\2\2\2\u00f5\u00f8"+
		"\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\27\3\2\2\2\u00f8"+
		"\u00f6\3\2\2\2\u00f9\u00fa\5\n\6\2\u00fa\u00fb\t\5\2\2\u00fb\u00fc\5\n"+
		"\6\2\u00fc\u00fd\b\r\1\2\u00fd\31\3\2\2\2\u00fe\u00ff\7!\2\2\u00ff\u0100"+
		"\7\t\2\2\u0100\u0101\5\26\f\2\u0101\u0102\7\n\2\2\u0102\u0103\7\"\2\2"+
		"\u0103\u0104\5\b\5\2\u0104\u0105\b\16\1\2\u0105\u0117\3\2\2\2\u0106\u0107"+
		"\7!\2\2\u0107\u0108\7\t\2\2\u0108\u0109\5\26\f\2\u0109\u010a\7\n\2\2\u010a"+
		"\u010b\7\"\2\2\u010b\u010f\5\b\5\2\u010c\u010e\7+\2\2\u010d\u010c\3\2"+
		"\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110"+
		"\u0112\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0113\7#\2\2\u0113\u0114\5\b"+
		"\5\2\u0114\u0115\b\16\1\2\u0115\u0117\3\2\2\2\u0116\u00fe\3\2\2\2\u0116"+
		"\u0106\3\2\2\2\u0117\33\3\2\2\2\u0118\u0119\7$\2\2\u0119\u011a\7\t\2\2"+
		"\u011a\u011b\5\f\7\2\u011b\u011c\7%\2\2\u011c\u011d\5\26\f\2\u011d\u011e"+
		"\7%\2\2\u011e\u011f\5\f\7\2\u011f\u0120\7\n\2\2\u0120\u0121\5\b\5\2\u0121"+
		"\u0122\b\17\1\2\u0122\35\3\2\2\2\u0123\u0124\7\60\2\2\u0124\u0125\7\62"+
		"\2\2\u0125\u0126\b\20\1\2\u0126\u0127\7\t\2\2\u0127\u0128\7\n\2\2\u0128"+
		"\u012a\7\22\2\2\u0129\u012b\7+\2\2\u012a\u0129\3\2\2\2\u012a\u012b\3\2"+
		"\2\2\u012b\u0131\3\2\2\2\u012c\u012d\5\6\4\2\u012d\u012e\b\20\1\2\u012e"+
		"\u0130\3\2\2\2\u012f\u012c\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2"+
		"\2\2\u0131\u0132\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2\2\2\u0134"+
		"\u0136\7+\2\2\u0135\u0134\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u013c\3\2"+
		"\2\2\u0137\u0138\5\b\5\2\u0138\u0139\b\20\1\2\u0139\u013b\3\2\2\2\u013a"+
		"\u0137\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2"+
		"\2\2\u013d\u013f\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0140\b\20\1\2\u0140"+
		"\u0168\7\23\2\2\u0141\u0142\7\60\2\2\u0142\u0143\7\62\2\2\u0143\u0144"+
		"\b\20\1\2\u0144\u0145\7\t\2\2\u0145\u0146\5 \21\2\u0146\u0147\7\n\2\2"+
		"\u0147\u0149\7\22\2\2\u0148\u014a\7+\2\2\u0149\u0148\3\2\2\2\u0149\u014a"+
		"\3\2\2\2\u014a\u0151\3\2\2\2\u014b\u014c\5\6\4\2\u014c\u014d\5$\23\2\u014d"+
		"\u014e\b\20\1\2\u014e\u0150\3\2\2\2\u014f\u014b\3\2\2\2\u0150\u0153\3"+
		"\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0155\3\2\2\2\u0153"+
		"\u0151\3\2\2\2\u0154\u0156\7+\2\2\u0155\u0154\3\2\2\2\u0155\u0156\3\2"+
		"\2\2\u0156\u015c\3\2\2\2\u0157\u0158\5\b\5\2\u0158\u0159\b\20\1\2\u0159"+
		"\u015b\3\2\2\2\u015a\u0157\3\2\2\2\u015b\u015e\3\2\2\2\u015c\u015a\3\2"+
		"\2\2\u015c\u015d\3\2\2\2\u015d\u015f\3\2\2\2\u015e\u015c\3\2\2\2\u015f"+
		"\u0160\b\20\1\2\u0160\u0164\7\23\2\2\u0161\u0163\7+\2\2\u0162\u0161\3"+
		"\2\2\2\u0163\u0166\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165"+
		"\u0168\3\2\2\2\u0166\u0164\3\2\2\2\u0167\u0123\3\2\2\2\u0167\u0141\3\2"+
		"\2\2\u0168\37\3\2\2\2\u0169\u016a\7\60\2\2\u016a\u016b\7\62\2\2\u016b"+
		"\u0172\b\21\1\2\u016c\u016d\7&\2\2\u016d\u016e\7\60\2\2\u016e\u016f\7"+
		"\62\2\2\u016f\u0171\b\21\1\2\u0170\u016c\3\2\2\2\u0171\u0174\3\2\2\2\u0172"+
		"\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173!\3\2\2\2\u0174\u0172\3\2\2\2"+
		"\u0175\u0176\5\n\6\2\u0176\u017d\b\22\1\2\u0177\u0178\7&\2\2\u0178\u0179"+
		"\5\n\6\2\u0179\u017a\b\22\1\2\u017a\u017c\3\2\2\2\u017b\u0177\3\2\2\2"+
		"\u017c\u017f\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u0181"+
		"\3\2\2\2\u017f\u017d\3\2\2\2\u0180\u0175\3\2\2\2\u0180\u0181\3\2\2\2\u0181"+
		"#\3\2\2\2\u0182\u0184\t\6\2\2\u0183\u0182\3\2\2\2\u0184\u0185\3\2\2\2"+
		"\u0185\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186%\3\2\2\2\".\65=CLZ\u0080"+
		"\u009e\u00aa\u00ac\u00b9\u00cb\u00d2\u00e8\u00f4\u00f6\u010f\u0116\u012a"+
		"\u0131\u0135\u013c\u0149\u0151\u0155\u015c\u0164\u0167\u0172\u017d\u0180"+
		"\u0185";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}