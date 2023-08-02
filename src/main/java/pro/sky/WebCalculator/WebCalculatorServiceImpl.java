package pro.sky.WebCalculator;

import org.springframework.stereotype.Service;

@Service
public class WebCalculatorServiceImpl implements WebCalculatorService {
    public String welcome() {
        return "Добро пожаловать в калькулятор.";
    }

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Ошибка: Деление на ноль недопустимо");
        }

        return num1 / num2;


    }
}
