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
public class Calc{
    
    private double[] firstComplex = null;
    private double[] secondComplex = null;
           
    public Calc(){
    }

    
    /** 
     * 
     * @param first
     * @param second
     * @return
    */
    public Complex sum(Complex first, Complex second){
        double sumReal = first.getRealP() + second.getRealP();
        double sumImagi = first.getImagiP() + second.getImagiP();
        return new Complex(sumReal,sumImagi);
    }

    /** 
     * 
     * @param first
     * @param second
     * @return
    */
    public Complex mult(Complex first, Complex second){
        extractComponents(first, second);
        double multReal = firstComplex[0]*secondComplex[0]-firstComplex[1]*secondComplex[1];
        double multImagi = firstComplex[0]*secondComplex[1]+firstComplex[1]*secondComplex[0];
        return new Complex(multReal, multImagi);
    }

    /** 
     * 
     * @param first
     * @param second
     * @return
    */
    public Complex substract(Complex first, Complex second){
        
        extractComponents(first, second);
        double subsReal = firstComplex[0] - secondComplex[0];
        double subsImagi = firstComplex[1] - secondComplex[1];
        return new Complex(subsReal,subsImagi);
    }

    /** 
     * 
     * @param first
     * @param second
     * @return
    */
    public Complex division(Complex first, Complex second ){
        extractComponents(first, second);
        double realNumerator = firstComplex[0]*secondComplex[0]+firstComplex[1]*secondComplex[1];
        double realDenominator = (Math.pow(secondComplex[0], 2) + Math.pow(secondComplex[1], 2));
        double realPart = realNumerator/realDenominator;
        
        double imagiNumerator = firstComplex[1]*secondComplex[0]-firstComplex[0]*secondComplex[1];
        double imagiPart = imagiNumerator/realDenominator;
        
        
        return new Complex(realPart, imagiPart);
    }

    public List<List<Complex>> sumVectors(){

        return null;

    }
    
    
    private void extractComponents(Complex first, Complex second){
        double[] temp1 = {first.getRealP(),first.getImagiP()};
        double[] temp2 = {second.getRealP(),second.getImagiP()};
        firstComplex = temp1;
        secondComplex = temp2;
    }
}
