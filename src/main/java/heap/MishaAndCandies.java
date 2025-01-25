package heap; /**
 * Problem Description
 * Misha loves eating candies. She has been given N boxes of Candies.
 *
 * She decides that every time she will choose a box having the minimum number of candies, eat half of the candies and put the remaining candies in the other box that has the minimum number of candies.
 * Misha does not like a box if it has the number of candies greater than B so she won't eat from that box. Can you find how many candies she will eat?
 *
 * NOTE 1: If a box has an odd number of candies then Misha will eat the floor(odd / 2).
 *
 * NOTE 2: The same box will not be chosen again.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * 1 <= A[i] <= 105
 *
 * 1 <= B <= 106
 *
 *
 *
 * Input Format
 * The first argument is A an Array of Integers, where A[i] is the number of candies in the ith box.
 * The second argument is B, the maximum number of candies Misha like in a box.
 *
 *
 *
 * Output Format
 * Return an integer denoting the number of candies Misha will eat.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [3, 2, 3]
 *  B = 4
 * Input 2:
 *
 *  A = [1, 2, 1]
 *  B = 2
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  1st time Misha will eat from 2nd box, i.e 1 candy she'll eat and will put the remaining 1 candy in the 1st box.
 *  2nd time she will eat from the 3rd box, i.e 1 candy she'll eat and will put the remaining 2 candies in the 1st box.
 *  She will not eat from the 3rd box as now it has candies greater than B.
 *  So the number of candies Misha eat is 2.
 * Explanation 2:
 *
 *  1st time Misha will eat from 1st box, i.e she can't eat any and will put the remaining 1 candy in the 3rd box.
 *  2nd time she will eat from the 3rd box, i.e 1 candy she'll eat and will put the remaining 1 candies in the 2nd box.
 *  She will not eat from the 2nd box as now it has candies greater than B.
 *  So the number of candies Misha eat is 1.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MishaAndCandies {
    static ArrayList<Integer> heap;
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(List.of(3,2,3));

        int ans = solve(array, 4);
        System.out.println(ans);
    }
    public static int solveUsingPQ(ArrayList<Integer> array, int B){
        int candiesAte = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : array) pq.offer(i);
        while (!pq.isEmpty() && pq.peek() <= B) {
            int min = pq.poll();
            candiesAte += (int) Math.floor(min/2);
            min -= (int) Math.floor(min/2);
            if (!pq.isEmpty()) {
                int val = pq.poll();
                val += min;
                pq.offer(val);
            }
        }
        return candiesAte;

    }
    public static int solve(ArrayList<Integer> array, int B) {
        heap = buildHeap(array);
        int candiesAte = 0;

        while (!heap.isEmpty() && peek() <= B) {
            int min = remove();
            candiesAte += (int) Math.floor(min / 2);
            min -= (int) Math.floor(min / 2);
            if (!heap.isEmpty()) {
                int val = remove();
                val += min;
                insert(val);
            }
        }
        return candiesAte;
    }
    public static ArrayList<Integer> buildHeap(ArrayList<Integer> array) {
        int firstParentIdx = (array.size() - 2 ) / 2;
        for (int currentIdx = firstParentIdx; currentIdx > -1; --currentIdx) {
            siftDown(currentIdx, array.size() - 1, array);
        }
        return array;
    }
    public static void siftDown(int currentIdx, int endIdx, ArrayList<Integer> heap) {
        int childOneIdx = currentIdx * 2+ 1;
        while (childOneIdx <= endIdx) {
            int childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
            int idxToSwap;
            if (childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)) {
                idxToSwap = childTwoIdx;
            } else {
                idxToSwap = childOneIdx;
            }
            if (heap.get(idxToSwap) < heap.get(currentIdx)) {
                swap(currentIdx, idxToSwap, heap);
                currentIdx = idxToSwap;
                childOneIdx = currentIdx * 2 + 1;
            } else {
                return;
            }
        }
    }

    // O(Log(N)) time | O(1) space
    public static void siftUp(int currentIdx, ArrayList<Integer> heap) {
        int parentIdx = (currentIdx - 1) / 2;
        while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
            swap(currentIdx, parentIdx, heap);
            currentIdx = parentIdx;
            parentIdx = (currentIdx - 1) / 2;
        }
    }
    public static int peek() {
        return heap.get(0);
    }
    public static int remove() {
        swap(0, heap.size() - 1, heap);
        int valueToRemove = heap.get(heap.size() - 1);
        heap.remove(heap.size() - 1);
        siftDown(0, heap.size() - 1, heap);
        return valueToRemove;
    }
    public static void insert(int value) {
        heap.add(value);
        siftUp(heap.size() - 1, heap);
    }
    public static void swap(int i, int j, ArrayList<Integer> heap) {
        Integer temp = heap.get(j);
        heap.set(j, heap.get(i));
        heap.set(i, temp);
    }

}
