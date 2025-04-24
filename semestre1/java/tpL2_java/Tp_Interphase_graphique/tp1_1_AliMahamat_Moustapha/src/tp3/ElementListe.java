package tp3 ;
public class ElementListe{
    protected int val ;
    protected ElementListe suivant ;
    public ElementListe (int val , ElementListe suivant){
        this.val = val ;
        this.suivant = suivant ;
    }

    public ElementListe(int val){
        this(val, null);
        //this.val = val ;
        //this.suivant = null ;
    }

    public int getval(){
        return this.val ;
    }
    public ElementListe getsuivant(){
        return this.suivant ;
    }
    public void setval(int val){
        this.val = val ;
    }
    public void setsuivant(ElementListe suivant){
        this.suivant = suivant ;
    }
    public String toString(){
        String res = "";
        res+=val+" ";
        if(this.suivant == null){
            res+="-> x";
        
        }
        else {res+="->"+this.suivant.toString();}


        return res;
    }
}