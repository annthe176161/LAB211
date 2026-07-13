package main;

import utils.FibonacciCalculator;

/**
 * Program entry point to calculate and display the Fibonacci sequence.
 */
public class Main {

    private static final int LIMIT = 45;

    /**
     * Main execution method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        FibonacciCalculator calculator = new FibonacciCalculator(LIMIT);

        System.out.println("The " + LIMIT + " sequence fibonacci:");

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < LIMIT; i++) {
            output.append(calculator.getTerm(i));

            if (i < LIMIT - 1) {
                output.append(", ");
            }
        }

        System.out.println(output.toString());
    }
}
