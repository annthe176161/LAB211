package service;

import constant.AppConstant;
import entity.BMIStatus;
import entity.Operator;
import exception.DivisionByZeroException;
import exception.InvalidOperatorException;

/**
 * Handles calculation logic for normal
 * calculator and BMI.
 */
public class Calculator {

    /**
     * Calculates result based on operator.
     *
     * @param a        first number
     * @param operator math operator
     * @param b        second number
     * @return calculation result
     */
    public double calculate(double a, Operator operator,
                            double b) {
        switch (operator) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                if (b == 0) {
                    throw new DivisionByZeroException();
                }
                return a / b;
            case EXPONENT:
                return Math.pow(a, b);
            default:
                throw new InvalidOperatorException(
                        operator);
        }
    }

    /**
     * Calculates BMI number.
     *
     * @param weight   weight in kg
     * @param heightCm height in cm
     * @return BMI value
     */
    public double calculateBMINumber(double weight,
                                     double heightCm) {
        double heightM = heightCm / AppConstant.CM_TO_M;
        return weight / (heightM * heightM);
    }

    /**
     * Determines BMI health status.
     *
     * @param weight   weight in kg
     * @param heightCm height in cm
     * @return BMIStatus enum
     */
    public BMIStatus calculateBMI(double weight,
                                  double heightCm) {
        double bmi = calculateBMINumber(weight, heightCm);

        if (bmi < AppConstant.BMI_UNDER_STANDARD) {
            return BMIStatus.UNDER_STANDARD;
        }
        if (bmi <= AppConstant.BMI_STANDARD_MAX) {
            return BMIStatus.STANDARD;
        }
        if (bmi <= AppConstant.BMI_OVERWEIGHT_MAX) {
            return BMIStatus.OVERWEIGHT;
        }
        if (bmi <= AppConstant.BMI_FAT_MAX) {
            return BMIStatus.FAT;
        }
        return BMIStatus.VERY_FAT;
    }
}
