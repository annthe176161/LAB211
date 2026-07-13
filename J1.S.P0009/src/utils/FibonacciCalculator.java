package utils;

/**
 * Handles Fibonacci calculations using recursion and array-based memoization.
 */
public class FibonacciCalculator {

    private final long[] cache;

    /**
     * Initializes the cache array.
     *
     * @param size the size of the cache
     */
    public FibonacciCalculator(int size) {
        this.cache = new long[size];
    }

    /**
     * Calculates the n-th Fibonacci term recursively.
     *
     * @param n the index of the Fibonacci term (0-based)
     * @return the Fibonacci value at the specified index
     */
    public long getTerm(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Index cannot be negative.");
        }

        // Base cases
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        // Return cached value if already calculated
        if (cache[n] != 0) {
            return cache[n];
        }

        // Calculate and store in cache
        cache[n] = getTerm(n - 1) + getTerm(n - 2);
        return cache[n];
    }
}
