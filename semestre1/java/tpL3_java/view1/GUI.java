package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.algorithmesTris.AbstractTris;
import model.observer.IEcouteurModele;
/**
 * L'interface graphique de l'application
 */
public class GUI extends JFrame implements IEcouteurModele{
    protected PanelBars pb ;
    protected AbstractTris model ;
    public GUI(AbstractTris m){
        this.setTitle("Algorithme de tris");
        this.setSize(1600,650);
        setResizable(false);
        model = m ;
        model.ajoutEcouteur(this);
        PanelBars pb = new PanelBars(model.getListe());

        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        JButton demarer = new JButton("Lancer le tris");
        JButton reini = new JButton("reigenerer liste");

        String[] initialOptions = {"Tri par fusion", "Tri par insertion", "Tri Bulles","Tri selection"};
        JComboBox<String> comboBox = new JComboBox<>(initialOptions);
        menu.add(comboBox);
        // menu.add(comboBox);
        menu.add(demarer);
        menu.add(reini);
        
        this.add(menu,BorderLayout.EAST);
        this.add(pb,BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setVisible(true);
    }
    /**
     * Affiche la fenêtre
     */
    public void affichage(){
        this.setVisible(true);
    }
    @Override
    public void modeleMiseAjour(Object o) {
       AbstractTris mode = (AbstractTris) o ;
       this.model = mode;
       this.repaint();
       this.revalidate();
       System.out.println(mode.getListe());
    }
}
