package com.example;

import java.io.IOException;

import io.github.mrrefactoring.Fraction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class PrimaryController {

    @FXML
    private TextField inputTextField;
    @FXML
    private Text currentText;

    // x + y, 'x' is firstValue, 'y' is secondValue, '+' is operation
    private String firstValue = "";
    private String secondValue = "";
    private String operation;

    @FXML
    private void handleCalculateButtonAction(ActionEvent event) {
        switch (operation) {
            case "^":
                calculateExponent();
                break;
            case "+":
                calculateAddition();
                break;
            case "-":
                calculateSubtraction();
                break;
            case "x":
                calculateMultiplication();
                break;
            case "/":
                calculateDivision();
                break;
            default:
                break;
        }
    }

    private void buildOperation(String operation) {
        this.operation = operation;
        firstValue = secondValue;
        secondValue = "";
        currentText.setText(firstValue + " " + operation);
    }

    public void appendNumber(String number) {
        secondValue += number;
        inputTextField.setText(secondValue);
    }

    @FXML
    private void handleExponentButtonAction(ActionEvent event) throws IOException {
        buildOperation("^");
    }

    @FXML
    private void handleMultButtonAction(ActionEvent event) throws IOException {
        buildOperation("x");
    }

    @FXML
    private void handleDivisionButtonAction(ActionEvent event) throws IOException {
        buildOperation("/");
    }

    @FXML
    private void handleAddButtonAction(ActionEvent event) throws IOException {
        buildOperation("+");
    }

    @FXML
    private void handleSubButtonAction(ActionEvent event) throws IOException {
        buildOperation("-");
    }

    private void calculateAddition() {
        double result = Double.parseDouble(firstValue) + Double.parseDouble(secondValue);
        currentText.setText(firstValue + " + " + secondValue + " = " + result);
        inputTextField.setText(String.valueOf(result));
    }

    private void calculateSubtraction() {
        double result = Double.parseDouble(firstValue) - Double.parseDouble(secondValue);
        currentText.setText(firstValue + " - " + secondValue + " = " + result);
        inputTextField.setText(String.valueOf(result));
    }

    private void calculateMultiplication() {
        double result = Double.parseDouble(firstValue) * Double.parseDouble(secondValue);
        currentText.setText(firstValue + " x " + secondValue + " = " + result);
        inputTextField.setText(String.valueOf(result));
    }

    private void calculateDivision() {
        double result = Double.parseDouble(firstValue) / Double.parseDouble(secondValue);
        currentText.setText(firstValue + " / " + secondValue + " = " + result);
        inputTextField.setText(String.valueOf(result));
    }

    private void calculateExponent() {
        // String query = inputTextField.getText();

        // int indexOfExp = query.indexOf("^");
        // double x = Double.parseDouble(query.substring(0, indexOfExp));
        // double y = Double.parseDouble(query.substring(indexOfExp));

        // if (y == 0.0) {

        //     inputTextField.setText("1.0");
        //     return;
        // }

        // double result = 1.0;
        // double absExponent = y < 0 ? -y : y;
        // String numString = String.valueOf(y);
        // int indexOfDecimal = numString.indexOf(".");
        // double decimal = Double.parseDouble(numString.substring(indexOfDecimal));
        // System.out.println("DEBUG: decimal part " + decimal);

        // for (int i = 1; i <= absExponent; i++) {
        //     result *= x;
        // }

        // if (decimal != 0.0) {
        //     try {
        //     Fraction frac = new Fraction(x);
        //     System.out.println("DEBUG: fraction " + frac.toFraction());
        //     System.out.println("DEBUG: power with fraction " + frac.pow(decimal));
        //     result *= frac.pow(decimal).toDecimal();
        //     } catch (Exception e) {
        //     System.out.println("ERROR - DIVISION BY ZERO");
        //     System.exit(0);
        //     }

        // }

        // if (y < 0.0) {
        //     result = 1.0 / result;
        // }

        double x = Double.parseDouble(firstValue);
        double y = Double.parseDouble(secondValue);

        System.out.println("DEBUG: exponent x " + x);
        System.out.println("DEBUG: exponent y " + y);

        if (y == 0.0) {
            inputTextField.setText("1.0");
            return;
        }

        double result = 1.0;
        double absExponent = y < 0 ? -y : y;
        String numString = String.valueOf(y);
        int indexOfDecimal = numString.indexOf(".");
        double decimal = Double.parseDouble(numString.substring(indexOfDecimal));
        System.out.println("DEBUG: decimal part " + decimal);

        for (int i = 1; i <= absExponent; i++) {
            result *= x;
        }

        if (decimal != 0.0) {
            try {
            Fraction frac = new Fraction(x);
            System.out.println("DEBUG: fraction " + frac.toFraction());
            System.out.println("DEBUG: power with fraction " + frac.pow(decimal));
            result *= frac.pow(decimal).toDecimal();
            } catch (Exception e) {
            System.out.println("ERROR - DIVISION BY ZERO");
            System.exit(0);
            }

        }

        if (y < 0.0) {
            result = 1.0 / result;
        }

        currentText.setText(firstValue + " ^ " + secondValue + " = ");
        inputTextField.setText(String.valueOf(result));
    }

    @FXML
    void handleButton0Action(ActionEvent event) {
        appendNumber("0");
    }

    @FXML
    void handleButton1Action(ActionEvent event) {
        appendNumber("1");
    }

    @FXML
    void handleButton2Action(ActionEvent event) {
        appendNumber("2");
    }

    @FXML
    void handleButton3Action(ActionEvent event) {
        appendNumber("3");
    }

    @FXML
    void handleButton4Action(ActionEvent event) {
        appendNumber("4");
    }

    @FXML
    void handleButton5Action(ActionEvent event) {
        appendNumber("5");
    }

    @FXML
    void handleButton6Action(ActionEvent event) {
        appendNumber("6");
    }

    @FXML
    void handleButton7Action(ActionEvent event) {
        appendNumber("7");
    }

    @FXML
    void handleButton8Action(ActionEvent event) {
        appendNumber("8");
    }

    @FXML
    void handleButton9Action(ActionEvent event) {
        appendNumber("9");
    }

}
