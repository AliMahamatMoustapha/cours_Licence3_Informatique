package tp1;
public class Cercle{
    protected Point center ;
    protected Double rayon ;
    public Cercle(Point center ,Double rayon){
        this.center = center;
        this.rayon = rayon ; 
    }
    public Point getcenter(){
        return this.center ;
    }
    public Double getrayon(){
        return this.rayon;
    }
    public void setcenter(Point c){
        this.center=c;
    }
    public void setrayon(Double r){
        this.rayon=r;
    }
    public void translation(Double dx ,Double dy ){
        center.translation(dx,dy);
    }
    public void hometetie(Point center ,Double k){
        this.center.homotetie(center,k);
        rayon=k*rayon;
    }
    public String toString(){
        return "center="+"("+this.center.getAbcisse()+","+this.center.getOrdonne()+")"+","+"rayon="+this.rayon ;
    }
}
