package schedules.constraints;
import java.util.Map;
import java.util.Set;

import schedules.activities.Activity;

public class MaxSpanConstraint implements Constraint{
    protected Set<Activity> activites ;
    protected int duree ;

    public MaxSpanConstraint(Set<Activity> activites , int duree){
        
        this.activites = activites ;
        //la condition ternaire ci-dessous  assure que la durée d'execution passez en parametre est positive sinon on initialise à zero
        this.duree = (duree>0) ? duree : 0 ;
        
    }

    @Override
    public Set<Activity> getActivities() {
       return this.activites ;
    }

    @Override
    public boolean isSatisfied(Map<Activity, Integer> map) {
        if(activites.isEmpty()){return true ;} 
        int tempMinDebut =Integer.MAX_VALUE , tempMaxFin=Integer.MIN_VALUE, debut=0 , fin=0 ;
        for (Activity activite : activites) {
            debut = map.getOrDefault(activite , 0) ;
            fin = debut +activite.getDuration() ;
            tempMinDebut = Math.min(tempMinDebut , debut) ;
            tempMaxFin = Math.max(tempMaxFin, fin) ;
        }
        return (tempMaxFin-tempMinDebut)<=this.duree ;
    }
    @Override
    public String toString() {
    return "MaxSpanConstraint" ;
    }
}
