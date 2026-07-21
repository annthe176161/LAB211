package service;

import common.NumberValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Solver for linear and quadratic equations.
 */
public class EquationSolver {

    private NumberValidator numberValidator =
            new NumberValidator();

    /**
     * Validates and parses a string into a Float.
     *
     * @param input the string to validate
     * @return the parsed Float, or null if invalid
     */
    public Float validateFloat(String input) {
        return numberValidator.checkIn(input);
    }

    /**
     * Solves a superlative equation: ax + b = 0.
     *
     * @param a coefficient A
     * @param b coefficient B
     * @return list of solutions, null if no solution,
     *         empty if infinitely many solutions
     */
    public List<Float> calculateEquation(
            float a, float b) {
        List<Float> solutions = new ArrayList<Float>();

        if (a == 0) {
            if (b == 0) {
                return solutions;
            } else {
                return null;
            }
        }

        float x = -b / a;
        solutions.add(x);
        return solutions;
    }

    /**
     * Collects coefficients and solutions into
     * a single list for property checking.
     *
     * @param a coefficient A
     * @param b coefficient B
     * @param solutions list of solutions
     * @return combined list of all numbers
     */
    public List<Float> collectAllNumbers(
            float a, float b, List<Float> solutions) {
        List<Float> allNumbers = new ArrayList<Float>();
        allNumbers.add(a);
        allNumbers.add(b);
        if (solutions != null && !solutions.isEmpty()) {
            allNumbers.addAll(solutions);
        }
        return allNumbers;
    }

    /**
     * Solves a quadratic equation: ax^2 + bx + c = 0.
     *
     * @param a coefficient A
     * @param b coefficient B
     * @param c coefficient C
     * @return list of solutions, null if no solution,
     *         empty if infinitely many solutions
     */
    public List<Float> calculateQuadraticEquation(
            float a, float b, float c) {
        if (a == 0) {
            List<Float> result =
                    calculateEquation(b, c);
            return result;
        }

        List<Float> solutions = new ArrayList<Float>();
        float delta = (b * b) - (4 * a * c);

        if (delta < 0) {
            return null;
        } else if (delta == 0) {
            float x = -b / (2 * a);
            solutions.add(x);
            solutions.add(x);
        } else {
            float x1 = (float) (
                    (-b + Math.sqrt(delta)) / (2 * a));
            float x2 = (float) (
                    (-b - Math.sqrt(delta)) / (2 * a));
            solutions.add(x1);
            solutions.add(x2);
        }

        return solutions;
    }

    /**
     * Collects coefficients and solutions into
     * a single list for property checking.
     *
     * @param a coefficient A
     * @param b coefficient B
     * @param c coefficient C
     * @param solutions list of solutions
     * @return combined list of all numbers
     */
    public List<Float> collectAllNumbers(
            float a, float b, float c,
            List<Float> solutions) {
        List<Float> allNumbers = new ArrayList<Float>();
        allNumbers.add(a);
        allNumbers.add(b);
        allNumbers.add(c);
        if (solutions != null && !solutions.isEmpty()) {
            allNumbers.addAll(solutions);
        }
        return allNumbers;
    }

    /**
     * Filters odd numbers from the list.
     *
     * @param numbers list of numbers to check
     * @return list of odd numbers
     */
    public List<Float> getOddNumbers(
            List<Float> numbers) {
        List<Float> result = new ArrayList<Float>();
        for (float num : numbers) {
            if (numberValidator.isOdd(num)) {
                result.add(num);
            }
        }
        return result;
    }

    /**
     * Filters even numbers from the list.
     *
     * @param numbers list of numbers to check
     * @return list of even numbers
     */
    public List<Float> getEvenNumbers(
            List<Float> numbers) {
        List<Float> result = new ArrayList<Float>();
        for (float num : numbers) {
            if (numberValidator.isEven(num)) {
                result.add(num);
            }
        }
        return result;
    }

    /**
     * Filters perfect square numbers from the list.
     *
     * @param numbers list of numbers to check
     * @return list of perfect square numbers
     */
    public List<Float> getPerfectSquares(
            List<Float> numbers) {
        List<Float> result = new ArrayList<Float>();
        for (float num : numbers) {
            if (numberValidator.isPerfectSquare(num)) {
                result.add(num);
            }
        }
        return result;
    }
}
