package tp5 ;
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
public class InterfaceConversion extends JFrame {
    public InterfaceConversion(){
        super("Convertiseur Dollar <--> Euro");
        setSize(600,200);
        setResizable(false);
        JPanel  fenetrePanel =(JPanel) this.getContentPane(); /*conversion de jfram en Jpanel */
        //fenetrePanel.setLayout(new BorderLayout(10,10));
        JPanel panelButton = new JPanel(new GridLayout(1,3,10,10));
        JPanel panelText = new JPanel(new GridLayout(2,1,10,10));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);/*pour fermer la fenetre lors de la clic sur le croix de la fenetre */
        JButton dolarEuro = new JButton("Dollar vers Euros");
        dolarEuro.setSize(80,10);
        JButton EuroDolar = new JButton("Euros vers Euros");
        EuroDolar.setSize(80,10);
        JButton c = new JButton("C");
        c.setSize(80,10);
        panelButton.add(dolarEuro);
        panelButton.add(EuroDolar);
        panelButton.add(c);
        JTextField userInput = new JTextField();
        JTextField afficheInput = new JTextField(); 
        //afficheInput.setEnabled(false);
        panelText.add(userInput);
        panelText.add(afficheInput);
        panelButton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));/*ajout bordur vide de 10 sur tout les cotes */
        panelText.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        fenetrePanel.add(panelText,BorderLayout.CENTER);
        fenetrePanel.add(panelButton,BorderLayout.SOUTH);
        //controle button
        c.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
               userInput.setText(""); 
               afficheInput.setText(""); 
            }
        });
     dolarEuro.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
        double valueInput =Double.parseDouble(userInput.getText()) ; 
        Conversion conver = new Conversion(valueInput);
        afficheInput.setText(String.valueOf(conver.getEuro()));
            
        }

     });
        
    }
    /*public JButton createButton(String nomButton){
        return new JButton(nomButton); 
    }*/
}
