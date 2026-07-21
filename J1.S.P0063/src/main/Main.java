package main;

import entity.Person;
import exception.PersonException;
import java.util.Scanner;
import service.PersonService;
import view.PersonView;

/**
 * Entry point for the Person management program.
 */
public class Main {

    private static final int MAX_PERSONS = 3;

    /**
     * Runs the program.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PersonService service = new PersonService();
        PersonView view = new PersonView(service);

        System.out.println(
                "=====Management Person programer=====");

        Person[] persons = view.inputAllPersons(
                scanner, MAX_PERSONS);

        try {
            Person[] sorted =
                    service.sortBySalary(persons);
            view.displayAllPersons(sorted);
        } catch (PersonException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(
                "=====Management Person programer=====");
        scanner.close();
    }
}
