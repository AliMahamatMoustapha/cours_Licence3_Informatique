public class Printer<E> {
    protected E objet;
    public Printer(E objet)
    {
        this.objet = objet;
    }
    public void printer()
    {
        System.out.println("Notre object : " + this.objet);
    }
    public static void main(String[] args) {
        Printer<Integer> a = new Printer<>(23);
        System.out.println("+++++++++++++++++++++");
        a.printer();
        Printer<Boolean> b = new Printer<>(true);
        System.out.println("+++++++++++++++++++++");
        b.printer();
        System.out.println("+++++++++++++++++++++");
        Printer<String> c = new Printer<>("Masta");
        c.printer();
    }
}
