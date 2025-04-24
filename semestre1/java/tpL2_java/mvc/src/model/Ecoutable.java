package model;

import java.util.ArrayList;

public abstract class Ecoutable implements IEcoutable {
    private ArrayList<IEcouteur> ecouteurs ;
    public Ecoutable(){
        ecouteurs = new ArrayList<>() ;
    }
    @Override
    public void ajouterEcouteur(IEcouteur e) {
        ecouteurs.add(e) ;
    }

    @Override
    public void supprimerEcouteur(IEcouteur e) {
       ecouteurs.remove(e) ;
    }
    public void notifierEcouteur(){
        for (IEcouteur e : ecouteurs) {
            e.miseAjours(this) ;
        }
    } 
}
