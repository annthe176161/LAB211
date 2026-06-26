/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package array;

import java.util.Random;

/**
 *
 * @author admin
 */
public class ArrayHandler {

    private static final Random RANDOM = new Random();

    /**
     * Generates an int array with random numbers.
     *
     * @param size the number of elements to generate
     * @return an array filled with random integers
     */
    public int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = RANDOM.nextInt(size + 1);
        }
        return array;
    }
}
