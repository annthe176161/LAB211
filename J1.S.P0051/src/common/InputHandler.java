package common;

import entity.Operator;
import java.util.Scanner;

/**
 * Reads and validates user input from console.
 */
public class InputHandler {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Validation VALIDATOR = new Validation();

    private InputHandler() {
    }

    /**
     * Reads a valid integer within a range.
     *
     * @param msg       prompt message
     * @param errFormat error for non-numeric input
     * @param errRange  error for out-of-range input
     * @param min       minimum allowed value
     * @param max       maximum allowed value
     * @return valid integer
     */
    public static int readInt(String msg, String errFormat,
                              String errRange, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int result = Integer.parseInt(
                        SCANNER.nextLine().trim());
                if (result >= min && result <= max) {
                    return result;
                }
                System.err.println(errRange);
            } catch (NumberFormatException e) {
                System.err.println(errFormat);
            }
        }
    }

    /**
     * Reads a valid double from user.
     *
     * @param msg       prompt message
     * @param errFormat error for non-numeric input
     * @return valid double
     */
    public static double readDouble(String msg, String errFormat) {
        while (true) {
            System.out.print(msg);
            Double result = VALIDATOR.checkInput(
                    SCANNER.nextLine());
            if (result != null) {
                return result;
            }
            System.err.println(errFormat);
        }
    }

    /**
     * Reads a valid operator from user.
     *
     * @param msg       prompt message
     * @param errFormat error for invalid operator
     * @return valid Operator
     */
    public static Operator readOperator(String msg,
                                        String errFormat) {
        while (true) {
            System.out.print(msg);
            Operator op = VALIDATOR.checkOperator(
                    SCANNER.nextLine());
            if (op != null) {
                return op;
            }
            System.err.println(errFormat);
        }
    }
}
