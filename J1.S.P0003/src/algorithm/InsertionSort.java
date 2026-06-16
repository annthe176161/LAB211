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
public class InsertionSort {

    /**
     * Sorts an array using optimized Insertion Sort.
     *
     * @param array The target array to sort.
     * @param order The sorting direction (ASCENDING or DESCENDING).
     */
    public void sort(int[] array, SortOrder order) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0) {
                boolean shouldShift = false;
                if (order == SortOrder.ASCENDING) {
                    if (array[j] > key) {
                        shouldShift = true;
                    }
                } else if (order == SortOrder.DESCENDING) {
                    if (array[j] < key) {
                        shouldShift = true;
                    }
                }
                if (shouldShift) {
                    array[j + 1] = array[j];
                    j = j - 1;
                } else {
                    break;
                }
            }
            array[j + 1] = key;
        }
    }
}
