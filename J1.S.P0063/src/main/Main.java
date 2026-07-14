package main;

import entity.Person;
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
     * @throws Exception if sorting fails
     */
    public static void main(String[] args)
            throws Exception {
        Scanner scanner = new Scanner(System.in);
        PersonView view = new PersonView();
        PersonService service = new PersonService();

        System.out.println(
                "=====Management Person programer=====");

        Person[] persons = view.inputAllPersons(
                scanner, MAX_PERSONS);

        Person[] sorted =
                service.sortBySalary(persons);

        for (int i = 0; i < sorted.length; i++) {
            view.displayPersonInfo(sorted[i]);
            System.out.println();
        }

        System.out.println(
                "=====Management Person programer=====");
        scanner.close();
    }
}
