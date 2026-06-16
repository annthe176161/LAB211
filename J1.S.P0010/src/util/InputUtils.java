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
public class InputUtils {

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Gets an integer within a specific range with validation.
     *
     * @param msg the prompt message
     * @param min the minimum value allowed
     * @param max the maximum value allowed
     * @param errorRange the message if value is out of range
     * @param errorFormat the message if input is not a number
     * @return a valid integer
     */
    public static int getInt(String msg, int min, int max, String errorRange,
            String errorFormat) {
        while (true) {
            try {
                System.out.println(msg);
                int result = Integer.parseInt(SCANNER.nextLine().trim());
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
