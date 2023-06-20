import java.util.HashSet;

/**
 *  Given an array of integers between 1 and n, inclusive, where n is the length of the array, write a function that returns the first integer that appears more than once (when the array is read from left to right).
 *
 * In other words, out of all the integers that might occur more than once in the input array, your function should return the one whose first duplicate value has the minimum index.
 *
 * If no integer appears more than once, your function should return -1.
 *
 * Note that you're allowed to mutate the input array.
 * Sample Input #1
 *
 * array = [2, 1, 5, 2, 3, 3, 4]
 *
 * Sample Output #1
 *
 * 2 // 2 is the first integer that appears more than once.
 * // 3 also appears more than once, but the second 3 appears after the second 2
 */
public class FirstDuplicateValue {
    public static void main(String[] args) {
        int[] array = {2, 1, 5, 2, 3, 3, 4};

        System.out.println(solve(array));
    }
    public static int solve(int[] array) {
        // O(n) time | O(1) space
        for (int value: array) {
            int absValue = Math.abs(value);
            if(array[absValue - 1] < 0) return  absValue;
            array[absValue - 1] *= -1;
        }
        return -1;
    }
    public static int solveUsingHashSet(int[] array) {
        // O(n) time | O(n) space
        HashSet<Integer> seen = new HashSet<>();
        for (int value: array) {
            if (seen.contains(value)) return value;
            seen.add(value);
        }
        return -1;
    }
}
