grammar Calculette;

@parser::members {

    private int evalexpr (int x, String op, int y) {
        if ( op.equals("*") ){
            return x*y;
        } else if ( op.equals("+") ){
            return x+y;
        } 
        else if ( op.equals("-") ){
            return x-y;
        }
        else if ( op.equals("%") ){
            return x%y;
        }
        else if ( op.equals("/") ){
            return x/y;
        }
        else {
           System.err.println("Opérateur arithmétique incorrect : '"+op+"'");
           throw new IllegalArgumentException("Opérateur arithmétique incorrect : '"+op+"'");
        }
    }
}
// rules
start
    : expr EOF;

expr returns [ int val ]
    : a=expr op=('*'|'/'|'%'|'+'|'-') b=expr {
        $val = evalexpr($a.val,$op.text,$b.val);
        }
    |'('expr')'{
        $val = $expr.val;
    }
    |'-'expr{
        $val = -$expr.val;
    }
    | ENTIER {
        $val = $ENTIER.int;
        
    }
;
// lexer
NEWLINE : '\r'? '\n'  -> skip;

WS :   (' '|'\t')+ -> skip  ;

ENTIER : ('0'..'9')+  ;
// DOUBLE : ('0'..'9')+'.'('0'..'9')+;
UNMATCH : . -> skip ;


