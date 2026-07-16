package helper;

import java.util.Random;

/**
 * Utility class for array operations including
 * random generation.
 */
public class ArrayUtils {

    private final Random random = new Random();

    /**
     * Generates an array with random values
     * from 0 to size.
     *
     * @param size The number of elements
     *             in the array.
     * @return A random integer array.
     */
    public int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size + 1);
        }
        return array;
    }
}
