
package schedules.solvers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import schedules.activities.Activity;
import schedules.constraints.PrecedenceConstraint;

public class TopologicalSorter{
    private int dateDepart ;
    
    public TopologicalSorter(){}


    //-methode qui permet d'ordonner les activités en respectant des contraints grace à l'algorithme de force brute 

    public List<Activity> bruteForceSort(Set<Activity> activities ,Set<PrecedenceConstraint> constraints){
        Set<Activity> copy = new HashSet<>(activities);
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

    public Activity algorithme2(Set<Activity> activities ,List<Activity> res ,Set<PrecedenceConstraint> constraints){
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

    public Map<Activity,Integer> schedule(Set<Activity> activities ,Set<PrecedenceConstraint> constraints,int dateDepart){
        this.dateDepart=dateDepart ;
        List<Activity> activitesOrdonnee = bruteForceSort(activities, constraints) ;
        Map<Activity ,Integer> dictionnaire =new HashMap<>() ;
        int debut = dateDepart ;
        if(activitesOrdonnee==null)
            return null ;
        for (Activity activite : activitesOrdonnee) {
            dictionnaire.put(activite, debut) ;
            debut=debut+activite.getDuration() ;
        }
        return dictionnaire ;
    }
    public int getDateDepart(){
        return dateDepart ;
    }
    
}