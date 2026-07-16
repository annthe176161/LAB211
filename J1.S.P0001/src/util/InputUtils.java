package util;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class InputUtils {

    private InputUtils() {
    }

    private static final Scanner SCANNER
            = new Scanner(System.in);

    /**
     * Gets a valid integer within a range
     * from the user.
     *
     * @param message     the prompt message
     * @param min         the minimum value
     * @param max         the maximum value
     * @param errorRange  error for out of range
     * @param errorFormat error for invalid format
     * @return a valid integer
     */
    public static int getInteger(
            String message, int min, int max,
            String errorRange, String errorFormat) {
        while (true) {
            try {
                System.out.print(message);
                String input
                        = SCANNER.nextLine().trim();
                int result
                        = Integer.parseInt(input);
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
