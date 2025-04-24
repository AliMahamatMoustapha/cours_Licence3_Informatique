package tp2 ;
public class Batiment {
  protected String nomProprietaire;
  protected String adress ;
  protected double surface ;
  public Batiment(String nomProprietaire , String adress , double surface){
    this.nomProprietaire = nomProprietaire ;
    this.adress = adress ;
    this.surface = surface ;
  }  
  public String getProprietaire(){
    return this.nomProprietaire ; 
  }
  public String getAdress(){
    return this.adress ;
  }
  public double getSurface(){
    return this.surface ;
  }
  public void setProprietaire(String NomProprietaire){
     this.nomProprietaire=NomProprietaire ; 
  }touch 
  public void  setAdress(String Adress){
     this.adress=Adress;
  }
  public void setSurface(double Surface){
     this.surface=Surface ;
  }
  public double impot(){
    return this.surface*5;
  }
  public void affichage(){
     System.out.println("l'adress est :"+this.adress+"de surface ="+this.surface+"et de proprietaire :"+this.nomProprietaire );
  }

}
