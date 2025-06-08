package com.devcalc;

public class CalculatorService {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor não pode ser zero");
        }

        return a / b;
    }

    public double sqrt(double x) {
        if(x < 0) throw new IllegalArgumentException("Número não pode ser negativo");
        return Math.sqrt(x);
    }


}
