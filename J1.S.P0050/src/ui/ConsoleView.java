package ui;

import java.util.List;
import java.util.Scanner;

/**
 * Console view for user interaction.
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
     * Displays invalid number error message.
     */
    public void displayInvalidNumber() {
        System.out.println("Please input number");
    }

    /**
     * Displays the main program menu options.
     */
    public void displayMenu() {
        System.out.println(
                "========= Equation Program =========");
        System.out.println(
                "1. Calculate Superlative Equation");
        System.out.println(
                "2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
    }

    /**
     * Displays the superlative equation header.
     */
    public void displaySuperlativeHeader() {
        System.out.println(
                "----- Calculate Equation -----");
    }

    /**
     * Displays the quadratic equation header.
     */
    public void displayQuadraticHeader() {
        System.out.println(
                "----- Calculate Quadratic Equation -----");
    }

    /**
     * Displays an invalid option error message.
     */
    public void displayInvalidOption() {
        System.out.println(
                "Invalid option."
                + " Please choose 1, 2, or 3.");
    }

    /**
     * Displays the calculated solutions.
     *
     * @param solutions list of equation answers
     */
    public void displaySolutions(List<Float> solutions) {
        if (solutions == null) {
            System.out.println("Solution: No solution");
        } else if (solutions.isEmpty()) {
            System.out.println(
                    "Solution: Infinitely many solutions");
        } else if (solutions.size() == 1) {
            float x = solutions.get(0);
            System.out.printf(
                    "Solution: x = %.3f\n", x);
        } else {
            float x1 = solutions.get(0);
            float x2 = solutions.get(1);
            System.out.printf(
                    "Solution: x1 = %.3f"
                    + " and x2 = %.3f\n", x1, x2);
        }
    }

    /**
     * Displays odd, even and perfect square numbers.
     *
     * @param oddList list of odd numbers
     * @param evenList list of even numbers
     * @param squareList list of perfect square numbers
     */
    public void displayProperties(
            List<Float> oddList,
            List<Float> evenList,
            List<Float> squareList) {
        System.out.print("Number is Odd: ");
        printFormattedList(oddList);

        System.out.print("Number is Even: ");
        printFormattedList(evenList);

        System.out.print("Number is Perfect Square: ");
        printFormattedList(squareList);
    }

    /**
     * Prints list elements separated by commas.
     *
     * @param list the list of elements to display
     */
    private void printFormattedList(List<Float> list) {
        if (list.isEmpty()) {
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
