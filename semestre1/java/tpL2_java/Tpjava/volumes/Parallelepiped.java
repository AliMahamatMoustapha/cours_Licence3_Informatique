class Parallelepiped {
	protected double largeur;
	protected double longueur ;
	protected double hauteur;
	public Parallelepiped(double largeur,double longueur ,double hauteur){
	this.largeur = largeur;
	this.longueur = longueur ;
	this.hauteur = hauteur ;
}
	public double getWidth(){
		return this.largeur;
	}
	public double getHeight(){
		return this.largeur;
	}
	public double basisSurface(){
		return this.largeur*this.longueur;
	}
	public double volume(){
		return this.basisSurface()*this.hauteur;
	}
	public String toString(){
		return "la surface de la base est "+this.basisSurface()+"et le volume est de "+this.volume();
	}
}
