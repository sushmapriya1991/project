package org.test;

import java.util.function.BiFunction;

public enum Operation {
    ADD((a, b) -> a + b),
    SUBTRACT((a, b) -> a - b),
    MULTIPLY((a, b) -> a * b),
    DIVIDE((a, b) -> {
        if (b == 0) {
            throw new ArithmeticException("Invalid denominator: Division by zero is not allowed.");
        }
        return a / b;
    });

    private final BiFunction<Double, Double, Double> function;

    Operation(BiFunction<Double, Double, Double> function) {
        this.function = function;
    }

    public double apply(double a, double b) {
        return function.apply(a, b);
    }

    public static Operation fromString(String op) {
        try {
            return Operation.valueOf(op.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Operation '" + op + "' is not supported");
        }
    }
}