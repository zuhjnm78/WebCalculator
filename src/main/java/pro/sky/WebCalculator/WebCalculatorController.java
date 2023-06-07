package pro.sky.WebCalculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/calculator")
@RestController
public class WebCalculatorController {
    private final WebCalculatorService calculatorService;

    public WebCalculatorController(WebCalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    @GetMapping ()
    public String welcome(){
        return calculatorService.welcome();
    }

    @GetMapping(path = "/plus")
    public String add(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2){
        int result = calculatorService.add(num1, num2);
        return num1 + " + " + num2 + " = " + result;
    }
    @GetMapping("/minus")
    public String subtract(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2){
        int result = calculatorService.subtract(num1, num2);
        return num1 + " - " + num2 + " = " + result;
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2){
        int result = calculatorService.multiply(num1, num2);
        return num1 + " * " + num2 + " = " + result;
    }
    @GetMapping("/divide")
    public String divide(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2){
        int result = calculatorService.divide(num1, num2);
        return num1 + " / " + num2 + " = " + result;
    }

}
