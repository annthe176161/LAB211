package util;

import java.util.Scanner;

/**
 * Provides reusable input validation methods
 * for reading and parsing user input from console.
 */
public class InputUtils {

    private static final Scanner SCANNER
            = new Scanner(System.in);

    private InputUtils() {
    }

    /**
     * Prompts the user and reads a valid integer
     * within the specified range. Repeats until
     * a valid input is received.
     *
     * @param message     The prompt message to show.
     * @param min         The minimum valid number.
     * @param max         The maximum valid number.
     * @param errorRange  Error for out-of-range input.
     * @param errorFormat Error for invalid format.
     * @return A valid integer within range.
     */
    public static int getInteger(String message,
            int min, int max,
            String errorRange,
            String errorFormat) {
        while (true) {
            try {
                System.out.print(message);
                String input
                        = SCANNER.nextLine().trim();
                int result
                        = Integer.parseInt(input);

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
