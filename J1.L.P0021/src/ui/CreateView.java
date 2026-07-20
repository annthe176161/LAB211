package ui;

import constant.AppConfigs;
import entity.Student;
import service.StudentService;
import util.Validation;

/**
 * Console view for creating a student.
 */
public class CreateView {

    private final StudentService service;

    /**
     * @param service the student service
     */
    public CreateView(StudentService service) {
        this.service = service;
    }

    /**
     * Prompts user for student details and creates records.
     */
    public void show() {
        System.out.println("\n--- Create Student ---");
        while (true) {
            String id = Validation.readString(
                    "Enter Student ID: ",
                    "Error: Student ID cannot be empty!");
            String name = Validation.readString(
                    "Enter Student Name: ",
                    "Error: Student Name cannot be empty!");
            String semester = Validation.readString(
                    "Enter Semester: ",
                    "Error: Semester cannot be empty!");
            String course = Validation.readOption(
                    "Enter Course Name (Java, Net, C/C++): ",
                    "Error: Invalid course!",
                    AppConfigs.ALLOWED_COURSES);

            if (service.addStudent(
                    new Student(id, name, semester, course))) {
                System.out.println("Student added successfully!");
            } else {
                System.out.println(
                        "Error: enrollment record already exists!");
            }

            int total = service.countUniqueStudents();
            System.out.println(
                    "Current total unique students: " + total);

            if (total >= AppConfigs.MIN_UNIQUE_STUDENTS) {
                String choice = Validation.readOption(
                        "Do you want to continue (Y/N)? ",
                        "Error: Please enter Y or N!",
                        AppConfigs.ALLOWED_YN);
                if (AppConfigs.NO.equals(choice)) {
                    break;
                }
            }
        }
    }
}
