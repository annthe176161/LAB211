package main;

import array.ArrayHandler;
import constant.ConfigConstants;
import constant.MessageConstants;
import java.util.Arrays;
import service.SearchService;
import util.InputValidator;

/**
 * Main class for the Linear Search program.
 *
 * @author admin
 */
public class Main {

    /**
     * Program entry point.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        final ArrayHandler arrayHandler =
                new ArrayHandler();
        final SearchService searchService =
                new SearchService();

        final int arraySize =
                InputValidator.getInteger(
                        MessageConstants.PROMPT_ARRAY_SIZE,
                        ConfigConstants.RANGE_MIN,
                        ConfigConstants.RANGE_MAX,
                        MessageConstants
                                .ERROR_SIZE_OUT_OF_BOUNDS,
                        MessageConstants
                                .ERROR_INVALID_FORMAT);

        final int searchValue =
                InputValidator.getInteger(
                        MessageConstants.PROMPT_SEARCH_VALUE,
                        ConfigConstants.RANGE_MIN,
                        ConfigConstants.RANGE_MAX,
                        MessageConstants
                                .ERROR_VALUE_OUT_OF_BOUNDS,
                        MessageConstants
                                .ERROR_INVALID_FORMAT);

        final int[] randomArray =
                arrayHandler.generateRandomArray(
                        arraySize);
        System.out.println(
                MessageConstants.DISPLAY_ARRAY_PREFIX
                        + Arrays.toString(randomArray));

        final int[] foundIndices =
                searchService.findAllValuePositions(
                        randomArray, searchValue);
        displaySearchResult(searchValue, foundIndices);
    }

    /**
     * Converts an array of indices to a
     * comma-separated string.
     *
     * @param indices array of indices
     * @return formatted string (e.g. "0, 2, 5")
     */
    private static String formatIndices(
            int[] indices) {
        final StringBuilder indexBuilder =
                new StringBuilder();
        for (int i = 0; i < indices.length; i++) {
            indexBuilder.append(indices[i]);
            if (i < indices.length - 1) {
                indexBuilder.append(", ");
            }
        }
        return indexBuilder.toString();
    }

    /**
     * Prints the search result to the console.
     *
     * @param searchValue value being searched
     * @param foundIndices indices where found
     */
    private static void displaySearchResult(
            int searchValue, int[] foundIndices) {
        if (foundIndices.length > 0) {
            final String formattedIndices =
                    formatIndices(foundIndices);
            final String suffix =
                    foundIndices.length == 1
                            ? MessageConstants
                                    .DISPLAY_FOUND_INDEX
                            : MessageConstants
                                    .DISPLAY_FOUND_INDICES;
            System.out.println(
                    MessageConstants.DISPLAY_FOUND_PREFIX
                            + searchValue + suffix
                            + formattedIndices);
        } else {
            System.out.println(
                    MessageConstants.DISPLAY_FOUND_PREFIX
                            + searchValue
                            + MessageConstants
                                    .DISPLAY_NOT_FOUND_SUFFIX);
        }
    }
}
