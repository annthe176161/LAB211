package service;

import java.util.ArrayList;
import java.util.List;

/**
 * Solver for linear and quadratic equations.
 */
public class EquationSolver {

    /**
     * Solves a superlative equation: ax + b = 0.
     *
     * @param a coefficient A
     * @param b coefficient B
     * @return list of solutions, null if no solution,
     *         empty if infinitely many solutions
     */
    public List<Float> calculateEquation(float a, float b) {
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
            List<Float> result = calculateEquation(b, c);
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
}
