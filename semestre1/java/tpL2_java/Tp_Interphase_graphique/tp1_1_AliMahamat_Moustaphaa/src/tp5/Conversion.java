/**
 * Conversion
 */
package tp5 ;
public class Conversion {
protected double euro;
protected double dolar;
protected double nbreConverir;
public Conversion (double nbrConvertir){
    this.nbreConverir = nbrConvertir ;
    this.euro = 1.07;
    this.dolar = 0.49;
}
public double getEuro(){
    return this.nbreConverir*this.euro;
}
public double getDollar(){
    return this.nbreConverir*this.dolar;
}
    
}