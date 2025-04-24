package tp1;
class MainPoint{
    public static void main(String[] args){
        Point point1=new Point(5,2);
        Point point2=new Point(2,2);
        Point point3=new Point(5,2);
        System.out.println("nombre d'intance ="+Point.nInstances);
        point1.translation(1,1);
        Point center = new Point(1,1) ;
        //point2.homotetie(center,3.0 );
        System.out.println("la translation d'un point situé au (5,2) est :"+point1);
        System.out.println("hometetie ="+point2);
        Cercle cercle=new Cercle(point2,4.0);
        cercle.hometetie(center,3.0);
        System.out.println(cercle);

    }
}
