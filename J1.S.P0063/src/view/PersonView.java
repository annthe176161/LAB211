package view;

import constant.MessageConstant;
import entity.Person;
import java.util.Scanner;

/**
 * Handles user input and display
 * for Person objects.
 */
public class PersonView {

    /**
     * Validates salary input and creates a Person.
     *
     * @param name    the person's name
     * @param address the person's address
     * @param sSalary the salary string to validate
     * @return a valid Person object
     * @throws Exception if salary input is invalid
     */
    public Person inputPersonInfo(
            String name,
            String address,
            String sSalary) throws Exception {
        if (sSalary == null
                || sSalary.trim().isEmpty()) {
            throw new Exception(
                    MessageConstant.ERROR_EMPTY_SALARY);
        }
        double salary;
        try {
            salary = Double.parseDouble(
                    sSalary.trim());
        } catch (NumberFormatException e) {
            throw new Exception(
                    MessageConstant.ERROR_DIGIT);
        }
        if (salary <= 0) {
            throw new Exception(
                    MessageConstant
                            .ERROR_GREATER_THAN_ZERO);
        }
        return new Person(name, address, salary);
    }

    /**
     * Prompts user to input all persons.
     * Re-asks salary until valid input is given.
     *
     * @param scanner the Scanner for user input
     * @param count   number of persons to input
     * @return array of valid Person objects
     */
    public Person[] inputAllPersons(
            Scanner scanner, int count) {
        Person[] persons = new Person[count];
        int index = 0;
        while (index < count) {
            System.out.println(
                    "Input Information of Person");

            System.out.print("Please input name: ");
            String name =
                    scanner.nextLine().trim();

            System.out.print(
                    "Please input address: ");
            String address =
                    scanner.nextLine().trim();

            boolean done = false;
            while (!done) {
                System.out.print(
                        "Please input salary: ");
                String sSalary =
                        scanner.nextLine().trim();
                try {
                    Person p = inputPersonInfo(
                            name, address, sSalary);
                    persons[index] = p;
                    index++;
                    done = true;
                } catch (Exception e) {
                    System.out.println(
                            e.getMessage());
                }
            }
            System.out.println();
        }
        return persons;
    }

    /**
     * Prints person information to the console.
     *
     * @param person the Person to display
     */
    public void displayPersonInfo(Person person) {
        if (person == null) {
            return;
        }
        System.out.println(
                "Information of Person"
                        + " you have entered:");
        System.out.println(
                "Name: " + person.getName());
        System.out.println(
                "Address: " + person.getAddress());
        System.out.println(
                "Salary: " + person.getSalary());
    }
}
