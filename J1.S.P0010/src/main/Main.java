/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import array.ArrayHandler;
import constant.ConfigConstants;
import constant.MessageConstants;
import java.util.Arrays;
import service.SearchService;
import ui.InputValidator;

/**
 *
 * @author admin
 */
public class Main {

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
            System.out.println(MessageConstants.DISPLAY_FOUND_PREFIX + searchValue
                    + MessageConstants.DISPLAY_FOUND_SUFFIX + Arrays.toString(foundIndices));
        } else {
            System.out.println(MessageConstants.DISPLAY_FOUND_PREFIX + searchValue
                    + MessageConstants.DISPLAY_NOT_FOUND_SUFFIX);
        }
    }
}
