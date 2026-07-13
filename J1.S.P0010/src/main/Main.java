package main;

import array.ArrayHandler;
import constant.ConfigConstants;
import constant.MessageConstants;
import java.util.Arrays;
import service.SearchService;
import util.InputValidator;

/**
 * Main execution class for the Linear Search program.
 * 
 * @author admin
 */
public class Main {

    /**
     * Main method that drives the program.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        ArrayHandler arrayHandler = new ArrayHandler();
        SearchService searchService = new SearchService();

        int arraySize = InputValidator.getInteger(
                MessageConstants.PROMPT_ARRAY_SIZE,
                ConfigConstants.RANGE_MIN,
                ConfigConstants.RANGE_MAX,
                MessageConstants.ERROR_SIZE_OUT_OF_BOUNDS,
                MessageConstants.ERROR_INVALID_FORMAT
        );

        int searchValue = InputValidator.getInteger(
                MessageConstants.PROMPT_SEARCH_VALUE,
                ConfigConstants.RANGE_MIN,
                ConfigConstants.RANGE_MAX,
                MessageConstants.ERROR_VALUE_OUT_OF_BOUNDS,
                MessageConstants.ERROR_INVALID_FORMAT
        );

        int[] randomArray = arrayHandler.generateRandomArray(arraySize);

        System.out.println(MessageConstants.DISPLAY_ARRAY_PREFIX + Arrays.toString(randomArray));

        int[] foundIndices = searchService.findAllValuePositions(randomArray, searchValue);

        if (foundIndices.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < foundIndices.length; i++) {
                sb.append(foundIndices[i]);
                if (i < foundIndices.length - 1) {
                    sb.append(", ");
                }
            }
            if (foundIndices.length == 1) {
                System.out.println(MessageConstants.DISPLAY_FOUND_PREFIX + searchValue
                        + MessageConstants.DISPLAY_FOUND_INDEX + sb.toString());
            } else {
                System.out.println(MessageConstants.DISPLAY_FOUND_PREFIX + searchValue
                        + MessageConstants.DISPLAY_FOUND_INDICES + sb.toString());
            }
        } else {
            System.out.println(MessageConstants.DISPLAY_FOUND_PREFIX + searchValue
                    + MessageConstants.DISPLAY_NOT_FOUND_SUFFIX);
        }
    }
}
