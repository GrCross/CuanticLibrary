package edu.eci.cnyt.entities.clasicalToQuantum;

import java.util.List;
import edu.eci.cnyt.entities.Calc;
import edu.eci.cnyt.entities.Complex;
import edu.eci.cnyt.entities.Exceptions.ComplexException;

public class QuantumMarbles {

    Calc calc = new Calc();

    public Complex[][] MarblesCalculateState(Complex[][] adjacencyMatrix, Complex[][] initialState, Integer clicks)
            throws ComplexException {

        Complex[][] powerMatrix = adjacencyMatrix;
        for (int i = 0; i < clicks; i++) 
            powerMatrix = calc.mult(powerMatrix, adjacencyMatrix);
        Complex[][] state = calc.action(powerMatrix, initialState);
        return state;
    }

    public Complex[][] marbleCalculationStateFraction(Integer slits, Integer targets,Complex[][]initialState){


        return null;
    }

    public void crateSlitMatrix(Integer slits,Integer targets){
        Complex[][]
    }

    private void printMatrix(Complex[][] matrix){

        for (int i = 0; i < matrix.length;i++) {
            for (int j = 0; j < matrix[0].length;j++) {
                System.out.print(matrix[i][j].toString()+" ");
            }
            System.out.println();
        }
    }

    private void initialMatrix(int row,int columns){
        Complex[][] matrix = new Complex[row][columns];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {

            }
        }
    }
    
}