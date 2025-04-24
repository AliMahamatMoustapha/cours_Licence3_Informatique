/**
 * ProxyPersonneNaissanceSecrete
 */
public class ProxyPersonneNaissanceSecrete implements Personne {
    private PersonneConcrete personneConcrete ;
    public ProxyPersonneNaissanceSecrete(PersonneConcrete p){
        personneConcrete = p ;
    }
    @Override
    public String getNom() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNom'");
    }

    @Override
    public int getAnneeNaissance() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAnneeNaissance'");
    }

    
}