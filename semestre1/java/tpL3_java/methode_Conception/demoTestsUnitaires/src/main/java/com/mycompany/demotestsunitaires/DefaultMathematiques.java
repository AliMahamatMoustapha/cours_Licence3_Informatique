/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demotestsunitaires;

/**
 *
 * @author 21914839
 */
public class DefaultMathematiques implements Mathematiques {

    @Override
    public boolean estPositif(double v) {
        return v>=0;
    }

    @Override
    public double valeurAbsolue(double v) {
        return estPositif(v) ? v : -v ;
    }
    
}
