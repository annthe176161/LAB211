/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import entity.Person;
import java.util.Scanner;
import repository.PersonRepository;
import view.PersonView;

/**
 *
 * @author admin
 */
public class Main {

    private static final int MAX_PERSONS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PersonView view = new PersonView();
        PersonRepository repo = new PersonRepository();

        Person[] persons = new Person[MAX_PERSONS];

        System.out.println("=====Management Person  programer=====");

        int count = 0;
        while (count < MAX_PERSONS) {
            System.out.println("Input Information of Person");

            System.out.print("Please input name:");
            String name = scanner.nextLine().trim();

            System.out.print("Please input address:");
            String address = scanner.nextLine().trim();

            // Reusable function to get positive double for salary
            double salary = view.inputPositiveDouble(scanner, "Please input salary:");

            Person newPerson = repo.createPerson(name, address, salary);

            if (newPerson != null) {
                persons[count] = newPerson;
                count = count + 1;
            } else {
                System.out.println("Input failed. Please enter information again.");
            }
        }

        // Sort the data
        Person[] sortedPersons = repo.sortBySalary(persons);

        // Display the results
        for (int i = 0; i < sortedPersons.length; i++) {
            view.displayPersonInfo(sortedPersons[i]);
        }

        System.out.println("=====Management Person programer=====");
        scanner.close();
    }
}
