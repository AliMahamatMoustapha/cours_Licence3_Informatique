/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demotestsunitaires;

/**
 *
 * @author 21914839
 */
public class Point {
    private double x,y;
    private Mathematiques mathematiques;  

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point(int x, int y) {
        this.x = x<0 ? 0 : x;
        this.y = y<0 ? 0 : y;
    }
public Mathematiques getMathematiques() {
        return new DefaultMathematiques() ;
    }
    @Override
    public String toString() {
        return "("+ x +","+y+')';
    }
    
}
