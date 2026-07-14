package entity;

/**
 * Represents a student with ID, name, semester and course.
 */
public class Student {

    private String id;
    private String studentName;
    private String semester;
    private String courseName;

    public Student() {
    }

    /**
     * Constructs a new Student with full details.
     *
     * @param id the student ID
     * @param studentName the student name
     * @param semester the semester
     * @param courseName the course name
     */
    public Student(
            String id, String studentName,
            String semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
