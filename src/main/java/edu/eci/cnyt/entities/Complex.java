/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cnyt.entities;

import java.util.Objects;

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

    public Complex(){

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

    public Complex aditiveInverse(){
        Complex inverse = new Complex(-1*realP,imagiP*-1);
        return inverse;
    }

    public double getRealP() {
        return this.realP;
    }

    public void setRealP(double realP) {
        this.realP = realP;
    }

    public double getImagiP() {
        return this.imagiP;
    }

    public void setImagiP(double imagiP) {
        this.imagiP = imagiP;
    }

    public Polar getPolar() {
        if(polar == null)this.polar = polar();
        return this.polar;
    }

    public void setPolar(Polar polar) {
        this.polar = polar;
    }


    public Polar polar(){
        double module = this.module(); 
        double angle = Math.atan(imagiP/realP);
        
        Polar polar = new Polar(angle, module);
        return polar;
    }


    @Override
    public String toString() {
        String string = "("+getRealP()+","+getImagiP()+")";
        return string;
    }


    @Override
    public boolean equals(Object o) {
         
        if (o == this)
            return true;
        if (!(o instanceof Complex)) {
            return false;
        }
        Complex complex = (Complex) o;
        return realP == complex.realP && imagiP == complex.imagiP && Objects.equals(this.getPolar(), complex.getPolar());
    }

    @Override
    public int hashCode() {
        return Objects.hash(realP, imagiP, polar);
    }

    
}
