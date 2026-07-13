package service;

/**
 * Service class for searching operations on arrays.
 * 
 * @author admin
 */
public class SearchService {

    /**
     * Finds all index positions of a search value in an array.
     *
     * @param array the array to search
     * @param searchValue the value to search for
     * @return an array of indices where the search value is found
     */
    public int[] findAllValuePositions(int[] array, int searchValue) {
        if (array == null || array.length == 0) {
            return new int[0];
        }

        int count = 0;
        for (int num : array) {
            if (num == searchValue) {
                count++;
            }
        }

        int[] resultIndices = new int[count];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchValue) {
                resultIndices[index++] = i;
            }
        }

        return resultIndices;
    }
}
