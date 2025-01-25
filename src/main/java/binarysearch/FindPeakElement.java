/**
 * Problem Description
 * Given an array of integers A, find and return the peak element in it. An array element is peak if it is smaller than its neighbors.
 *
 * For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.
 *
 * NOTE: Users are expected to solve this in O(log(N)) time. The array may have duplicate elements.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the peak element.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 3, 4, 5]
 * Input 2:
 *
 * A = [5, 17, 100, 11]
 *
 *
 * Example Output
 * Output 1:
 *
 *  5
 * Output 2:
 *
 *  100
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  5 is the peak.
 * Explanation 2:
 *
 *  100 is the peak.
 */
package binarysearch;

public class FindPeakElement {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int ans = solve(array);
        System.out.println(ans);
    }
    public static int solve(int[] array) {

//        for (int i = 0; i < array.length - 1; ++i) {
//
//            if (array[i] > array[i + 1]) {
//                return array[i];
//            }
//        }


        /*

        1. First element > left neighbor
        2. Last element > right neighbour
        3. No adjacent elements are equal

         -Infinity [1, 2, 3, 4, 5, 6] -Infinity

         */
//        return array[array.length - 1];

        // -- BINARY SEARCH SOLUTION --
        int left = 0, right = array.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (array[mid] > array[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
