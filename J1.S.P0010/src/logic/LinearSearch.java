/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class LinearSearch {

    /**
     * Finds all indices where the search value appears in the array.
     *
     * @param array the source array
     * @param value the value to search for
     * @return a list of found indices
     */
    public List<Integer> findAllValueIndices(int[] array, int value) {
        List<Integer> foundIndices = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                foundIndices.add(i);
            }
        }
        return foundIndices;
    }
}
