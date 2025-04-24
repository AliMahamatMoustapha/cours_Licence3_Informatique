package view;

import java.util.List;
import java.util.Scanner;

import model.generateur.Desordre;
import model.generateur.Generateur;

public class ConsoleMain {
    public static void main(String[] args) {

/*      Scanner sc = new Scanner(System.in);
        System.out.println("entrer la quantité de données");
        int quantite = sc.nextInt();
        System.out.println("entrer le degrés de repartition");
        float repartition = sc.nextFloat();
        // generer la liste en fonction de quantité et la repartition entrer par l'utilisateur
        Desordre desordre = new Desordre(quantite, repartition);
        Context ctx = new Context();
        System.out.println("choisissez un algo de tris 1 pour triFusion 2 pour TriInserton 3 pour TrisRapide");
        ctx.appliquerAlgo(); */
        
        Desordre d = new Desordre (1,0);
        Generateur g = new Generateur(d) ;
        List<Integer> liste = g.genererList(15);
        System.out.println("-----------------------------------");
        System.out.println(liste);
        System.out.println("-----------------------------------");

    }
}
