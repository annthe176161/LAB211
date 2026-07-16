package helper;

import java.util.Random;

/**
 *
 * @author admin
 */
public class ArrayUtils {

    private final Random random = new Random();

    /**
     * Generates an array with random values
     * from 0 to size.
     *
     * @param size the number of elements
     * @return a random integer array
     */
    public int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size + 1);
        }
        return array;
    }
}
