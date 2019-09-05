/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cnyt.entities;

import java.text.DecimalFormat;
import java.util.List;
import edu.eci.cnyt.entities.*;
import edu.eci.cnyt.entities.Exceptions.ComplexException;

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
     * Sum two complex numbers
     * @param c1 first complex number
     * @param c2 second complex number
     * @return Complex The sum of the two complex numbers
     */
    public Complex sum(Complex c1, Complex c2) {
        double sumReal = c1.getRealP() + c2.getRealP();
        double sumImagi = c1.getImagiP() + c2.getImagiP();
        return new Complex(sumReal, sumImagi);
    }

    /**
     * Substract two complex numbers
     * @param c1 first complex number
     * @param c2 second complex number
     * @return Complex the subtract of the two complex numbers
     */
    public Complex substract(Complex c1, Complex c2) {

        extractComponents(c1, c2);
        double subsReal = firstComplex[0] - secondComplex[0];
        double subsImagi = firstComplex[1] - secondComplex[1];
        return new Complex(subsReal, subsImagi);
    }

    /**
     * Multiplication between two complex number
     * @param c1 first complex number
     * @param c2 second complex number
     * @return Complex the result of multiply two complex
     */
    public Complex mult(Complex c1, Complex c2) {
        extractComponents(c1, c2);
        double multReal = firstComplex[0] * secondComplex[0] - firstComplex[1] * secondComplex[1];
        double multImagi = firstComplex[0] * secondComplex[1] + firstComplex[1] * secondComplex[0];
        return new Complex(multReal, multImagi);
    }


    /**
     * Multiplication between a constant and a Complex
     * @param cons defined constat
     * @param c1 Complex that will be multiplicated by the constant
     * @return Complex
     */
    public Complex constantMult(double cons, Complex c1) {
        double multReal = cons * c1.getRealP();
        double multImagi = cons * c1.getImagiP();
        return new Complex(multReal, multImagi);
    }

    /**
     * Division between two complex number
     * @param c1 complex numerator of the division
     * @param c2 complex denominator of the division
     * @return Complex
     * @throws ComplexException if the second complex(c2) is zero
     */
    public Complex division(Complex c1, Complex c2) throws ComplexException {
        if(c2.getRealP() == 0) throw new ComplexException(ComplexException.DIVISION_BY_ZERO);

        extractComponents(c1, c2);
        double realNumerator = firstComplex[0] * secondComplex[0] + firstComplex[1] * secondComplex[1];
        double realDenominator = (Math.pow(secondComplex[0], 2) + Math.pow(secondComplex[1], 2));
        double realPart = realNumerator / realDenominator;

        double imagiNumerator = firstComplex[1] * secondComplex[0] - firstComplex[0] * secondComplex[1];
        double imagiPart = imagiNumerator / realDenominator;
        //DecimalFormat df = new DecimalFormat("#.##");
        return new Complex(realPart,imagiPart);
    }
// ------------ Matrix zone--------------------


    /**
     * Scalar multiplication between a complex and
     * a complex vector o complex matrix
     * @param scalar scalar number
     * @param c1 complex vector o matrix that will be multiplicated by the scalar
     * @return Complex[][]
     */
    public Complex[][] scalarMult(Complex scalar, Complex[][] c1) {
        Complex[][] scalarMult = new Complex[c1.length][c1[0].length];
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c1[0].length; j++) {
                scalarMult[i][j] = this.mult(scalar, c1[i][j]);
            }
        }
        return scalarMult;
    }

    /**
     * Division between a complex number and a complex matrix
     * @param complex Complex number
     * @param matrix Complex matrix
     * @return Complex[][]
     * @throws ComplexException if the real part of the complex number is zero
     */
    public Complex[][] complexDivMatrix(Complex complex, Complex[][] matrix) throws ComplexException {
        if(complex.getRealP() == 0) throw new ComplexException(ComplexException.DIVISION_BY_ZERO);
        Complex[][] ans = new Complex[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans[i][j] = this.division(matrix[i][j], complex);
            }
        }

        return ans;
    }


    /**
     * Sum between two complex matrix or two complex vectors
     * @param c1 first complex matrix
     * @param c2 second complex matrix
     * @return  Complex[][]
     * @throws ComplexException if the number of of rows and columns between them are different
     */
    public Complex[][] sum(Complex[][] c1, Complex[][] c2) throws ComplexException {

        if(c1.length != c2.length || c1[0].length != c2[0].length) throw new ComplexException(ComplexException.DIFFERENT_LENGTHS);

        Complex[][] ans = new Complex[c1.length][c1[0].length];
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c1[0].length; j++) {
                ans[i][j] = this.sum(c1[i][j], c2[i][j]);
            }
        }
        return ans;
    }

    /**
     *  Subtract between two complex matrix or two complex vectors
     * @param c1 first complex matrix
     * @param c2 second complex matrix
     * @return C
     * @throws ComplexException if the two matrix have different number of columns and rows
     */
    public Complex[][] substract(Complex[][] c1, Complex[][] c2) throws ComplexException {

        if(c1.length != c2.length || c1[0].length != c2[0].length) throw new ComplexException(ComplexException.DIFFERENT_LENGTHS);

        Complex[][] ans = new Complex[c1.length][c1[0].length];
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c1[0].length; j++) {
                ans[i][j] = this.substract(c1[i][j], c2[i][j]);
            }
        }
        return ans;
    }


    /**
     * Multiplication betwwen tow complex vectors or two complex matrix
     * @param c1 first complex matrix
     * @param c2 second complex matrix
     * @return  Complex[][]
     * @throws ComplexException if the number of rows of the first matrix are diferent from the number of columns of the second matrix
     */
    public Complex[][] mult(Complex[][] c1, Complex[][] c2) throws ComplexException {

        if(c1.length != c2[0].length)throw new ComplexException(ComplexException.DIFFERENT_ROWS_AND_COLUMNS);

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

    public Complex internalProduct(Complex[][] c1, Complex[][] c2) throws ComplexException {
        return trace(mult(adjunt(c1), c2));
    }

    /**
     * Transpose the defined complex matrix or verctor
     * @param c1 complex matrix who will be trasposed
     * @return Complex[][]
     */
    public Complex[][] transpose(Complex[][] c1) {
        Complex[][] ans = new Complex[c1[0].length][c1.length];
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c1[0].length; j++) {
                ans[j][i] = c1[i][j];
            }
        }
        return ans;
    }

    /**
     * Calculete the determinant of a complex matrix
     * @param c1 complex to which the determinant will be determined
     * @return Complex
     * @throws ComplexException if the matrix is not square
     */
    public Complex determinant(Complex[][] c1) throws ComplexException {
        if(c1.length != c1[0].length) throw new ComplexException(ComplexException.NO_SQUARE_MATRIX);
        Complex ans = new Complex(0, 0);
        if (c1.length > 2) {
            for (int m = 0; m < c1.length; m++) {
                Complex[][] subMatrix = subMatrix(m, 0, c1);

                Complex constMult = this.constantMult(Math.pow(-1, m), determinant(subMatrix));

                ans = this.sum(ans, this.mult(c1[m][0], constMult));
            }
            return ans;
        } else {
            return determinant2x2(c1);
        }
    }

    /**
     * Calculate the adjunt of a complex matrix
     * @param c1 complex matrix to which the adjunt will be determined
     * @return Complex[][]
     * @throws ComplexException if the matrix is not square
     */
    public Complex[][] adjunt(Complex[][] c1) throws ComplexException {
        return conjugateMatrix(transpose(c1));
    }
    /**
     * Calculate the adjunt of a complex matrix
     * using Cofactors
     * @param c1 complex matrix to which the adjunt will be determined
     * @return Complex[][]
     * @throws ComplexException if the matrix is not square
     */
    public Complex[][] adjuntConfactors(Complex[][] c1) throws ComplexException {

        if(c1.length != c1[0].length) throw  new ComplexException(ComplexException.NO_SQUARE_MATRIX);
        Complex[][] adj = new Complex[c1.length][c1[0].length];

        for (int n = 0; n < c1.length; n++) {
            for (int m = 0; m < c1.length; m++) {

                Complex[][] subMatrix = this.subMatrix(n, m, c1);
                adj[n][m] = determinant(subMatrix);

            }
        }

        Complex[][] ans = new Complex[c1.length][c1[0].length];
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c1[0].length; j++) {
                adj[i][j] = this.constantMult(Math.pow(-1, i + j), adj[i][j]);
            }
        }
        adj = this.transpose(adj);
        return adj;
    }

    /**
     * Calculate the aditive inverse of a complex matrix
     * using the determinant and the cofactors traspose matrix
     * @param c1 complex matrix to which the inverse will be determined
     * @return
     * @throws ComplexException
     */
    public Complex[][] inverse(Complex[][] c1) throws ComplexException {
        Complex[][] inverseAns = new Complex[c1.length][c1[0].length];
        for (int i = 0; i < c1[0].length; i++) {
            for (int j = 0; j < c1[0].length; j++) {
                inverseAns[i][j] = c1[i][j].aditiveInverse();
            }
        }
        return inverseAns;
    }

    /**
     * Calculate the inverse of a complex matrix
     * using the determinant and the cofactors traspose matrix
     * @param c1 complex matrix to which the inverse will be determined
     * @return
     * @throws ComplexException
     */
    public Complex[][] inverseCofactors(Complex[][] c1) throws ComplexException {
        Complex determinant = this.determinant(c1);
        Complex[][] adjoint = this.adjuntConfactors(c1);
        Complex[][] inverse = this.complexDivMatrix(determinant, adjoint);
        return inverse;
    }

    /**
     *Calculate the conjugate of a matrix
     * @param c1 complex matrix to which the conjugate will be determined
     * @return Complex[][]
     */
    public Complex[][] conjugateMatrix(Complex[][] c1) {
        Complex[][] conjugateMatrix = new Complex[c1.length][c1[0].length];
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c1[0].length; j++) {
                conjugateMatrix[i][j] = c1[i][j].conjugate();
            }
        }
        return conjugateMatrix;
    }

    /**
     * Calculate the Norm of a complex matrix
     * @param c1 complex matrix to which the norm will be determined
     * @return double the norm of the vector
     */
    public double matrixNorm(Complex[][] c1) throws ComplexException {
        double norm = Math.sqrt(this.internalProduct(c1,c1).getRealP());
         return norm;
     }

     public double distance(Complex[][] c1,Complex[][] c2) throws ComplexException {
        Complex[][] sub = this.substract(c1,c2);
        double distance = Math.sqrt(this.internalProduct(sub,sub).getRealP());
        return distance;
     }

    /**
     * Determine the action of a vector over a matrix
     * @param c1 Complex matrix
     * @param v1 Complex vector that will take action on the matrix
     * @return Complex[][]
     */
    public Complex[][] action(Complex[][] c1, Complex[][] v1) {

        Complex[][] action = new Complex[v1.length][1];
        Complex result;
        for (int i = 0; i < v1.length; i++) {
            result = new Complex();
            for (int j = 0; j < c1[0].length; j++) {
                result = sum(result, mult(c1[i][j], v1[i][0]));
            }
            action[i][0] = result;
        }
        return action;
    }

    /**
     * Determine if the complex matrix is hermitian
     * <ul>
     *     <li> an hermitian matrix is the matrix that his adjunt is equals with itself</li>
     * </ul>
     * @param c1 matrix which is determined if it is hermitian
     * @return boolean (true if is hermitian false if no is hermitian)
     */
    public boolean isHermitian(Complex[][] c1) throws ComplexException {
        boolean hermitia = true;
        Complex[][] adjunt = this.adjunt(c1);
        hermitia = equalsMatrix(c1, adjunt);
        return hermitia;
    }

    /**
     * Determine if the complex matrix is Unitary
     * <ul>
     *     <li> an Unitary matrix is the matrix that the multiplication with its adjunt is the identity</li>
     * </ul>
     * @param c1 matrix which is determined if it is Unitary
     * @return boolean (true if is Unitary false if no is Unitary)
     */
    public boolean unitary(Complex[][] c1) throws ComplexException {
        boolean isUnitary=false;
        Complex[][] in = identityMatrix(c1.length);
        Complex[][] multAdj = mult(c1, adjunt(c1));
        isUnitary = equalsMatrix(multAdj, in);
        return isUnitary;

    }

    /**
     * This method calculates the tensor product between two matrices.
     * <ul>
     *      <li>the tensor product is multiply each component of the first matrix with all the
     *      second matrix, performing scalar multiplication for each component.</li>
     * </ul>
     * *
     * @param c1 first complex matrix
     * @param c2 second complex matrix
     * @return Complex[][]
     */
    public Complex[][] tensorProduct(Complex[][] c1,Complex[][]c2){
        Complex[][] productotensor = new Complex[c1.length * c1.length][c1[0].length * c1[0].length];
        int r = 0;
        int c = 0;
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c1[0].length; j++) {
                for (int k = 0; k < c2.length; k++) {
                    for (int a = 0; a < c2[0].length; a++) {
                        productotensor[k + r][a + c] = mult(c1[i][j], c2[k][a]);

                    }
                }
                c += (c2[0].length);
            }
            c = 0;
            r += c2.length;
        }
        return productotensor;
    }

    private Complex[][] subMatrix(int noTouchI, int noTouchJ, Complex[][] c1) {

        Complex[][] mMatrix = new Complex[c1.length - 1][c1.length - 1];
        int i, j, p = 0;
        for (i = 0; i < c1.length; i++) {
            int q = 0;
            for (j = 0; j < c1.length; j++) {
                if (i != noTouchI && j != noTouchJ) {

                    mMatrix[p][q] = c1[i][j];

                    q += 1;
                }
            }
            if (i != noTouchI && j != noTouchJ)
                p += 1;

        }

        return mMatrix;
    }

    public Complex trace(Complex[][] m) {
        Complex trace = new Complex();
        for (int i = 0; i < m.length; i++) {
            if (i < m[0].length) {
                trace = this.sum(trace, m[i][i]);
            }
        }
        return trace;
    }

    private Complex determinant2x2(Complex[][] matrix) {
        Complex ans = substract(mult(matrix[0][0], matrix[1][1]), mult(matrix[0][1], matrix[1][0]));
        return ans;
    }

    private boolean equalsMatrix(Complex[][] c1, Complex[][] c2) {
        boolean equals = true;
        for (int i = 0; i < c1.length && equals; i++) {
            for (int j = 0; j < c1[0].length && equals; j++) {
                equals = c1[i][j].equals(c2[i][j]);
            }
        }
        return equals;
    }

    private void extractComponents(Complex c1, Complex c2) {
        double[] temp1 = { c1.getRealP(), c1.getImagiP() };
        double[] temp2 = { c2.getRealP(), c2.getImagiP() };
        firstComplex = temp1;
        secondComplex = temp2;
    }

    private void printMatrix(Complex[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j].toString() + " ");
            }
            System.out.println();
        }
    }

    public static Complex[][] identityMatrix(int len) {
        Complex[][] in = new Complex[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    in[i][j] = new Complex(1, 0);
                } else {
                    in[i][j] = new Complex(0, 0);
                }
            }
        }
        return in;
    }



}
