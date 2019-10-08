# Quantum Library

**Autor** : Daniel Alberto Rosales Castro

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

 1. Addition of complex vectors.
 2. Inverse of complex vectors.
 3. Scalar multiplication of complex vectors.
 4. Addition of complex matrices.
 5. Inversion of complex matrices.
 6. Scalar multiplication of complex matrices.
 7. Transposed matrix
 8. Conjugate Matrix
 9. Attached Matrix
10. Function to calculate the "action" of a matrix on a vector.
11. Matrix standard
12. Distance between dies
13. Check if it is unitary
14. Check if it is Hermitian
15. Tensor product.





## Install

### requisites
To use the library you must have Maven and Git
There is a link with a tutorial of the installation:

In order to install the program you must download the repository through the next link:
**Windows**
https://docs.wso2.com/display/IS323/Installing+Apache+Maven+on+Windows

**Linux**
https://www.javahelps.com/2017/10/install-apache-maven-on-linux.html

**Mac Oxs**

https://www.mkyong.com/maven/install-maven-on-mac-osx/

To download and use the repository clone the repository through the next command:


````
git clone https://github.com/GrCross/CuanticLibrary
````
## Use

To use the Functions that are related with complex number and Matrix of complex numbers, have in mind the next recommendation’s.

* In order to use all the function you must import the class **Calc** and the class **Complex.**
* The parameters of all functions has the next names **c1** and **c2**.
* If you want to use one function with vectors send a nx1 matrix where the n is the number of rows.
  
  ### Quantum Marbles
  In order to use the Quantum marbles experiments libraries there are two public methods ``MarblesCalculateState`` and ``marbleCalculationStateSlits``.

  **marblesCalculateState:** this function receive an adjacency matrix and an initial state matrix.

  **marbleCalculationStateSlits:** This function receive the number of slits, the number of shared slits and the number of targets, If we are calculating the states of a complex matrix we must set the ``isComplex`` parameter to true, in other way false. 


## Tests

In order to execute the Tests run the next command:

#### Imaginary Calculator
````
$ mvn -Dtest=ImaginaryCalcTest test
````

#### Quantum marble experiments
````
$ mvn -Dtest=UsersServiceImplTest test
````

There are 19 tests about Imaginary Calculator, one test for every function mentioned before And there are 4 Test about the Quantum marble experiments

Exist varius package **TestFiles**, in that packages are different files with examples that are used by tests. Inside that folders there is one folder with the respective answers.

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

the other tests only need one Complex number and only have the **fComplex** variable, but it has the same structure

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
## Author
**Daniel Alberto Rosales Castro**
Estudent of software engineer at Escuela Colombiana de Ingenieria Julio Garavito


## Documentation

To read the Calculator documentation see the check out html file

[Calc.html](Calc.html)

## Licence
[MIT](LICENSE)

