package ui;

import constant.AppConfigs;
import entity.Student;
import java.util.List;
import service.StudentService;
import util.Validation;

/**
 * Console view for updating or deleting student records.
 */
public class UpdateDeleteView {

    private final StudentService service;

    /**
     * @param service the student service
     */
    public UpdateDeleteView(StudentService service) {
        this.service = service;
    }

    /**
     * Prompts for a student ID, then updates or deletes the records.
     */
    public void show() {
        System.out.println("\n--- Update or Delete ---");
        if (service.isEmpty()) {
            System.out.println("The student list is empty.");
            return;
        }

        String id = Validation.readString(
                "Enter Student ID to find: ",
                "Error: Student ID cannot be empty!");
        List<Student> records = service.findById(id);

        if (records.isEmpty()) {
            System.out.println("No student found for ID: " + id);
            return;
        }

        String decision = Validation.readOption(
                "Do you want to update (U) or delete (D) student? ",
                "Error: Please enter U or D!",
                AppConfigs.ALLOWED_UD);

        if (AppConfigs.DELETE.equals(decision)) {
            service.deleteAll(records);
            System.out.println(
                    "All records for ID '" + id + "' deleted!");
            return;
        }

        System.out.println("\nSelect a record to update:");
        for (int i = 0; i < records.size(); i++) {
            System.out.printf(
                    "[%d] Name: %s | Semester: %s | Course: %s%n",
                    i + 1,
                    records.get(i).getStudentName(),
                    records.get(i).getSemester(),
                    records.get(i).getCourseName());
        }

        int idx = Validation.readInteger(
                "Enter selection index: ",
                1, records.size(),
                "Error: Index must be a number!",
                "Error: Index out of range!");
        Student target = records.get(idx - 1);

        System.out.println(
                "Leave empty to keep current value.");

        String newName = Validation.readOptionalLine(
                "Enter new Name (Current: "
                + target.getStudentName() + "): ");
        String newSemester = Validation.readOptionalLine(
                "Enter new Semester (Current: "
                + target.getSemester() + "): ");
        String newCourse = Validation.readOptionalLine(
                "Enter new Course (Java, Net, C/C++)"
                + " (Current: "
                + target.getCourseName() + "): ");

        if (!newCourse.isEmpty()
                && !newCourse.equalsIgnoreCase(
                        AppConfigs.COURSE_JAVA)
                && !newCourse.equalsIgnoreCase(
                        AppConfigs.COURSE_NET)
                && !newCourse.equalsIgnoreCase(
                        AppConfigs.COURSE_C)) {
            System.out.println(
                    "Invalid course. Only Java, Net, C/C++.");
        } else {
            service.updateStudent(
                    target, newName, newSemester, newCourse);
            System.out.println("Record updated!");
        }
    }
}
