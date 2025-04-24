lexer grammar JetonsJava;

MOTSCLES : 'break' | 'while' | 'class' | 'double' | 'else' | 'if' | 'import' | 'public' | 'static' | 'throws'
    { System.out.print("[motcle : "+getText()+" ]"); }
;
OPERATEUR : '<' | '>' |'==' | '>=' | '<=' | '!='
    { System.out.print("[operateur : "+getText()+" ]"); }

;
IDENTIFIANT :   ('a'..'z' | 'A'..'Z' | '_')('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*
    { System.out.print("[Idenfier : "+getText()+" ]"); }

;
WHITE_SPACE: (' '|'\n'|'\t'|'\r')+
    { System.out.print("[space : "+getText()+" ]"); }
;
UNMATCH: .
    { System.out.print("[unknow : "+getText()+" ]"); }
;

