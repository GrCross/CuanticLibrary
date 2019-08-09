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
        System.out.println(complexSum.toString());
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
        System.out.println(complexSum.toString());
        assertTrue(realP*realS-imagiP*imagiS == complexSum.getRealP());
        assertTrue(realP*imagiS+imagiP*realS == complexSum.getImagiP());
    }
}
