package service;

import constant.MessageConstant;
import entity.Person;
import exception.PersonException;

/**
 * Provides business operations for Person objects.
 */
public class PersonService {

    /**
     * Validates salary and creates a Person.
     *
     * @param name    the person's name
     * @param address the person's address
     * @param sSalary the salary string to validate
     * @return a valid Person object
     * @throws PersonException if salary input
     *         is invalid
     */
    public Person createPerson(
            String name,
            String address,
            String sSalary) throws PersonException {
        if (sSalary == null
                || sSalary.trim().isEmpty()) {
            throw new PersonException(
                    MessageConstant.ERROR_EMPTY_SALARY);
        }
        double salary;
        try {
            salary = Double.parseDouble(
                    sSalary.trim());
        } catch (NumberFormatException e) {
            throw new PersonException(
                    MessageConstant.ERROR_DIGIT);
        }
        if (salary <= 0) {
            throw new PersonException(
                    MessageConstant
                            .ERROR_GREATER_THAN_ZERO);
        }
        return new Person(name, address, salary);
    }

    /**
     * Sorts persons by salary ascending
     * using Bubble Sort.
     *
     * @param personList the array to sort
     * @return the sorted array
     * @throws PersonException if the array is null
     */
    public Person[] sortBySalary(
            Person[] personList)
            throws PersonException {
        if (personList == null) {
            throw new PersonException(
                    MessageConstant.ERROR_SORT);
        }

        int n = personList.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0;
                    j < n - i - 1; j++) {
                Person a = personList[j];
                Person b = personList[j + 1];
                if (a != null && b != null) {
                    if (a.getSalary()
                            > b.getSalary()) {
                        personList[j] = b;
                        personList[j + 1] = a;
                    }
                }
            }
        }
        return personList;
    }
}
