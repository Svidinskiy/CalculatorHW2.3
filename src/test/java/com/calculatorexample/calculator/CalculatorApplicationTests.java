package com.calculatorexample.calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorApplicationTests {

	private CalculatorService calculatorService;
	private CalculatorController calculatorController;

	@BeforeEach
	public void setup() {
		calculatorService = new CalculatorServiceImpl();
		calculatorController = new CalculatorController(calculatorService);
	}

	@Test
	public void testWelcome() {
		String result = calculatorController.welcome();
		Assertions.assertEquals("Добро пожаловать в калькулятор", result);
	}

	@Test
	public void testPlus() {
		String result = calculatorController.plus(2.0, 3.0);
		Assertions.assertEquals("2.0 + 3.0 = 5.0", result);
	}

	@Test
	public void testMinus() {
		String result = calculatorController.minus(5.0, 2.0);
		Assertions.assertEquals("5.0 - 2.0 = 3.0", result);
	}

	@Test
	public void testMultiply() {
		String result = calculatorController.multiply(2.0, 3.0);
		Assertions.assertEquals("2.0 * 3.0 = 6.0", result);
	}

	@Test
	public void testDivide() {
		String result = calculatorController.divide(6.0, 3.0);
		Assertions.assertEquals("6.0 / 3.0 = 2.0", result);
	}

	@Test
	public void testDivideByZero() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			calculatorController.divide(6.0, 0.0);
		});
	}
}