/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import helper.ArrayHelper;
import java.util.List;
import logic.LinearSearch;
import util.InputUtils;

/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) {
        // 1. Get array size from user
        int size = InputUtils.getInt(
                "Enter number of array: ",
                1,
                Integer.MAX_VALUE,
                "Error: Out of range!",
                "Error: Invalid format!"
        );

        // 2. Get value to search from user
        int searchValue = InputUtils.getInt(
                "Enter search value: ",
                Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                "Error: Out of range!",
                "Error: Invalid format!"
        );

        // 3. Generate and display random array (Using the new helper package)
        int[] randomArray = ArrayHelper.generateRandomArray(size);
        ArrayHelper.displayArray(randomArray);

        // 4. Perform search and gather all found indices
        LinearSearch searcher = new LinearSearch();
        List<Integer> foundIndices = searcher.findAllValueIndices(randomArray, searchValue);

        // 5. Display the result
        if (!foundIndices.isEmpty()) {
            System.out.println("Found " + searchValue + " at indices: " + foundIndices.toString());
        } else {
            System.out.println("Value " + searchValue + " does not exist in the array.");
        }
    }
}
