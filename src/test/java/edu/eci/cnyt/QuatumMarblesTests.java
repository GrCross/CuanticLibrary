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

import edu.eci.cnyt.entities.Complex;
import edu.eci.cnyt.entities.Exceptions.ComplexException;
import edu.eci.cnyt.entities.clasicalToQuantum.QuantumMarbles;

import org.junit.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.eci.cnyt.entities.Calc;


public class QuatumMarblesTests {
    String defaultPath = "src/test/java/edu/eci/cnyt/testFilesMarbles/matrixSample";
    String answerPath = "src/test/java/edu/eci/cnyt/testFilesMarbles/answers/matrixSample";

    QuantumMarbles qm = new QuantumMarbles();
    
    
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

    @Test
    public void TestCalculateState() throws FileNotFoundException, ComplexException {
        Complex[][] matrix = this.createMatrix(defaultPath,"1");
        Complex[][] vector = this.createMatrix(defaultPath,"Vector1");
        Complex[][] nextState = qm.MarblesCalculateState(matrix, vector, 0);

    }

    @Test
    public void TestCalculateStateFraction() throws FileNotFoundException, ComplexException {
        Complex[][] matrix = this.createMatrixFractions(defaultPath,"Fraction1");
        printMatrix(matrix);
        Complex[][] vector = this.createMatrixFractions(defaultPath,"VectorFraction1");
        Complex[][] nextState = qm.MarblesCalculateState(matrix, vector, 0);

        printMatrix(nextState);
    }



    private Complex[][] createMatrix(String path, String sample) throws FileNotFoundException {
        File file = new File(path+sample+".in");
        Scanner sc = new Scanner(file);

        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());
        Complex[][]matrix = new Complex[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] temp = sc.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                String[] uTemp = temp[j].split(",");
                double realP = Double.parseDouble(uTemp[0]);
                double imagiP = Double.parseDouble(uTemp[1]);
                Complex complex = new Complex(realP, imagiP);
                matrix[i][j] = complex;
            }
        }
        return matrix;
    }

    private Complex[][] createMatrixFractions(String path, String sample) throws FileNotFoundException {
        File file = new File(path+sample+".in");
        Scanner sc = new Scanner(file);

        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());
        Complex[][]matrix = new Complex[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] temp = sc.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                String[] uTemp = temp[j].split(",");
                String[] fraction = uTemp[0].split("/");
                System.out.println(uTemp[0]+"---"+uTemp[1]);
                Double ansFraction =  Double.parseDouble(fraction[0])/Double.parseDouble(fraction[1]);
                double imagiP = Double.parseDouble(uTemp[1]);
                Complex complex = new Complex(ansFraction, imagiP);
                matrix[i][j] = complex;
            }
        }
        return matrix;
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

    private void printMatrix(Complex[][] matrix){

        for (int i = 0; i < matrix.length;i++) {
            for (int j = 0; j < matrix[0].length;j++) {
                System.out.print(matrix[i][j].toString()+" ");
            }
            System.out.println();
        }
    }
}