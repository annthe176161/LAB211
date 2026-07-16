package main;

import algorithm.QuickSort;
import constant.AppConstants;
import enums.SortOrder;
import helper.ArrayUtils;
import java.util.Arrays;
import util.InputUtils;

/**
 * Entry point for Quick Sort program.
 * Prompts user for array size, generates random
 * array and displays sorted results.
 */
public class Main {

    /**
     * Main method to run the Quick Sort program.
     *
     * @param args Command line arguments.
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
        QuickSort sorter = new QuickSort();

        int[] array = arrayUtils
                .generateRandomArray(size);

        System.out.println(
                "Unsorted array: "
                        + Arrays.toString(array));

        int[] ascending = array.clone();
        sorter.sort(ascending, SortOrder.ASCENDING);
        System.out.println(
                "Sorted array (Ascending): "
                        + Arrays.toString(ascending));

        int[] descending = array.clone();
        sorter.sort(
                descending, SortOrder.DESCENDING);
        System.out.println(
                "Sorted array (Descending): "
                        + Arrays.toString(descending));
    }
}
