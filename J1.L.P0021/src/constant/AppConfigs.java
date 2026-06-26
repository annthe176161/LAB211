/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constant;

/**
 *
 * @author admin
 */
public class AppConfigs {

    /**
     * Private constructor to prevent instantiation of this utility
     * configuration class.
     */
    private AppConfigs() {
        throw new UnsupportedOperationException("Configuration class cannot be instantiated");
    }

    // Business Logic Thresholds
    public static final int MIN_UNIQUE_STUDENTS_REQUIRED = 10;

    // Course Configurations
    public static final String COURSE_JAVA = "Java";
    public static final String COURSE_NET = ".Net";
    public static final String COURSE_C = "C/C++";
    public static final String[] ALLOWED_COURSES = {COURSE_JAVA, COURSE_NET, COURSE_C};

    // User Navigation Choices
    public static final String CHOICE_Y = "Y";
    public static final String CHOICE_N = "N";
    public static final String CHOICE_U = "U";
    public static final String CHOICE_D = "D";
    public static final String[] ALLOWED_YN = {CHOICE_Y, CHOICE_N};
    public static final String[] ALLOWED_UD = {CHOICE_U, CHOICE_D};

    // UI Input Message Prompts
    public static final String MSG_ENTER_COURSE = "Enter Course Name (Java, .Net, C/C++): ";
    public static final String ERR_INVALID_COURSE = "Invalid course! Allowed courses are: Java, .Net, C/C++.";

    public static final String MSG_CONTINUE = "Do you want to continue (Y/N)? ";
    public static final String ERR_INVALID_YN = "Invalid input! Please enter 'Y' or 'N'.";

    public static final String MSG_UPDATE_OR_DELETE = "Do you want to update (U) or delete (D) student? ";
    public static final String ERR_INVALID_UD = "Invalid input! Please enter 'U' to update or 'D' to delete.";
}
