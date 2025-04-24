import java.util.*;

public class Automate {

    /** La fonction de transition de l'automate */
    protected int[][] _tableTransitions;
    /** État initial */
    protected int _etatInitial;
    /** Liste d’états finaux */
    protected List<Integer>  _etatsFinaux;
   
    public Automate(int Initial, Integer[] Acceptants, int[][] _tableTransitions) {
        this._tableTransitions = _tableTransitions;
        this._etatInitial = Initial;
        this._etatsFinaux = Arrays.asList(Acceptants);
    }

    /** État interne de l'automate */
    protected int etat;

    /** Positionne l'automate dans son état initial */
    protected void etatInitial() {
	etat = _etatInitial;
    }
    /** L'état courant est-il acceptant ? */
    protected boolean etatCourantEstAcceptant() {
	return _etatsFinaux.contains(etat);
    }
    /** Étant donné un caractère (donné par son code unicode), déclencher la transition */
    protected void etatSuivant(char c) {
	etat = _tableTransitions[etat][c-'a'];
    }

    public boolean reconnait(String mot) {
	etatInitial();
	char[] ch = mot.toCharArray();
	for (int i = 0; i < mot.length(); i++){ 
	    char c=ch[i];
	    System.out.println("État : "+ etat + " entrée " + String.format("%c", c));
	    etatSuivant(c);
	}
	System.out.println("État : "+ etat);
	return  etatCourantEstAcceptant();
    }

    public int compte(String mot) {
        int occ = 0;
        etatInitial();
        char[] ch = mot.toCharArray();
        for (int i = 0; i < mot.length(); i++){ 
            char c=ch[i];
            if(etatCourantEstAcceptant()){
                occ++;
                etatInitial();
            }
            etatSuivant(c);
        }
        return occ;
        }
}

