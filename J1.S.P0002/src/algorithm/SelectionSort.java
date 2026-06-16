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
public class SelectionSort {

    /**
     * Sorts an array using Selection Sort based on enum selection.
     *
     * @param array The target array to sort.
     * @param order The sorting direction (ASCENDING or DESCENDING).
     */
    public void sort(int[] array, SortOrder order) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int targetIndex = i;
            for (int j = i + 1; j < n; j++) {
                boolean conditionMet = false;
                if (order == SortOrder.ASCENDING) {
                    if (array[j] < array[targetIndex]) {
                        conditionMet = true;
                    }
                } else if (order == SortOrder.DESCENDING) {
                    if (array[j] > array[targetIndex]) {
                        conditionMet = true;
                    }
                }
                if (conditionMet) {
                    targetIndex = j;
                }
            }
            if (targetIndex != i) {
                int temp = array[targetIndex];
                array[targetIndex] = array[i];
                array[i] = temp;
            }
        }
    }
}
