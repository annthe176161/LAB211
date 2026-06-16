/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import algorithm.MergeSort;
import constant.AppConstants;
import enums.SortOrder;
import helper.ArrayUtils;
import util.InputUtils;

/**
 *
 * @author admin
 */
public class Main {

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
        arrayUtils.displayArray("Unsorted array: ", array);

        sorter.sort(array, SortOrder.ASCENDING);
        arrayUtils.displayArray("Sorted array (Ascending): ", array);

        sorter.sort(array, SortOrder.DESCENDING);
        arrayUtils.displayArray("Sorted array (Descending): ", array);
    }
}
