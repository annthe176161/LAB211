/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import entity.Operator;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Validation {

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Gets a valid integer within a specific range.
     *
     * @param msg The message to prompt the user.
     * @param errFormat The error message if input is not a number.
     * @param errRange The error message if input is out of range.
     * @param min The minimum allowed value.
     * @param max The maximum allowed value.
     * @return A valid integer within the range.
     */
    public static int checkInputIntLimit(String msg, String errFormat, String errRange, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int result = Integer.parseInt(SCANNER.nextLine().trim());
                if (result < min || result > max) {
                    System.err.println(errRange);
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println(errFormat);
            }
        }
    }

    /**
     * Gets a valid double number from the user.
     *
     * @param msg The message to prompt the user.
     * @param errFormat The error message if input is not a number.
     * @return A valid double number.
     */
    public static double checkInputDouble(String msg, String errFormat) {
        while (true) {
            try {
                System.out.print(msg);
                String input = SCANNER.nextLine().trim();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.err.println(errFormat);
            }
        }
    }

    /**
     * Prompts the user to enter a valid mathematical operator.
     *
     * @param msg The message to prompt the user for input.
     * @param invalidOperatorMsg The error message displayed when the input is
     * not (+, -, *, /, ^, =).
     * @return The corresponding Operator enum.
     */
    public static Operator checkOperator(String msg, String invalidOperatorMsg) {
        while (true) {
            System.out.print(msg);
            String input = SCANNER.nextLine().trim();
            switch (input) {
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
                    System.err.println(invalidOperatorMsg);
            }
        }
    }
}
