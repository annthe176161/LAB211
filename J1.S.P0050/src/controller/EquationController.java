package controller;

import constant.MenuConstant;
import service.EquationSolver;
import ui.ConsoleView;

import java.util.ArrayList;
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
                System.out.println(
                        "Invalid option."
                        + " Please choose 1, 2, or 3.");
            }
        }
    }

    /**
     * Pipelines the execution for linear
     * (superlative) equation.
     */
    private void handleSuperlative() {
        System.out.println(
                "----- Calculate Equation -----");
        float a = view.inputFloat("Enter A: ");
        float b = view.inputFloat("Enter B: ");

        List<Float> solutions =
                solver.calculateEquation(a, b);
        view.displaySolutions(solutions);

        List<Float> allNumbers =
                new ArrayList<Float>();
        allNumbers.add(a);
        allNumbers.add(b);
        if (solutions != null
                && !solutions.isEmpty()) {
            allNumbers.addAll(solutions);
        }

        view.displayProperties(allNumbers);
    }

    /**
     * Pipelines the execution for quadratic equation.
     */
    private void handleQuadratic() {
        System.out.println(
                "----- Calculate Quadratic Equation -----");
        float a = view.inputFloat("Enter A: ");
        float b = view.inputFloat("Enter B: ");
        float c = view.inputFloat("Enter C: ");

        List<Float> solutions =
                solver.calculateQuadraticEquation(
                        a, b, c);
        view.displaySolutions(solutions);

        List<Float> allNumbers =
                new ArrayList<Float>();
        allNumbers.add(a);
        allNumbers.add(b);
        allNumbers.add(c);
        if (solutions != null
                && !solutions.isEmpty()) {
            allNumbers.addAll(solutions);
        }

        view.displayProperties(allNumbers);
    }
}
