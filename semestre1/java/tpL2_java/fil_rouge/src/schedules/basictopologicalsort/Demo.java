package schedules.basictopologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import schedules.activities.Activity;
import schedules.basicconstraints.PrecedenceConstraint;
import schedulestests.basictopologicalsort.TopologicalSorterTests;
public class Demo {

    public static void main(String[] args) {

        //-------------partie des instances de differentes activités-----------------

        Activity activite1= new Activity("se lever                 ", 1) ;
        Activity activite2= new Activity("aller au travail         ", 15) ;
        Activity activite3= new Activity("prendre une douche       " ,10) ;
        Activity activite4= new Activity("se brosser les dent      " ,3) ;
        Activity activite5= new Activity("s’habiller               " ,2) ;
        Activity activite6= new Activity("prendre un petit déjeuner" ,15) ;

        //-------creation d'un ensemble et ajout des activités creer ci dessus -----------

        HashSet<Activity> activites = new HashSet<>() ;
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

        HashSet<PrecedenceConstraint> contraints = new HashSet<>() ;
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
        
       ArrayList<Activity> ordonnancement = topologie.bruteForceSort(activites, contraints);
       System.out.print("\n\n |        Activite            |  Duree|  heure  |\n");
        System.out.print(" |----------------------------------------------|\n");
        if(ordonnancement==null){System.out.println("impossible d'ordonnencement");}
        else{
         HashMap<Activity ,Integer> emploi = topologie.schedule(activites, contraints, 500) ;
        for (Activity a : ordonnancement) {
            
           // String depart = String.valueOf(emploi.get(a)) ;
            System.out.print(" | "+a.getDescription()+"  |   "+a.getDuration()+"  |     "+emploi.get(a));
            System.out.print("\n |----------------------------------------------|");
            System.out.println();
     }
     System.out.println("\n\n");
    
    }





     //---------------------------partie du test-------------------------------------------------------------

        TopologicalSorterTests tester = new TopologicalSorterTests();
        boolean ok = true;
        ok = ok && tester.testBruteForceSort();
        ok = ok && tester.testSchedule();
        System.out.println(ok ? "All tests passed" : "At least one test failed");




    }
}
