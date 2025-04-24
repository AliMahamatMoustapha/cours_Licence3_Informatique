package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

public class Control implements ActionListener {
    private Model model ;
    
    public Control(Model modele){
        this.model = modele ;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        model.suivant();
    }
    
}
