package tp3 ;
import java.util.LinkedList;
public class Demo{
    public static void main (String[] args){
        
         ElementListe e1 = new ElementListe(24);
         ElementListe e2 = new ElementListe(45, e1);
         ElementListe e3 = new ElementListe(12,e2);

        System.out.println(e3.toString());

    }
}