package entity;

import constant.DisplayMessages;
import constant.ShapeConstants;

/**
 * Represents a triangle with three side lengths.
 */
public class Triangle extends Shape {

    private double sideA;
    private double sideB;
    private double sideC;

    /**
     * Creates a triangle with default side lengths.
     */
    public Triangle() {
    }

    /**
     * Creates a triangle with the specified side lengths.
     *
     * @param sideA first side length
     * @param sideB second side length
     * @param sideC third side length
     * @throws IllegalArgumentException if sides do not form a valid triangle
     */
    public Triangle(double sideA, double sideB, double sideC) {
        if (!isValid(sideA, sideB, sideC)) {
            throw new IllegalArgumentException(
                    "Sides do not form a valid triangle.");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    /**
     * Gets the first side length.
     *
     * @return first side length
     */
    public double getSideA() {
        return sideA;
    }

    /**
     * Sets the first side length.
     *
     * @param sideA new first side length
     */
    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    /**
     * Gets the second side length.
     *
     * @return second side length
     */
    public double getSideB() {
        return sideB;
    }

    /**
     * Sets the second side length.
     *
     * @param sideB new second side length
     */
    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    /**
     * Gets the third side length.
     *
     * @return third side length
     */
    public double getSideC() {
        return sideC;
    }

    /**
     * Sets the third side length.
     *
     * @param sideC new third side length
     */
    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    /**
     * Validates if three side lengths can form a valid triangle.
     *
     * @param a side A
     * @param b side B
     * @param c side C
     * @return true if valid, false otherwise
     */
    public static boolean isValid(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    /**
     * Calculates the area of the triangle.
     *
     * @return area of the triangle
     */
    @Override
    public double getArea() {
        double s = getPerimeter() / ShapeConstants.TRIANGLE_HALF_DIVISOR;
        return Math.sqrt(s * (s - this.sideA) * (s - this.sideB)
                * (s - this.sideC));
    }

    /**
     * Calculates the perimeter of the triangle.
     *
     * @return perimeter of the triangle
     */
    @Override
    public double getPerimeter() {
        return this.sideA + this.sideB + this.sideC;
    }

    /**
     * Prints the triangle information.
     */
    @Override
    public void printResult() {
        System.out.println(DisplayMessages.TRIANGLE_HEADER);
        System.out.println(DisplayMessages.LABEL_SIDE_A + this.sideA);
        System.out.println(DisplayMessages.LABEL_SIDE_B + this.sideB);
        System.out.println(DisplayMessages.LABEL_SIDE_C + this.sideC);
        System.out.println(DisplayMessages.LABEL_AREA + getArea());
        System.out.println(DisplayMessages.LABEL_PERIMETER + getPerimeter());
    }
}
