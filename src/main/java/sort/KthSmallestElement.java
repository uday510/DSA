/**
 * Problem Description
 * Find the Bth smallest element in given array A .
 *
 * NOTE: Users should try to solve it in less than equal to B swaps.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= B <= min(|A|, 500)
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The first argument is an integer array A.
 *
 * The second argument is integer B.
 *
 *
 *
 * Output Format
 * Return the Bth smallest element in given array.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [2, 1, 4, 3, 2]
 * B = 3
 * Input 2:
 *
 * A = [1, 2]
 * B = 2
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  3rd element after sorting is 2.
 * Explanation 2:
 *
 *  2nd element after sorting is 2.
 */
package sort;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] array = {2, 1, 4, 3, 2};
        int ans = solve(array, 3);
        System.out.println(ans);
    }
    public static int solve(int[] array, int k) {
        int startIdx = 0;
        while (startIdx < array.length - 1) {
            int smallestIdx = startIdx;

            for (int i = startIdx + 1; i < array.length; i++) {
                if (array[smallestIdx] > array[i]) {
                    smallestIdx = i;
                }
            }
            swap(smallestIdx, startIdx, array);
            if (k-1 == startIdx) {
                return array[k-1];
            }
            startIdx++;
        }
        return array[array.length - 1];
    }
    public static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
