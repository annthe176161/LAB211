/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Validation {

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private Validation() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Reads a validated integer within a specific range.
     *
     * @param msg the text message prompt for the user
     * @param min the minimum acceptable value
     * @param max the maximum acceptable value
     * @param errorFormat the error message for invalid number input formats
     * @param errorRange the error message for values out of boundaries
     * @return a valid integer value within the specified range
     */
    public static int inputInt(String msg, int min, int max, String errorFormat, String errorRange) {
        while (true) {
            try {
                System.out.print(msg);
                int result = Integer.parseInt(SCANNER.nextLine().trim());
                if (result >= min && result <= max) {
                    return result;
                } else {
                    System.err.println(errorRange);
                }
            } catch (NumberFormatException e) {
                System.err.println(errorFormat);
            }
        }
    }

    /**
     * Reads a validated non-empty string.
     *
     * @param msg the text message prompt for the user
     * @param errorMsg the error message displayed if input is blank
     * @return a valid trimmed non-empty string
     */
    public static String inputString(String msg, String errorMsg) {
        while (true) {
            System.out.print(msg);
            String result = SCANNER.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println(errorMsg);
            } else {
                return result;
            }
        }
    }

    /**
     * Reads a string that matches an option inside an allowed values list
     * array.
     *
     * @param msg the text message prompt for the user
     * @param errorMsg the error message displayed if input matches nothing
     * @param allowedValues the array containing acceptable string options
     * @return the matched string choice value
     */
    public static String inputAllowedValue(String msg, String errorMsg, String[] allowedValues) {
        while (true) {
            System.out.print(msg);
            String result = SCANNER.nextLine().trim();
            for (String allowed : allowedValues) {
                if (result.equalsIgnoreCase(allowed)) {
                    return allowed;
                }
            }
            System.err.println(errorMsg);
        }
    }
}
