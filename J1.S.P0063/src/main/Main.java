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
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PersonView view = new PersonView();
        PersonService service = new PersonService();

        view.displayBanner();

        Person[] persons = view.inputAllPersons(
                scanner, MAX_PERSONS);

        try {
            Person[] sorted =
                    service.sortBySalary(persons);
            view.displayAllPersons(sorted);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        view.displayBanner();
        scanner.close();
    }
}
