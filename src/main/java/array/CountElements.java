package array;

/**
 * Given an array A of N integers.
 * Count the number of elements that have at least 1 elements
 * greater than itself.
 * Test Case:
 * input: [3, 1, 2]
 * output: [2]
 * The elements that have at least 1
 * element greater than itself are 1 and 2
 */
public class CountElements {
    public static void main(String[] args) {
        int[] array = {3, 1, 2};
        System.out.println(solve(array));
    }
    public static int solve(int[] array) {
        // O(n) time | O(1) space
        int maxElement = Integer.MIN_VALUE;

        for(Integer num : array) {
            maxElement = Math.max(maxElement, num);
        }
        int maxElementCount = 0;
        for (Integer num : array) {
            if (num == maxElement) maxElementCount += 1;
        }
        return array.length - maxElementCount;
    }
}
