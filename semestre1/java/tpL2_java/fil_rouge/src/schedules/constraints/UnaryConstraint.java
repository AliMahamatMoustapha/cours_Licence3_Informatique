package schedules.constraints;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import schedules.activities.Activity;

public class UnaryConstraint implements Constraint {

    protected Activity activite ;
    protected int dateMin , dateMax ;

    public UnaryConstraint(Activity activite , int dateMin , int dateMax){
        this.activite = activite ;
        this.dateMin = dateMin ;
        this.dateMax = dateMax ;
    }

    @Override
    public Set<Activity> getActivities() {
        Set<Activity> activiteConcerne = new HashSet<>() ;
        activiteConcerne.add(activite) ;
        return activiteConcerne ;
    }

    @Override
    public boolean isSatisfied(Map<Activity, Integer> activitesDates) {
        int dateDebut = activitesDates.get(this.activite) ;
        return (dateDebut>=dateMin && dateDebut<=dateMax );
    }
    @Override
    public String toString() {
        return "UnaryConstraint" ;
    }
}
