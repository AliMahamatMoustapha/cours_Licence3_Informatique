package tp6 ;
public class ViewConsole implements EcouteurModele{
    Tricolor feu;
    
    public ViewConsole(Tricolor t){
        this.feu = t ;
        this.feu.ajoutEcouteur(this);
    }
    
    public void modeleMisAJour(Object source) {
        System.out.println(this.feu);
    }
}
