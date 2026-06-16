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
public class QuickSort {

    /**
     * Public method to start the sorting process with validation.
     *
     * @param array The target array to sort.
     * @param order The sorting direction (ASCENDING or DESCENDING).
     */
    public void sort(int[] array, SortOrder order) {
        if (array == null || array.length <= 1) {
            return;
        }
        quickSort(array, 0, array.length - 1, order);
    }

    /**
     * Internal recursive algorithm driven by SortOrder enum.
     *
     * @param array The target array to sort.
     * @param left The starting index of the partition.
     * @param right The ending index of the partition.
     * @param order The sorting direction (ASCENDING or DESCENDING).
     */
    private void quickSort(int[] array, int left, int right, SortOrder order) {
        if (left >= right) {
            return;
        }

        int i = left;
        int j = right;
        int pivot = array[(left + right) / 2];

        while (i <= j) {
            if (order == SortOrder.ASCENDING) {
                while (array[i] < pivot) {
                    i++;
                }
                while (array[j] > pivot) {
                    j--;
                }
            } else if (order == SortOrder.DESCENDING) {
                while (array[i] > pivot) {
                    i++;
                }
                while (array[j] < pivot) {
                    j--;
                }
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (left < j) {
            quickSort(array, left, j, order);
        }
        if (i < right) {
            quickSort(array, i, right, order);
        }
    }
}
