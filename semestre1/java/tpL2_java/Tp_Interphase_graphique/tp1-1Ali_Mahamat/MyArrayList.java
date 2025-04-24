import java.util.ArrayList;
import java.util.Collection;
public class MyArrayList<E> extends ArrayList<E>{
    private static final int ArrayList = 0;
    private static final int E = 0;
    public MyArrayList(Collection c){
        super(c);
    }
    @Override
    public  java.util.Iterator<E> iterator() {
        return new MyArrayListIterator(ArrayList<E> l);

      }
}
