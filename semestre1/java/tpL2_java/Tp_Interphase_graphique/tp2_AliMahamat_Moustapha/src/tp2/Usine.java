package tp2 ;
public class Usine extends Batiment{
protected int nobreEmployes;
public Usine (String nomProprietaire ,String adress , double surface ,int nobreEmployes){
    super(nomProprietaire ,adress,surface);
    this.nobreEmployes = nobreEmployes ;
}
public double impot(){
    return this.nobreEmployes*5; 
}
public String toString(){
    return"gffgf";
}
}