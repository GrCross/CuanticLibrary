package edu.eci.cnyt.entities;

public class Polar{

    private double angle;
    private double module;
    private double cosPart;
    private double sinPart;

    public Polar(double angle, double module) {
        this.setAngle(angle);
        this.setModule(module);
        this.setCosPart(Math.cos(angle));
        this.setSinPart(Math.sin(angle));
    }


    public double getSinPart() {
        return sinPart;
    }

    public void setSinPart(double sinPart) {
        this.sinPart = sinPart;
    }

    public double getCosPart() {
        return cosPart;
    }

    public void setCosPart(double cosPart) {
        this.cosPart = cosPart;
    }

    public double getModule() {
        return module;
    }

    public void setModule(double module) {
        this.module = module;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

	
	
    
}