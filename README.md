# QuantumLibrary

**autor** : Daniel Alberto Rosales Castro

This is the quantum computing library, here you will find different properties on complex numbers such as:

---
### Complex numbers
1.  Sum
2.  Product
3.  Subtract
4.  Division
5.  Module
6.  Conjugate
7.  Conversion between polar and Cartesian representations
8.  Returning the phase of a complex number.
### Complex matrix


 1. Adición de vectores complejos.
 2. Inversa de vectores complejos.
 3. Multiplicación escalar de vectores complejos.
 4. Adición de matrices complejos.
 5. Inversa de matrices complejos.
 6. Multiplicación escalar de matrices complejas.
 7. Matriz transpuesta
 8. Matriz conjugada
 9. Matriz adjunta
10. Función para calcular la "acción" de una matriz sobre un vector.
11. Norma de matrices
12. Distancia entrematrices
13. Revisar si es unitaria
14. Revisar si es Hermitian
15. Producto tensor.





## Install

In order to install the program you must download the repository through the next link:

````
https://github.com/GrCross/CuanticLibrary
````
## Use

To use the Functions that are related with complex number and Matrix of complex numbers, have in mind the next recomendations

* In order to use all the function you must import the class **Calc** and the class **Complex.**
* The parameters of all fuction has the next names **c1** and **c2**
* If you want to use one function with vectors send a nx1 matrix where the n is the number of rows

## tests

In order to execute the Tests run the next comand:

````
$ mvn package
````

There are 19 test at the moment, one test for every function mentioned before.

on the package **TestFiles** are diferent files with examples that are used by tests. inside that folder there are one folder with the respectives answers


### Example


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

## Documentation

To read the Calculator documentation see the next link

[Calc](Calc.html)
