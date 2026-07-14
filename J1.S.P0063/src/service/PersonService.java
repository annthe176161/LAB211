package service;

import entity.Person;

/**
 * Provides business operations for Person objects.
 */
public class PersonService {

    /**
     * Sorts persons by salary ascending
     * using Bubble Sort.
     *
     * @param personList the array to sort
     * @return the sorted array
     * @throws Exception if the array is null
     */
    public Person[] sortBySalary(
            Person[] personList) throws Exception {
        if (personList == null) {
            throw new Exception("Can't Sort Person");
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
