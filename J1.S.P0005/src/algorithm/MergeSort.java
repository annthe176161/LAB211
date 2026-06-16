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
public class MergeSort {

    /**
     * Public method to start the sorting process with safety validation.
     *
     * @param array The target array to sort.
     * @param order The sorting direction (ASCENDING or DESCENDING).
     */
    public void sort(int[] array, SortOrder order) {
        if (array == null || array.length <= 1) {
            return;
        }
        mergeSort(array, 0, array.length - 1, order);
    }

    /**
     * Internal recursive method to divide the array.
     *
     * @param array The target array.
     * @param left The starting index of the segment.
     * @param right The ending index of the segment.
     * @param order The sorting direction (ASCENDING or DESCENDING).
     */
    private void mergeSort(int[] array, int left, int right, SortOrder order) {
        if (left >= right) {
            return;
        }

        int middle = (left + right) / 2;

        mergeSort(array, left, middle, order);
        mergeSort(array, middle + 1, right, order);

        merge(array, left, middle, right, order);
    }

    /**
     * Internal helper method to merge two sorted segments using clean
     * structures.
     *
     * @param array The target array.
     * @param left The starting index of the left segment.
     * @param middle The ending index of the left segment.
     * @param right The ending index of the right segment.
     * @param order The sorting direction (ASCENDING or DESCENDING).
     */
    private void merge(int[] array, int left, int middle, int right, SortOrder order) {
        int size = right - left + 1;
        int[] temp = new int[size];

        int i = left;
        int j = middle + 1;
        int k = 0;

        while (i <= middle && j <= right) {
            boolean chooseLeft = false;

            if (order == SortOrder.ASCENDING) {
                if (array[i] <= array[j]) {
                    chooseLeft = true;
                }
            } else if (order == SortOrder.DESCENDING) {
                if (array[i] >= array[j]) {
                    chooseLeft = true;
                }
            }

            if (chooseLeft) {
                temp[k] = array[i];
                i++;
            } else {
                temp[k] = array[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            temp[k] = array[i];
            i++;
            k++;
        }

        while (j <= right) {
            temp[k] = array[j];
            j++;
            k++;
        }

        for (int m = 0; m < size; m++) {
            array[left + m] = temp[m];
        }
    }
}
