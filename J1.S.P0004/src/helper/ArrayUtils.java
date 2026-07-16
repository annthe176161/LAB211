package helper;

import java.util.Random;

/**
 * Provides utility methods for array operations
 * including random generation.
 */
public class ArrayUtils {

    private final Random random = new Random();

    /**
     * Generates an array with random integer values
     * in the range from 0 to the given size.
     *
     * @param size The number of elements in the array.
     * @return A randomly generated integer array.
     */
    public int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size + 1);
        }
        return array;
    }
}
