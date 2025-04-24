package schedules.activities;

public class Activity {

    //--------attributs de la classe  : description(string ) et durree de type entier

    protected String description ;
    protected int duree ;

    //--initialisation des attributs 

    public Activity(String description , int duree){
        this.description = description ;
        this.duree = duree ;
    }

    //--methode qui renvoie la description de l'activité 


     public String getDescription() {
        return description;
    }

    //--methode qui renvoie la durrée de l'activité 

    public int getDuration() {
        return duree;
    }

    public String toString(){
        return this.description+"de durée "+this.duree ;
    }
    public boolean isTrue(Activity a){
        return a.getDescription()==description && a.getDuration()==duree ;
    }
}