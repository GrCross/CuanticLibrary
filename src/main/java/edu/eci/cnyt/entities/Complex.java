package edu.eci.cnyt.entities;


public interface Complex{

    public double phase();

    public double module();

    public Complex conjugate();

    public Polar polar();

    public double getRealP();

    public void setRealP(double realP); 

    public double getImagiP(); 

    public void setImagiP(double imagiP);

    public Polar getPolar();

    public void setPolar(Polar polar) ;
    
}