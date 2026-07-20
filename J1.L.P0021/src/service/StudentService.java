package service;

import entity.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Handles all student business logic without I/O.
 */
public class StudentService {

    private final List<Student> students;

    /**
     * @param students the backing list (allows different implementations)
     */
    public StudentService(List<Student> students) {
        this.students = Objects.requireNonNull(
                students, "students must not be null");
    }

    /**
     * Adds a student if no duplicate record exists.
     *
     * @param student the student to add
     * @return true if added, false if duplicate found
     */
    public boolean addStudent(Student student) {
        Objects.requireNonNull(
                student, "student must not be null");
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(student.getId())
                    && s.getStudentName()
                            .equalsIgnoreCase(student.getStudentName())
                    && s.getSemester()
                            .equalsIgnoreCase(student.getSemester())
                    && s.getCourseName()
                            .equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        students.add(student);
        return true;
    }

    /**
     * Counts unique student IDs in the list.
     *
     * @return number of distinct student IDs
     */
    public int countUniqueStudents() {
        Set<String> ids = new HashSet<>();
        for (Student s : students) {
            ids.add(s.getId().toLowerCase());
        }
        return ids.size();
    }

    /**
     * Finds students whose name contains the keyword, sorted by name.
     *
     * @param keyword the search keyword
     * @return sorted list of matching students
     */
    public List<Student> findByName(String keyword) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getStudentName().toLowerCase()
                    .contains(keyword.toLowerCase())) {
                result.add(s);
            }
        }
        Collections.sort(result,
                (s1, s2) -> s1.getStudentName()
                        .compareToIgnoreCase(s2.getStudentName()));
        return result;
    }

    /**
     * Finds all records with the given student ID.
     *
     * @param id the student ID to search
     * @return list of matching records
     */
    public List<Student> findById(String id) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                result.add(s);
            }
        }
        return result;
    }

    /**
     * Removes all given records from the list.
     *
     * @param records the records to remove
     * @return true if any record was removed
     */
    public boolean deleteAll(List<Student> records) {
        return students.removeAll(records);
    }

    /**
     * Updates fields of a target student. Empty strings are ignored.
     *
     * @param target   the student to update
     * @param name     new name (empty to keep)
     * @param semester new semester (empty to keep)
     * @param course   new course (empty to keep)
     */
    public void updateStudent(
            Student target, String name,
            String semester, String course) {
        if (name != null && !name.isEmpty()) {
            target.setStudentName(name);
        }
        if (semester != null && !semester.isEmpty()) {
            target.setSemester(semester);
        }
        if (course != null && !course.isEmpty()) {
            target.setCourseName(course);
        }
    }

    /**
     * Groups students by name and course and counts each group.
     *
     * @return map of "name | course" to count, empty if no students
     */
    public Map<String, Integer> countByCourseAndName() {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Student s : students) {
            String key = s.getStudentName()
                    + " | " + s.getCourseName();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return map;
    }

    /**
     * Checks whether the student list is empty.
     *
     * @return true if no students
     */
    public boolean isEmpty() {
        return students.isEmpty();
    }
}
