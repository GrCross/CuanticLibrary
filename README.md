# QuantumLibrary

**autor** : Daniel Alberto Rosales Castro

This is the quantum computing library, here you will find different properties on complex numbers such as:
1.  Sum
2.  Product
3.  Subtract
4.  Division
5.  Module
6.  Conjugate
7.  Conversion between polar and Cartesian representations
8.  Returning the phase of a complex number.


## Install

In order to install the program you must download the repository through the next link:

````
https://github.com/GrCross/CuanticLibrary
````
## Use
In order to use all the function you must import the class Calc and the class Complex.
### sum:
Calc has the function **sum**, that receive two Complex objects

````
public Complex sum(Complex first, Complex second){}
````
### multiply:
Calc has the function **mult** to multiply two complex numbers, that receive two complex objects

````
public Complex mult(Complex first, Complex second){}
````

### Substract:
Calc has the function **substract** to substract two complex numbers, that receive two Complex objects

````
public Complex substract(Complex first, Complex second){}
````

### Division:
Calc has the function **division** to divide two complex numbers, that receive two Complex objects

````
public Complex division(Complex first, Complex second ){}
````

### Division:
Calc has the function **division** to divide two complex numbers, that receive two Complex objects

````
public Complex division(Complex first, Complex second ){}
````

### Module:
the Complex object has the function **module**, that return the module of that complex number.

````
public double module(){
        double module = Math.sqrt(Math.pow(realP, 2)+Math.pow(imagiP, 2));
        return module;
    }
````
### Conjugate:
the Complex object has the function **conjugate**, that return the Conjugate complex relative of the number

````
public Complex conjugate(){
        Complex conjugate = new Complex(realP, imagiP * -1);
        return conjugate;
    } 
````

### Polar conversion:
the Complex object has the function **polar**, that return a Polar object relative of the complex number

````
public Polar polar(){
        double module = this.module(); 
        double angle = Math.atan(imagiP/realP);
        Polar polar = new Polar(angle, module);
        return polar;
    }
````



## tests

In order to execute the Tests run the next comand:

````
$ mvn package
````

There are 8 test at the moment, one test for every function mentioned before.

### Modify the tests

There are 4 function those needs two Complex number in order to work:
All 4 function has the variables **fComplex** and **sComplex** (first Complex, second Complex) their respective imaginary part and real part have the next names **realP**and **imagiP** for the first complex and **realS** and **imagiS** for the second complex.

````
@Test
    public void sumTest(){

        Calc calc = new Calc();
        double realP = 5;
        double imagiP = -10;
        Complex fComplex = new Complex(realP, imagiP);

        double realS = 50;
        double imagiS = 320;
        Complex sComplex = new Complex(realS, imagiS);

        Complex complexSum = calc.sum(fComplex, sComplex);
        Complex complexTest = new Complex(realP+realS, imagiP+imagiS);
        
        assertTrue(complexSum.equals(complexTest));
    }
````

the other tests only needs one Complex number and only have	the **fComplex** variable, but it has the same structure

````
@Test
    public void PolarTest(){
        
        double realP = 23;
        double imagiP = -56;
        Complex fComplex = new Complex(realP, imagiP);
        Polar polar = fComplex.polar();
        
        assertTrue(polar.getSinPart() == -0.93 && polar.getCosPart() == 0.38);         
    }
````
