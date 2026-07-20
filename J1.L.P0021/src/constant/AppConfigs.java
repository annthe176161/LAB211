package constant;

import java.util.Arrays;
import java.util.List;

/**
 * Contains all configuration constants for the application.
 */
public class AppConfigs {

    private AppConfigs() {
    }

    public static final int MIN_UNIQUE_STUDENTS = 10;

    public static final int CREATE = 1;
    public static final int FIND_AND_SORT = 2;
    public static final int UPDATE_OR_DELETE = 3;
    public static final int REPORT = 4;
    public static final int EXIT = 5;

    public static final String COURSE_JAVA = "Java";
    public static final String COURSE_NET = ".Net";
    public static final String COURSE_C = "C/C++";
    public static final List<String> ALLOWED_COURSES =
            Arrays.asList(COURSE_JAVA, COURSE_NET, COURSE_C);

    public static final String YES = "Y";
    public static final String NO = "N";
    public static final List<String> ALLOWED_YN =
            Arrays.asList(YES, NO);

    public static final String UPDATE = "U";
    public static final String DELETE = "D";
    public static final List<String> ALLOWED_UD =
            Arrays.asList(UPDATE, DELETE);
}
