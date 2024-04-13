package pro.sky.testing07.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.testing07.Exception.DivisionByZeroException;
import pro.sky.testing07.Service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @ExceptionHandler(DivisionByZeroException.class)
    public ResponseEntity<?> handleDivisionByZero(DivisionByZeroException e) {
        return ResponseEntity.badRequest().body("Делить на ноль нельзя!!!");
    }
    @GetMapping
    public String hello() {
        return "Добро пожаловать в Калькулятор!";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        double result = calculatorService.plus(num1, num2);
        return num1 + "+" + num2 + "=" + result;
    }
    @GetMapping("/minus")
    public String minus(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        double result = calculatorService.minus(num1, num2);
        return num1 + "-" + num2 + "=" + result;
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        double result = calculatorService.multiply(num1, num2);
        return num1 + "*" + num2 + "=" + result;
    }
    @GetMapping("/divide")
    public String divide(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        double result = calculatorService.divide(num1, num2);
        return num1 + "/" + num2 + "=" + result;
    }
}

