package combattant;

import java.util.ArrayList;

public class Combattant {
    private String nomJoueur ;
    private int energie;
    private ArrayList<IArme> armes ;

    public Combattant(String nom,int energie,){
        this.nomJoueur = nom;
        this.energie = energie;
        armes = new ArrayList<>();
    }

}
