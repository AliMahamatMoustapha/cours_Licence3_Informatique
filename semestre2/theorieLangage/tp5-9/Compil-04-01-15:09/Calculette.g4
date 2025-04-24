grammar Calculette;


@parser::members {
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
}

//regles de production   
start : calcul   ;// point d'entrer ou axiome
calcul returns [ String code ]
@init{ $code = new String(); }   // On initialise une variable pour accumuler le code 
@after{ System.out.println($code); } // On affiche le code effectivement produit
    : 
        (decl finInstruction { $code += $decl.code; } )* 
        {$code += "JUMP start\n"; }
        NEWLINE*

        (fonction { $code += $fonction.code ;})*
        NEWLINE*

        { $code += "LABEL start\n";}
        (instruction { $code += $instruction.code; })*
        { $code += "HALT\n"; }
    ;
decl returns [ String code ] 
    :
    TYPE IDENTIFIANT 
        {
            // declaration de variable

            tablesSymboles.addVarDecl($IDENTIFIANT.text,$TYPE.text);
            VariableInfo vi = tablesSymboles.getVar($IDENTIFIANT.text);
            
            $code = !$TYPE.text.equals("double") ? "PUSHI 0\n" : "PUSHF 0.0\n";
           
        }
    | TYPE IDENTIFIANT '=' expression 
    {
        tablesSymboles.addVarDecl($IDENTIFIANT.text,$TYPE.text);
        VariableInfo vi = tablesSymboles.getVar($IDENTIFIANT.text);
        String storeGorStoreL = (vi.scope == VariableInfo.Scope.GLOBAL) ? "STOREG " :"STOREL ";

        $code = (!$TYPE.text.equals("double") ? "PUSHI 0\n" : "PUSHF 0.0\n" ) + $expression.code ;
        $code += ( vi.type.equals("double") ? storeGorStoreL + (vi.address+1) + "\n" : "") ;
        $code += storeGorStoreL + vi.address + "\n";
    }
    ;


instruction returns [ String code ] 
    : 
    assignation finInstruction
        { 
		// à compléter
            $code = $assignation.code;
        }

    |expression finInstruction
        { 
            // à compléter
            $code = $expression.code;

        }
   | input finInstruction
    {
        $code = $input.code;
    }
   | output finInstruction
        {
            $code = $output.code;
        }
   | bloc 
      {
         $code = $bloc.code;
      }
    | bouclewhile 
        {
            $code = $bouclewhile.code ;
        }
    | branchements 
        {
            $code = $branchements.code ;
        }
    | boucleFor 
        {
            $code = $boucleFor.code;
        }
    | RETURN expression finInstruction    
        {

            VariableInfo vi = tablesSymboles.getReturn();
            $code = $expression.code;
            $code += "STOREL " + vi.address + "\n" + (vi.type.equals("double") ? "STOREL "  + (vi.address+1) + "\n": "" ) + "RETURN\n";

        }

   | finInstruction
        {
            $code = "";
        };

expression returns [ String code ,String type ]
    : 
    
    // à compléter
    '-' a=expression{
        $type = $a.type;
        $code = (!$a.type.equals("double") ? "PUSHI 0 \n" : "PUSHF 0.0\n") + $a.code + evalexpr("-",$a.type);
    }

    | exp1=expression OP=('*'|'/'|'%') exp2=expression{
              
        if(!$exp1.type.equals($exp2.type)){ 
            if($exp1.type.equals("double")){
                $type = $exp1.type;

                $code = $exp1.code  + $exp2.code  + "ITOF\n" + evalexpr($OP.text,$exp1.type);
            }
            else if($exp2.type.equals("double")) {
                $type = $exp2.type;
                $code = $exp1.code  + "ITOF\n" + $exp2.code  + evalexpr($OP.text,$exp2.type);

            }
        }
        else{
             $type = "int";
            $code = $exp1.code + $exp2.code + evalexpr($OP.text,$type);

         }
        
    }
    | exp1=expression OP=('+'|'-') exp2=expression{
         if(!$exp1.type.equals($exp2.type)){ 
            if($exp1.type.equals("double")){
                $type = $exp1.type;

                $code = $exp1.code  + $exp2.code  + "ITOF\n" + evalexpr($OP.text,$exp1.type);
            }
            else if($exp2.type.equals("double")) {
                $type = $exp2.type;
                $code = $exp1.code  + "ITOF\n" + $exp2.code  + evalexpr($OP.text,$exp2.type);

            }
        }
        else{
             $type ="int";
            $code = $exp1.code + $exp2.code + evalexpr($OP.text,$type);

         }
        
    }
    |'(' a=expression ')'{
        $type = $a.type;
        $code = $a.code;
    }
    
    | IDENTIFIANT 
        {
            VariableInfo vi = tablesSymboles.getVar($IDENTIFIANT.text);
            String typeOfPushi = (vi.scope == VariableInfo.Scope.GLOBAL ) ? "PUSHG "  : "PUSHL ";
            $code = typeOfPushi + vi.address +"\n" + (vi.type.equals("double") ? typeOfPushi +(vi.address+1) +"\n" : "" );
            $type = vi.type;
        }
    | IDENTIFIANT'('')' // Appel de la fonction sans parametre
        {   
            $type = tablesSymboles.getFunction($IDENTIFIANT.text);
            $code =  !$type.equals("double") ? "PUSHI 0\n" : "PUSHF 0.0\n" ;
            $code += "CALL " + $IDENTIFIANT.text + "\n";
           
        }
    | IDENTIFIANT '(' args ')'                  // Appel de fonction avec parametre
        {
            $type = tablesSymboles.getFunction($IDENTIFIANT.text);
            $code =  !$type.equals("double") ? "PUSHI 0\n" : "PUSHF 0.0\n" ;
            $code += $args.code + "CALL " + $IDENTIFIANT.text + "\n";
            // Ajouter ici le nettoyage de la pile
            for(int i=0; i<$args.size;i++){
                $code += "POP\n";
            }
            
        }

    | ENTIER {
        $type = "int";
        $code = "PUSHI " + $ENTIER.text + "\n";
    }
    | BOOL {
        $type = "int";
        $code = ($BOOL.text).equals("true") ? "PUSHI 1\n" : "PUSHI 0\n";
    }
    | DOUBLE {
        $type = "double";
        $code = "PUSHF " + $DOUBLE.text + "\n";
    }
    
    ;
assignation returns [ String code ] 
    : IDENTIFIANT '=' expression 
        {  
            // à compléter
            VariableInfo vi = tablesSymboles.getVar($IDENTIFIANT.text);
            String typeStore =  ((vi.scope != VariableInfo.Scope.GLOBAL) ? "STOREL " : "STOREG ") ;
            $code = $expression.code + typeStore + vi.address+"\n" + (vi.type.equals("double") ? 
               typeStore + (vi.address + 1) +"\n" : "" );
        }

    | IDENTIFIANT  OP=('*=' | '/=' | '%=' | '-=' | '+=')  expression 
        {

         VariableInfo vi = tablesSymboles.getVar($IDENTIFIANT.text); 
         String typePush = ((vi.scope == VariableInfo.Scope.GLOBAL) ? "PUSHG " : "PUSHL ");
         $code = typePush + vi.address + "\n"+ (vi.type.equals("double") ?  typePush + (vi.address+1) + "\n" : "" );
         $code += $expression.code + evalexpr((Character.toString($OP.text.charAt(0))),vi.type);
         $code +=  ((vi.scope == VariableInfo.Scope.GLOBAL) ? "STOREG " :"STOREL ") + vi.address +"\n";
        }
    ;
input returns [ String code ]:
    'input('IDENTIFIANT')'
    {
        VariableInfo vi = tablesSymboles.getVar($IDENTIFIANT.text);
        $code = (!vi.type.equals("double") ? "READ \n" : "READF\n");
        String typeStore = ((vi.scope == VariableInfo.Scope.GLOBAL) ? "STOREG " :"STOREL ");
        $code += (vi.type.equals("double") ?  typeStore + (vi.address+1) + "\n"  + typeStore + vi.address + "\n" : typeStore + vi.address + "\n" );


       
    }
    ;
output returns [String code]:
     'output('expression')'
     {

        $code = $expression.code + (!$expression.type.equals("double") ? "WRITE\nPOP\n" : "WRITEF\nPOP\nPOP\n");

     };
bloc returns [ String code ]  
@init{ $code = new String(); } 
    : '{' 
           // à compléter    
           (instruction { $code += $instruction.code; })*  
      '}'  
      NEWLINE*
    ;
// Traitement du while 
bouclewhile returns [String code] :
    'while' '('condition')' instruction
    {
        String debut = newLabel();
        String fin = newLabel();
        $code  = "LABEL " + debut + $condition.code + "JUMPF " + fin + $instruction.code + "JUMP " + debut + "LABEL " + fin ; 
    }
    ;

condition returns [String code]: 
    'not'condition
        {
            $code = $condition.code + "PUSHI 1\nNEQ\n";
        }
    
   | a=condition 'and' b=condition 
        {
            $code = $a.code + $b.code + "MUL\n";
        }
    | a=condition 'or' b=condition 
        {
        $code = $a.code + $b.code + "ADD\nPUSHI 0\nSUP\n";
        }
    |'True'
        {
            $code =  "PUSHI 1\n";
        }
    |'False'
        {
           $code =  "PUSHI 0\n"; 
        }
    | operationRationelle
        {
            $code = $operationRationelle.code;
        }
    ;
operationRationelle returns [String code]:
      exp1=expression OP=('<' | '>' | '<=' | '>=' | '!=' | '<>' | '==') exp2=expression
        {
            if(!$exp1.type.equals($exp2.type)){ 
                if($exp1.type.equals("double")){
                    $code = $exp1.code  + $exp2.code  + "ITOF\n" + evalexpr($OP.text,$exp1.type);
                }
                else if($exp2.type.equals("double")) {
                    $code = $exp1.code  + "ITOF\n" + $exp2.code  + evalexpr($OP.text,$exp2.type);

                }
           }

         else {
            $code = $exp1.code + $exp2.code + evalexpr($OP.text,$exp1.type);

        }
        
        }
        ;

branchements returns [String code]:
    'if' '('condition')' 'then' instruction
        {
            String sifaux = newLabel();
            $code = $condition.code + "JUMPF " + sifaux + $instruction.code +  "LABEL " + sifaux ;
        }
    |'if' '('condition')' 'then' a=instruction NEWLINE* 'else' b=instruction
        {
            String sifaux = newLabel();
            String finIf = newLabel();
            $code = $condition.code + "JUMPF " + sifaux + $a.code + "JUMP " + finIf + "LABEL " + sifaux +  $b.code + "LABEL " + finIf;
        }
;
// regle de boucle for 
boucleFor  returns [String code]:
    'for' '(' a=assignation ';' condition ';' b=assignation ')' instruction
    {
        String fin = newLabel();
        String debut = newLabel();
        $code =  $a.code + "LABEL " + debut + $condition.code +"JUMPF " + fin + $instruction.code + $b.code + "JUMP " + debut + "LABEL " + fin;
    };

// les fonctions 
fonction returns [ String code ]
@init{  tablesSymboles.enterFunction(); }   // On initialise une variable pour accumuler le code 
@after{ tablesSymboles.exitFunction(); } // On affiche le code effectivement produit
    : TYPE IDENTIFIANT 
        {
            // enregistrer dans la table de fonction
            tablesSymboles.addFunction($IDENTIFIANT.text,$TYPE.text);
            $code = "LABEL " + $IDENTIFIANT.text + "\n";
        }
    '(' ')' 
        '{'
            NEWLINE?

            (decl { $code += $decl.code; })*

            NEWLINE?
            (instruction { $code += $instruction.code; })*
            {$code += "RETURN\n";}
        '}'
           

    
    | TYPE IDENTIFIANT
    {   
        // enregistrer dans la table de fonction
        tablesSymboles.addFunction($IDENTIFIANT.text,$TYPE.text);
        $code = "LABEL " + $IDENTIFIANT.text + "\n";
    }
    '('params')' '{'

        NEWLINE?
        // partie de declaration des variables locales
        (decl finInstruction {$code += $decl.code;})*

        NEWLINE?
        (instruction { $code += $instruction.code; })*
        {$code += "RETURN\n";}


     '}'
        NEWLINE*
    ;

// permettant la definition de parametre 
params
    : TYPE IDENTIFIANT
        {
            // code java gérant le premier paramètre
            tablesSymboles.addParam($IDENTIFIANT.text,$TYPE.text);

        }
        ( ',' TYPE IDENTIFIANT
            {
                // code java gérant un paramètre
                tablesSymboles.addParam($IDENTIFIANT.text,$TYPE.text);

            }
        )*
    ;
// init nécessaire à cause du ? final et donc args peut être vide (mais $args sera non null) 
args returns [ String code, int size] @init{ $code = new String(); $size = 0; }
    : ( expression 
    {
        // code java pour première expression pour arg
        $code = $expression.code;
        $size += !$expression.type.equals("double") ? 1 : 2;
    }
    ( ',' expression
    {
        // code java pour expression suivante pour arg
        $code += $expression.code;
        $size += !$expression.type.equals("double") ? 1 : 2;


    }
    )*
      )?
    ;


    
   
finInstruction : ( NEWLINE | ';' )+ ;


//lexer 
RETURN: 'return';
COMM :  ( ('#')(~('\n'))* ) -> skip;
COMMLIGNE : ( ('//')(~('\n'))* )  -> skip;
COMMMULTI : ( ('/*') .*? ('*/') ) -> skip;

NEWLINE : '\r'? '\n' ;

WS :   (' '|'\t')+  -> skip;
ENTIER : ('0'..'9')+  ;
DOUBLE :  ('0'..'9')+ '.' ('0'..'9')*  ;
OP : '*' | '/' | '%'| '-' | '+'  ;
TYPE : 'int' | 'double' ;
BOOL : 'True' | 'False';
IDENTIFIANT :('a'..'z' | 'A'..'Z' | '_')('a'..'z' | 'A'..'Z' | '_' | ENTIER)*;
UNMATCH : . -> skip;