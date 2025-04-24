// Generated from /home/21914839/Documents/theorieLangage/tp3/JetonsJava.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JetonsJava extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MOTSCLES=1, OPERATEUR=2, IDENTIFIANT=3, WHITE_SPACE=4, UNMATCH=5;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"MOTSCLES", "OPERATEUR", "IDENTIFIANT", "WHITE_SPACE", "UNMATCH"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "MOTSCLES", "OPERATEUR", "IDENTIFIANT", "WHITE_SPACE", "UNMATCH"
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


	public JetonsJava(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JetonsJava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0:
			MOTSCLES_action((RuleContext)_localctx, actionIndex);
			break;
		case 1:
			OPERATEUR_action((RuleContext)_localctx, actionIndex);
			break;
		case 2:
			IDENTIFIANT_action((RuleContext)_localctx, actionIndex);
			break;
		case 3:
			WHITE_SPACE_action((RuleContext)_localctx, actionIndex);
			break;
		case 4:
			UNMATCH_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void MOTSCLES_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 System.out.print("[motcle : "+getText()+" ]"); 
			break;
		}
	}
	private void OPERATEUR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			 System.out.print("[operateur : "+getText()+" ]"); 
			break;
		}
	}
	private void IDENTIFIANT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			 System.out.print("[Idenfier : "+getText()+" ]"); 
			break;
		}
	}
	private void WHITE_SPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			 System.out.print("[space : "+getText()+" ]"); 
			break;
		}
	}
	private void UNMATCH_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			 System.out.print("[unknow : "+getText()+" ]"); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\7d\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2C\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\3P\n\3\3\4\3\4\7\4T\n\4\f\4\16\4W\13\4\3\4\3\4\3\5"+
		"\6\5\\\n\5\r\5\16\5]\3\5\3\5\3\6\3\6\3\6\2\2\7\3\3\5\4\7\5\t\6\13\7\3"+
		"\2\6\4\2>>@@\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2r\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\3B\3\2\2\2\5O\3\2"+
		"\2\2\7Q\3\2\2\2\t[\3\2\2\2\13a\3\2\2\2\r\16\7d\2\2\16\17\7t\2\2\17\20"+
		"\7g\2\2\20\21\7c\2\2\21C\7m\2\2\22\23\7y\2\2\23\24\7j\2\2\24\25\7k\2\2"+
		"\25\26\7n\2\2\26C\7g\2\2\27\30\7e\2\2\30\31\7n\2\2\31\32\7c\2\2\32\33"+
		"\7u\2\2\33C\7u\2\2\34\35\7f\2\2\35\36\7q\2\2\36\37\7w\2\2\37 \7d\2\2 "+
		"!\7n\2\2!C\7g\2\2\"#\7g\2\2#$\7n\2\2$%\7u\2\2%C\7g\2\2&\'\7k\2\2\'C\7"+
		"h\2\2()\7k\2\2)*\7o\2\2*+\7r\2\2+,\7q\2\2,-\7t\2\2-C\7v\2\2./\7r\2\2/"+
		"\60\7w\2\2\60\61\7d\2\2\61\62\7n\2\2\62\63\7k\2\2\63C\7e\2\2\64\65\7u"+
		"\2\2\65\66\7v\2\2\66\67\7c\2\2\678\7v\2\289\7k\2\29C\7e\2\2:;\7v\2\2;"+
		"<\7j\2\2<=\7t\2\2=>\7q\2\2>?\7y\2\2?@\7u\2\2@A\3\2\2\2AC\b\2\2\2B\r\3"+
		"\2\2\2B\22\3\2\2\2B\27\3\2\2\2B\34\3\2\2\2B\"\3\2\2\2B&\3\2\2\2B(\3\2"+
		"\2\2B.\3\2\2\2B\64\3\2\2\2B:\3\2\2\2C\4\3\2\2\2DP\t\2\2\2EF\7?\2\2FP\7"+
		"?\2\2GH\7@\2\2HP\7?\2\2IJ\7>\2\2JP\7?\2\2KL\7#\2\2LM\7?\2\2MN\3\2\2\2"+
		"NP\b\3\3\2OD\3\2\2\2OE\3\2\2\2OG\3\2\2\2OI\3\2\2\2OK\3\2\2\2P\6\3\2\2"+
		"\2QU\t\3\2\2RT\t\4\2\2SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2VX\3\2\2"+
		"\2WU\3\2\2\2XY\b\4\4\2Y\b\3\2\2\2Z\\\t\5\2\2[Z\3\2\2\2\\]\3\2\2\2][\3"+
		"\2\2\2]^\3\2\2\2^_\3\2\2\2_`\b\5\5\2`\n\3\2\2\2ab\13\2\2\2bc\b\6\6\2c"+
		"\f\3\2\2\2\7\2BOU]\7\3\2\2\3\3\3\3\4\4\3\5\5\3\6\6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}