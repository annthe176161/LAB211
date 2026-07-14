package ui;

import common.InputHandler;
import entity.Operator;
import exception.DivisionByZeroException;
import exception.InvalidOperatorException;
import service.Calculator;

/**
 * UI logic for normal calculator.
 */
public class NormalCalculator {

    private final Calculator calculator = new Calculator();

    /**
     * Runs the normal calculator flow.
     */
    public void performCalculation() {
        System.out.println(
                "----- Normal Calculator -----");
        double memory = InputHandler.readDouble(
                "Enter number: ",
                "Error: Digit only!");

        while (true) {
            Operator op = InputHandler.readOperator(
                    "Enter Operator: ",
                    "Please input (+, -, *, /, ^)");

            if (op == Operator.EQUAL) {
                System.out.println(
                        "Result: " + memory);
                break;
            }

            try {
                double nextNum = InputHandler.readDouble(
                        "Enter number: ",
                        "Error: Digit only!");
                memory = calculator.calculate(
                        memory, op, nextNum);
                System.out.println(
                        "Memory: " + memory);
            } catch (DivisionByZeroException
                     | InvalidOperatorException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
