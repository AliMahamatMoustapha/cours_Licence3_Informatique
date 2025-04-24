package model;

public class Model extends Ecoutable{
    public enum Couleur{vert,orange,rouge} ;
    
    private Couleur currentColor ;
    public Model(){
        super() ;
        currentColor = Couleur.rouge ;
    }
    public void suivant(){
        if(currentColor == Couleur.vert){
            currentColor = Couleur.orange ;
        }
        else if(currentColor == Couleur.orange){
            currentColor = Couleur.rouge ;
        }
        else{
            currentColor = Couleur.vert ;

        }
        this.notifierEcouteur();
    }
    public Couleur getCurrentColor() {
        return currentColor;
    }
}
