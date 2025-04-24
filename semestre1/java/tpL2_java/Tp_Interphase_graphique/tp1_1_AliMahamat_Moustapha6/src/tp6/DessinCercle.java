package tp6 ;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
/**
 * DessinCercle
 */
public class DessinCercle extends JComponent{
    public DessinCercle(){
        this.paint(getGraphics());
    }
    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
        g.setColor(Color.red);
        g.fillOval(40, 40, 150, 150);
    }
    
}