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
     * Gets a valid integer within a range from the user.
     *
     * @param message The prompt message to show.
     * @param min The minimum valid number.
     * @param max The maximum valid number.
     * @param errorRange Error message for out-of-range input.
     * @param errorFormat Error message for invalid number format.
     * @return A valid integer.
     */
    public static int getInteger(String message, int min, int max,
            String errorRange, String errorFormat) {
        while (true) {
            try {
                System.out.print(message);
                String input = SCANNER.nextLine().trim();
                int result = Integer.parseInt(input);
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
