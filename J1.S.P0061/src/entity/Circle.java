package entity;

import constant.DisplayMessages;
import constant.ShapeConstants;

/**
 * Represents a circle with a radius.
 */
public class Circle extends Shape {

    private double radius;

    /**
     * Creates a circle with the default radius.
     */
    public Circle() {
    }

    /**
     * Creates a circle with the specified radius.
     *
     * @param radius radius of the circle
     * @throws IllegalArgumentException if radius is not positive
     */
    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException(
                    "Radius must be greater than 0.");
        }
        this.radius = radius;
    }

    /**
     * Gets the radius of the circle.
     *
     * @return radius of the circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the circle.
     *
     * @param radius new radius of the circle
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Calculates the area of the circle.
     *
     * @return area of the circle
     */
    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    /**
     * Calculates the perimeter of the circle.
     *
     * @return perimeter of the circle
     */
    @Override
    public double getPerimeter() {
        return ShapeConstants.CIRCLE_DIAMETER_FACTOR * Math.PI * this.radius;
    }

    /**
     * Prints the circle information.
     */
    @Override
    public void printResult() {
        System.out.println(DisplayMessages.CIRCLE_HEADER);
        System.out.println(DisplayMessages.LABEL_RADIUS + this.radius);
        System.out.println(DisplayMessages.LABEL_AREA + getArea());
        System.out.println(DisplayMessages.LABEL_PERIMETER + getPerimeter());
    }
}
