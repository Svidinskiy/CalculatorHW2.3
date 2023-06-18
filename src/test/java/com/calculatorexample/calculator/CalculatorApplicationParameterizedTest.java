package com.calculatorexample.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorApplicationParameterizedTest {

    private CalculatorController calculatorController = new CalculatorController(new CalculatorServiceImpl());

    @ParameterizedTest
    @MethodSource("plusArguments")
    public void testPlus(double num1, double num2, String expected) {
        String result = calculatorController.plus(num1, num2);
        Assertions.assertEquals(expected, result);
    }
    private static Stream<Arguments> plusArguments() {
        return Stream.of(
                Arguments.of(2.0, 3.0, "2.0 + 3.0 = 5.0"),
                Arguments.of(5.0, 2.0, "5.0 + 2.0 = 7.0")
        );
    }

    @ParameterizedTest
    @MethodSource("minusArguments")
    public void testMinus(double num1, double num2, String expected) {
        String result = calculatorController.minus(num1, num2);
        Assertions.assertEquals(expected, result);
    }
    private static Stream<Arguments> minusArguments() {
        return Stream.of(
                Arguments.of(2.0, 3.0, "2.0 - 3.0 = -1.0"),
                Arguments.of(5.0, 2.0, "5.0 - 2.0 = 3.0")
        );
    }

    @ParameterizedTest
    @MethodSource("multiplyArguments")
    public void testMultiply(double num1, double num2, String expected) {
        String result = calculatorController.multiply(num1, num2);
        Assertions.assertEquals(expected, result);
    }
    private static Stream<Arguments> multiplyArguments() {
        return Stream.of(
                Arguments.of(2.0, 3.0, "2.0 * 3.0 = 6.0"),
                Arguments.of(5.0, 2.0, "5.0 * 2.0 = 10.0")
        );
    }

    @ParameterizedTest
    @MethodSource("divideArguments")
    public void testDivide(double num1, double num2, String expected) {
        String result = calculatorController.divide(num1, num2);
        Assertions.assertEquals(expected, result);
    }
    private static Stream<Arguments> divideArguments() {
        return Stream.of(
                Arguments.of(6.0, 3.0, "6.0 / 3.0 = 2.0"),
                Arguments.of(12.0, 6.0, "12.0 / 6.0 = 2.0")
        );
    }
}
