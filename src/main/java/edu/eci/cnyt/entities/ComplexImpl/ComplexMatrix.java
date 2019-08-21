package edu.eci.cnyt.entities.ComplexImpl;

import edu.eci.cnyt.entities.Complex;
import edu.eci.cnyt.entities.Polar;
import edu.eci.cnyt.entities.twoDimensionComplex;
import java.util.*;

public class ComplexMatrix implements twoDimensionComplex {

    Complex[][] matrix;


    public ComplexMatrix(Complex[][] matrix) {
        this.matrix = matrix;
    }
    
    public twoDimensionComplex transpose() {

        Complex[][] temp = new ComplexNumber[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[i][j] = matrix[j][i];
            }
        }
        return new ComplexMatrix(temp);
    }

    
    public twoDimensionComplex adjunct() {
        return null;
    }

    public double norm() {
        return 0;
    }

    public boolean isUnitary() {
        return false;
    }

    public boolean isHermitian() {
        return false;
    }

    public double phase() {
        return 0;
    }

    public double module() {
        return 0;
    }

    public Complex conjugate() {
        return null;
    }

    public Polar polar() {
        return null;
    }

    public double getRealP() {
        return 0;
    }

    public void setRealP(double realP) {

    }

    public double getImagiP() {
        return 0;
    }

    public void setImagiP(double imagiP) {

    }

    public Polar getPolar() {
        return null;
    }

    public void setPolar(Polar polar) {

    }

    public Complex[][] getMatrix() {
        return this.matrix;
    }

    public void setMatrix(Complex[][] matrix) {
        this.matrix = matrix;
    }


}