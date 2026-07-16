package main;

import algorithm.SelectionSort;
import constant.AppConstants;
import enums.SortOrder;
import helper.ArrayUtils;
import java.util.Arrays;
import util.InputUtils;

/**
 * Entry point for the Selection Sort program.
 *
 * @author admin
 */
public class Main {

    /**
     * Main method.
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
        SelectionSort sorter = new SelectionSort();

        int[] array = arrayUtils
                .generateRandomArray(size);
        System.out.println("Unsorted array: "
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
