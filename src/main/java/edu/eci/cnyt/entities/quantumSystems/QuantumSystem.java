package edu.eci.cnyt.entities.quantumSystems;

import edu.eci.cnyt.entities.Calc;
import edu.eci.cnyt.entities.Complex;
import edu.eci.cnyt.entities.Exceptions.ComplexException;

public class QuantumSystem {

    Calc calc = new Calc();

    public double probabilityOfPosition(int nPositions, Complex[][] ket, int x) {
        double normaKet = Calc.ketNorm(ket);
        double probabilidad = Math.pow(ket[x][0].module(), 2) / Math.pow(normaKet, 2);
        return probabilidad;
    }

    public Complex amplitudeOfTransition(Complex[][] ket1, Complex[][] ket2) throws ComplexException {
        Complex inner = calc.internalProduct(ket1, ket2);
        System.out.println(inner.toString());
        Complex norm1 = new Complex(calc.ketNorm(ket1),0);
        Complex norm2 = new Complex(calc.ketNorm(ket2),0);

        return calc.division(inner,calc.mult(norm1,norm2));
    }

    public Complex meanObservableOverAVector(Complex[][] m, Complex[][] ket) throws ComplexException {
        if (!calc.isHermitian(m)) {
            throw new ComplexException(ComplexException.IS_NOT_HERMITIAN);
        }
        Complex[][] action = calc.action(m, ket);
        Complex mean = calc.internalProduct(action, ket);
        return mean;
    }



}