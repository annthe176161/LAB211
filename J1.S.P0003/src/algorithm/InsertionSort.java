package algorithm;

import enums.SortOrder;

/**
 * Implements the Insertion Sort algorithm.
 *
 * <p>Insertion sort divides the array into a sorted part
 * and an unsorted part. At each iteration, it picks the
 * first element from the unsorted part and inserts it into
 * the correct position in the sorted part.</p>
 *
 * <p>Time complexity: O(n^2) in the worst and average cases,
 * O(n) in the best case (already sorted).</p>
 */
public class InsertionSort {

    /**
     * Sorts the given array in the specified order
     * using the Insertion Sort algorithm.
     *
     * @param array The array to be sorted.
     * @param order The sorting direction
     *              (ASCENDING or DESCENDING).
     */
    public void sort(int[] array, SortOrder order) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && shouldShift(
                    array[j], key, order)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    /**
     * Determines whether the current element should be
     * shifted to the right based on the sort order.
     *
     * @param current The current element in the sorted part.
     * @param key     The element to be inserted.
     * @param order   The sorting direction.
     * @return {@code true} if the element should be shifted;
     *         {@code false} otherwise.
     */
    private boolean shouldShift(
            int current, int key, SortOrder order) {
        if (order == SortOrder.ASCENDING) {
            return current > key;
        }
        return current < key;
    }
}
