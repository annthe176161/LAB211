package utility;

import java.util.List;
import java.util.Scanner;

public class Validation {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Validation() {
    }

    /**
     * Reads and validates an integer within a given range.
     *
     * @param msg the prompt message
     * @param min the minimum acceptable value
     * @param max the maximum acceptable value
     * @param errNum the error message if the input is not a valid number
     * @param errRange the error message if the input is out of range
     * @return a valid integer between min and max
     */
    public static int readInteger(
            String msg, int min, int max, String errNum, String errRange) {
        while (true) {
            try {
                System.out.print(msg);
                int result = Integer.parseInt(SCANNER.nextLine().trim());
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
     * Reads a non-empty string from the user.
     *
     * @param msg the prompt message
     * @param errMsg the error message if the string is empty
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
     * Reads an optional line from the user, may be empty.
     *
     * @param msg the prompt message
     * @return the trimmed input, possibly empty
     */
    public static String readOptionalLine(String msg) {
        System.out.print(msg);
        return SCANNER.nextLine().trim();
    }

    /**
     * Reads and validates input against a list of allowed options.
     *
     * @param msg the prompt message
     * @param errMsg the error message if the input is not allowed
     * @param options the list of acceptable strings
     * @return the matched allowed string
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
