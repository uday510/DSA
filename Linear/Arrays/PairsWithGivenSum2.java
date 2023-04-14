/**
 * Problem Description
 * Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
 *
 * Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 10^9
 *
 * 1 <= B <= 10^9
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 * The second argument given is integer B.
 *
 *
 *
 * Output Format
 * Return the number of pairs for which sum is equal to B modulo (10^9+7).
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 1, 1]
 * B = 2
 * Input 2:
 *
 *
 * A = [1, 1]
 * B = 2
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Any two pairs sum up to 2.
 * Explanation 2:
 *
 *  only pair (1, 2) sums up to 2.
 */
package Linear.Arrays;

public class PairsWithGivenSum2 {
    public static void main(String[] args) {
        int[] array = { 2, 2, 3, 4, 4, 5, 6, 7, 10 };
        int targetSum = 8;
        int ans = solve(array, targetSum);
        System.out.println(ans);
    }
    public static int solve(int[] array, int targetSum) {
        // O(N) time | O(1) space
        long pairsCount = 0;
        int mod = (int) 1e9 + 7;

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int currentSum = array[left] + array[right];

            if (currentSum == targetSum) {
                if (array[left] == array[right]) {
                    // count left and right pairs
                    long count = right - left + 1;
                    pairsCount += (count * (count - 1) / 2) % mod;
                    pairsCount %= mod;
                    break;
                } else {
                    int leftNum = array[left], leftCount = 0;
                    int count = 0;
                    while (leftNum == array[left]) {
                        leftCount++;
                        left++;
                    }
                    int rightNum = array[right], rightCount = 0;
                    int count2 = 0;
                    while (rightNum == array[right]) {
                        rightCount++;
                        right--;
                    }
                    pairsCount += ((long) leftCount * rightCount) % mod;
                }
            } else if (currentSum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
        return (int) pairsCount;
    }
}
