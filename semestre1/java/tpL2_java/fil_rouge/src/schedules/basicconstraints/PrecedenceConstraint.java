package schedules.basicconstraints;

import schedules.activities.Activity;

public class PrecedenceConstraint {

    //-----attributs de la classe 

    protected Activity activity1 , activity2 ;

    //--constructeur qui initialise les attributs

    public PrecedenceConstraint(Activity a1 , Activity a2){
        activity1 = a1 ;
        activity2 = a2 ;
    }

    //methode qui retourne la premiere activité 

    public Activity getFirst() {
            return activity1;
        }


     //methode qui retourne la deuxieme activité 

    public Activity getSecond(){
            return activity2;
        }

    //methode qui verifie la validité de date 

    
    public boolean isSatisfied(int date1, int date2){
        if(date1 + activity1.getDuration() <= date2){
            return true;
        }
        return false;
    }
}