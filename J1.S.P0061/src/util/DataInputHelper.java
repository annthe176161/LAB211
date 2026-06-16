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
public class DataInputHelper {

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Prompts for and returns a valid positive double value.
     *
     * @param prompt prompt message
     * @param errFormat format error message
     * @param errNegative range error message
     * @return a positive double
     */
    public static double inputPositiveDouble(String prompt, String errFormat, String errNegative) {
        while (true) {
            try {
                System.out.print(prompt);
                final double result = Double.parseDouble(SCANNER.nextLine().trim());
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
