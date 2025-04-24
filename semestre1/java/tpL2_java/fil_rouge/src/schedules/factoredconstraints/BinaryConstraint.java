package schedules.factoredconstraints;

import schedules.activities.Activity;

public abstract class BinaryConstraint {
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
     public abstract String toString();

            
}
