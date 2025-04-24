package model.etat;

import model.machine.Machine;

public class Inserer extends AbstractEtat{
    public Inserer(Machine machine){
       super(machine) ;
    }
    public Inserer(){
        this(machine) ;
     }
    @Override
    public void insererCB() {
        machine.setEtat(new Inserer(this.machine));
    }

    @Override
    public void codeCB() {
        System.out.println("Vous devez inserer la carte d'abord \n");
    }

    @Override
    public void retraitMontant() {
        System.out.println("Vous devez inserer la carte puis votre mot de passe \n");

    }

    @Override
    public void abandonOP() {
        System.out.println("impossible  \n");

    }

    
}