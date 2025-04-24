
public interface OperationBancaire {
    void setCompteBancaire(CompteBancaire cb);
    Date getDate();
    void appliquer();
    void desappliquer() ;
    
}