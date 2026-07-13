package util;

import java.util.Scanner;

/**
 * Provides methods for reading and validating user input.
 */
public class DataInputHelper {

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Prevents creating an instance of this utility class.
     */
    private DataInputHelper() {
    }

    /**
     * Reads a positive decimal number from the user.
     *
     * @param prompt message displayed before input
     * @param errFormat message displayed for invalid numeric input
     * @param errNegative message displayed for a non-positive number
     * @return a valid positive decimal number
     */
    public static double inputPositiveDouble(
            String prompt, String errFormat, String errNegative) {
        while (true) {
            try {
                System.out.print(prompt);
                double result = Double.parseDouble(SCANNER.nextLine().trim());
                if (result > 0) {
                    return result;
                }
                System.out.println(errNegative);
            } catch (NumberFormatException e) {
                System.out.println(errFormat);
            }
        }
    }
}
