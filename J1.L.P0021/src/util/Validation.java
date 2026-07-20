package util;

import java.util.List;
import java.util.Scanner;

/**
 * Utility for reading and validating user input from the console.
 */
public class Validation {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Validation() {
    }

    /**
     * Reads an integer within a given range.
     *
     * @param msg      the prompt message
     * @param min      minimum acceptable value
     * @param max      maximum acceptable value
     * @param errNum   shown when input is not a number
     * @param errRange shown when input is out of range
     * @return a valid integer between min and max
     */
    public static int readInteger(
            String msg, int min, int max,
            String errNum, String errRange) {
        while (true) {
            try {
                System.out.print(msg);
                int result = Integer.parseInt(
                        SCANNER.nextLine().trim());
                if (result >= min && result <= max) {
                    return result;
                }
                System.out.println(errRange);
            } catch (NumberFormatException e) {
                System.out.println(errNum);
            }
        }
    }

    /**
     * Reads a non-empty string.
     *
     * @param msg    the prompt message
     * @param errMsg shown when input is empty
     * @return a non-empty trimmed string
     */
    public static String readString(String msg, String errMsg) {
        while (true) {
            System.out.print(msg);
            String result = SCANNER.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println(errMsg);
            } else {
                return result;
            }
        }
    }

    /**
     * Reads a line that may be empty (optional input).
     *
     * @param msg the prompt message
     * @return trimmed input, may be empty
     */
    public static String readOptionalLine(String msg) {
        System.out.print(msg);
        return SCANNER.nextLine().trim();
    }

    /**
     * Reads input and validates against a list of allowed options.
     *
     * @param msg     the prompt message
     * @param errMsg  shown when input does not match any option
     * @param options list of acceptable values
     * @return the matched option
     */
    public static String readOption(
            String msg, String errMsg, List<String> options) {
        while (true) {
            System.out.print(msg);
            String result = SCANNER.nextLine().trim();
            for (String opt : options) {
                if (result.equalsIgnoreCase(opt)) {
                    return opt;
                }
            }
            System.out.println(errMsg);
        }
    }
}
