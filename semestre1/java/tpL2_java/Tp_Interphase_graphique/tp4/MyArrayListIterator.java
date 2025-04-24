import java.util.ArrayList;
import java.util.Iterator;
public class MyArrayListIterator<E> implements Iterator<E> {
    protected ArrayList<E> liste ;
    public MyArrayListIterator(ArrayList<E> l){
        this.liste = l ;
    }

    @Override
    public boolean hasNext(){
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E next() {
        // TODO Auto-generated method stub
        return null;
    }
}
