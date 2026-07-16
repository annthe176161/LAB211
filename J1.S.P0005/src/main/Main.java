package main;

import algorithm.MergeSort;
import constant.AppConstants;
import enums.SortOrder;
import helper.ArrayUtils;
import java.util.Arrays;
import util.InputUtils;

/**
 * Main entry point for the Merge Sort application.
 * Handles user input, array generation, and
 * displays sorted results.
 */
public class Main {

    /**
     * Runs the program: prompts user for array size,
     * generates a random array, and displays the
     * sorted result using Merge Sort.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        int size = InputUtils.getInteger(
                "Enter number of array:\n",
                AppConstants.MIN_SIZE,
                AppConstants.MAX_SIZE,
                "Error: Number must be a positive decimal number!",
                "Error: Input must be a valid integer!"
        );

        ArrayUtils arrayUtils = new ArrayUtils();
        MergeSort sorter = new MergeSort();

        int[] array = arrayUtils.generateRandomArray(size);
        System.out.println(
                "Unsorted array: "
                        + Arrays.toString(array));

        sorter.sort(array, SortOrder.ASCENDING);
        System.out.println(
                "Sorted array (Ascending): "
                        + Arrays.toString(array));

        sorter.sort(array, SortOrder.DESCENDING);
        System.out.println(
                "Sorted array (Descending): "
                        + Arrays.toString(array));
    }
}
