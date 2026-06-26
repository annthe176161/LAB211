/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author admin
 */
public class SearchService {

    /**
     * Finds all index positions of a specific value in an array.
     *
     * @param array the target array to search
     * @param searchValue the number to look for
     * @return an array of all found indices, or an empty array if not found
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
