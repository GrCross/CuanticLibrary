/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cnyt.entities;

import java.text.DecimalFormat;
import java.util.List;
import edu.eci.cnyt.entities.*;

/**
 *
 * @author daniel
 */
public class Calc {

    private double[] firstComplex = null;
    private double[] secondComplex = null;

    public Calc() {
    }

    /**
     * 
     * @param first
     * @param second
     * @return
     */
    public Complex sum(Complex c1, Complex c2) {
        double sumReal = c1.getRealP() + c2.getRealP();
        double sumImagi = c1.getImagiP() + c2.getImagiP();
        return new Complex(sumReal, sumImagi);
    }

       

    /**
     * 
     * @param first
     * @param second
     * @return
     */
    public Complex substract(Complex c1, Complex c2) {

        extractComponents(c1, c2);
        double subsReal = firstComplex[0] - secondComplex[0];
        double subsImagi = firstComplex[1] - secondComplex[1];
        return new Complex(subsReal, subsImagi);
    }

    /**
     * 
     * @param first
     * @param second
     * @return
     */
    public Complex mult(Complex c1, Complex c2) {
        extractComponents(c1, c2);
        double multReal = firstComplex[0] * secondComplex[0] - firstComplex[1] * secondComplex[1];
        double multImagi = firstComplex[0] * secondComplex[1] + firstComplex[1] * secondComplex[0];
        return new Complex(multReal, multImagi);
    }

    public Complex constantMult(double cons,Complex c1){
        double multReal = cons*c1.getRealP();
        double multImagi = cons*c1.getImagiP();
        return new Complex(multReal,multImagi);
    }

    public Complex[][] scalarMult(Complex scalar, Complex[][]c1){
        Complex[][] scalarMult = new Complex[c1.length][c1[0].length];
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c1[0].length; j++) {
                scalarMult[i][j] = this.mult(scalar, c1[i][j]);
            }
        }
        return scalarMult;
    }

    /**
     * 
     * @param first
     * @param second
     * @return
     */
    public Complex division(Complex c1, Complex c2) {
        extractComponents(c1, c2);
        double realNumerator = firstComplex[0] * secondComplex[0] + firstComplex[1] * secondComplex[1];
        double realDenominator = (Math.pow(secondComplex[0], 2) + Math.pow(secondComplex[1], 2));
        double realPart = realNumerator / realDenominator;

        double imagiNumerator = firstComplex[1] * secondComplex[0] - firstComplex[0] * secondComplex[1];
        double imagiPart = imagiNumerator / realDenominator;
        DecimalFormat df = new DecimalFormat("#.##");
        return new Complex(Double.valueOf(df.format(realPart)), Double.valueOf(df.format(imagiPart)));
    }

    public Complex[][] complexDivMatrix(Complex complex, Complex[][]matrix){
        Complex[][]ans = new Complex[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans[i][j] = this.division(matrix[i][j], complex); 
            }
        }

        return ans;
    }


    // ------------ Matrix zone--------------------

    public Complex[][] sum(Complex[][] c1, Complex[][] c2) {
        Complex[][] ans = new Complex[c1.length][c1[0].length];
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c1[0].length; j++) {
                ans[i][j] = this.sum(c1[i][j], c2[i][j]);
            }
        }
        return ans;
    }

    public Complex[][] mult(Complex[][] c1, Complex[][] c2){
        Complex[][] mult = new Complex[c1.length][c2[0].length];
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c2[0].length; j++) {
                Complex sum = new Complex(0, 0);
                for (int k = 0; k < c1[0].length; k++) {
                    sum = this.sum(sum, mult(c1[i][k], c2[k][j]));
                }
                mult[i][j] = sum;
            }
        }
        return mult;
    }

    public Complex[][] transpose(Complex[][] c1) {
        Complex[][] ans = new Complex[c1[0].length][c1.length];

        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c1[0].length; j++) {
                ans[j][i] = c1[i][j];
            }
        }

        return ans;
    }


    public Complex determinant(Complex[][] c1) {
        
        Complex ans = new Complex(0,0);
        if (c1.length > 2) {
            for (int m = 0; m < c1.length; m++) {
                Complex[][] subMatrix = subMatrix(m,0, c1);

                Complex constMult = this.constantMult(Math.pow(-1, m), determinant(subMatrix));

                ans = this.sum(ans, this.mult(c1[m][0],constMult));
            }
            return ans;
        }else{
            return determinant2x2(c1);
        }
    }

    public Complex determinant2x2(Complex[][] matrix) {
        Complex ans = substract(mult(matrix[0][0], matrix[1][1]),mult(matrix[0][1], matrix[1][0]));
        return ans;
    }

    public Complex[][] adjunt(Complex[][] c1) {
        Complex[][] adj = new Complex[c1.length][c1[0].length];

        for (int n = 0; n < c1.length; n++) {
            for (int m = 0; m < c1.length; m++) {

                Complex [][] subMatrix =this.subMatrix(n, m, c1); 
                adj[n][m] = determinant(subMatrix);
                
            }
        }

        Complex[][] ans = new Complex[c1.length][c1[0].length];
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c1[0].length; j++) {
                adj[i][j] = this.constantMult(Math.pow(-1, i+j),adj[i][j]);
            }
        }
        adj = this.transpose(adj);
        return adj;
    }


    public Complex[][] inverse(Complex[][] c1){
        Complex determinant = this.determinant(c1);
        Complex[][] adjoint = this.adjunt(c1);
        Complex[][] inverse = this.complexDivMatrix(determinant, adjoint);
        return inverse;
    }

    public Complex[][] conjugateMatrix(Complex[][] c1){
        Complex[][] conjugateMatrix = new Complex[c1.length][c1[0].length];
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c1[0].length; j++) {
                conjugateMatrix[i][j] = c1[i][j].conjugate();
            }
        }
        return conjugateMatrix;
    }

    private Complex[][] subMatrix(int noTouchI,int noTouchJ,Complex[][]c1){
        //System.out.println(noTouch);
        Complex[][] mMatrix = new Complex[c1.length - 1][c1.length - 1];
        int i, j, p = 0;
        for ( i = 0; i < c1.length; i++) {
            int q = 0;
            for ( j = 0; j < c1.length; j++) {
                if (i != noTouchI && j != noTouchJ) {
                    //System.out.println(p+","+q);
                    mMatrix[p][q] = c1[i][j];
                    //System.out.print(mMatrix[p][q].toString()+",");
                    q += 1;
                }
            }
            if (i != noTouchI && j != noTouchJ)
                p += 1;
                //System.out.println();
        }

        return mMatrix;
    }


    private void extractComponents(Complex c1, Complex c2) {
        double[] temp1 = { c1.getRealP(), c1.getImagiP() };
        double[] temp2 = { c2.getRealP(), c2.getImagiP() };
        firstComplex = temp1;
        secondComplex = temp2;
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
