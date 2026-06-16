/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

/**
 *
 * @author admin
 */
public class NumberValidation {

    /**
     * Validates and parses a string into a Float object.
     *
     * @param floatString the string input to validate
     * @return the parsed Float value, or null if invalid
     */
    public static Float checkIn(String floatString) {
        try {
            float number = Float.parseFloat(floatString);
            return number;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Checks if a number is odd.
     *
     * @param number the float number to check
     * @return true if odd, false otherwise
     */
    public static boolean isOdd(float number) {
        if (number % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if a number is even.
     *
     * @param number the float number to check
     * @return true if even, false otherwise
     */
    public static boolean isEven(float number) {
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if a number is a perfect square.
     *
     * @param number the float number to check
     * @return true if a perfect square, false otherwise
     */
    public static boolean isPerfectSquare(float number) {
        if (number < 0) {
            return false;
        }
        double squareRoot = Math.sqrt(number);
        double roundedDown = Math.floor(squareRoot);
        if ((squareRoot - roundedDown) == 0) {
            return true;
        } else {
            return false;
        }
    }
}
