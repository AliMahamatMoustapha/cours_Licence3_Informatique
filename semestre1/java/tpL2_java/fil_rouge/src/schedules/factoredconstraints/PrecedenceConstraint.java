package schedules.factoredconstraints;

import schedules.activities.Activity;

public class PrecedenceConstraint extends BinaryConstraint {

    //--constructeur qui initialise les attributs

    public PrecedenceConstraint(Activity a1 , Activity a2){
        super(a1, a2) ;
    }

    //methode qui verifie la validité de date 
    @Override
    public boolean isSatisfied(int date1, int date2){

        return (date1 +activite1.getDuration() <= date2) ;       
    }

    @Override
    public String toString() {
        return "PrecedenceConstraint" ;
    }
    
}