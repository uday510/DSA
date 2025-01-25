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
 *  Output denotes the first 7 integers that contains only digits 1, 2 and 3.
 */
package queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Only123 {
    public static void main(String[] args) {
        int a = 15;

        int[] ans = solve(a);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int a) {
        // O(N) time | O(N) space
        Queue<Integer> queue = new LinkedList<>();
        int[] output = new int[a];
        queue.add(1);
        queue.add(2);
        queue.add(3);
        int currIdx = 0;
        int cnt = 3;

        while (currIdx < a) {
            int val = queue.poll();
            output[currIdx++] = val;
            if (cnt >= a) continue;

            queue.add(val * 10 + 1);
            queue.add(val * 10 + 2);
            queue.add(val * 10 + 3);
            cnt += 3;
        }
        return output;
        /**   my logic
         * if (a == 1) return new int[] {1};
         *         if (a == 2) return new int[] {1, 2};
         *         if (a == 3) return new int[] {1, 2, 3};
         *
         *         int[] output = new int[a];
         *         int idx = 0;
         *         output[idx++] = 1;
         *         output[idx++] = 2;
         *         output[idx++] = 3;
         *         Queue<Integer> queue = new LinkedList<>();
         *         queue.add(1);
         *         queue.add(2);
         *         queue.add(3);
         *
         *         int val = 10;
         *         int i = 3;
         *
         *         while (true) {
         *             int curr = queue.peek() * val + 1;
         *             i++;
         *             output[idx++] = curr;
         *             queue.add(curr);
         *             if (i == a) break;
         *
         *             curr = queue.peek() * val + 2;
         *             i++;
         *             queue.add(curr);
         *             output[idx++] = curr;
         *             if (i == a) break;
         *
         *             curr = queue.peek() * val + 3;
         *             i++;
         *             queue.add(curr);
         *             output[idx++] = curr;
         *             if (i == a) break;
         *
         *             queue.poll();;
         *         }
         *         return output;
         */
    }
}
