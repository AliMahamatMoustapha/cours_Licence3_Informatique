package model.machine;

import model.etat.IEtat;
import model.etat.Inserer;

public class Machine {
    
    private IEtat etat = new Inserer(null) ;

    public Machine(IEtat etat){
        this.etat = etat ;
    }

    public IEtat getEtat() {
        return etat;
    }

    public void setEtat(IEtat etat) {
        this.etat = etat;
    }
}