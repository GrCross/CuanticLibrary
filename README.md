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
