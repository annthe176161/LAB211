/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import constant.AppConfigs;
import entity.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import util.Validation;

/**
 *
 * @author admin
 */
public class StudentManager {

    private final List<Student> studentList;

    /**
     * Constructor initializing the core list instance data container.
     */
    public StudentManager() {
        this.studentList = new ArrayList<>();
    }

    /**
     * Counts the total number of unique student IDs inside the database list.
     *
     * @return the count of unique student IDs found
     */
    private int countUniqueStudents() {
        Set<String> uniqueIds = new HashSet<>();
        for (Student s : studentList) {
            uniqueIds.add(s.getId().toLowerCase());
        }
        return uniqueIds.size();
    }

    /**
     * Reads and validates the user course name choice selection line.
     *
     * @return the clean validated course name choice string
     */
    private String inputCourse() {
        return Validation.inputAllowedValue(
                AppConfigs.MSG_ENTER_COURSE,
                AppConfigs.ERR_INVALID_COURSE,
                AppConfigs.ALLOWED_COURSES
        );
    }

    /**
     * Reads and validates the continuation yes/no confirmation answer selection
     * line.
     *
     * @return the clean validated choice string answer
     */
    private String inputYN() {
        return Validation.inputAllowedValue(
                AppConfigs.MSG_CONTINUE,
                AppConfigs.ERR_INVALID_YN,
                AppConfigs.ALLOWED_YN
        );
    }

    /**
     * Reads and validates the decision choice between updating or deleting a
     * student record.
     *
     * @return the clean validated choice decision value string
     */
    private String inputUD() {
        return Validation.inputAllowedValue(
                AppConfigs.MSG_UPDATE_OR_DELETE,
                AppConfigs.ERR_INVALID_UD,
                AppConfigs.ALLOWED_UD
        );
    }

    /**
     * Feature 1: Creates and adds new student records into the memory list.
     * Requires at least 10 unique student identities to allow loops to
     * terminate.
     */
    public void createStudent() {
        System.out.println("\n--- Create Student ---");
        while (true) {
            String id = Validation.inputString("Enter Student ID: ", "ID cannot be empty!");
            String name = Validation.inputString("Enter Student Name: ", "Name cannot be empty!");
            String semester = Validation.inputString("Enter Semester: ", "Semester cannot be empty!");
            String course = inputCourse();

            if (isDuplicateRecord(id, name, semester, course)) {
                System.err.println("Error: This exact student enrollment record already exists!");
            } else {
                studentList.add(new Student(id, name, semester, course));
                System.out.println("Student added successfully!");
            }

            int totalUnique = countUniqueStudents();
            System.out.println("Current total unique students in system: " + totalUnique);

            if (totalUnique >= AppConfigs.MIN_UNIQUE_STUDENTS_REQUIRED) {
                String choice = inputYN();
                if (choice.equalsIgnoreCase(AppConfigs.CHOICE_N)) {
                    break;
                }
            }
        }
    }

    /**
     * Feature 2: Finds student entries matching a search name keyword query,
     * sorted alphabetically.
     */
    public void findAndSort() {
        System.out.println("\n--- Find and Sort ---");
        if (studentList.isEmpty()) {
            System.err.println("The student list is empty.");
            return;
        }

        String searchName = Validation.inputString("Enter student name to search: ", "Search query cannot be empty!");
        List<Student> matchedList = new ArrayList<>();

        for (Student s : studentList) {
            if (s.getStudentName().toLowerCase().contains(searchName.toLowerCase())) {
                matchedList.add(s);
            }
        }

        if (matchedList.isEmpty()) {
            System.err.println("No student records found containing: " + searchName);
        } else {
            Collections.sort(matchedList, (s1, s2) -> s1.getStudentName().compareToIgnoreCase(s2.getStudentName()));

            System.out.printf("%-20s | %-10s | %-10s\n", "Student Name", "Semester", "Course Name");
            System.out.println("-------------------------------------------------------");
            for (Student s : matchedList) {
                System.out.printf("%-20s | %-10s | %-10s\n", s.getStudentName(), s.getSemester(), s.getCourseName());
            }
        }
    }

    /**
     * Feature 3: Modifies or erases a specific student identity tracking
     * records dataset.
     */
    public void updateOrDelete() {
        System.out.println("\n--- Update or Delete ---");
        if (studentList.isEmpty()) {
            System.err.println("The student list is empty.");
            return;
        }

        String id = Validation.inputString("Enter Student ID to find: ", "ID cannot be empty!");
        List<Student> targetRecords = getRecordsById(id);

        if (targetRecords.isEmpty()) {
            System.err.println("No student found matching ID: " + id);
            return;
        }

        String decision = inputUD();

        if (decision.equalsIgnoreCase(AppConfigs.CHOICE_D)) {
            studentList.removeAll(targetRecords);
            System.out.println("All records for Student ID '" + id + "' have been completely deleted!");
        } else {
            System.out.println("\nSelect a specific record index line to update:");
            for (int i = 0; i < targetRecords.size(); i++) {
                Student s = targetRecords.get(i);
                System.out.printf("[%d] Name: %s | Semester: %s | Course: %s\n", i + 1, s.getStudentName(), s.getSemester(), s.getCourseName());
            }

            int choice = Validation.inputInt(
                    "Enter selection index: ",
                    1,
                    targetRecords.size(),
                    "Error: Index must be a valid number!",
                    "Error: Selected index is out of bounds!"
            );
            Student studentToUpdate = targetRecords.get(choice - 1);

            System.out.println("Leave empty and press Enter if you do not wish to change a value.");

            System.out.print("Enter new Name (Current: " + studentToUpdate.getStudentName() + "): ");
            String newName = new java.util.Scanner(System.in).nextLine().trim();
            if (!newName.isEmpty()) {
                // Đồng bộ hóa tên cho TẤT CẢ bản ghi có cùng ID
                for (Student s : studentList) {
                    if (s.getId().equalsIgnoreCase(id)) {
                        s.setStudentName(newName);
                    }
                }
            }

            System.out.print("Enter new Semester (Current: " + studentToUpdate.getSemester() + "): ");
            String newSemester = new java.util.Scanner(System.in).nextLine().trim();
            if (!newSemester.isEmpty()) {
                studentToUpdate.setSemester(newSemester);
            }

            System.out.print("Enter new Course (Java, .Net, C/C++) (Current: " + studentToUpdate.getCourseName() + "): ");
            String newCourseInput = new java.util.Scanner(System.in).nextLine().trim();
            if (!newCourseInput.isEmpty()) {
                if (newCourseInput.equalsIgnoreCase(AppConfigs.COURSE_JAVA)
                        || newCourseInput.equalsIgnoreCase(AppConfigs.COURSE_NET)
                        || newCourseInput.equalsIgnoreCase(AppConfigs.COURSE_C)) {
                    studentToUpdate.setCourseName(newCourseInput);
                } else {
                    System.err.println("Invalid Course value entered. Field update bypassed.");
                }
            }
            System.out.println("Record updated successfully!");
        }
    }

    /**
     * Feature 4: Creates an aggregated tracking summary student report output
     * grouped by course.
     */
    public void generateReport() {
        System.out.println("\n--- Report ---");
        if (studentList.isEmpty()) {
            System.err.println("The student list is empty.");
            return;
        }

        Map<String, Integer> reportMap = new LinkedHashMap<>();

        for (Student s : studentList) {
            String key = String.format("%-20s | %-10s", s.getStudentName(), s.getCourseName());
            reportMap.put(key, reportMap.getOrDefault(key, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : reportMap.entrySet()) {
            sb.append(entry.getKey()).append(" | ").append(entry.getValue()).append("\n");
        }
        System.out.print(sb.toString());
    }

    /**
     * Helper evaluation checking if a data combination row is already inside
     * the database.
     *
     * @param id student ID code
     * @param name student literal string name
     * @param semester academic semester label
     * @param course enrolled course name
     * @return true if an identical record match exists, false otherwise
     */
    private boolean isDuplicateRecord(String id, String name, String semester, String course) {
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)
                    && s.getStudentName().equalsIgnoreCase(name)
                    && s.getSemester().equalsIgnoreCase(semester)
                    && s.getCourseName().equalsIgnoreCase(course)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gathers all objects whose tracking keys share the same identity parameter
     * string.
     *
     * @param id target identity query string filter to match
     * @return a dedicated sublist holding copies of matching reference pointers
     */
    private List<Student> getRecordsById(String id) {
        List<Student> subList = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                subList.add(s);
            }
        }
        return subList;
    }
}
