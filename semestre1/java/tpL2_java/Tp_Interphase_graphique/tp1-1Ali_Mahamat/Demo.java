import java.util.ArrayList;
public class Demo{
  public static void main(String[] args) {
    ArrayList<String> al=new ArrayList<>();
    al.add("A");
    al.add("B");
    al.add("C");
    AfficheurIterator.afficheElements(al.iterator());
    }
        
}