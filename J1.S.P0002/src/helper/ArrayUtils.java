/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.util.Random;

/**
 *
 * @author admin
 */
public class ArrayUtils {

    private final Random random = new Random();

    /**
     * Generates an array with random values from 0 to size.
     *
     * * @param size The number of elements in the array.
     * @return A random integer array.
     */
    public int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size + 1);
        }
        return array;
    }

    /**
     * Prints the array in standard format [1, 2, 3].
     *
     * @param label The text to display before the array.
     * @param array The target array to print.
     */
    public void displayArray(String label, int[] array) {
        StringBuilder sb = new StringBuilder(label);
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i != array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
