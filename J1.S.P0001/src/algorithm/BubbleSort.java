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
     * @param array the target array to sort
     * @param order the sorting direction
     */
    public void sort(int[] array, SortOrder order) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                boolean shouldSwap = false;

                switch (order) {
                    case ASCENDING -> {
                        if (array[j] > array[j + 1]) {
                            shouldSwap = true;
                        }
                    }
                    case DESCENDING -> {
                        if (array[j] < array[j + 1]) {
                            shouldSwap = true;
                        }
                    }
                }

                if (shouldSwap) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}
