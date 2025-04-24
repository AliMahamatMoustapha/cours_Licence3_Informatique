package vue.client;

import model.etat.Inserer;
import model.etat.Retrait;
import model.machine.Machine;

public class Client {
    public static void main(String[] args) {
        Machine m = new Machine(new Inserer()) ;
        m.setEtat(new Retrait(m)) ;
    }
    
}