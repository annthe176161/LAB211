package common;

import exception.InvalidValueException;

/**
 * Validates business rules for BMI calculation.
 */
public class Validator {

    /**
     * Validates weight is positive.
     *
     * @param weight weight in kg
     * @return validated weight
     * @throws InvalidValueException if weight <= 0
     */
    public double validateWeight(double weight) {
        if (weight <= 0) {
            throw new InvalidValueException(
                    "Weight must be greater than 0!");
        }
        return weight;
    }

    /**
     * Validates height is positive.
     *
     * @param heightCm height in cm
     * @return validated height
     * @throws InvalidValueException if height <= 0
     */
    public double validateHeight(double heightCm) {
        if (heightCm <= 0) {
            throw new InvalidValueException(
                    "Height must be greater than 0!");
        }
        return heightCm;
    }
}
