package com.calculatorexample.calculator;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String welcome() {
        return calculatorService.welcome();
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(value = "num1") Double number1, @RequestParam(value = "num2") Double number2) {
        double result = calculatorService.plus(number1, number2);
        return number1 + " + " + number2 + " = " + result;
    }

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") Double number1, @RequestParam("num2") Double number2) {
        double result = calculatorService.minus(number1, number2);
        return number1 + " - " + number2 + " = " + result;
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") Double number1, @RequestParam("num2") Double number2) {
        double result = calculatorService.multiply(number1, number2);
        return number1 + " * " + number2 + " = " + result;
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("num1") Double number1, @RequestParam("num2") Double number2) {
        double result = calculatorService.divide(number1, number2);
        return number1 + " / " + number2 + " = " + result;
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMissingParams(MissingServletRequestParameterException ex) {
        return "Ошибка: Не указаны оба числа";
    }
}
