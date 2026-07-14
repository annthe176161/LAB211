package entity;

/**
 * Defines BMI health status categories.
 */
public enum BMIStatus {

    /** BMI less than 19. */
    UNDER_STANDARD,

    /** BMI between 19 and 25. */
    STANDARD,

    /** BMI between 25 and 30. */
    OVERWEIGHT,

    /** BMI between 30 and 40. */
    FAT,

    /** BMI over 40. */
    VERY_FAT
}
