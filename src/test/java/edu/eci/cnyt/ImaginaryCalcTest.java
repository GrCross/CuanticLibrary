
package edu.eci.cnyt;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.eci.cnyt.entities.Calc;
import edu.eci.cnyt.entities.Complex;
import edu.eci.cnyt.entities.Polar;

/**
 *
 * @author daniel
 */
public class ImaginaryCalcTest {

    Calc calc = new Calc();
    
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

        
        double realP = 5;
        double imagiP = -10;
        Complex fComplex = new Complex(realP, imagiP);

        double realS = 50;
        double imagiS = 320;
        Complex sComplex = new Complex(realS, imagiS);

        Complex complexSum = calc.sum(fComplex, sComplex);
        Complex complexTest = new Complex(realP+realS, imagiP+imagiS);
        
        assertTrue(complexSum.equals(complexTest));
    }
    
    @Test
    public void multTest(){
        
        double realP = 5;
        double imagiP = -10;
        Complex fComplex = new Complex(realP, imagiP);

        double realS = 50;
        double imagiS = 320;
        Complex sComplex = new Complex(realS, imagiS);

        Complex complexMult = calc.mult(fComplex, sComplex);
        
        assertTrue(realP*realS-imagiP*imagiS == complexMult.getRealP());
        assertTrue(realP*imagiS+imagiP*realS == complexMult.getImagiP());

        Complex complexTest = new Complex();
        complexTest.setRealP(realP*realS-imagiP*imagiS);
        complexTest.setImagiP(realP*imagiS+imagiP*realS);
        
        assertTrue(complexMult.equals(complexTest));
    }
    
    @Test
    public void substractTest(){
        
        double realP = 5;
        double imagiP = -10;
        Complex fComplex = new Complex(realP, imagiP);

        double realS = 50;
        double imagiS = 320;
        Complex sComplex = new Complex(realS, imagiS);

        Complex complexSub = calc.substract(fComplex, sComplex);
        Complex complexTest = new Complex(realP-realS, imagiP-imagiS);
        
        assertTrue(complexTest.equals(complexSub));
    }
    
     @Test
    public void divisionTest(){
        
        double realP = 2;
        double imagiP = 3;
        Complex fComplex = new Complex(realP, imagiP);

        double realS = 4;
        double imagiS = -5;
        Complex sComplex = new Complex(realS, imagiS);

        Complex divisionComplex = calc.division(fComplex, sComplex);

        Complex complexTest = new Complex();
        complexTest.setImagiP((imagiP*realS-realP*imagiS)/(Math.pow(realS, 2)+Math.pow(imagiS, 2)));
        complexTest.setRealP((realP*realS+imagiP*imagiS)/(Math.pow(realS, 2)+Math.pow(imagiS, 2)));
        
        assertTrue(complexTest.equals(divisionComplex));
    }

    @Test
    public void moduleTest(){
        
        double realP = 5;
        double imagiP = -10;
        Complex fComplex = new Complex(realP, imagiP); 

        double testModule = fComplex.module();

        double realModule = Math.sqrt(Math.pow(5, 2)+Math.pow(-10, 2));
        assertTrue(testModule == realModule);
    }

    @Test
    public void ConjugateTest(){
        double realP = 23;
        double imagiP = -56;
        Complex fComplex = new Complex(realP, imagiP); 

        Complex testConjugate = fComplex.conjugate();
        Complex complexTest = new Complex(realP, imagiP*-1);

        
        assertTrue(complexTest.equals(testConjugate));
    }

    @Test
    public void PolarTest(){
        
        double realP = 23;
        double imagiP = -56;
        Complex fComplex = new Complex(realP, imagiP);
        Polar polar = fComplex.polar();
        
        assertTrue(polar.getSinPart() == -0.93 && polar.getCosPart() == 0.38);         
    }

    @Test
    public void phaseTest(){
        double realP = 96;
        double imagiP = 54;
        Complex fComplex = new Complex(realP, imagiP);
        assertTrue(fComplex.phase() == 0.51);   
    }

    @Test
    public void transposeTest() throws FileNotFoundException{
        Complex[][] matrix = createMatrix("1");
        Complex[][] transposeMatrix = calc.transpose(matrix);

        //printMatrix(matrix);
        //System.out.println("------------------");
        //printMatrix(transposeMatrix);
        for (int i = 0; i < matrix.length;i++) {
            for (int j = 0; j < matrix[0].length;j++) {
                assertTrue(matrix[i][j].equals(transposeMatrix[j][i]));
                
            }
        }
        
    }


    @Test
    public void determinantTest() throws FileNotFoundException {

        Complex[][] matrix = createMatrix("Binary");
        printMatrix(matrix);
        calc.determinant(matrix);
        
        //System.out.println(determinat.toString());

    }


    private Complex[][] createMatrix(String sample) throws FileNotFoundException {
        File file = new File("src/test/java/edu/eci/cnyt/testFiles/matrixSample"+sample+".in");
        Scanner sc = new Scanner(file);
        
        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());
        Complex[][]matrix = new Complex[rows][cols]; 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String[] temp = sc.nextLine().split(",");
                Complex complex = new Complex(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
                matrix[i][j] = complex;
            }
        }
        return matrix;
    }

    private void printMatrix(Complex[][] matrix){

        for (int i = 0; i < matrix.length;i++) {
            for (int j = 0; j < matrix[0].length;j++) {
                System.out.print(matrix[i][j].toString()+" ");
            }
            System.out.println();
        }
    }
}
