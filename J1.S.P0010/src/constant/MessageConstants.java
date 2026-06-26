/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constant;

/**
 *
 * @author admin
 */
public class MessageConstants {

    public static final String PROMPT_ARRAY_SIZE = "Enter number of array:";
    public static final String PROMPT_SEARCH_VALUE = "Enter search value:";
    public static final String ERROR_INVALID_FORMAT = "Error: Invalid number format!";
    public static final String ERROR_SIZE_OUT_OF_BOUNDS = "Error: Array size must be a positive number greater than 0!";
    public static final String ERROR_VALUE_OUT_OF_BOUNDS = "Error: Search value must be a positive number greater than 0!";
    public static final String DISPLAY_ARRAY_PREFIX = "The array: ";
    public static final String DISPLAY_FOUND_PREFIX = "Found ";
    public static final String DISPLAY_FOUND_SUFFIX = " at indices: ";
    public static final String DISPLAY_NOT_FOUND_SUFFIX = " does not exist in the array.";

    private MessageConstants() {
        throw new AssertionError("Constant class should not be instantiated.");
    }
}
