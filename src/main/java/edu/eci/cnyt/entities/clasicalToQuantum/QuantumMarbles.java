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
        
        Complex[][] state = calc.action(adjacencyMatrix, initialState);
        return state;
    }
    
}