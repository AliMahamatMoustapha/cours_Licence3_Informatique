 package model.etat;

import model.machine.Machine;

public class Code extends AbstractEtat{
    public Code(Machine machine){
        super(machine) ;
    }
    @Override
    public void insererCB() {
        System.out.println("Carte deja inserer \n");
    }

    @Override
    public void codeCB() {
        machine.setEtat(new Code(machine));
    }

    @Override
    public void retraitMontant() {
        System.out.println("impossible  \n");
        
    }

    @Override
    public void abandonOP() {
        System.out.println("impossible \n");

    }

 }
