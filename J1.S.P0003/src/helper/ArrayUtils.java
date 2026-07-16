package helper;

import java.util.Random;

/**
 * Utility class for common array operations.
 *
 * <p>Provides methods to generate random arrays.</p>
 */
public class ArrayUtils {

    private final Random random = new Random();

    /**
     * Generates an array of the given size with random
     * integer values in the range [0, size].
     *
     * @param size The number of elements in the array.
     * @return A new array filled with random integers.
     */
    public int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size + 1);
        }
        return array;
    }
}
