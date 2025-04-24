package schedules.solvers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import schedules.activities.Activity;
import schedules.constraints.Constraint;

public class RandomScheduler {
    protected Random aleatoire ;
    protected int nombreEmploi ;
    public RandomScheduler(Random aleatoire){
        this.aleatoire = aleatoire ;
    }
    public Map<Activity ,Integer> generateOneSchedule(Set<Activity> activites ,int dateMin , int dateMax){
        Map<Activity , Integer> emploi = new HashMap<>() ;
        int dateDebut = 0 ;
        for (Activity activite : activites) {
            dateDebut = aleatoire.nextInt(dateMax - dateMin +1)+dateMin ;
            emploi.put(activite, dateDebut) ;  

        }
        return emploi ;
    }
    public Map<Activity,Integer> generateSchedule(Set<Activity> activites , Set<Constraint> contraints ,int dateMin ,int dateMax ,int nombreEmploi ){
            Verifier verifier = new Verifier((contraints)) ;
            this.nombreEmploi = nombreEmploi ;
            Map<Activity,Integer> emploi = new HashMap<>() ;           
            Map<Activity,Integer> emploiCourant = new HashMap<>() ;
            int valeurMax = 0;
            int taille=0;
            for(int i = 0; i< nombreEmploi ;i++){
                emploiCourant = this.generateOneSchedule(activites, dateMin, dateMax);
                taille = emploiCourant.size() - verifier.unsatisfied(emploiCourant).size();
                if(valeurMax < taille){
                    valeurMax = taille;
                    emploi = emploiCourant;
                }

            }

           
            return emploi ;
    }
    public int getNombreEmploi(){
        return nombreEmploi ;
    }
}
