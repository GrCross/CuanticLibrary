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
public class Complex{
    private double realP;
    private double imagiP;
    public Complex(double realP,double imagiP){
        this.realP = realP;
        this.imagiP = imagiP;
    }

    public double getRealP(){
        return realP;
    }

    public double getImagiP(){
        return imagiP;
    }

    public String toString(){
        return Double.toString(realP) +","+ Double.toString(imagiP);
    }
}
