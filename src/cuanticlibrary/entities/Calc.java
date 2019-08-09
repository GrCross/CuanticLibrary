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

    public Calc(){
    }

    public Complex sum(Complex first, Complex second){
        double sumReal = first.getRealP() + second.getRealP();
        double sumImagi = first.getImagiP() + second.getImagiP();
        return new Complex(sumReal,sumImagi);
    }

    public Complex mult(Complex first, Complex second){
        double[] firstA = {first.getRealP(),first.getImagiP()};
        double[] secondA = {second.getRealP(),second.getImagiP()};
        double multReal = firstA[0]*secondA[0]-firstA[1]*secondA[1];
        double multImagi = firstA[0]*secondA[1]+firstA[1]*secondA[0];
        return new Complex(multReal, multImagi);
    }
}
