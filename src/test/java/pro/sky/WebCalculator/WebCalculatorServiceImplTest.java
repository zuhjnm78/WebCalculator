package pro.sky.WebCalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class WebCalculatorServiceImplTest {

    private WebCalculatorServiceImpl calculatorService = new WebCalculatorServiceImpl();
    @ParameterizedTest
    @CsvSource({"1, 2, 3", "-5, 3, -2", "0, 0, 0", "10, -10, 0"})
    public void testAdd(int num1, int num2, int expected) {
        int result = calculatorService.add(num1, num2);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"5, 3, 2", "-5, 3, -8", "0, 0, 0", "10, 10, 0"})
    public void testSubtract(int num1, int num2, int expected) {
        int result = calculatorService.subtract(num1, num2);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"2, 3, 6", "-5, 3, -15", "0, 5, 0", "10, -2, -20"})
    public void testMultiply(int num1, int num2, int expected) {
        int result = calculatorService.multiply(num1, num2);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"10, 2, 5", "-15, 3, -5", "0, 5, 0", "10, -2, -5"})
    public void testDivide(int num1, int num2, int expected) {
        if (num2 != 0) {
            int result = calculatorService.divide(num1, num2);
            assertEquals(expected, result);
        } else {
            assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(num1, num2));
        }
    }
}