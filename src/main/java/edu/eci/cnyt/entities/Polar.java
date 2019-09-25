package edu.eci.cnyt.entities;

import java.text.DecimalFormat;
import java.util.Objects;

public class Polar {

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
        //DecimalFormat df = new DecimalFormat("##.##");
        return sinPart;
    }

    public void setSinPart(double sinPart) {
        this.sinPart = sinPart;
    }

    public double getCosPart() {
        //DecimalFormat df = new DecimalFormat("##.##");
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
       // DecimalFormat df = new DecimalFormat("##.##");
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }


    @Override
    public String toString() {
        return "{" +
            " angle='" + getAngle() + "'" +
            ", module='" + getModule() + "'" +
            ", cosPart='" + getCosPart() + "'" +
            ", sinPart='" + getSinPart() + "'" +
            "}";
    }
	

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Polar)) {
            return false;
        }
        Polar polar = (Polar) o;
        boolean test = angle == polar.angle && module == polar.module && cosPart == polar.cosPart && sinPart == polar.sinPart;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(angle, module, cosPart, sinPart);
    }
	
    
}