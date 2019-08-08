
import java.util.*;
public class Main{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Calc calc= new Calc();
        double realP =sc.nextDouble();
        double imagiP =sc.nextDouble();
        Complex com1 = new Complex(realP, imagiP);
        System.out.println("Otros numeros");
        realP =sc.nextDouble();
        imagiP =sc.nextDouble();  
        Complex com2 = new Complex(realP, imagiP);
        System.out.println(calc.sum(com1,com2).toString());
    }

}