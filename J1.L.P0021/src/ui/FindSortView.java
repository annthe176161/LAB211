package ui;

import entity.Student;
import java.util.List;
import service.StudentService;
import util.Validation;

/**
 * Console view for finding and sorting students.
 */
public class FindSortView {

    private final StudentService service;

    /**
     * @param service the student service
     */
    public FindSortView(StudentService service) {
        this.service = service;
    }

    /**
     * Prompts for a keyword and displays matching students sorted by name.
     */
    public void show() {
        System.out.println("\n--- Find and Sort ---");
        if (service.isEmpty()) {
            System.out.println("The student list is empty.");
            return;
        }

        String keyword = Validation.readString(
                "Enter student name to search: ",
                "Error: Search keyword cannot be empty!");
        List<Student> matched = service.findByName(keyword);

        if (matched.isEmpty()) {
            System.out.println(
                    "No student found containing: " + keyword);
            return;
        }

        System.out.printf(
                "%-20s | %-10s | %-10s%n",
                "Student Name", "Semester", "Course Name");
        System.out.println(
                "-----------------------------------------------");
        for (Student s : matched) {
            System.out.printf(
                    "%-20s | %-10s | %-10s%n",
                    s.getStudentName(), s.getSemester(),
                    s.getCourseName());
        }
    }
}
