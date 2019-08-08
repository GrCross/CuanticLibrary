
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