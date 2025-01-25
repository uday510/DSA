/**
 * Problem Description
 * You are given an array A of integers that represent the lengths of ropes.
 *
 * You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.
 *
 * Find and return the minimum cost to connect these ropes into one rope.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 1000
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the minimum cost to connect these ropes into one rope.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *
 *
 * Example Output
 * Output 1:
 *
 *  33
 * Output 2:
 *
 *  182
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Given array A = [1, 2, 3, 4, 5].
 *  Connect the ropes in the following manner:
 *  1 + 2 = 3
 *  3 + 3 = 6
 *  4 + 5 = 9
 *  6 + 9 = 15
 *
 *  So, total cost  to connect the ropes into one is 3 + 6 + 9 + 15 = 33.
 * Explanation 2:
 *
 *  Given array A = [5, 17, 100, 11].
 *  Connect the ropes in the following manner:
 *  5 + 11 = 16
 *  16 + 17 = 33
 *  33 + 100 = 133
 *
 *  So, total cost  to connect the ropes into one is 16 + 33 + 133 = 182.
 */
package heap;

import java.util.PriorityQueue;

public class ConnectRopes {
    public static void main(String[] args) {
        int[] ropes = {4};

        int ans = connectRopes(ropes);
        System.out.println(ans);
    }
    public static int connectRopes(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int stick : A) {
            pq.offer(stick);
        }
        int minCost = 0;

        while (pq.size() >= 2) {
            int firstCost = pq.poll();
            int secondCost = pq.poll();

            int combinedCost = firstCost + secondCost;
            minCost += combinedCost;
            pq.offer(combinedCost);
        }
        return minCost;
    }
    public static int solve(int[] ropes) {
        buildMinHeap(ropes);
        int ans = 0;
        for (int endIdx = ropes.length - 1; endIdx > 1; --endIdx) {
            int temp = ropes[0] + ropes[1];

            siftDown(0, endIdx - 2, ropes);
        }
        return ans;
    }
    public static void buildMinHeap(int[] array) {
        int firstParentIdx = (array.length - 2) / 2;
        for (int currentIdx = firstParentIdx; currentIdx > -1; --currentIdx) {
            siftDown(currentIdx, array.length - 1, array);
        }
    }
    public static void siftDown(int currentIdx, int endIdx, int[] heap) {
        int childOneIdx = currentIdx * 2 + 1;
        while (childOneIdx <= endIdx) {
            int childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
            int idxToSwap;
            if (childTwoIdx != -1 && heap[childTwoIdx] < heap[childOneIdx]) {
                idxToSwap = childTwoIdx;
            } else {
                idxToSwap = childOneIdx;
            }
            if (heap[idxToSwap] < heap[currentIdx]) {
                swap(idxToSwap, currentIdx, heap);
                currentIdx = idxToSwap;
                childOneIdx = currentIdx * 2 + 1;
            } else {
                return;
            }
        }
    }
    public static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
