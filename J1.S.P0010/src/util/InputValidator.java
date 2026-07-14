package util;

import java.util.Scanner;

/**
 * Utility class for validating user input.
 *
 * @author admin
 */
public class InputValidator {

    private static final Scanner SCANNER =
            new Scanner(System.in);

    /**
     * Prevents instantiation.
     */
    private InputValidator() {
        throw new AssertionError();
    }

    /**
     * Reads and validates an integer from the user.
     *
     * @param message prompt to display
     * @param min minimum allowed value
     * @param max maximum allowed value
     * @param errorRange message for out-of-range
     * @param errorFormat message for invalid format
     * @return a valid integer within [min, max]
     */
    public static int getInteger(
            String message, int min, int max,
            String errorRange, String errorFormat) {
        while (true) {
            try {
                System.out.println(message);
                final String input =
                        SCANNER.nextLine().trim();
                final int result =
                        Integer.parseInt(input);

                if (result >= min
                        && result <= max) {
                    return result;
                }
                System.err.println(errorRange);
            } catch (NumberFormatException e) {
                System.err.println(errorFormat);
            }
        }
    }
}
