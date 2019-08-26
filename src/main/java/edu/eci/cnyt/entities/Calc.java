/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cnyt.entities;

import java.util.List;

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
    public Complex division(Complex c1, Complex c2) {
        extractComponents(c1, c2);
        double realNumerator = firstComplex[0] * secondComplex[0] + firstComplex[1] * secondComplex[1];
        double realDenominator = (Math.pow(secondComplex[0], 2) + Math.pow(secondComplex[1], 2));
        double realPart = realNumerator / realDenominator;

        double imagiNumerator = firstComplex[1] * secondComplex[0] - firstComplex[0] * secondComplex[1];
        double imagiPart = imagiNumerator / realDenominator;

        return new Complex(realPart, imagiPart);
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

    public Complex[][] transpose(Complex[][] c1) {
        Complex[][] ans = new Complex[c1[0].length][c1.length];

        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c1[0].length; j++) {
                ans[j][i] = c1[i][j];
            }
        }

        return ans;
    }

    public Complex[][] subMatrix(int noTouch,Complex[][]c1){
        System.out.println(noTouch);
        Complex[][] mMatrix = new Complex[c1.length - 1][c1.length - 1];
        int i, j, p = 0;
        for ( i = 0; i < c1.length; i++) {
            int q = 0;
            for ( j = 0; j < c1.length; j++) {
                if (i != noTouch && j != 0) {
                    System.out.println(p+","+q);
                    mMatrix[p][q] = c1[i][j];
                    //System.out.print(mMatrix[p][q].toString()+",");
                    q += 1;
                }
            }
            if (i != noTouch && j != 0)
                p += 1;
                //System.out.println();
        }

        return mMatrix;
    }
    public Complex determinant(Complex[][] c1) {
        
        Complex ans = new Complex(0,0);
        if (c1.length > 2) {
            for (int m = 0; m < c1.length; m++) {
                Complex[][] subMatrix = subMatrix(m, c1);

                Complex constMult = this.constantMult(Math.pow(-1, m), determinant(subMatrix));

                ans = this.sum(ans, this.mult(c1[m][0],constMult));
                System.out.println(ans.toString()+"soy el determinante de esta matriiiizzz");
            }
            return ans;
        }else{
            return determinant2x2(c1);
        }
    }

    public Complex determinant2x2(Complex[][] matrix) {
        // Complex[] positives = new Complex[matrix.length];
        // for (int i = 0; i < matrix.length; i++)
        //     positives[i] = new Complex(1, 0);

        // for (int i = 0; i < matrix.length; i++) {
        //     int j = i;
        //     for (int b = 0; b < matrix.length; b++) {
        //         if (j == matrix.length)
        //             j = 0;
        //         positives[b] = this.mult(positives[b], matrix[i][j]);
        //         j += 1;
        //     }
        // }

        // Complex[] negatives = new Complex[matrix.length];
        // for (int i = 0; i < matrix.length; i++)
        //     negatives[i] = new Complex(1, 0);
        // int m = 0;
        // for (int i = matrix.length - 1; i >= 0; i--) {
        //     int j = m;
        //     for (int b = 0; b < matrix.length; b++) {
        //         if (j == -1)
        //             j = matrix.length - 1;
        //         //System.out.println(i + " " + j);
        //         negatives[b] = this.mult(negatives[b], matrix[i][j]);
        //         //System.out.println(negatives[b] + "   " + b);
        //         j -= 1;
        //     }
        //     m += 1;
        // }

        // Complex sum = positives[0];
        // Complex subs = negatives[0];
        // Complex ans;
        // if (matrix.length == 2){
        //     ans = this.substract(sum, subs);
        //     System.out.println(ans.toString()+"determinante 2x2");    
        // }
        // else {
        //     for (int i = 1; i < matrix.length; i++) {
        //         sum = this.sum(sum, positives[i]);
        //         subs = this.sum(sum, negatives[i]);
        //     }
        //     //System.out.println(sum.toString() + " summmm");
        //     //System.out.println(subs.toString() + " subbbb");
        //     ans = this.substract(sum, subs);
        // }
        
        System.out.println(matrix[0][0].toString()+"*"+ matrix[1][1].toString()+"-"+matrix[0][1].toString()+"*"+matrix[1][0].toString());
        Complex ans = substract(mult(matrix[0][0], matrix[1][1]),mult(matrix[0][1], matrix[1][0]));
        System.out.println(ans.toString()+"determinante 2x2");    
        
        return ans;
    }

    public Complex[][] adjunt(Complex[][] c1) {
        Complex[][] adj = new Complex[c1.length][c1[0].length];

        for (int n = 0; n < c1.length; n++) {
            for (int m = 0; m < c1.length; m++) {
                Complex[][] mMatrix = new Complex[c1.length - 1][c1.length - 1];
                int i, j, p = 0;
                for (i = 0; i < c1.length; i++) {
                    int q = 0;
                    for (j = 0; j < c1.length; j++) {
                        if (i != n && j != m) {
                            mMatrix[p][q] = c1[i][j];
                            q += 1;
                        }
                    }
                    if (i != n && j != m)
                        p += 1;
                }
                adj[n][m] = determinant(mMatrix);
            }
        }

        Complex[][] ans = new Complex[c1.length][c1[0].length];
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c1[0].length; j++) {
                Complex constant = new Complex(-1, 0);
                ans[i][j] = this.mult(constant, c1[i][j]);
            }
        }
        return ans;
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
