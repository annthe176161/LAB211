package ui;

import common.InputHandler;
import entity.BMIStatus;
import service.Calculator;

/**
 * UI logic for BMI calculator.
 */
public class BMICalculator {

    private final Calculator calculator = new Calculator();

    /**
     * Runs the BMI calculator flow.
     */
    public void performCalculation() {
        System.out.println(
                "----- BMI Calculator -----");
        double weight, height;

        while (true) {
            weight = InputHandler.readDouble(
                    "Enter Weight(kg): ",
                    "BMI is digit");
            if (weight > 0) {
                break;
            }
            System.err.println(
                    "Weight must be greater than 0!");
        }

        while (true) {
            height = InputHandler.readDouble(
                    "Enter Height(cm): ",
                    "BMI is digit");
            if (height > 0) {
                break;
            }
            System.err.println(
                    "Height must be greater than 0!");
        }

        BMIStatus status = calculator.calculateBMI(
                weight, height);
        System.out.printf("BMI Number: %.2f\n",
                calculator.calculateBMINumber(
                        weight, height));
        System.out.println(
                "BMI Status: " + status);
    }
}
