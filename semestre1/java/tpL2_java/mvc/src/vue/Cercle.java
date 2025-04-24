package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Cercle extends JPanel  {
    private Color color ; 
   
    public Cercle(Color color){    
        this.color = color ;    
        setPreferredSize(new Dimension(90,90));
    }
    public Cercle(){    
        this(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g){
        g.setColor(color);
        g.fillOval(0,0,80,80) ;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
