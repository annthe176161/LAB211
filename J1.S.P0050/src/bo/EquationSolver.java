/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class EquationSolver {

    /**
     * Solves a superlative equation: ax + b = 0.
     *
     * @param a coefficient A
     * @param b coefficient B
     * @return List of solutions (empty if infinitely many, null if no solution)
     */
    public List<Float> calculateEquation(float a, float b) {
        List<Float> solutions = new ArrayList<Float>();

        if (a == 0) {
            if (b == 0) {
                return solutions; // Infinitely many solutions
            } else {
                return null; // No solution
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
     * @return List of solutions (empty if infinitely many, null if no solution)
     */
    public List<Float> calculateQuadraticEquation(float a, float b, float c) {
        if (a == 0) {
            List<Float> result = calculateEquation(b, c);
            return result;
        }

        List<Float> solutions = new ArrayList<Float>();
        float delta = (b * b) - (4 * a * c);

        if (delta < 0) {
            return null; // No solution
        } else if (delta == 0) {
            float x = -b / (2 * a);
            solutions.add(x);
            solutions.add(x); // Display x1 = x2 as requested by UI format
        } else {
            float x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
            float x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
            solutions.add(x1);
            solutions.add(x2);
        }

        return solutions;
    }
}
