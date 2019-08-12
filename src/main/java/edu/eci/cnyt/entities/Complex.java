/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cnyt.entities;


/**
 *
 * @author daniel
 */
public class Complex{

    private double realP;
    private double imagiP;
    private Polar polar;

    public Complex(double realP,double imagiP){
        this.realP = realP;
        this.imagiP = imagiP;
        this.polar = polar();
    }

    public double phase(){
        return polar.getAngle();
    }
    public double module(){
        double module = Math.sqrt(Math.pow(realP, 2)+Math.pow(imagiP, 2));
        return module;
    }

    public Complex conjugate(){
        Complex conjugate = new Complex(realP, imagiP * -1);
        return conjugate;
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

    private Polar polar(){
        double module = this.module(); 
        double angle = Math.atan(realP/imagiP);
        Polar polar = new Polar(angle, module);
        return polar;
    }
}
