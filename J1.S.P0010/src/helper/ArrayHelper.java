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
public class ArrayHelper {

    private static final Random RANDOM = new Random();

    /**
     * Generates an array with random integers from 0 to size.
     *
     * @param size the length of the array
     * @return a randomized integer array
     */
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = RANDOM.nextInt(size + 1);
        }
        return array;
    }

    /**
     * Prints the array using StringBuilder for loop optimization.
     *
     * @param array the array to display
     */
    public static void displayArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("The array: [");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
