package array;

import java.util.Random;

/**
 * Class for handling array generation.
 * 
 * @author admin
 */
public class ArrayHandler {

    private static final Random RANDOM = new Random();

    /**
     * Generates an array with random integers.
     *
     * @param size the number of elements in the array
     * @return an array of random integers
     */
    public int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = RANDOM.nextInt(size + 1);
        }
        return array;
    }
}
