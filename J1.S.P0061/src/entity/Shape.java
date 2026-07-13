package entity;

/**
 * Defines common operations for geometric shapes.
 */
public abstract class Shape {

    /**
     * Calculates the area of the shape.
     *
     * @return the area
     */
    public abstract double getArea();

    /**
     * Calculates the perimeter of the shape.
     *
     * @return the perimeter
     */
    public abstract double getPerimeter();

    /**
     * Displays the shape details to the console.
     */
    public abstract void printResult();
}
