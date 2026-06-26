/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class Student {

    private String id;
    private String studentName;
    private String semester;
    private String courseName;

    /**
     * Default constructor.
     */
    public Student() {
    }

    /**
     * Constructor with all parameters.
     *
     * * @param id the student unique identifier
     * @param studentName the student full name
     * @param semester the current academic semester
     * @param courseName the selected course name
     */
    public Student(String id, String studentName, String semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    /**
     * Gets student ID.
     *
     * * @return the student ID string
     */
    public String getId() {
        return id;
    }

    /**
     * Sets student ID.
     *
     * * @param id the student ID to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets student name.
     *
     * * @return the student name string
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Sets student name.
     *
     * * @param studentName the student name to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Gets semester info.
     *
     * * @return the semester string
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Sets semester info.
     *
     * * @param semester the semester to set
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Gets course name.
     *
     * * @return the course name string
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets course name.
     *
     * * @param courseName the course name to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
