package controller;

import constant.MenuConstant;
import service.EquationSolver;
import ui.ConsoleView;

import java.util.List;

/**
 * Controller for equation solving application.
 */
public class EquationController {

    private ConsoleView view = new ConsoleView();
    private EquationSolver solver = new EquationSolver();

    /**
     * Controls the main application loop
     * and menu selection.
     */
    public void run() {
        while (true) {
            view.displayMenu();
            String choice = view.getUserInput(
                    "Please choice one option: ");

            if (choice.equals(
                    MenuConstant.OPTION_SUPERLATIVE)) {
                handleSuperlative();
            } else if (choice.equals(
                    MenuConstant.OPTION_QUADRATIC)) {
                handleQuadratic();
            } else if (choice.equals(
                    MenuConstant.OPTION_EXIT)) {
                break;
            } else {
                view.displayInvalidOption();
            }
        }
    }

    /**
     * Gets a valid float input from user.
     *
     * @param prompt message to display
     * @return a valid float value
     */
    private float inputFloat(String prompt) {
        while (true) {
            String input = view.getUserInput(prompt);
            Float validNumber = solver.validateFloat(input);

            if (validNumber != null) {
                return validNumber;
            } else {
                view.displayInvalidNumber();
            }
        }
    }

    /**
     * Displays properties of the number list.
     *
     * @param allNumbers list of numbers to classify
     */
    private void showProperties(List<Float> allNumbers) {
        List<Float> oddList =
                solver.getOddNumbers(allNumbers);
        List<Float> evenList =
                solver.getEvenNumbers(allNumbers);
        List<Float> squareList =
                solver.getPerfectSquares(allNumbers);
        view.displayProperties(
                oddList, evenList, squareList);
    }

    /**
     * Pipelines the execution for linear
     * (superlative) equation.
     */
    private void handleSuperlative() {
        view.displaySuperlativeHeader();
        float a = inputFloat("Enter A: ");
        float b = inputFloat("Enter B: ");

        List<Float> solutions =
                solver.calculateEquation(a, b);
        view.displaySolutions(solutions);

        List<Float> allNumbers =
                solver.collectAllNumbers(
                        a, b, solutions);
        showProperties(allNumbers);
    }

    /**
     * Pipelines the execution for quadratic equation.
     */
    private void handleQuadratic() {
        view.displayQuadraticHeader();
        float a = inputFloat("Enter A: ");
        float b = inputFloat("Enter B: ");
        float c = inputFloat("Enter C: ");

        List<Float> solutions =
                solver.calculateQuadraticEquation(
                        a, b, c);
        view.displaySolutions(solutions);

        List<Float> allNumbers =
                solver.collectAllNumbers(
                        a, b, c, solutions);
        showProperties(allNumbers);
    }
}
