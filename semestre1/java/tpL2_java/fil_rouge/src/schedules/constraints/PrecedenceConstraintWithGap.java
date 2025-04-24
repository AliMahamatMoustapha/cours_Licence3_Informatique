package schedules.constraints;
import schedules.activities.Activity;


public class PrecedenceConstraintWithGap extends PrecedenceConstraint {

    //declaration des attributs :

    protected int delaiMin , delaiMax ;
    // constructeur et initialisation des attributs 

    public PrecedenceConstraintWithGap(Activity activite1,Activity activite2 ,int delaiMin,int delaiMax){
        super(activite1, activite2) ;
        this.delaiMin = delaiMin ;
        this.delaiMax = delaiMax ;
    }
    //Redefinition de la methode isSatisfied
    
    @Override
    public boolean isSatisfied(int date1, int date2){
       int duree =date2-(date1+activite1.getDuration());
       return (duree>=delaiMin) && (duree<=delaiMax) ;
    }
    @Override
    public String toString() {
        return "PrecedenceConstraintWithGap" ;
    }
}
