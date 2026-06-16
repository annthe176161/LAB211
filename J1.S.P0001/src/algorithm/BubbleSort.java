/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithm;

import enums.SortOrder;

/**
 *
 * @author admin
 */
public class BubbleSort {

    /**
     * Sorts an array using optimized Bubble Sort.
     *
     * @param array The target array to sort.
     * @param order The sorting direction (ASCENDING or DESCENDING).
     */
    public void sort(int[] array, SortOrder order) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                boolean shouldSwap = false;

                if (order == SortOrder.ASCENDING) {
                    if (array[j] > array[j + 1]) {
                        shouldSwap = true;
                    }
                } else if (order == SortOrder.DESCENDING) {
                    if (array[j] < array[j + 1]) {
                        shouldSwap = true;
                    }
                }

                if (shouldSwap) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (swapped == false) {
                break;
            }
        }
    }
}
