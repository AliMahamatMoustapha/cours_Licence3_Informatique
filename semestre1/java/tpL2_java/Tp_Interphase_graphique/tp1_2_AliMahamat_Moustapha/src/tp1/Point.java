package tp1;
public class Point {
protected double x ;
protected double y ;
static  int nInstances=0;
public Point (double x , double y){
    this.x=x;
    this.y=y;
    nInstances++;
}
public Point(){
   this(0,0);
}
public double getAbcisse(){
    return this.x;
}
public double getOrdonne(){
    return this.y;
}
public void setAbcisse(double a){
    this.x=a;
}
public void setordonne(double a){
    this.y=a;
}
public String toString(){
    return "("+this.x+","+this.y+")";
}
public static int getInstance(){
    return Point.nInstances;
}
public void setInstance(int i){
    Point.nInstances=i;
}
public void translation(double dx ,double dy){
    x+=dx;
    y+=dy;
}
public void homotetie(Point center ,double k){
   homotetie(center.getAbcisse(),center.getOrdonne(),k);
}
public void homotetie(double centerX,Double centerY,Double k){
 x=k*(x-centerX)+centerX;
 y=k*(y-centerY)+centerY;
}
}
