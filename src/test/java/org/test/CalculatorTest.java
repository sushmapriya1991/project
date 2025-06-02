package org.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testBasicCalculation() {
        assertEquals(5, calculator.calculate("ADD", 2, 3));
        assertEquals(-1, calculator.calculate("SUBTRACT", 2, 3));
        assertEquals(6, calculator.calculate("MULTIPLY", 2, 3));
        assertEquals(2, calculator.calculate("DIVIDE", 6, 3));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () ->calculator.calculate("DIVIDE", 2, 0));
    }

    @Test
    void testUnsupportedOperation() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("POWER", 2, 3));
    }

    @Test
    void testChaining() {
        Calculator.Chain chain = calculator.chain(5);
        double result = chain.apply("ADD", 3).apply("MULTIPLY", 2).getResult();
        assertEquals(16, result);
    }
}