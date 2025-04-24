package schedules.solvers;
//import java.util.ArrayList;
//import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import schedules.activities.Activity;
import schedules.constraints.Constraint;
import schedules.constraints.MaxSpanConstraint;
import schedules.constraints.MeetConstraint;
import schedules.constraints.PrecedenceConstraint;
import schedulestests.solvers.TopologicalSorterTests;
import schedulestests.solvers.VerifierTests;
//import schedulestests.factoredtopologicalsort.TopologicalSorterTests;
public class Demo {
    public static void main(String[] args) {

        //instance de la class qui permet d'afficher un emploi grace à sa methode afficheMoiEmploi(prenant un emploi et son titre)
        AfficheEmploi affichEmploi = new AfficheEmploi() ;
        
        //-------------partie des instances de differentes activités----------------- 
        Activity activite1= new Activity("se lever                 ", 1) ;
        Activity activite2= new Activity("aller au travail         ", 15) ;
        Activity activite3= new Activity("prendre une douche       " ,10) ;
        Activity activite4= new Activity("se brosser les dent      " ,3) ;
        Activity activite5= new Activity("s’habiller               " ,2) ;
        Activity activite6= new Activity("prendre un petit déjeuner" ,15) ;

        //-------creation d'un ensemble et ajout des activités creer ci dessus -----------

        Set<Activity> activites = new HashSet<>() ;
        activites.add(activite1) ;
        activites.add(activite2) ;
        activites.add(activite3) ;
        activites.add(activite4) ;
        activites.add(activite5) ;
        activites.add(activite6) ;

        //--------parties des instances de contraints de precedence-------------------------

        PrecedenceConstraint contraint1= new PrecedenceConstraint(activite1, activite6) ;
        PrecedenceConstraint contraint2= new PrecedenceConstraint(activite1, activite5) ;
        PrecedenceConstraint contraint3= new PrecedenceConstraint(activite6, activite4) ;
        PrecedenceConstraint contraint4= new PrecedenceConstraint(activite3, activite5) ;
        PrecedenceConstraint contraint5= new PrecedenceConstraint(activite4, activite2) ;
        PrecedenceConstraint contraint6= new PrecedenceConstraint(activite5, activite2) ;
        PrecedenceConstraint contraint7= new PrecedenceConstraint(activite1, activite3) ;
         PrecedenceConstraint contraint8= new PrecedenceConstraint(activite6, activite2) ;

        //-------creation d'un ensemble et ajout des contraints creer ci dessus ----------------

        Set<PrecedenceConstraint> contraints = new HashSet<>() ;
        contraints.add(contraint1) ;
        contraints.add(contraint2) ;
        contraints.add(contraint3) ;
        contraints.add(contraint4) ;
        contraints.add(contraint5) ;
        contraints.add(contraint6) ;
        contraints.add(contraint7) ;
        contraints.add(contraint8) ;
       
        //----------------partie affichage--avec style-------------------------------------------------------------------------

       TopologicalSorter topologie = new TopologicalSorter() ;
        
        List<Activity> ordonnancement = topologie.bruteForceSort(activites, contraints);
        if(ordonnancement==null){System.out.println("impossible d'ordonnencement");}
        else{
        Map<Activity ,Integer> emploi = topologie.schedule(activites, contraints, 500) ;

        //Affichage d'emploi ordonnée par algoritme de brute force 
        affichEmploi.afficheMoiEmploi(emploi,"EMPLOI ORDONNÉE");
    } 



        Set<Constraint> constraints = new HashSet<>();

        // Contrainte : activit1 doit se terminer avant qu’activite6 ne commence
        constraints.add(new PrecedenceConstraint(activite1, activite6));

        // Contrainte : activity4 doit commencer exactement quand activity3 se termine
        constraints.add(new MeetConstraint(activite3, activite4));

        // Contrainte : activity1, activity2 et activity3 doivent toutes
        // prendre place en au plus 90 minutes
        Set<Activity> activities = new HashSet<> ();
        activities.add(activite1);
        activities.add(activite2);
        activities.add(activite3);
        MaxSpanConstraint spanConstraint = new MaxSpanConstraint(activities, 90);
        constraints.add(spanConstraint);
        Verifier verifier = new Verifier(constraints);
        Map<Activity, Integer> schedule =topologie.schedule(activites, contraints, 500) ;
        System.out.println("L’emploi du temps satisfait-il toutes les contraintes ?\n\n ");
        Set<Constraint> unsatisfied = verifier.unsatisfied(schedule);
        if(unsatisfied.isEmpty()) {
        System.out.println("Oui\n");
        } 
        else {
        System.out.println("Non, les contraintes suivantes sont non satisfaites :\n");
        }
     //---------------------------partie du test-------------------------------------------------------------
        boolean ok= true ;
        TopologicalSorterTests topologicalSortTester = new TopologicalSorterTests();
        ok = ok && topologicalSortTester.testBruteForceSort();
        ok = ok && topologicalSortTester.testSchedule();
        //ok = ok && topologicalSortTester.testLinearTimeSort();
        VerifierTests verifierTester = new VerifierTests();
        ok = ok && verifierTester.testUnsatisfied();
        System.out.println(ok ? "All tests passed" : "At least one test failed");
    }
}

