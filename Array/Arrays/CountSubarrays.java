/**
 * Problem Description
 *
 * Misha likes finding all Subarrays of an Array. Now she gives you an array A of N elements and told you to find the number of subarrays of A, that have unique elements.
 *
 * Since the number of subarrays could be large, return value % 109 +7.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 105
 *
 * 1 <= A[i] <= 106
 *
 *
 *
 * Input Format
 *
 * The only argument given is an Array A, having N integers.
 *
 *
 *
 * Output Format
 *
 * Return the number of subarrays of A, that have unique elements.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 1, 3]
 * Input 2:
 *
 *  A = [2, 1, 2]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  4
 * Output 1:
 *
 *  5
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Subarrays of A that have unique elements only:
 *  [1], [1], [1, 3], [3]
 * Explanation 2:
 *
 *  Subarrays of A that have unique elements only:
 *  [2], [1], [2, 1], [1, 2], [2]
 */
package Array.Arrays;

import java.util.HashSet;

public class CountSubarrays {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3};

        int ans = solve(arr);
        System.out.println(ans);
    }

    public static int solve(int[] arr) {

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i; j < arr.length; j++) {
//                Set<Integer> set = new HashSet<>();
//                boolean flag = true;
//                for (int k = i; k <= j; k++) {
//                    if (set.contains(arr[k])) {
//                        flag = false;
//                    }
//                    set.add(arr[k]);
//                }
//                if (flag) {
//                    count++;
//                }
//            }
//        }
        HashSet<Integer> hs = new HashSet<>();
        long ans = 0;
        int n = arr.length, left = 0;

        for (int right = 0; right < n; right++) {
            // check if arr[right] is already there in the present window
            while (hs.contains(arr[right])) { // increment left until arr[right] is present in window
                hs.remove(arr[left]);
                left++;
            }
            // add the sub-arrays ending at position right
            ans += right - left + 1;
            hs.add(arr[right]);
        }

        return (int) (ans % (long) (1e9 + 7));
    }
}
