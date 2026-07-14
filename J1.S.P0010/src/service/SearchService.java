package service;

/**
 * Provides linear search operations on arrays.
 *
 * @author admin
 */
public class SearchService {

    /**
     * Finds all indices of a value in an array.
     *
     * @param array the array to search
     * @param searchValue value to find
     * @return array of matching indices
     */
    public int[] findAllValuePositions(
            int[] array, int searchValue) {
        if (array == null || array.length == 0) {
            return new int[0];
        }

        int count = 0;
        for (int num : array) {
            if (num == searchValue) {
                count++;
            }
        }

        final int[] resultIndices =
                new int[count];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchValue) {
                resultIndices[index++] = i;
            }
        }

        return resultIndices;
    }
}
