/**
 * Given an array A and an integer B.
 * A pair(i, j) in the array is a good pair if i != j
 * and (A[i] + A[j] == B).
 * Check if any good pair exist or not.
 *
 * TestCase :
 *          Array = [1, 2, 3, 4]
 *          targetSum = 7;
 *  Output :
 *          Return 1 if good pair exists otherwise return 0
 */
public class GoodPair {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        int targetSum = 7;
        System.out.println(solve(array, targetSum));
    }
    public static int solve(int[] array, int targetSum) {
        // O(n) time | O(1) space
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] + array[j] == targetSum) return 1;
            }
        }
        return 0;
    }
}
