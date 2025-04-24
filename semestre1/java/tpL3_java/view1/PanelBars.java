package view;

import java.awt.Graphics;
import java.util.List;
import java.util.Collections;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
import javax.swing.JPanel;

public class PanelBars extends JPanel {
    protected List<Integer> liste;
    protected double width, height;

    public PanelBars(List<Integer> liste) {
        this.liste = liste;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int taille = liste.size();
        int gap = 2;
        int largeurBar = 20;
        double largeur = (gap + largeurBar) * taille + 50;
        double hauteurTotal = 590;
        this.setPreferredSize(new Dimension((int) largeur, (int) hauteurTotal));
        int valMax = Collections.max(liste);

        for (int i = 0; i < taille; i++) {
            int hauteurBar = (int) ((liste.get(i) * (hauteurTotal-10)) / valMax);
            double x = i * (largeurBar + gap) + 5;
            Random r = new Random();
            g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
            g.fillRect((int) x, (int) (hauteurTotal - hauteurBar), largeurBar, hauteurBar);
            g.drawString(String.valueOf(liste.get(i)), (int) x + largeurBar / 4, (int) (hauteurTotal - hauteurBar - 5));
        }
    }
}
