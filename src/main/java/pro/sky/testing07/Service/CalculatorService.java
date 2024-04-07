package pro.sky.testing07.Service;

import org.springframework.stereotype.Service;
import pro.sky.testing07.Exception.DivisionByZeroException;

@Service
public class CalculatorService {    public double plus(double num1, double num2) {
    return num1 + num2;
}

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double minus(double num1, double num2) {
        return num1 - num2;
    }

    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new DivisionByZeroException();
        }
        return num1 / num2;
    }
}

