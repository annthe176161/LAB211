package ui;

import common.InputHandler;
import common.Validator;
import entity.BMIStatus;
import exception.InvalidValueException;
import service.Calculator;

/**
 * UI logic for BMI calculator.
 */
public class BMICalculator {

    private final Calculator calculator = new Calculator();
    private final Validator validator = new Validator();

    /**
     * Runs the BMI calculator flow.
     */
    public void performCalculation() {
        System.out.println(
                "----- BMI Calculator -----");

        double weight = readWeight();
        double height = readHeight();

        BMIStatus status = calculator.calculateBMI(
                weight, height);
        System.out.printf("BMI Number: %.2f\n",
                calculator.calculateBMINumber(
                        weight, height));
        System.out.println(
                "BMI Status: " + status);
    }

    private double readWeight() {
        while (true) {
            try {
                double weight = InputHandler.readDouble(
                        "Enter Weight(kg): ",
                        "BMI is digit");
                return validator.validateWeight(weight);
            } catch (InvalidValueException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private double readHeight() {
        while (true) {
            try {
                double height = InputHandler.readDouble(
                        "Enter Height(cm): ",
                        "BMI is digit");
                return validator.validateHeight(height);
            } catch (InvalidValueException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
