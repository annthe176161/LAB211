/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.Person;

/**
 *
 * @author admin
 */
public class PersonRepository {

    /**
     * Validates input data and creates a new Person object.
     *
     * @param name the name of the person
     * @param address the address of the person
     * @param salary the salary of the person
     * @return a valid Person object, or null if any input is invalid
     */
    public Person createPerson(String name, String address, double salary) {
        if (name == null || name.isEmpty() || address == null || address.isEmpty()) {
            return null;
        }
        if (salary <= 0) {
            return null;
        }
        return new Person(name, address, salary);
    }

    /**
     * Sorts an array of Person objects ascending by salary using Bubble Sort.
     *
     * @param personList the array of Person objects to be sorted
     * @return the sorted array of Person objects, or a new empty array if input
     * is null
     */
    public Person[] sortBySalary(Person[] personList) {
        if (personList == null) {
            return new Person[0];
        }

        int n = personList.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (personList[j] != null && personList[j + 1] != null) {
                    if (personList[j].getSalary() > personList[j + 1].getSalary()) {
                        Person temp = personList[j];
                        personList[j] = personList[j + 1];
                        personList[j + 1] = temp;
                    }
                }
            }
        }
        return personList;
    }
}
