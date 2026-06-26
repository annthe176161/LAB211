/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class InputValidator {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputValidator() {
        throw new AssertionError("Utility class should not be instantiated.");
    }

    /**
     * Reads and validates an integer from the console within a range.
     *
     * @param message the prompt message for input
     * @param min the minimum allowed value
     * @param max the maximum allowed value
     * @param errorRange the error message for out-of-range input
     * @param errorFormat the error message for non-numeric input
     * @return a valid integer between min and max
     */
    public static int getInteger(String message, int min, int max,
            String errorRange, String errorFormat) {
        while (true) {
            try {
                System.out.println(message);
                String input = SCANNER.nextLine().trim();

                double number = Double.parseDouble(input);
                int result = (int) number;

                if (result >= min && result <= max) {
                    return result;
                }
                System.err.println(errorRange);
            } catch (NumberFormatException e) {
                System.err.println(errorFormat);
            }
        }
    }
}
