package com.zedapps.calculator.processor;

/**
 * @author Shamah M Zoha
 * @since 02-Feb-18
 */
public class CalculatorProcessor {

    public static double calculate(Double num1, Double num2, String operand) {
        switch (operand) {
            case "+":
                return num1 + num2;

            case "-":
                return num1 - num2;

            case "*":
                return num1 * num2;

            case "/":
                if (num2 == 0) return 0;
                return num1 / num2;

            case "^":
                return Math.pow(num1, num2);

            default:
                return 0;
        }
    }

    public static double resolve(String number, String resolve) {
        switch (resolve) {
            case "=":
                return number == null ? 0 : Double.parseDouble(number);

            case "INV":
                return number == null ? 0 : Double.parseDouble(number) * -1;

            default:
                return 0;
        }
    }
}
