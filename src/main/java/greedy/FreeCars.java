/**
 * Problem Description
 * Given two arrays, A and B of size N. A[i] represents the time by which you can buy the ith car without paying any money.
 *
 * B[i] represents the profit you can earn by buying the ith car. It takes 1 minute to buy a car, so you can only buy the ith car when the current time <= A[i] - 1.
 *
 * Your task is to find the maximum profit one can earn by buying cars considering that you can only buy one car at a time.
 *
 * NOTE:
 *
 * You can start buying from time = 0.
 * Return your answer modulo 109 + 7.
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= A[i] <= 109
 * 0 <= B[i] <= 109
 *
 *
 *
 * Input Format
 * The first argument is an integer array A represents the deadline for buying the cars.
 * The second argument is an integer array B represents the profit obtained after buying the cars.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum profit you can earn.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 3, 2, 3, 3]
 *  B = [5, 6, 1, 3, 9]
 * Input 2:
 *
 *  A = [3, 8, 7, 5]
 *  B = [3, 1, 7, 19]
 *
 *
 * Example Output
 * Output 1:
 *
 *  20
 * Output 2:
 *
 *  30
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  At time 0, buy car with profit 5.
 *  At time 1, buy car with profit 6.
 *  At time 2, buy car with profit 9.
 *  At time = 3 or after , you can't buy any car, as there is no car with deadline >= 4.
 *  So, total profit that one can earn is 20.
 * Explanation 2:
 *
 *  At time 0, buy car with profit 3.
 *  At time 1, buy car with profit 1.
 *  At time 2, buy car with profit 7.
 *  At time 3, buy car with profit 19.
 *  We are able to buy all cars within their deadline. So, total profit that one can earn is 30.
 */
package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FreeCars {
    public static void main(String[] args) {
        int[] A = {1, 3, 2, 3, 3};
        int[] B = {5, 6, 1, 3, 9};

        int ans = solve(A, B);
        System.out.println(ans);
    }
    public static int solve(int[] A, int[] B) {
        int n = A.length;
        Pair[] pairs = new Pair[n];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            Pair currPair = new Pair(A[i], B[i]);
            pairs[i] = currPair;
        }
        Arrays.sort(pairs, new CustomComparator());

        int currTime = 0; // time
        for (int i = 0; i < n; i++) {
            Pair curr = pairs[i];
            if (currTime < curr.time) {
                minHeap.add(curr.profit);
                ++currTime;
            } else {
                if (curr.profit <= minHeap.peek()) {
                } // ignore, because we want maximum profit
                else {
                    minHeap.poll();
                    minHeap.add(curr.profit);
                }
            }
        }
        int res = 0;

        while (!minHeap.isEmpty()) {
            res += minHeap.peek();
            minHeap.poll();
        }
        return res;
    }

    static class CustomComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            return p1.time - p2.time;
        }
    }

    static class Pair {
        int time;
        int profit;

        Pair(int time, int profit) {
            this.time = time;
            this.profit = profit;
        }
    }
}
