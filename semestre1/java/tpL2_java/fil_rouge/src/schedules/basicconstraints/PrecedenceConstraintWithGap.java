package schedules.basicconstraints;

import schedules.activities.Activity;

public class PrecedenceConstraintWithGap extends PrecedenceConstraint {
    protected int delaiMin , delaiMax ;

    public PrecedenceConstraintWithGap(Activity activite1,Activity activite2 ,int delaiMin,int delaiMax){
        super(activite1, activite2) ;
        this.delaiMin = delaiMin ;
        this.delaiMax = delaiMax ;
    }
    
    @Override
    public boolean isSatisfied(int date1, int date2){
       int duree =date2-(date1+activity1.getDuration());
       return (duree>=delaiMin) && (duree<=delaiMax) ;
    }

}
