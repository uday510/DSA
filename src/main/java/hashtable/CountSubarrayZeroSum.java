/**
 * Problem Description
 * Given an array A of N integers.
 *
 * Find the count of the subarrays in the array which sums to zero. Since the answer can be very large, return the remainder on dividing the result with 109+7
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 * -109 <= A[i] <= 109
 *
 *
 * Input Format
 * Single argument which is an integer array A.
 *
 *
 * Output Format
 * Return an integer.
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, -1, -2, 2]
 * Input 2:
 *
 *  A = [-1, 2, -1]
 *
 *
 * Example Output
 * Output 1:
 *
 * 3
 * Output 2:
 *
 * 1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The subarrays with zero sum are [1, -1], [-2, 2] and [1, -1, -2, 2].
 * Explanation 2:
 *
 *  The subarray with zero sum is [-1, 2, -1].
 */

package hashtable;

import java.util.HashMap;

public class CountSubarrayZeroSum {
    public static void main(String[] args) {
        int[] array = {1, -1, -2, 2};

        int res = solve(array);
        System.out.println(res);
    }
    public static int solve(int[] array) {
        int len = array.length;
//        int res = 0;

//        for (int i = 0; i < len; i++) {
//            int sum = 0;
//            for (int j = i; j < len; j++) {
//                sum += array[j];
//                if (sum == 0) res++;
//            }
//        }
//        return res;

        final int mod = (int)(1e9 + 7);
        HashMap<Long, Integer> hashMap = new HashMap<>();
        Long currentSum = 0L, res = 0L;
        hashMap.put(0L, 1);

        for (int num : array) {
            currentSum += num;

            if (hashMap.containsKey(currentSum)) {
                res += hashMap.get(currentSum);
                System.out.println(res);
            }
            hashMap.put(currentSum, hashMap.getOrDefault(currentSum, 0) + 1);
        }
        return (int) (res % mod);

    }
}
