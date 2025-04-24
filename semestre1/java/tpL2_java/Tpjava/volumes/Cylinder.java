class Cylinder {
  protected double radius;
  protected double height ;
  public Cylinder(double radius ,double height){
    this.radius = radius;
    this.height = height;
  }
  public double basisSurface(){
    return 2*Math.PI*this.radius**2;
  }
  public double volume(){
    return this.basisSurface()*this.height/2;
  }
}
