class Prism{
  protected double basislength;//base du triangle
  protected double basisHeight;//hauteur du triangle
  protected double height;//hauteur du Prism
  //base prisme = base*hauteur*hauteurprism
  public double basisSurface(){
    return this.basisHeight*this.basislength;
  }
  public double volume(){
    return this.basisHeight*this.basislength*this.height/2;
  }
}
