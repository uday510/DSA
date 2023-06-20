/**
 * Problem Description
 * You are given a matrix A of size N x 2 which represents different operations.
 * Assume initially you have a stack-like data structure you have to perform operations on it.
 *
 * Operations are of two types:
 *
 * 1 x: push an integer x onto the stack and return -1.
 *
 * 2 0: remove and return the most frequent element in the stack. This basically means the element which has the highest count among all the elements currently in the stack.
 *
 * If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.
 *
 * A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 100000
 *
 * 1 <= A[i][0] <= 2
 *
 * 0 <= A[i][1] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the array of integers denoting the answer to each operation.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [
 *             [1, 5]
 *             [1, 7]
 *             [1, 5]
 *             [1, 7]
 *             [1, 4]
 *             [1, 5]
 *             [2, 0]
 *             [2, 0]
 *             [2, 0]
 *             [2, 0]  ]
 * Input 2:
 *
 *  A =  [
 *         [1, 5]
 *         [2, 0]
 *         [1, 4]   ]
 *
 * Example Output
 * Output 1:
 *
 *  [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]
 * Output 2:
 *
 *  [-1, 5, -1]
 */
package Stack;

import java.util.*;

public class MaximumFrequencyStack {

    public static void main(String[] args) {
        int[][] arr =  { {1, 5},
                         {1, 7},
                         {1, 5},
                         {1, 7},
                         {1, 4},
                         {1, 5},
                         {2, 0},
                         {2, 0},
                         {2, 0},
                         {2, 0}};

        int[] ans = solve(arr);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int[][] arr) {

        // to store frequency of an element in the stack.
        HashMap<Integer, Stack<Integer>> stacks = new HashMap<>();
        // to maintain the structure of stack and pop out top most element in case of tie.
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        Stack<Integer> tmpStack;
        int maxFreq = 0;
        int[] ans = new int[arr.length];
        int i = 0;

        for (int[] a : arr) {
            int operation = a[0];
            int val = a[1];
            //push operation
            if (operation == 1) {
                freqMap.putIfAbsent(val, 0);
                freqMap.put(val, freqMap.get(val) + 1);
                int currentValFreq = freqMap.get(val);
                maxFreq = Math.max(currentValFreq, maxFreq);
                if (stacks.get(currentValFreq) != null) {
                    tmpStack = stacks.get(currentValFreq);
                    tmpStack.push(val);
                } else {
                    tmpStack = new Stack<>();
                    tmpStack.push(val);
                    stacks.put(currentValFreq, tmpStack);
                }
                ans[i++] = -1;
            } else {
                // pop operation
                // pop
                val = stacks.get(maxFreq).pop();

                freqMap.put(val, freqMap.get(val) - 1);
                if (stacks.get(maxFreq).isEmpty()) maxFreq--;

                ans[i++] = val;
            }
        }
        return ans;
    }
}
