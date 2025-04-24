 package model.etat;

import model.machine.Machine;

public class Retrait extends AbstractEtat {

    public Retrait(Machine machine){

        super(machine) ;
    }
        @Override
        public void insererCB() {
            System.out.println("vous avez deja inserer votre CB\n");
        }

        @Override
        public void codeCB() {
            System.out.println("vous avez deja taper votre mot de passe\n");
            
        }

        @Override
        public void retraitMontant() {
            machine.setEtat(new Retrait(machine));
        }

        @Override
        public void abandonOP() {
            System.out.println("impossible \n");
        }
    
}