package com.calculatorexample.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    public double plus(Double number1, Double number2) {
        return number1 + number2;
    }
    public double minus(Double number1, Double number2) {
        return number1 - number2;
    }

    public double multiply(Double number1, Double number2) {
        return number1 * number2;
    }

    public double divide(Double number1, Double number2) throws ArithmeticException {
        if (number2 == 0) {
            throw new  IllegalArgumentException("Деление на 0 запрещено");
        }
        return number1 / number2;
    }

}
