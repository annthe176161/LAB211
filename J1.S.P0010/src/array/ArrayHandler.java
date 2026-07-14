package array;

import java.util.Random;

/**
 * Handles random array generation.
 *
 * @author admin
 */
public class ArrayHandler {

    private static final Random RANDOM =
            new Random();

    /**
     * Generates an array of random integers.
     *
     * @param size number of elements (> 0)
     * @return random integer array
     */
    public int[] generateRandomArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(
                    "Size must be greater than 0");
        }
        final int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = RANDOM.nextInt(size + 1);
        }
        return array;
    }
}
