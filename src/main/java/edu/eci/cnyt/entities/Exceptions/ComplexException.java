package edu.eci.cnyt.entities.Exceptions;

import edu.eci.cnyt.entities.Complex;

public class ComplexException extends Exception {

    public static final String DIVISION_BY_ZERO = "The division by zero it's not defined on complex numbers";
    public static final String DIFFERENT_LENGTHS = "The matrices must have the same number of rows and columns in order to be operated";
    public static final String DIFFERENT_ROWS_AND_COLUMNS = "The matrices in order to be multiplicated their columns and rows must be the same lenght";
    public static final String NO_SQUARE_MATRIX = "The matrix must be square in order to realize this operation";
    public ComplexException(String message){
        super(message);
    }
}
