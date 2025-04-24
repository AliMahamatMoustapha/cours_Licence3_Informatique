import java.util.Iterator;
public class AfficheurIterator {
    public static void afficheElements(Iterator<?> iterateur){
        while (iterateur.hasNext())
        System.out.println(iterateur.next()); 
    }

}