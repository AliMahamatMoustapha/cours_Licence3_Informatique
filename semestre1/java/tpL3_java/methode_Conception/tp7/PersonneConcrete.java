/**
 * PersonneConcrete
 */
public class PersonneConcrete implements Personne{
    private String nom ;
    private int age ;
    
    public PersonneConcrete(String nom,int age){
        this.nom = nom ;
        this.age = age ;
    }
    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public int getAnneeNaissance() {
       return age ;
    }

    
}