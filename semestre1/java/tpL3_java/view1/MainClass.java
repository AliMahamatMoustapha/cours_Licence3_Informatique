package view;

import model.algorithmesTris.AbstractTris;
import model.algorithmesTris.TriBulles;
import model.generateur.Desordre;
import model.generateur.Generateur;

public class MainClass {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // System.out.println("Test de build");
        Desordre d = new Desordre(1, 0);
        Generateur g  = new Generateur(d);
        AbstractTris m = new TriBulles(g.genererList(500));
        GUI screen = new GUI(m);
        screen.affichage();
        // ConsoleMain.main(args);
        

        // TriBulles triBulles = new TriBulles(new ArrayList<>(Arrays.asList(10,2,5,3,4,9,7,8,6)));
        // System.out.println("debut : " + triBulles.getListe());
        // PanelBars p = new PanelBars(triBulles);
        m.trier();
        // System.out.println("fin : " + triBulles.getListe());
    }
}