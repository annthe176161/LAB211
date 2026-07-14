package constant;

/**
 * Application-wide configuration values.
 *
 * @author admin
 */
public class ConfigConstants {

    public static final int RANGE_MIN = 1;
    public static final int RANGE_MAX =
            Integer.MAX_VALUE;

    /**
     * Prevents instantiation.
     */
    private ConfigConstants() {
        throw new AssertionError();
    }
}
