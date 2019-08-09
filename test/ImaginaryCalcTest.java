/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.*;

import cuanticlibrary.entities.Calc;
import cuanticlibrary.entities.Complex;

import static org.junit.Assert.*;

/**
 *
 * @author daniel
 */
public class ImaginaryCalcTest {
    
    public ImaginaryCalcTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void sumTest(){
        Calc calc = new Calc();
        double realP = 5;
        double imagiP = -10;
        Complex fComplex = new Complex(realP, imagiP);
        double realS = 50;
        double imagiS = 320;
        Complex sComplex = new Complex(realS, imagiS);
        Complex complexSum = calc.sum(fComplex, sComplex);
        
        assertTrue(realP+realS == complexSum.getRealP() && imagiP+imagiS == complexSum.getImagiP());
    }
    
    @Test
    public void multTest(){
        Calc calc = new Calc();
        double realP = 5;
        double imagiP = -10;
        Complex fComplex = new Complex(realP, imagiP);
        double realS = 50;
        double imagiS = 320;
        Complex sComplex = new Complex(realS, imagiS);
        Complex complexSum = calc.mult(fComplex, sComplex);
        
        assertTrue(realP*realS-imagiP*imagiS == complexSum.getRealP());
        assertTrue(realP*imagiS+imagiP*realS == complexSum.getImagiP());
    }
    
    @Test
    public void substractTest(){
        Calc calc = new Calc();
        double realP = 5;
        double imagiP = -10;
        Complex fComplex = new Complex(realP, imagiP);
        double realS = 50;
        double imagiS = 320;
        Complex sComplex = new Complex(realS, imagiS);
        Complex complexSum = calc.substract(fComplex, sComplex);
        
        assertTrue(realP-realS == complexSum.getRealP() && imagiP-imagiS == complexSum.getImagiP());
    }
    
     @Test
    public void divisionTest(){
        Calc calc = new Calc();
        double realP = 3;
        double imagiP = 2;
        Complex fComplex = new Complex(realP, imagiP);
        double realS = 1;
        double imagiS = -2;
        Complex sComplex = new Complex(realS, imagiS);
        Complex divisionComplex = calc.division(fComplex, sComplex);
        double realPart = (realP*realS+imagiP*imagiS)/(Math.pow(realS, 2)+Math.pow(imagiS, 2));
        System.out.println(realPart);
        double imagiPart = (imagiP*realS-imagiP*realS)/((Math.pow(realS, 2)+Math.pow(imagiS, 2))); 
        System.out.println(imagiPart);
        assertTrue(realPart == divisionComplex.getRealP() && imagiPart == divisionComplex.getImagiP());
    }
}
