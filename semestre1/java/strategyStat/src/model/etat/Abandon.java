 package model.etat;

import model.machine.Machine;

public class Abandon extends AbstractEtat {

    public Abandon(Machine machine){
       super(machine) ;
    }
    @Override
    public void insererCB() {
        System.out.println("impossible \n");
    }
    @Override
    public void codeCB() {
        System.out.println("impossible \n");

    }
    @Override
    public void retraitMontant() {
        System.out.println("impossible \n");
    }
    @Override
    public void abandonOP() {
        machine.setEtat(new Abandon(machine));
    }
    
}