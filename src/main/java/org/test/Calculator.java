package org.test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {

    // Basic calculation method
    public double calculate(String op, double num1, double num2) {
        Operation operation = Operation.fromString(op);
        if (operation == null) {
            throw new IllegalArgumentException("Operation '" + op + "' is not supported");
        }
        return operation.apply(num1, num2);
    }

    // Chaining operations
    public static class Chain {
        private double value;

        public Chain(double value) {
            this.value = value;
        }

        public Chain apply(String op, double num) {
            Operation operation = Operation.fromString(op);
            value = operation.apply(value, num);
            return this;
        }

        public double getResult() {
            return value;
        }
    }

    public Chain chain(double initialValue) {
        return new Chain(initialValue);
    }
}