/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.BMIStatus;
import entity.Operator;

/**
 *
 * @author admin
 */
public class Manager {

    /**
     * Performs math calculation based on the given operator.
     *
     * @param a The current value in memory.
     * @param operator The math operator enum.
     * @param b The next number to calculate.
     * @return The calculation result, or 0 if division by zero occurs.
     */
    public double calculate(double a, Operator operator, double b) {
        switch (operator) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                if (b == 0) {
                    return 0; // Prevent crash when dividing by zero
                }
                return a / b;
            case EXPONENT:
                return Math.pow(a, b);
            default:
                return 0; // Safe default for the compiler
        }
    }

    /**
     * Calculates the BMI index and determines the health status.
     *
     * @param weight Body weight in kilograms (kg).
     * @param heightCm Body height in centimeters (cm).
     * @return The matching BMIStatus enum.
     */
    public BMIStatus calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100; // Convert cm to meters
        double bmi = weight / (heightM * heightM);

        System.out.printf("BMI Number: %.2f\n", bmi);

        if (bmi < 19) {
            return BMIStatus.UNDER_STANDARD;
        }
        if (bmi <= 25) {
            return BMIStatus.STANDARD;
        }
        if (bmi <= 30) {
            return BMIStatus.OVERWEIGHT;
        }
        if (bmi <= 40) {
            return BMIStatus.FAT;
        }
        return BMIStatus.VERY_FAT;
    }
}
