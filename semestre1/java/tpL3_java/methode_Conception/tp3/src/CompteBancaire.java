
public class CompteBancaire {
    private String id  ;
    private Banque banque  ;
    private double solde  ;
    public CompteBancaire(String id){
        this.id = id ;
        solde = 0 ;
    }
    public void operation(OperationBancaire operation){
        banque.operations.add(operation) ;
    }
}
