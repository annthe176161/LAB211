/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.EquationSolver;
import java.util.ArrayList;
import java.util.List;
import ui.ConsoleView;

/**
 *
 * @author admin
 */
public class EquationController {

    public static final String OPTION_SUPERLATIVE = "1";
    public static final String OPTION_QUADRATIC = "2";
    public static final String OPTION_EXIT = "3";

    private ConsoleView view = new ConsoleView();
    private EquationSolver solver = new EquationSolver();

    /**
     * Controls the main application loop and menu selection.
     */
    public void run() {
        while (true) {
            view.displayMenu();
            String choice = view.getUserInput("Please choice one option: ");

            if (choice.equals(OPTION_SUPERLATIVE) == true) {
                handleSuperlative();
            } else if (choice.equals(OPTION_QUADRATIC) == true) {
                handleQuadratic();
            } else if (choice.equals(OPTION_EXIT) == true) {
                break;
            } else {
                System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }
    }

    /**
     * Pipelines the execution for linear (superlative) equation.
     */
    private void handleSuperlative() {
        System.out.println("----- Calculate Equation -----");
        float a = view.inputFloat("Enter A: ");
        float b = view.inputFloat("Enter B: ");

        List<Float> solutions = solver.calculateEquation(a, b);
        view.displaySolutions(solutions);

        List<Float> allNumbers = new ArrayList<Float>();
        allNumbers.add(a);
        allNumbers.add(b);
        if (solutions != null && solutions.isEmpty() == false) {
            allNumbers.addAll(solutions);
        }

        view.displayProperties(allNumbers);
    }

    /**
     * Pipelines the execution for quadratic equation.
     */
    private void handleQuadratic() {
        System.out.println("----- Calculate Quadratic Equation -----");
        float a = view.inputFloat("Enter A: ");
        float b = view.inputFloat("Enter B: ");
        float c = view.inputFloat("Enter C: ");

        List<Float> solutions = solver.calculateQuadraticEquation(a, b, c);
        view.displaySolutions(solutions);

        List<Float> allNumbers = new ArrayList<Float>();
        allNumbers.add(a);
        allNumbers.add(b);
        allNumbers.add(c);
        if (solutions != null && solutions.isEmpty() == false) {
            allNumbers.addAll(solutions);
        }

        view.displayProperties(allNumbers);
    }
}
