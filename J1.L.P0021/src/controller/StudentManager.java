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
import utility.Validation;

/**
 * Manages student records: create, find, sort, update, delete and report.
 */
public class StudentManager {

    private final List<Student> students = new ArrayList<>();

    /**
     * Counts unique student IDs in the list.
     */
    private int countUniqueStudents() {
        Set<String> ids = new HashSet<>();
        for (Student s : students) {
            ids.add(s.getId().toLowerCase());
        }
        return ids.size();
    }

    /**
     * Checks if an identical record already exists.
     */
    private boolean isDuplicate(
            String id, String name, String semester, String course) {
        for (Student s : students) {
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
     * Returns all records with the given student ID.
     */
    private List<Student> findMatch(String id) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                result.add(s);
            }
        }
        return result;
    }

    /**
     * Creates a new student record. Requires at least 10 unique students
     * before allowing user to stop.
     */
    public void createStudent() {
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

            if (isDuplicate(id, name, semester, course)) {
                System.out.println(
                        "Error: enrollment record already exists!");
            } else {
                students.add(new Student(id, name, semester, course));
                System.out.println("Student added successfully!");
            }

            int total = countUniqueStudents();
            System.out.println(
                    "Current total unique students: " + total);

            if (total >= AppConfigs.MIN_UNIQUE_STUDENTS) {
                String choice = Validation.readOption(
                        "Do you want to continue (Y/N)? ",
                        "Error: Please enter Y or N!",
                        AppConfigs.ALLOWED_YN);
                if ("N".equals(choice)) {
                    break;
                }
            }
        }
    }

    /**
     * Finds students by name (partial match) and displays them sorted.
     */
    public void findAndSort() {
        System.out.println("\n--- Find and Sort ---");
        if (students.isEmpty()) {
            System.out.println("The student list is empty.");
            return;
        }

        String keyword = Validation.readString(
                "Enter student name to search: ",
                "Error: Search keyword cannot be empty!");
        List<Student> matched = new ArrayList<>();

        for (Student s : students) {
            if (s.getStudentName().toLowerCase()
                    .contains(keyword.toLowerCase())) {
                matched.add(s);
            }
        }

        if (matched.isEmpty()) {
            System.out.println(
                    "No student found containing: " + keyword);
            return;
        }

        Collections.sort(matched,
                (s1, s2) -> s1.getStudentName()
                        .compareToIgnoreCase(s2.getStudentName()));

        System.out.printf("%-20s | %-10s | %-10s%n",
                "Student Name", "Semester", "Course Name");
        System.out.println(
                "-----------------------------------------------");
        for (Student s : matched) {
            System.out.printf("%-20s | %-10s | %-10s%n",
                    s.getStudentName(), s.getSemester(),
                    s.getCourseName());
        }
    }

    /**
     * Finds a student by ID, then updates or deletes the record(s).
     */
    public void updateOrDelete() {
        System.out.println("\n--- Update or Delete ---");
        if (students.isEmpty()) {
            System.out.println("The student list is empty.");
            return;
        }

        String id = Validation.readString(
                "Enter Student ID to find: ",
                "Error: Student ID cannot be empty!");
        List<Student> records = findMatch(id);

        if (records.isEmpty()) {
            System.out.println("No student found for ID: " + id);
            return;
        }

        String decision = Validation.readOption(
                "Do you want to update (U) or delete (D) student? ",
                "Error: Please enter U or D!",
                AppConfigs.ALLOWED_UD);

        if ("D".equals(decision)) {
            students.removeAll(records);
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
        if (!newName.isEmpty()) {
            target.setStudentName(newName);
        }

        String newSemester = Validation.readOptionalLine(
                "Enter new Semester (Current: "
                + target.getSemester() + "): ");
        if (!newSemester.isEmpty()) {
            target.setSemester(newSemester);
        }

        String newCourse = Validation.readOptionalLine(
                "Enter new Course (Java, Net, C/C++)"
                + " (Current: "
                + target.getCourseName() + "): ");
        if (!newCourse.isEmpty()) {
            if (newCourse.equalsIgnoreCase(AppConfigs.COURSE_JAVA)
                    || newCourse.equalsIgnoreCase(AppConfigs.COURSE_NET)
                    || newCourse.equalsIgnoreCase(AppConfigs.COURSE_C)) {
                target.setCourseName(newCourse);
            } else {
                System.out.println(
                        "Invalid course. Only Java, Net, C/C++.");
            }
        }

        System.out.println("Record updated!");
    }

    /**
     * Displays a report: student name, course, and total count.
     */
    public void generateReport() {
        System.out.println("\n--- Report ---");
        if (students.isEmpty()) {
            System.out.println("The student list is empty.");
            return;
        }

        Map<String, Integer> map = new LinkedHashMap<>();
        for (Student s : students) {
            String key = s.getStudentName()
                    + " | " + s.getCourseName();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            sb.append(e.getKey())
                    .append(" | ")
                    .append(e.getValue())
                    .append("\n");
        }
        System.out.print(sb);
    }
}
