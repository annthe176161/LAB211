/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import common.NumberValidation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class ConsoleView {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Prompts user for an input string and returns it.
     *
     * @param prompt message to display
     * @return user input string
     */
    public String getUserInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        return input;
    }

    /**
     * Continuously prompts user until a valid float value is entered.
     *
     * @param prompt message to display
     * @return a valid float value
     */
    public float inputFloat(String prompt) {
        while (true) {
            System.out.print(prompt);
            String inputStr = scanner.nextLine();
            Float validNumber = NumberValidation.checkIn(inputStr);

            if (validNumber != null) {
                return validNumber;
            } else {
                System.out.println("Please input number");
            }
        }
    }

    /**
     * Displays the main program menu options.
     */
    public void displayMenu() {
        System.out.println("========= Equation Program =========");
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
    }

    /**
     * Displays the calculated solutions of the equations.
     *
     * @param solutions list containing the equation answers
     */
    public void displaySolutions(List<Float> solutions) {
        if (solutions == null) {
            System.out.println("Solution: No solution");
        } else if (solutions.isEmpty() == true) {
            System.out.println("Solution: Infinitely many solutions");
        } else if (solutions.size() == 1) {
            float x = solutions.get(0);
            System.out.printf("Solution: x = %.3f\n", x);
        } else {
            float x1 = solutions.get(0);
            float x2 = solutions.get(1);
            System.out.printf("Solution: x1 = %.3f and x2 = %.3f\n", x1, x2);
        }
    }

    /**
     * Groups and displays specific properties (odd, even, perfect square) from
     * the collected list.
     *
     * @param numbers combined list of inputs and roots
     */
    public void displayProperties(List<Float> numbers) {
        List<Float> oddList = new ArrayList<Float>();
        List<Float> evenList = new ArrayList<Float>();
        List<Float> squareList = new ArrayList<Float>();

        for (int i = 0; i < numbers.size(); i++) {
            float currentNumber = numbers.get(i);

            if (NumberValidation.isOdd(currentNumber) == true) {
                oddList.add(currentNumber);
            }
            if (NumberValidation.isEven(currentNumber) == true) {
                evenList.add(currentNumber);
            }
            if (NumberValidation.isPerfectSquare(currentNumber) == true) {
                squareList.add(currentNumber);
            }
        }

        System.out.print("Number is Odd: ");
        printFormattedList(oddList);

        System.out.print("Number is Even: ");
        printFormattedList(evenList);

        System.out.print("Number is Perfect Square: ");
        printFormattedList(squareList);
    }

    /**
     * Custom print format to display arrays of float without trailing square
     * brackets.
     *
     * @param list the list of elements to display
     */
    private void printFormattedList(List<Float> list) {
        if (list.isEmpty() == true) {
            System.out.println();
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
