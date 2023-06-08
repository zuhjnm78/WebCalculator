package pro.sky.WebCalculator;

import org.springframework.stereotype.Service;

@Service
public class WebCalculatorServiceImpl implements WebCalculatorService {
    public String welcome() {
        return "Добро пожаловать в калькулятор.";
    }

    public int add(Integer num1, Integer num2) {
        return num1 + num2;
    }

    public int subtract(Integer num1, Integer num2) {
        return num1 - num2;
    }

    public int multiply(Integer num1, Integer num2) {
        return num1 * num2;
    }

    public int divide(Integer num1, Integer num2) {
        if (num2 == 0) {
            System.out.println("Ошибка: Деление на ноль недопустимо");
        }

        return num1 / num2;


    }
}