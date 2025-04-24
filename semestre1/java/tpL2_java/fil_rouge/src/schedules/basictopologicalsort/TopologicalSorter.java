
package schedules.basictopologicalsort;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import schedules.activities.Activity;
import schedules.basicconstraints.PrecedenceConstraint;

public class TopologicalSorter{

    
    public TopologicalSorter(){}


    //-methode qui permet d'ordonner les activités en respectant des contraints grace à l'algorithme de force brute 

    public ArrayList<Activity> bruteForceSort(HashSet<Activity> activities ,HashSet<PrecedenceConstraint> constraints){
        HashSet<Activity> copy = new HashSet<>(activities);
        ArrayList<Activity> res=new ArrayList<>() ;

        while(!copy.isEmpty()){
           Activity activite = algorithme2(copy ,res, constraints) ;
            if(activite==null)
                return null ;
            else{
                res.add(activite);
                copy.remove(activite) ;
            }
          
        }

        return res ;
    }

    public Activity algorithme2(HashSet<Activity> activities ,ArrayList<Activity> res ,HashSet<PrecedenceConstraint> constraints){
        boolean ok;
        for (Activity o2 : activities) {
            ok = true  ;
            for (PrecedenceConstraint c : constraints) {
                if(o2.equals(c.getSecond()) && !res.contains(c.getFirst())){
                    ok=false ;
                    break ;
                }   
            }
            if(ok){return o2 ;}
        }
        return null ;
    }

    //--methode shedule qui prends en parametre ensemble des activités, ensemble de contraints et une date de debut puis retourne un emploi du temps

    public HashMap<Activity,Integer> schedule(HashSet<Activity> activities ,HashSet<PrecedenceConstraint> constraints,int dateDepart){
        ArrayList<Activity> activitesOrdonnee = bruteForceSort(activities, constraints) ;
        HashMap<Activity ,Integer> dictionnaire =new HashMap<>() ;
        int debut = dateDepart ;
        if(activitesOrdonnee==null)
            return null ;
        for (Activity activite : activitesOrdonnee) {
            dictionnaire.put(activite, debut) ;
            debut=debut+activite.getDuration() ;
        }
        return dictionnaire ;
    }
    
}