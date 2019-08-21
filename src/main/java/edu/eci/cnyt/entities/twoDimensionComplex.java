package edu.eci.cnyt.entities;


public interface twoDimensionComplex extends Complex{
    /**
     * 
     * @return
     */
    public twoDimensionComplex transpose();
    /**
     * 
     * @return
     */
    public twoDimensionComplex adjunct();
    /**
     * 
     * @return
     */
    public double norm();
    /**
     * 
     * @return
     */
    public boolean isUnitary();
    /**
     * 
     * @return
     */
    public boolean isHermitian();

}