package algorithm;

import enums.SortOrder;

/**
 * Provides Quick Sort algorithm implementation
 * with support for ascending and descending order.
 * Uses divide-and-conquer strategy with
 * middle-element pivot selection.
 */
public class QuickSort {

    /**
     * Sorts the given array using Quick Sort.
     * Performs null and length check before sorting.
     *
     * @param array The target array to sort.
     * @param order The sorting direction.
     */
    public void sort(int[] array, SortOrder order) {
        if (array == null || array.length <= 1) {
            return;
        }
        quickSort(array, 0,
                array.length - 1, order);
    }

    /**
     * Recursively partitions and sorts
     * the sub-array between left and right.
     *
     * @param array The target array to sort.
     * @param left  The starting index of partition.
     * @param right The ending index of partition.
     * @param order The sorting direction.
     */
    private void quickSort(int[] array, int left,
            int right, SortOrder order) {
        if (left >= right) {
            return;
        }

        int i = left;
        int j = right;
        int pivot = array[(left + right) / 2];

        while (i <= j) {
            switch (order) {
                case ASCENDING:
                    while (array[i] < pivot) {
                        i++;
                    }
                    while (array[j] > pivot) {
                        j--;
                    }
                    break;
                case DESCENDING:
                    while (array[i] > pivot) {
                        i++;
                    }
                    while (array[j] < pivot) {
                        j--;
                    }
                    break;
                default:
                    break;
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
