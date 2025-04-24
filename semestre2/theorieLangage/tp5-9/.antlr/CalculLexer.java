// Generated from /home/21914839/Documents/theorieLangage/tp5-9/Calculette.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, OPERATEUR=2, MOTCLE=3, IDENTIFIANT=4, WHITE_SPACE=5, UNMATCH=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "OPERATEUR", "MOTCLE", "IDENTIFIANT", "WHITE_SPACE", "UNMATCH"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "OPERATEUR", "MOTCLE", "IDENTIFIANT", "WHITE_SPACE", "UNMATCH"
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


	public CalculLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calculette.g4"; }

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\b[\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\3\34\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4L\n\4\3\5\3\5\7\5P\n\5\f\5\16\5S\13\5\3\6\6\6V\n\6\r\6\16\6W\3\7"+
		"\3\7\2\2\b\3\3\5\4\7\5\t\6\13\7\r\b\3\2\5\5\2C\\aac|\6\2\62;C\\aac|\5"+
		"\2\13\f\17\17\"\"\2i\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\3\17\3\2\2\2\5\33\3\2\2\2\7K\3\2\2\2\tM\3\2\2"+
		"\2\13U\3\2\2\2\rY\3\2\2\2\17\20\7=\2\2\20\4\3\2\2\2\21\34\7>\2\2\22\23"+
		"\7>\2\2\23\34\7?\2\2\24\34\7@\2\2\25\26\7@\2\2\26\34\7?\2\2\27\30\7?\2"+
		"\2\30\34\7?\2\2\31\32\7#\2\2\32\34\7?\2\2\33\21\3\2\2\2\33\22\3\2\2\2"+
		"\33\24\3\2\2\2\33\25\3\2\2\2\33\27\3\2\2\2\33\31\3\2\2\2\34\6\3\2\2\2"+
		"\35\36\7d\2\2\36\37\7t\2\2\37 \7g\2\2 !\7c\2\2!L\7m\2\2\"#\7e\2\2#$\7"+
		"n\2\2$%\7c\2\2%&\7u\2\2&L\7u\2\2\'(\7f\2\2()\7q\2\2)*\7w\2\2*+\7d\2\2"+
		"+,\7n\2\2,L\7g\2\2-.\7g\2\2./\7n\2\2/\60\7u\2\2\60L\7g\2\2\61\62\7k\2"+
		"\2\62L\7h\2\2\63\64\7k\2\2\64\65\7o\2\2\65\66\7r\2\2\66\67\7q\2\2\678"+
		"\7t\2\28L\7v\2\29:\7r\2\2:;\7w\2\2;<\7d\2\2<=\7n\2\2=>\7k\2\2>L\7e\2\2"+
		"?@\7u\2\2@A\7v\2\2AB\7c\2\2BC\7v\2\2CD\7k\2\2DL\7e\2\2EF\7v\2\2FG\7j\2"+
		"\2GH\7t\2\2HI\7q\2\2IJ\7y\2\2JL\7u\2\2K\35\3\2\2\2K\"\3\2\2\2K\'\3\2\2"+
		"\2K-\3\2\2\2K\61\3\2\2\2K\63\3\2\2\2K9\3\2\2\2K?\3\2\2\2KE\3\2\2\2L\b"+
		"\3\2\2\2MQ\t\2\2\2NP\t\3\2\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2R"+
		"\n\3\2\2\2SQ\3\2\2\2TV\t\4\2\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2"+
		"X\f\3\2\2\2YZ\13\2\2\2Z\16\3\2\2\2\7\2\33KQW\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}