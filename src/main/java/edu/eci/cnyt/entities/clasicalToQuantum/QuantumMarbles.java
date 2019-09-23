package edu.eci.cnyt.entities.clasicalToQuantum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Complex[][] marbleCalculationStateFraction(Integer slits,
                                                      Integer shared,
                                                      Integer targets) throws ComplexException {
        int tam = slits+targets+1;
        Complex[][] matrix = calc.zeroMatrix(tam,tam);

        for (int i = 1; i <= slits; i++) {
            matrix[i][0] = new Complex((1/(double)slits),0);
            System.out.println(matrix[i][0].toString());
        }

        printMatrix(matrix);
        System.out.println("-------------------------------------------------");
        Map<Integer,Integer> deltas = new HashMap<Integer, Integer>();
        for (int i = 1; i <= slits; i++) {
            for (int j = slits+1; j < slits+targets ; j++) {
                int delta = j-i;
                if(deltas.containsKey(delta)){
                    int value = deltas.get(delta) + 1;
                    deltas.put(delta, value);
                }else{
                    deltas.put(delta,1);
                }
            }
        }
        int max=0;
        for (Integer k: deltas.keySet()) {
            Integer integer = deltas.get(k);
            if(integer > max) max = integer;
        }

        ArrayList<Integer> maxDeltas = new ArrayList<Integer>();
        for (Integer k: deltas.keySet()) {
            Integer integer = deltas.get(k);
            if(integer == max) maxDeltas.add(k);
        }

        if(slits%2==0 && targets%2==1 && shared%2==0) throw new ComplexException(ComplexException.NO_SQUARE_MATRIX);
        if(slits%2==1 && targets%2==1 && shared%2==1) throw new ComplexException(ComplexException.NO_SQUARE_MATRIX);
        if(slits%2==1 && targets%2==0 && shared%2==1) throw new ComplexException(ComplexException.NO_SQUARE_MATRIX);

        for (int i = 1; i <= slits; i++) {
            for (int j = j = slits+1; j < slits+targets; j++) {
                int delta = j - i;
                if(maxDeltas.contains(delta))  matrix[j][i] = new Complex(-1, 0);
            }
        }

        int rShared = 0;
        int[] sharedList = new int[targets];
        int rIndex = 0;
        for (int i = slits+1; i < slits+targets; i++) {
            int temp = 0;
            for (int j = 1; j <= slits; j++) {
                if(matrix[i][j].equals(new Complex(-1,0))) temp+=1;
            }
            sharedList[rIndex] = temp;
            if(temp > 1) rShared+=1;
            rIndex+=1;
        }
        int top = slits+1;
        int bottom = slits+targets-1;
        int sharedIndex = 0;
        while(rShared > shared){
            while(sharedList[sharedIndex]== 1) {
                sharedIndex += 1;
            }
            int n = slits;
            int m = 1;
            while(n > 0 && m <= slits && sharedList[sharedIndex] > 1 && sharedList[sharedList.length-sharedIndex-2]>1 && rShared > shared) {
                int topIndex = top + sharedIndex;
                if(matrix[topIndex][n].equals(new Complex(-1,0))){
                    matrix[topIndex][n] = new Complex(0,0);
                    rShared-=1;
                    sharedList[sharedIndex]-=1;
                }
                int buttIndex = bottom - sharedIndex;
                if(matrix[buttIndex][m].equals(new Complex(-1,0)) && topIndex!=buttIndex){
                    matrix[buttIndex][m] = new Complex(0,0);
                    rShared-=1;
                    sharedList[sharedList.length-sharedIndex-2]-= 1;
                }
                n-=1;
                m+=1;
            }
        }

        for (int i = slits+1; i < slits+targets; i++) matrix[i][i] = new Complex(1,0);

        int sum=0;
        for (int i = slits+1; i < slits+targets; i++) {
            if(matrix[i][1].equals(new Complex(-1,0))) sum+=1;
        }
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if(matrix[i][j].equals(new Complex(-1,0))){
                    matrix[i][j] = new Complex(1/(double)sum,0);
                }
            }
        }

        printMatrix(matrix);

        return matrix;
    }

    public void crateSlitMatrix(Integer slits,Integer targets){
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