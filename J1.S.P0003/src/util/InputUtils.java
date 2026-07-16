package util;

import java.util.Scanner;

/**
 * Utility class for reading and validating user input.
 *
 * <p>Provides static methods to prompt the user and parse
 * input values with range and format validation.</p>
 */
public class InputUtils {

    private static final Scanner SCANNER =
            new Scanner(System.in);

    private InputUtils() {
    }

    /**
     * Prompts the user and reads a valid integer
     * within the specified range.
     *
     * @param message    The prompt message to display.
     * @param min        The minimum acceptable value.
     * @param max        The maximum acceptable value.
     * @param errorRange Error message for out-of-range input.
     * @param errorFormat Error message for non-integer input.
     * @return A valid integer within the specified range.
     */
    public static int getInteger(
            String message,
            int min,
            int max,
            String errorRange,
            String errorFormat) {
        while (true) {
            try {
                System.out.print(message);
                String input =
                        SCANNER.nextLine().trim();
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
