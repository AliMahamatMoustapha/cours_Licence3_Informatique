import java.util.ArrayList;
import java.util.Map;

public class Banque {
    public static ArrayList<CompteBancaire> comptes ;
    public static Map<CompteBancaire,ArrayList<OperationBancaire>> operations ;

    public Banque(){
        comptes = new ArrayList<>() ;
        operations = new ArrayList<>() ;
    }

    public void creationCompte(String id){
        CompteBancaire compte = new CompteBancaire(id) ;
        comptes.add(compte) ;
    }
    
}
