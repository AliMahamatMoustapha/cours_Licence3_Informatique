import java.util.ArrayList;
public class MyArrayList<E> extends ArrayList<E>{
    public MyArrayList(){
        super();
    }
    @Override
    public  java.util.Iterator<E> iterator() {
        return new MyArrayListIterator<E> (ArrayList<E> l);

      }
}
