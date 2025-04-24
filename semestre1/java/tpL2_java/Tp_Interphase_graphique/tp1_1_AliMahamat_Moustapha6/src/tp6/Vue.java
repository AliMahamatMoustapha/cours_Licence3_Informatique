package tp6 ;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import tp6.Tricolor;
import tp6.ViewPanel;

/**
 * Vue
 */
public class Vue extends JFrame{
    public Vue(){
        super("tricolor");
        Tricolor feu = new Tricolor() ;
        setSize(400,800);
        JPanel viewPanel = new ViewPanel(feu);
        this.getContentPane().add(viewPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        
        setVisible(true);
    }


    
}