package view;

import entity.Person;
import exception.PersonException;
import java.util.Scanner;
import service.PersonService;

/**
 * Handles user input and display
 * for Person objects.
 */
public class PersonView {

    private final PersonService service;

    public PersonView(PersonService service) {
        this.service = service;
    }

    /**
     * Prompts user to input one person's info.
     * Re-asks salary until valid input is given.
     *
     * @param scanner the Scanner for user input
     * @return a valid Person object
     */
    public Person inputPersonInfo(
            Scanner scanner) {
        System.out.print("Please input name: ");
        String name =
                scanner.nextLine().trim();

        System.out.print("Please input address: ");
        String address =
                scanner.nextLine().trim();

        while (true) {
            System.out.print(
                    "Please input salary: ");
            String sSalary =
                    scanner.nextLine().trim();
            try {
                return service.createPerson(
                        name, address, sSalary);
            } catch (PersonException e) {
                System.out.println(
                        e.getMessage());
            }
        }
    }

    /**
     * Prompts user to input all persons.
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
            persons[index] =
                    inputPersonInfo(scanner);
            index++;
            System.out.println();
        }
        return persons;
    }

    /**
     * Displays all persons in the array.
     *
     * @param persons the array of Person to display
     */
    public void displayAllPersons(Person[] persons) {
        for (int i = 0; i < persons.length; i++) {
            displayPersonInfo(persons[i]);
            System.out.println();
        }
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
