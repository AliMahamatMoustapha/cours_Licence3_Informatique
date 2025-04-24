/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapterdemo.model;

import java.util.Random;
import util.observer.AbstractListenableModel;

/**
 *
 * @author mathet
 */
public class Personne extends AbstractListenableModel {

    private String nom;
    private String prenom;
    private int anneeNaissance;

    private final static String[] RANDOM_LAST_NAME={"SMITH","DUPONT","COVILLI","BARRE"};
    private final static String[] RANDOM_FIRST_NAME={"John","Suzanne","Philippe","Anne","Robert"};
    
    public Personne(String nom, String prenom, int anneeNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.anneeNaissance = anneeNaissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
        fireChange();

    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
        fireChange();
    }

    public int getAnneeNaissance() {
        return anneeNaissance;
    }

    public void setAnneeNaissance(int anneeNaissance) {
        this.anneeNaissance = anneeNaissance;
        fireChange();
    }

    public static Personne createRandomPersonne()
    {
        Random r=new Random();
        return new Personne(
                RANDOM_LAST_NAME[r.nextInt(RANDOM_LAST_NAME.length)],
                RANDOM_FIRST_NAME[r.nextInt(RANDOM_FIRST_NAME.length)],
                new Integer(1970+r.nextInt(40))
        );
    }
    public String toString(){
        return "name : "+nom+" prenom : "+prenom+" DateN : "+anneeNaissance ;
    }
}
