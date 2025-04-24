package tp6 ;

public class DemoTricoloe {
    public static void main(String[] args) {
        Tricolor feu = new Tricolor();
        System.out.println(feu); 
        ViewConsole vc = new ViewConsole(feu) ;
        
    feu.suivant();
    feu.suivant();
    feu.suivant();
    Vue fenetre = new Vue() ;
    
    }
}
