/**
 * Problem Description
 * Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
 *
 * NOTE: All the A integers will fit in 32-bit integers.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 29500
 *
 *
 *
 * Input Format
 * The only argument given is integer A.
 *
 *
 *
 * Output Format
 * Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 3
 * Input 2:
 *
 *  A = 7
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 2, 3]
 * Output 2:
 *
 *  [1, 2, 3, 11, 12, 13, 21]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Output denotes the first 3 integers that contains only digits 1, 2 and 3.
 * Explanation 2:
 *
 *  Output denotes the first 3 integers that contains only digits 1, 2 and 3.
 */
package queue;

import java.util.LinkedList;
import java.util.Queue;

public class NIntegersOnly123 {
    public static void main(String[] args) {
        int a = 7;

        int[] ans = solve(a);
        System.out.println(ans);
    }
    public static int[] solve(int a) {
        int[] ans = new int[a];
        int idx = 0;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        return ans;
    }
}
