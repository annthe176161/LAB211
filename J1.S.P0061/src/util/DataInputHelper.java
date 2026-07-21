package util;

import java.util.Scanner;

import constant.ShapeConstants;

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
     * Reads a decimal number from the user that is greater than the minimum.
     *
     * @param prompt message displayed before input
     * @param errFormat message displayed for invalid numeric input
     * @param errNegative message displayed for a number below minimum
     * @param min the minimum allowed value (exclusive)
     * @return a valid decimal number greater than min
     */
    public static double inputDouble(
            String prompt, String errFormat, String errNegative, double min) {
        while (true) {
            try {
                System.out.print(prompt);
                double result = Double.parseDouble(SCANNER.nextLine().trim());
                if (result > min) {
                    return result;
                }
                System.out.println(errNegative);
            } catch (NumberFormatException e) {
                System.out.println(errFormat);
            }
        }
    }
}
