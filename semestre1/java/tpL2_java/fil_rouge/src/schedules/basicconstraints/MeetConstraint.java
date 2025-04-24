package schedules.basicconstraints;

import schedules.activities.Activity;


public class MeetConstraint{
  private Activity activite1;
  private Activity activite2;

  public MeetConstraint(Activity activite1,Activity activite2){
    this.activite1 = activite1;
    this.activite2 = activite2;
  }

  public Activity getFirst(){
    return activite1;
  }

  public Activity getSecond(){
    return activite2;
  }

 public boolean isSatisfied(int date1, int date2){
        if(date1 + activite1.getDuration() == date2){
            return true;
        }
        return false;
    }



}