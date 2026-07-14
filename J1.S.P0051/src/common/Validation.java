package common;

import entity.Operator;

/**
 * Validates user input for numbers and operators.
 */
public class Validation {

    /**
     * Checks if input is a valid number.
     *
     * @param inputVal input string to check
     * @return parsed Double or null if invalid
     */
    public Double checkInput(String inputVal) {
        try {
            return Double.parseDouble(inputVal.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Checks if input is a valid operator.
     *
     * @param operator input string to check
     * @return matching Operator or null if invalid
     */
    public Operator checkOperator(String operator) {
        switch (operator.trim()) {
            case "+":
                return Operator.ADD;
            case "-":
                return Operator.SUBTRACT;
            case "*":
                return Operator.MULTIPLY;
            case "/":
                return Operator.DIVIDE;
            case "^":
                return Operator.EXPONENT;
            case "=":
                return Operator.EQUAL;
            default:
                return null;
        }
    }
}
