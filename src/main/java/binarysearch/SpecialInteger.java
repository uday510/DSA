/**
 * Problem Description
 * Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
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
 * Return the maximum value of K (sub array length).
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 3, 4, 5]
 * B = 10
 * Input 2:
 *
 * A = [5, 17, 100, 11]
 * B = 130
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Constraints are satisfied for maximal value of 2.
 * Explanation 2:
 *
 * Constraints are satisfied for maximal value of 3.
 */
package binarysearch;

public class SpecialInteger {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int b = 10;
        int ans = solve(array, b);
        System.out.println(ans);
    }

    public static int solve(int[] array, int b) {
//        for (int i = 0; i < array.length; i++) {
//            for (int j = i; j < array.length; j++) {
//                List<Integer> list = new ArrayList<>();
//                for (int k = i; k <= j; k++) {
//                    list.add(array[k]);
//                }
//                System.out.println(list);
//            }
//        }

        // calculate the prefix sum
        long[] prefix = new long[array.length];
        prefix[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            prefix[i] = array[i] + prefix[i-1];
        }

        // binary search for length
        int left = 1;
        int right = array.length;
        int ans = 0;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (check(middle, prefix, (long) b) == 1) {
                right = middle - 1;
            } else {
                ans = middle;
                left = middle + 1;
            }
        }
        return ans;
    }

    public static int check(int start, long[] array, long b) {
        for (int i = start - 1; i < array.length; i++) {
            if (i == start - 1) {
                if (array[i] > b) {
                    return 1;
                }
            } else if (array[i] - array[i - start] > b) {
                return 1;
            }
        }
        return 0;
    }
}
