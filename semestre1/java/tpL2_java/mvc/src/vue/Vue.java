package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import controler.Control;
import model.*;
import model.Model.Couleur;

public class Vue extends JFrame implements IEcouteur{
    private JButton next ; 
    private Model model;
    private Cercle cercle,cercle2,cercle3 ;
    public Vue() {
        this.model = new Model();
        this.model.ajouterEcouteur(this);
    }
    public void init(){
        this.setSize(250,400);
        //this.setLayout(null);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,40,10));
        cercle = new Cercle(Color.red) ;
        cercle2 = new Cercle();
        cercle3 = new Cercle();
        next = new JButton("Next");
        next.setPreferredSize(new Dimension(90,40));
        next.addActionListener(new Control(model));
        this.getContentPane().add(cercle) ;
        this.getContentPane().add(cercle2) ;
        this.getContentPane().add(cercle3) ;
        this.getContentPane().add(next) ;
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

    }
@Override
    public void miseAjours(Object source) {
        Couleur c = ((Model) source ).getCurrentColor() ;
        switch (c) {
            case rouge:
                cercle.setColor(Color.RED);
                cercle2.setColor(Color.black);
                cercle3.setColor(Color.black); 
                break;
            case vert:
                cercle.setColor(Color.black);
                cercle2.setColor(Color.black); 
                cercle3.setColor(Color.blue);   
                break;
            case orange:
                // cercle.setColor(Color.black);
                cercle2.setColor(Color.orange);
                // cercle3.setColor(Color.black);
                break;
            default:
                break;
        }
        this.repaint();
        this.revalidate();

    }
}
