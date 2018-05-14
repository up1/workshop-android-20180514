package com.example.somkiat.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorMinusTest {

    @Test
    public void minus() {
        Calculator calculator = new Calculator();
        int actualResult = calculator.minus(1, 1);
        assertEquals(0, actualResult);
    }
}