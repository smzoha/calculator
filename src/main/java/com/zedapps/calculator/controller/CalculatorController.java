package com.zedapps.calculator.controller;

import com.zedapps.calculator.processor.CalculatorProcessor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * @author Shamah M Zoha
 * @since 02-Feb-18
 */
public class CalculatorController {

    private Double number1;
    private Double number2;

    private String operand;
    private String resolve;

    private boolean clearOutput;
    private boolean operationLock;

    @FXML
    private Label lblOutput;

    @FXML
    private Label lblOperator;

    public void processNumberInput(ActionEvent event) {
        String value = clearOutput ? "" : lblOutput.getText();
        String input = ((Button) event.getSource()).getText();

        if (input.equals(".")) {
            if (!value.contains(".")) {
                if (value.isEmpty()) value = value.concat("0");
                value = value.concat(input);
            }
        } else {
            value = value.concat(input);
        }

        lblOutput.setText(value);
        clearOutput = !clearOutput && clearOutput;
        operationLock = false;
    }

    public void processOperatorInput(ActionEvent event) {
        if (operand == null || clearOutput) {
            operand = ((Button) event.getSource()).getText();
        }

        String output = lblOutput.getText();

        if (number1 == null && !output.trim().isEmpty()) {
            number1 = Double.parseDouble(output);
        } else {
            if (!operationLock) {
                number2 = Double.parseDouble(output);
                double result = CalculatorProcessor.calculate(number1, number2, operand);
                processCalculationResult(result);
                operand = ((Button) event.getSource()).getText();
            }
        }

        lblOperator.setText(operand);

        operationLock = true;
        clearOutput = true;
    }

    public void processResolveInput(ActionEvent event) {
        resolve = ((Button) event.getSource()).getText();

        String resolveIn = lblOutput.getText();

        if (!operationLock && operand != null && number1 != null) {
            number2 = Double.parseDouble(resolveIn);
            resolveIn = String.valueOf(CalculatorProcessor.calculate(number1, number2, operand));
        }

        double resolveOut = CalculatorProcessor.resolve(resolveIn, resolve);

        clearOutput = true;
        lblOperator.setText(resolve);
        processResolveResult(resolveOut);
    }

    public void clear(ActionEvent event) {
        lblOutput.setText("");
        lblOperator.setText(((Button) event.getSource()).getText());

        operationLock = true;
        clearOutput = true;

        resetAll();
    }

    public void exit() {
        System.exit(1);
    }

    private void processCalculationResult(double result) {
        number1 = result;
        number2 = null;
        lblOutput.setText(Double.toString(result));
    }

    private void processResolveResult(double result) {
        lblOutput.setText(Double.toString(result));
        resetAll();
    }

    private void resetAll() {
        number1 = null;
        number2 = null;
        operand = null;
        resolve = null;
    }
}
