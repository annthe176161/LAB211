package algorithm;

import enums.SortOrder;

/**
 * Provides Selection Sort algorithm
 * for sorting integer arrays.
 *
 * @author admin
 */
public class SelectionSort {

    /**
     * Sorts an array using Selection Sort
     * based on the given sort order.
     *
     * @param array The target array to sort.
     * @param order The sorting direction
     *              (ASCENDING or DESCENDING).
     */
    public void sort(int[] array, SortOrder order) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int targetIndex = i;
            for (int j = i + 1; j < n; j++) {
                switch (order) {
                    case ASCENDING:
                        if (array[j]
                                < array[targetIndex]) {
                            targetIndex = j;
                        }
                        break;
                    case DESCENDING:
                        if (array[j]
                                > array[targetIndex]) {
                            targetIndex = j;
                        }
                        break;
                    default:
                        break;
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
