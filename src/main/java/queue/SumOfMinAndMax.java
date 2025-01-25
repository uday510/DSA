/**
 * Problem Description
 * Given an array A of both positive and negative integers.
 *
 * Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
 *
 * NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of array A <= 105
 *
 * -109 <= A[i] <= 109
 *
 * 1 <= B <= size of array
 *
 *
 *
 * Input Format
 * The first argument denotes the integer array A.
 * The second argument denotes the value B
 *
 *
 *
 * Output Format
 * Return an integer that denotes the required value.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 5, -1, 7, -3, -1, -2]
 *  B = 4
 * Input 2:
 *
 *  A = [2, -1, 3]
 *  B = 2
 *
 *
 * Example Output
 * Output 1:
 *
 *  18
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Subarrays of size 4 are :
 *     [2, 5, -1, 7],   min + max = -1 + 7 = 6
 *     [5, -1, 7, -3],  min + max = -3 + 7 = 4
 *     [-1, 7, -3, -1], min + max = -3 + 7 = 4
 *     [7, -3, -1, -2], min + max = -3 + 7 = 4
 *     Sum of all min & max = 6 + 4 + 4 + 4 = 18
 * Explanation 2:
 *
 *  Subarrays of size 2 are :
 *     [2, -1],   min + max = -1 + 2 = 1
 *     [-1, 3],   min + max = -1 + 3 = 2
 *     Sum of all min & max = 1 + 2 = 3
 */
package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class SumOfMinAndMax {
    public static void main(String[] args) {
        int[] array = {2, 5, -1, 7, -3, -1, -2};
        int b = 4;

        int ans = solve(array, b);
        System.out.println(ans);
    }
    public static int solve(int[] array, int b) {
        int mod = (int) 1e9 + 7;
        int ans = 0;
        int currNum;
        int currSum;
        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();

        for (int i = 0; i < array.length; i++) {
            // O(N) time | O(N) space
            currNum = array[i];
            currSum = 0;

            // poll elements which are not part of the window
            if (!minDeque.isEmpty() && minDeque.peekFirst() == i - b) {
                minDeque.pollFirst();
            }

            if (!maxDeque.isEmpty() && maxDeque.peekFirst() == i - b) {
                maxDeque.pollFirst();
            }

            // remove the elements which are > curr.element from the
            // min.deque as we want only min elements.
            while (!minDeque.isEmpty() && array[minDeque.peekLast()] > currNum) {
                minDeque.pollLast();
            }


            // remove the elements which are < curr.element from the
            // max.deque as we want only max elements;
            while (!maxDeque.isEmpty() && array[maxDeque.peekLast()] < currNum) {
                maxDeque.pollLast();
            }
            // poll the current idx
            minDeque.offer(i);
            maxDeque.offer(i);

            //update currSum;
            if (!maxDeque.isEmpty() && !minDeque.isEmpty()) {
                currSum = array[maxDeque.peekFirst()] + array[minDeque.peekFirst()];
                currSum %= mod;
            }
            // update the ans;
            if (i >= b - 1) {
                ans += currSum;
            }
        }
        return ans;
    }
}
