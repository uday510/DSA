/**
 * Problem Description
 * Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
 *
 * Since the answer may be large, return the answer modulo (109 + 7).
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 109
 * 1 <= B <= 106
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 *
 *
 *
 * Output Format
 * Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 *  B = 2
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *  B = 28
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5).
 *  So total 4 pairs.
 */
package math;

import java.util.HashMap;

public class PairSumDivisibleByM {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5};
        int b = 2;

        int ans = solve(array, b);
        System.out.println(ans);
    }
    public static int solve(int[] array, int b) {

        //Insert all elements in map after taking modulo with b

        HashMap<Integer, Integer> map = new HashMap<>();
        int mod = (int) (1e9 + 7);

        for (int num : array) {
            num = num % b;
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }

        long ans = 0;
        long temp;
        long val;
        // 0 frequency
        if (map.containsKey(0)) {
            val = map.get(0);
            temp = (val * (val - 1) / 2);
            ans = (temp + ans) % mod;
        }

        // even (b/2) case
        if (b % 2 == 0) {
            if(map.containsKey(b/2)) {
                val = map.get(b / 2);
                temp = (val * (val - 1)) / 2;
                ans = (temp + ans) % mod;
            }
        }

        for(int i = 1; i < (b +1) / 2; i++) {
            if (map.containsKey(i) && map.containsKey(b - i)) {
                temp = (long) map.get(i) * map.get(b-i);
                ans = (temp + ans) % mod;
            }
        }
        return (int) ans;
    }
}
