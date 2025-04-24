package schedules.constraints;
import java.util.Map;
import java.util.Set;
import schedules.activities.Activity;

public interface Constraint {
    
    public Set<Activity> getActivities() ;

    public boolean isSatisfied(Map<Activity ,Integer> activitesDates)  ;
    public abstract String toString();
}
