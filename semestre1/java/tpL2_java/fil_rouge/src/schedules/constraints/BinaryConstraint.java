package schedules.constraints;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import schedules.activities.Activity;

public abstract class BinaryConstraint implements Constraint {
    protected Activity activite1 , activite2 ;

    public BinaryConstraint(Activity activite1 , Activity activite2){
        this.activite1 = activite1 ;
        this.activite2 = activite2 ;

    }
    public Activity getFirst(){
        return activite1;
      }
    
      public Activity getSecond(){
        return activite2;
      }
    
     public abstract boolean isSatisfied(int date1, int date2);

     @Override
     public boolean isSatisfied(Map<Activity, Integer> map) {
        return isSatisfied(map.get(activite1),map.get(activite2)) ;
  }

  @Override
  public Set<Activity> getActivities() {
    Set<Activity> activitesConcernes = new HashSet<>() ;
    activitesConcernes.add(activite1) ;
    activitesConcernes.add(activite2) ;
    return activitesConcernes ;
  }
  
  

            
}
