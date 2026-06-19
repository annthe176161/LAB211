/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class InputValidator {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Validates that the input from console is an integer greater than 0.
     *
     * @param promptMessage the message asking for input
     * @param formatError the error message if the input is not a number
     * @param valueError the error message if the input is less than or equal to
     * 0
     * @return a valid integer greater than 0
     */
    public static int checkInputInt(String promptMessage, String formatError, String valueError) {
        while (true) {
            try {
                System.out.print(promptMessage);
                int result = Integer.parseInt(scanner.nextLine().trim());
                if (result > 0) {
                    return result;
                } else {
                    System.out.println(valueError);
                }
            } catch (NumberFormatException e) {
                System.out.println(formatError);
            }
        }
    }

    /**
     * Validates that the input is a proper integer (can be positive, negative,
     * or zero).
     *
     * @param promptMessage the message asking for input
     * @param formatError the error message if the input is not a valid number
     * @return a valid integer value
     */
    public static int checkMatrixValue(String promptMessage, String formatError) {
        while (true) {
            try {
                System.out.print(promptMessage);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(formatError);
            }
        }
    }

    /**
     * Validates that the input integer is strictly within a given range.
     *
     * @param min the minimum allowed boundary
     * @param max the maximum allowed boundary
     * @param promptMessage the message asking for input
     * @param formatError the error message if the input is not a number
     * @param rangeError the error message if the input is out of range
     * @return a valid integer within the boundary limits
     */
    public static int checkInputIntLimit(int min, int max, String promptMessage, String formatError, String rangeError) {
        while (true) {
            try {
                System.out.print(promptMessage);
                int result = Integer.parseInt(scanner.nextLine().trim());
                if (result >= min && result <= max) {
                    return result;
                } else {
                    System.out.println(rangeError);
                }
            } catch (NumberFormatException e) {
                System.out.println(formatError);
            }
        }
    }
}
