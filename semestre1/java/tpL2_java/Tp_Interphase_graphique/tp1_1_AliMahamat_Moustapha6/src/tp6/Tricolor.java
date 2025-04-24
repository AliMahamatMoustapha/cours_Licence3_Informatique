package tp6 ;
/* import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

import tp6.AbstractModeleEcoutable;
 */
/**
 * Tricolor
 */
public class Tricolor extends AbstractModeleEcoutable{

    protected enum COULEURS {vert , rouge ,orange}
    protected COULEURS currentColor ;
    public Tricolor(){
        super();
        this.currentColor = COULEURS.rouge ;
    }
    /**
     * 
     */
    public void suivant(){
        if(this.currentColor == COULEURS.vert){
            this.currentColor = COULEURS.orange ;
        }
        else if(this.currentColor == COULEURS.orange){
            this.currentColor = COULEURS.rouge ;
        }
        else {
            this.currentColor = COULEURS.vert ;
        }
        this.fireChangement();
    }
    public COULEURS getcurrentColor(){
        return this.currentColor ;
    }
    public String toString(){
        return ""+this.getcurrentColor() ;
    }
}