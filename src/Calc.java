

public class Calc{

    public Calc(){
    }

    public Complex sum(Complex first, Complex second){
        double sumReal = first.getRealP() + second.getRealP();
        double sumImagi = first.getImagiP() + second.getImagiP();
        return new Complex(sumReal,sumImagi);
    }
}