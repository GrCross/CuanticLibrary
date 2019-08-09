/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuanticlibrary;

import cuanticlibrary.entities.*;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class CuanticLibrary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calc calc = new Calc();
        System.out.println("sum of imaginaries");
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
