package entity;

/**
 * Stores personal information including name,
 * address, and salary.
 */
public class Person {

    private String name;
    private String address;
    private double salary;

    public Person() {
    }

    /**
     * Creates a new Person with the given details.
     *
     * @param name    the person's name
     * @param address the person's address
     * @param salary  the person's salary
     */
    public Person(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
