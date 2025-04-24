package schedules.solvers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import schedules.activities.Activity;
import schedules.constraints.Constraint;
import schedules.constraints.MaxSpanConstraint;
import schedules.constraints.MeetConstraint;
import schedules.constraints.PrecedenceConstraint;
import schedulestests.solvers.RandomSchedulerTests;
class DemonstationAlgo {

    public static void main(String[] args) {
    // Demonstration de projet
    AfficheEmploi a = new AfficheEmploi() ;

    Activity activite1= new Activity("se lever                 ", 1) ;
    Activity activite2= new Activity("aller au travail         ", 15) ;
    Activity activite3= new Activity("prendre une douche       " ,10) ;
    Activity activite4= new Activity("se brosser les dent      " ,3) ;
    Activity activite5= new Activity("s’habiller               " ,2) ;
    Activity activite6= new Activity("prendre un petit déjeuner" ,15) ;

    Set<Activity> activites = new HashSet<>() ;
    activites.add(activite1) ;
    activites.add(activite2) ;
    activites.add(activite3) ;
    activites.add(activite4) ;
    activites.add(activite5) ;
    activites.add(activite6) ;
    
    //instantiation de different contraints
    Constraint contraint1= new PrecedenceConstraint(activite1, activite6) ;
    Constraint contraint2= new PrecedenceConstraint(activite1, activite5) ;
    Constraint contraint3= new PrecedenceConstraint(activite6, activite4) ;
    Constraint contraint4= new PrecedenceConstraint(activite3, activite5) ;
    Constraint contraint5= new PrecedenceConstraint(activite4, activite2) ;
    Constraint contraint6= new PrecedenceConstraint(activite5, activite2) ;
    Constraint contraint7= new PrecedenceConstraint(activite1, activite3) ;
    Constraint contraint8= new PrecedenceConstraint(activite6, activite2) ;
    //Definition d'un ensemble de contraints 
    Set<Constraint> contraints = new HashSet<>() ;
    contraints.add(contraint1) ;
    contraints.add(contraint2) ;
    contraints.add(contraint3) ;
    contraints.add(contraint4) ;
    contraints.add(contraint5) ;
    contraints.add(contraint6) ;
    contraints.add(contraint7) ;
    contraints.add(contraint8) ;

    //
    PrecedenceConstraint contraint9= new PrecedenceConstraint(activite1, activite6) ;
    PrecedenceConstraint contraint10= new PrecedenceConstraint(activite1, activite5) ;
    PrecedenceConstraint contraint11= new PrecedenceConstraint(activite6, activite4) ;
    PrecedenceConstraint contraint12= new PrecedenceConstraint(activite3, activite5) ;
    PrecedenceConstraint contraint13= new PrecedenceConstraint(activite4, activite2) ;
    PrecedenceConstraint contraint14= new PrecedenceConstraint(activite5, activite2) ;
    PrecedenceConstraint contraint15= new PrecedenceConstraint(activite1, activite3) ;
    PrecedenceConstraint contraint16= new PrecedenceConstraint(activite6, activite2) ;
    TopologicalSorter topologie = new TopologicalSorter() ;
    Set<PrecedenceConstraint> pcontraints = new HashSet<>() ;
    pcontraints.add(contraint9) ;
    pcontraints.add(contraint10) ;
    pcontraints.add(contraint11) ;
    pcontraints.add(contraint12) ;
    pcontraints.add(contraint13) ;
    pcontraints.add(contraint14) ;
    pcontraints.add(contraint15) ;
    pcontraints.add(contraint16) ;
    List<Activity> ordonnancement = topologie.bruteForceSort(activites, pcontraints);
    //instantiation d'un Emploi dessordonné
    Map<Activity ,Integer> emploi1 = topologie.schedule(activites, pcontraints, 500) ;
    a.afficheMoiEmploi(emploi1, "EMPLOI DESSORDONNÉ AVEC DATE DEBUT "+topologie.getDateDepart());

    //Ordonner l'emploi creer precedement (emploi1)
       System.out.println("\n          EMPLOI ORDONNÉ AVEC DATE DE DEBUT "+topologie.getDateDepart());
       System.out.print("\n\n |        Activite            |  Duree|  heure  |\n");
        System.out.print(" |----------------------------------------------|\n");
        if(ordonnancement==null){System.out.println("impossible d'ordonnencement");}
        else{
           Map<Activity ,Integer> emploi = topologie.schedule(activites, pcontraints, 500) ;
        for (Activity b : ordonnancement) {  
           // String depart = String.valueOf(emploi.get(a)) ;
            System.out.print(" | "+b.getDescription()+"  |   "+b.getDuration()+"  |     "+emploi.get(b));
            System.out.print("\n |----------------------------------------------|");
            System.out.println();
     }
     System.out.println("\n\n");
    
    }

    
    //creer un emploi aleatoire entre date minimum et maximum
    Random random = new Random() ;
    RandomScheduler alea = new RandomScheduler(random) ;
    Map<Activity , Integer> emploiGenerer = alea.generateOneSchedule(activites, 200, 500);
    Map<Activity,Integer> emploiSatisfaisant = alea.generateSchedule(activites , contraints,200,500,3) ;
    // affichage de l'mploi generer aleatoirement 
        a.afficheMoiEmploi(emploiGenerer,"EMPLOI GENERER AVEC DATE DEBUT ALEA");
   
    // affichage de l'emploi satisfaisant parmis n emploi generer 
        a.afficheMoiEmploi(emploiSatisfaisant,"L'EMPLOI SATIFAISANT PARMIS LE "+alea.getNombreEmploi()+" GENERER ALEATOIRE");
    
    //Testons ou verifions si un empoi satisfait un ensemble de contraints 

        Set<Constraint> constraintsQuelconque = new HashSet<>();
        // Contrainte : activit1 doit se terminer avant qu’activite6 ne commence
        constraintsQuelconque.add(new PrecedenceConstraint(activite1, activite6));
        // Contrainte : activity4 doit commencer exactement quand activity3 se termine
        constraintsQuelconque.add(new MeetConstraint(activite3, activite4));
        // Contrainte : activity1, activity2 et activity3 doivent toutes
        // prendre place en au plus 90 minutes
        MaxSpanConstraint spanConstraint = new MaxSpanConstraint(activites, 90);
        constraintsQuelconque.add(spanConstraint);
        Verifier verifier = new Verifier(constraintsQuelconque);
        //Map<Activity, Integer> schedule =topologie.schedule(activites, pcontraints, 500) ;
        System.out.println("\nL’emploi du temps satisfaisant generer parmi le "+alea.getNombreEmploi()+" satisfait-il toutes les contraintes suivantes ?\n ");
        for (Constraint c : constraintsQuelconque) {
            System.out.println("-"+c.toString());
        }
        Set<Constraint> unsatisfied = verifier.unsatisfied(emploiSatisfaisant);
        if(unsatisfied.isEmpty()) {
        System.out.println("\nOui,L'emploi generer parmis "+alea.getNombreEmploi()+" satisfait toutes les contraintes \n");
        } 
        else {
        System.out.println("\nNon, L'emploi generer parmis le "+ alea.getNombreEmploi()+" ne satisfait pas toutes les contraintes :\n");
        }
        Set<Constraint> constraintsQuelconque1 = new HashSet<>();
        constraintsQuelconque1.add(new PrecedenceConstraint(activite1, activite6));
     
            // partie de tests
        boolean ok = true;
        RandomSchedulerTests randomSchedulerTester = new RandomSchedulerTests(random);
        ok = ok && randomSchedulerTester.testGenerateSchedule();
        System.out.println(ok ? "All tests passed" : "At least one test failed");
        
    }
}