package schedules.solvers;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import schedules.activities.Activity;
import schedules.constraints.Constraint;


public class Verifier {
    protected Set<Constraint> constraintes;

    public Verifier(Set<Constraint> contraintes ){

        this.constraintes = contraintes ;
    }

    public Set<Constraint> unsatisfied(Map<Activity,Integer> map){
        Set<Constraint> constraintUnsatisfied = new HashSet<>() ;

        for (Constraint c : constraintes) {
            if(!c.isSatisfied(map)){
                constraintUnsatisfied.add(c) ;
            }
            
        }

        return constraintUnsatisfied ;
    }
}
