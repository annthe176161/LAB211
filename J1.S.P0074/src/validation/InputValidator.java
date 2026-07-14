package validation;

import java.util.Scanner;

/**
 * Provides reusable input validation methods.
 */
public class InputValidator {

    private static final Scanner scanner =
            new Scanner(System.in);

    private InputValidator() {
    }

    /**
     * Input an integer greater than 0.
     *
     * @param prompt message to display
     * @param formatError error for non-number input
     * @param valueError error for value <= 0
     * @return valid integer > 0
     */
    public static int checkInputInt(
            String prompt,
            String formatError,
            String valueError) {
        while (true) {
            try {
                System.out.print(prompt);
                final int result =
                        Integer.parseInt(
                                scanner.nextLine()
                                        .trim());
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
     * Input a valid integer (positive, negative, or 0).
     *
     * @param prompt message to display
     * @param formatError error for non-number input
     * @return valid integer
     */
    public static int checkMatrixValue(
            String prompt,
            String formatError) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(
                        scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(formatError);
            }
        }
    }

    /**
     * Input an integer within a range.
     *
     * @param min minimum value
     * @param max maximum value
     * @param prompt message to display
     * @param formatError error for non-number input
     * @param rangeError error for out-of-range input
     * @return valid integer within range
     */
    public static int checkInputIntLimit(
            int min,
            int max,
            String prompt,
            String formatError,
            String rangeError) {
        while (true) {
            try {
                System.out.print(prompt);
                final int result =
                        Integer.parseInt(
                                scanner.nextLine()
                                        .trim());
                if (result >= min
                        && result <= max) {
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
