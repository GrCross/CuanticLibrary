
package edu.eci.cnyt;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

import edu.eci.cnyt.entities.Exceptions.ComplexException;
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
    String defaultPath = "src/test/java/edu/eci/cnyt/testFiles/matrixSample";
    String answerPath = "src/test/java/edu/eci/cnyt/testFiles/answers/matrixSample";
    
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
        
        assertEquals(complexSum,complexTest);
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
        
        assertEquals(complexMult,complexTest);
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
        
        assertEquals(complexTest,complexSub);
    }
    
     @Test
    public void divisionTest() throws ComplexException {
        
        double realP = 2;
        double imagiP = 3;
        Complex fComplex = new Complex(realP, imagiP);

        double realS = 4;
        double imagiS = -5;
        Complex sComplex = new Complex(realS, imagiS);

        Complex divisionComplex = calc.division(fComplex, sComplex);

        Complex complexTest = new Complex();
        Double imagiPans = (imagiP*realS-realP*imagiS)/(Math.pow(realS, 2)+Math.pow(imagiS, 2));
        Double realPans = (realP*realS+imagiP*imagiS)/(Math.pow(realS, 2)+Math.pow(imagiS, 2));
        complexTest.setImagiP(imagiPans);
        complexTest.setRealP(realPans);

        
        assertEquals(complexTest,divisionComplex);
    }

    @Test
    public void moduleTest(){
        
        double realP = 5;
        double imagiP = -10;
        Complex fComplex = new Complex(realP, imagiP); 

        double testModule = fComplex.module();

        double realModule = Math.sqrt(Math.pow(5, 2)+Math.pow(-10, 2));
        assertEquals(testModule,realModule,0.001);
    }

    @Test
    public void ConjugateTest(){
        double realP = 23;
        double imagiP = -56;
        Complex fComplex = new Complex(realP, imagiP); 

        Complex testConjugate = fComplex.conjugate();
        Complex complexTest = new Complex(realP, imagiP*-1);

        
        assertEquals(complexTest,testConjugate);
    }

    @Test
    public void PolarTest(){
        
        double realP = 23;
        double imagiP = -56;
        Complex fComplex = new Complex(realP, imagiP);
        Polar polar = fComplex.polar();
        
        
        
        assertTrue(polar.getSinPart() == -0.9250198183784528 && polar.getCosPart() == 0.3799188539768645);         
    }

    @Test
    public void phaseTest(){
        double realP = 96;
        double imagiP = 54;
        Complex fComplex = new Complex(realP, imagiP);
        assertTrue(fComplex.phase() == Math.atan(imagiP/realP));   
    }

    @Test
    public void matrixSumTest() throws FileNotFoundException, ComplexException {
        Complex[][] matrix1 = createMatrix(defaultPath,"1");
        Complex[][] matrix2 = createMatrix(defaultPath,"2");
        Complex[][] sumMatrix = calc.sum(matrix1,matrix2);
        Complex[][] ansMatrix = createMatrix(answerPath, "Sum");
        assertTrue(compareMatrix(sumMatrix,ansMatrix));
        
    }

    @Test
    public void transposeTest() throws FileNotFoundException{
        Complex[][] matrix = createMatrix(defaultPath,"1");
        Complex[][] transposeMatrix = calc.transpose(matrix);

        for (int i = 0; i < matrix.length;i++) {
            for (int j = 0; j < matrix[0].length;j++) {
                assertTrue(matrix[i][j].equals(transposeMatrix[j][i]));
                
            }
        }
        
    }

    @Test
    public void multMatrixTest() throws FileNotFoundException, ComplexException {
        Complex[][] matrix1 = createMatrix(defaultPath,"1");
        Complex[][] matrix2 = createMatrix(defaultPath,"2");
        Complex[][] multMatrix = calc.mult(matrix1,matrix2);
        Complex[][] ansMatrix = createMatrix(answerPath,"Mult");
        assertTrue(compareMatrix(multMatrix,ansMatrix));
    }


    @Test
    public void determinantTest() throws FileNotFoundException, ComplexException {

        Complex[][] matrix = createMatrix(defaultPath,"Real1");
        Complex ans = calc.determinant(matrix);
        assertEquals(ans,new Complex(-28,0));

    }

    @Test
    public void adjuntTest() throws FileNotFoundException, ComplexException {
        Complex[][] matrix = createMatrix(defaultPath,"3");
        Complex[][] adjunt = calc.adjunt(matrix);
        Complex[][] ansdAdjunt = createMatrix(answerPath,"Adj2");
        assertTrue(compareMatrix(adjunt,ansdAdjunt));
    }

    @Test
    public void conjugateTest() throws FileNotFoundException {
        Complex[][] matrix = createMatrix(defaultPath,"3");
        Complex[][] conjugate = calc.conjugateMatrix(matrix);
        Complex[][] conjugateAns = createMatrix(answerPath,"Conjugate");
        assertTrue(compareMatrix(conjugate,conjugateAns));
    }



    @Test
    public void inverseTest() throws FileNotFoundException, ComplexException {
        Complex[][] matrix = createMatrix(defaultPath,"3");
        Complex[][] inverse = calc.inverse(matrix);
        Complex[][] inverseAns = createMatrix(answerPath,"Inverse");
        assertTrue(compareMatrix(inverse,inverseAns));
    }

    @Test
    public void internalProductTest() throws FileNotFoundException, ComplexException {
        Complex[][] matrix1 = createMatrix(defaultPath,"1");
        Complex[][] matrix2 = createMatrix(defaultPath,"2");
        Complex internal = calc.internalProduct(matrix1,matrix2);
        assertEquals(internal,new Complex(32,-9));

    }

    @Test
    public void normTest() throws FileNotFoundException, ComplexException {
        Complex[][] matrix1 = createMatrix(defaultPath,"1");
        double norm = calc.matrixNorm(matrix1);
        assertTrue(norm==Math.sqrt(59));


    }

    @Test
    public void actionTest() throws FileNotFoundException, ComplexException {
        Complex[][] matrix1 = createMatrix(defaultPath,"2");
        Complex[][] matrix2 = createMatrix(defaultPath,"Vector");
        Complex[][] action = calc.action(matrix1,matrix2);
        Complex[][] ansAction = createMatrix(answerPath,"Action");
        assertTrue(compareMatrix(action,ansAction));

    }

    @Test
    public void hermitianTest() throws FileNotFoundException, ComplexException {
        Complex[][] matrix1 = createMatrix(defaultPath,"Hermitian");
        assertTrue(calc.isHermitian(matrix1));

    }


    @Test
    public void tensorProductText() throws FileNotFoundException, ComplexException {
        Complex[][] matrixA = createMatrix(defaultPath,"2");
        Complex[][] matrixB = createMatrix(defaultPath,"1");
        Complex[][] tensor = calc.tensorProduct(matrixA,matrixB);
        Complex[][] tensorAns = createMatrix(answerPath,"Tensor");
        assertTrue(compareMatrix(tensorAns,tensor));

    }


    private Complex[][] createMatrix(String path,String sample) throws FileNotFoundException {
        File file = new File(path+sample+".in");
        Scanner sc = new Scanner(file);
        
        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());
        Complex[][]matrix = new Complex[rows][cols]; 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String[] temp = sc.nextLine().split(",");
                Complex complex = new Complex(Double.parseDouble(temp[0]),Double.parseDouble(temp[1]));
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

    private boolean compareMatrix(Complex[][] m1, Complex[][] m2){
        boolean equals = true;
        for (int i = 0; i < m1.length && equals;i++) {
            for (int j = 0; j < m1[0].length && equals;j++) {
                if(!m1[i][j].equals(m2[i][j])) equals=false;
            }
        }
        return equals;
    }
}
