package tp2 ; 
public class Maison extends Batiment {
    protected boolean pisine;
    protected int NbrePieces ;
    public Maison (String NomProprietaire ,String adress ,double surface ,int NbrePieces,boolean pisine){
        super(NomProprietaire,adress,surface);
        this.NbrePieces=NbrePieces ;
        this.pisine = pisine ;
    }
    public boolean getPisine(){
        return this.pisine ;
    }
    public int getnbrepiece(){
        return this.NbrePieces ;
    }
    public void setPisine(boolean pisine){
        this.pisine = pisine ;
    }
    public double impot(){
        if(pisine==false){
            return this.NbrePieces*surface*50 ;
        }
        return this.NbrePieces*this.surface*50+40 ;
    }
}