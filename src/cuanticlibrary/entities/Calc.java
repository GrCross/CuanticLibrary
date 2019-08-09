/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuanticlibrary.entities;



/**
 *
 * @author daniel
 */
public class Calc{
    
    private double[] firstComplex = null;
    private double[] secondComplex = null;
           

    public Calc(){
    }

    public Complex sum(Complex first, Complex second){
        double sumReal = first.getRealP() + second.getRealP();
        double sumImagi = first.getImagiP() + second.getImagiP();
        return new Complex(sumReal,sumImagi);
    }

    public Complex mult(Complex first, Complex second){
        extractComponents(first, second);
        double multReal = firstComplex[0]*secondComplex[0]-firstComplex[1]*secondComplex[1];
        double multImagi = firstComplex[0]*secondComplex[1]+firstComplex[1]*secondComplex[0];
        return new Complex(multReal, multImagi);
    }
    
    public Complex substract(Complex first, Complex second){
        
        extractComponents(first, second);
        double subsReal = firstComplex[0] - secondComplex[0];
        double subsImagi = firstComplex[1] - secondComplex[1];
        return new Complex(subsReal,subsImagi);
    }
    
    public Complex division(Complex first, Complex second ){
        extractComponents(first, second);
        double realNumerator = firstComplex[0]*secondComplex[0]+firstComplex[1]*secondComplex[1];
        double realDenominator = (Math.pow(secondComplex[0], 2) + Math.pow(secondComplex[1], 2));
        double realPart = realNumerator/realDenominator;
        System.out.println(realPart + "realPA");
        double imagiNumerator = firstComplex[1]*secondComplex[0]-firstComplex[0]*secondComplex[1];
        double imagiPart = imagiNumerator/realDenominator;
        System.out.println(imagiPart + "imagiPA");
        
        return new Complex(realPart, imagiPart);
    }
    
    
    private void extractComponents(Complex first, Complex second){
        double[] temp1 = {first.getRealP(),first.getImagiP()};
        double[] temp2 = {second.getRealP(),second.getImagiP()};
        firstComplex = temp1;
        secondComplex = temp2;
    }
}
