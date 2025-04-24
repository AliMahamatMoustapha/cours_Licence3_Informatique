/**
 * Date
 */
public class Date implements Comparable {

    private int annee , mois,jour_mois ;

    public Date(int annee, int mois, int jour_mois) {
        this.annee = annee;
        this.mois = mois;
        this.jour_mois = jour_mois;
      
    }

    public int getAnnee() {
        return annee;
    }

    public int getMois() {
        return mois;
    }

    public int getJour_mois() {
        return jour_mois;
    }

    @Override
    public int compareTo(Object t) {
        Date date = (Date)t ;
        int annee_t = date.getAnnee() ;
        int mois_t = date.getMois() ;
        int jour_t = date.getJour_mois() ;
        if(annee_t != this.annee)
            return (annee_t>this.annee)? -1 : 1 ;
        if(mois_t != this.mois)
            return (mois_t>this.mois)? -1 : 1 ;
        if(jour_t != this.mois)
            return (jour_t>this.jour_mois)? -1 : 1 ;
        return 0 ;
    }
    public boolean isDateValide(int mois ,int jour){
        return (mois>0 && mois<=12) && (jour>0 && jour<=31) ;
    }
}