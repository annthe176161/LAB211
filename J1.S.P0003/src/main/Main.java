package main;

import algorithm.InsertionSort;
import constant.AppConstants;
import enums.SortOrder;
import helper.ArrayUtils;
import java.util.Arrays;
import util.InputUtils;

/**
 * Entry point of the Insertion Sort program.
 *
 * <p>Prompts the user for array size, generates a random
 * array, then displays the array before and after sorting
 * using the Insertion Sort algorithm.</p>
 */
public class Main {

    /**
     * Main method - program entry.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        int size = InputUtils.getInteger(
                "Enter number of array:\n",
                AppConstants.MIN_SIZE,
                AppConstants.MAX_SIZE,
                "Error: Number must be "
                        + "a positive decimal number!",
                "Error: Input must be "
                        + "a valid integer!"
        );

        ArrayUtils arrayUtils = new ArrayUtils();
        InsertionSort sorter = new InsertionSort();

        int[] array = arrayUtils.generateRandomArray(size);
        System.out.println(
                "Unsorted array: " + Arrays.toString(array)
        );

        sorter.sort(array, SortOrder.ASCENDING);
        System.out.println(
                "Sorted array (Ascending): "
                        + Arrays.toString(array)
        );

        sorter.sort(array, SortOrder.DESCENDING);
        System.out.println(
                "Sorted array (Descending): "
                        + Arrays.toString(array)
        );
    }
}
