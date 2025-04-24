/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.demotestsunitaires;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 21914839
 */
public class PointTest {
    
    public PointTest() {
        Point p1 = new Point(-1,2) ;
        assertTrue(p1.getX()==0 && p1.getY()==2) ;
        Point p2 = new Point(1,-2) ;
        assertTrue(p1.getX()==1 && p1.getY()==0) ;
    }

    /**
     * Test of getX method, of class Point.
     */
    @Test
    public void testGetX() {
    }

    /**
     * Test of setX method, of class Point.
     */
    @Test
    public void testSetX() {
    }

    /**
     * Test of getY method, of class Point.
     */
    @Test
    public void testGetY() {
    }

    /**
     * Test of setY method, of class Point.
     */
    @Test
    public void testSetY() {
    }

    /**
     * Test of getMathematiques method, of class Point.
     */
    @Test
    public void testGetMathematiques() {
    }

    /**
     * Test of toString method, of class Point.
     */
    @Test
    public void testToString() {
        Point p = new Point(1,2) ;
        assertEquals(p.toString(),"(1,2)") ;
    }
    
}
