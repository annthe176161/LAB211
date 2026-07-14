package constant;

/**
 * Application-wide constants.
 */
public class AppConstant {

    private AppConstant() {
    }

    /** Menu option: Normal Calculator. */
    public static final int MENU_NORMAL_CALC = 1;

    /** Menu option: BMI Calculator. */
    public static final int MENU_BMI_CALC = 2;

    /** Menu option: Exit program. */
    public static final int MENU_EXIT = 3;

    /** Conversion factor from centimeters to meters. */
    public static final double CM_TO_M = 100.0;

    /** BMI threshold for under standard. */
    public static final double BMI_UNDER_STANDARD = 19.0;

    /** BMI threshold for standard max. */
    public static final double BMI_STANDARD_MAX = 25.0;

    /** BMI threshold for overweight max. */
    public static final double BMI_OVERWEIGHT_MAX = 30.0;

    /** BMI threshold for fat max. */
    public static final double BMI_FAT_MAX = 40.0;
}
