package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class View extends JFrame{
    private JButton addB,edit;
    public View(){
        super("GIU DEMO ADAPTER");
        this.setSize(700,500);
        JPanel  fenetrePanel =(JPanel) this.getContentPane();
        JButton addB= new JButton("Ajouter une personne");
        JButton edit= new JButton("modifier une personne");
        fenetrePanel.add(addB,BorderLayout.NORTH); 
        fenetrePanel.add(edit,BorderLayout.SOUTH); 

        //this.setLayout(null);
        // this.setLayout(new FlowLayout(FlowLayout.CENTER,40,10));
       
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
   
    public static void main(String[] args) {
        new View();
    }
}
