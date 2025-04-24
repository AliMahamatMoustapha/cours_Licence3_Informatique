package schedules.constraints;
import schedules.activities.Activity;


public class MeetConstraint extends BinaryConstraint{

  public MeetConstraint(Activity activite1,Activity activite2){
    super(activite1, activite2) ;
  }

@Override
 public boolean isSatisfied(int date1, int date2){

      return  (date1 + activite1.getDuration() == date2) ;     
    }

@Override
public String toString() {
  return "MeetConstraint" ;
}

}