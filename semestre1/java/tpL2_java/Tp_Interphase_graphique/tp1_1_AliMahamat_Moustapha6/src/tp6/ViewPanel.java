package tp6 ;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
public class ViewPanel extends JPanel implements EcouteurModele{
    Tricolor feu;
    
    public ViewPanel(Tricolor t){
        this.feu = t ;
        this.feu.ajoutEcouteur(this);
    }
    
    public void modeleMisAJour(Object source) {
        System.out.println(this.feu);
       this.repaint();
    }


protected void paintComponent(Graphics g){
    g.setColor(Color.red);
    g.fillOval(40,40,150,150);
}




}
