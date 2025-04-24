/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
import java.io.*;
import java.util.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.util.ArrayList;
/**
 *
 * @author 21914839
 */
public class SaxEcho extends DefaultHandler {
    protected boolean isName = false ;
    protected boolean isUsd = false ;
    protected String chemin = "" ;
    protected double total_couts = 0 ;
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance() ;
        
        try{
            SAXParser saxParser = factory.newSAXParser() ;
            SaxEcho handler = new SaxEcho() ;
            saxParser.parse("./src/juicers.xml",handler ) ;
        System.out.println("Hello World!");
        }catch(Exception e){System.out.println("erreur : "+e.getMessage()) ;}
    }
    //Cette fonction se declanche une fois que le parseur commence à parsser le document 
    @Override
    public void startDocument() throws SAXException {
         System.out.println("debDoc");
    }
    //cette fonction se declanche à chaque fois que le parsseur rencontre une balise ouvrante
    @Override
    public void startElement(String string, String string1, String string2, Attributes atrbts) throws SAXException {
       /* chemin+="/"+string2 ;
        System.out.println(chemin) ; */
        if(string2.equalsIgnoreCase("cost")) {
            for (int i=0;i<atrbts.getLength();i++){
                if(atrbts.getValue(i).equalsIgnoreCase("usd")){
                    isUsd = true ;
                }
            }
        }
    }
    // cette fonction se declanche à chaque fois que le parsseur rencontre une balise fermente 
    @Override
    public void endElement(String string, String string1, String string2) throws SAXException {
                isUsd = false ;
    }
    //cette methode se declanche quand le parseur rencontre le dernier balise du document 
    @Override
    public void endDocument() throws SAXException {
        System.out.println("total_cout : "+total_couts);
         System.out.println("finDoc");
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
            if(isUsd){
                String valStr = new String(ch,start,length) ;
                total_couts+= Double.parseDouble(valStr) ;
              
            }
    }
   

}
