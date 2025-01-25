/**
 * Problem Description
 * Given an integer array A of size N.
 *
 * You have to find the product of the three largest integers in array A from range 1 to i, where i goes from 1 to N.
 *
 * Return an array B where B[i] is the product of the largest 3 integers in range 1 to i in array A. If i < 3, then the integer at index i in B should be -1.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 0 <= A[i] <= 103
 *
 *
 *
 * Input Format
 * First and only argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return an integer array B. B[i] denotes the product of the largest 3 integers in range 1 to i in array A.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 * Input 2:
 *
 *  A = [10, 2, 13, 4]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [-1, -1, 6, 24, 60]
 * Output 2:
 *
 *  [-1, -1, 260, 520]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  For i = 1, ans = -1
 *  For i = 2, ans = -1
 *  For i = 3, ans = 1 * 2 * 3 = 6
 *  For i = 4, ans = 2 * 3 * 4 = 24
 *  For i = 5, ans = 3 * 4 * 5 = 60
 *
 *  So, the output is [-1, -1, 6, 24, 60].
 *
 * Explanation 2:
 *
 *  For i = 1, ans = -1
 *  For i = 2, ans = -1
 *  For i = 3, ans = 10 * 2 * 13 = 260
 *  For i = 4, ans = 10 * 13 * 4 = 520
 *
 *  So, the output is [-1, -1, 260, 520].
 *
 */
package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Productof3 {
    public static void main(String[] args) {
        int[] array = {10, 2, 13, 4};

        int[] ans = solve(array);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] solve(int[] array) {
        int n = array.length;
        int[] ans = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>(new CustomComp());

        for (int i = 0; i < n; i++) {
            pq.offer(array[i]);

            if (i < 2) {
                ans[i] = -1;
            } else {
                int a = pq.poll();
                int b = pq.poll();
                int c = pq.poll();

                pq.offer(a);
                pq.offer(b);
                pq.offer(c);

                ans[i] = a * b * c;
            }
        }
        return ans;
    }
}
    class CustomComp implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return b.compareTo(a);
        }
    }
