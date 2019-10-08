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
import edu.eci.cnyt.entities.quantumExperiments.*;

import edu.eci.cnyt.entities.quantumSystems.QuantumSystem;
import org.junit.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.eci.cnyt.entities.Calc;


public class QuantumSystemTest {
    String defaultPath = "src/test/java/edu/eci/cnyt/testFilesQuantumSystem/SystemSample";
    String answerPath = "src/test/java/edu/eci/cnyt/testFilesQuantumSystem/answer/SystemSample";

    QuantumSystem qs = new QuantumSystem();


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
    public void TestCalcProbabilityPosition() throws FileNotFoundException, ComplexException {

        Complex[][] ket1 = {{new Complex(-3, -1)}, {new Complex(0, -2)},
                {new Complex(0, 1)}, {new Complex(2, 0)}};
        double ans = qs.probabilityOfPosition(4,ket1,2);
        double realAns = 1 / Math.pow(Math.sqrt(19), 2);
        assertEquals(ans,realAns,0.3);
    }

    @Test
    public void TestCalcAmplitudeOfTransition() throws FileNotFoundException, ComplexException {
        Complex[][] ket1 = {
                {new Complex(Math.sqrt(2) / 2.0, 0)}, {new Complex(0, Math.sqrt(2) / 2.0)}
        };
        Complex[][] ket2 = {
                {new Complex(0, Math.sqrt(2) / 2.0)}, {new Complex(-Math.sqrt(2) / 2.0, 0)}
        };
        Complex ans = qs.amplitudeOfTransition(ket1,ket2);
        System.out.println(ans.toString());
        Complex realAns = new Complex(0,1.0000000000000002);
        assertTrue(ans.equals(realAns));
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