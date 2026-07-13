package util;

import java.util.Scanner;

/**
 * Utility class for validating user input.
 * 
 * @author admin
 */
public class InputValidator {

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Private constructor to prevent instantiation.
     */
    private InputValidator() {
        throw new AssertionError();
    }

    /**
     * Prompts the user and returns a validated integer within a range.
     *
     * @param message the prompt message
     * @param min the minimum allowed value
     * @param max the maximum allowed value
     * @param errorRange the error message for out-of-range input
     * @param errorFormat the error message for invalid format
     * @return a valid integer between min and max
     */
    public static int getInteger(String message, int min, int max,
            String errorRange, String errorFormat) {
        while (true) {
            try {
                System.out.println(message);
                String input = SCANNER.nextLine().trim();

                int result = Integer.parseInt(input);

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
