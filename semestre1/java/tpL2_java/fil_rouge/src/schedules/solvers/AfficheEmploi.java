package schedules.solvers;

import java.util.Map;

import schedules.activities.Activity;

public class AfficheEmploi {

    //Cette class est fait specialement pour afficher un Emploi à la place de repétition de boucle pour afficher un emloi dans les demos 

    public AfficheEmploi(){
    }

    // cette methode prend un Emploi et son titre puis l'affiche automatiquement
    public void afficheMoiEmploi(Map<Activity,Integer> emploi,String title){
        System.out.println("\n\n     "+title+"        ");
        System.out.print("\n\n |        Activite            |  Duree|  heure  |\n");
        System.out.print(" |----------------------------------------------|\n");
        for(Map.Entry<Activity,Integer> m : emploi.entrySet()) {
            System.out.print(" | "+m.getKey().getDescription()+"  |   "+m.getKey().getDuration()+"  |     "+m.getValue());
            System.out.print("\n |----------------------------------------------|");
            System.out.println();
        }
    }
}
