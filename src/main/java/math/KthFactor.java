package math;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthFactor {
    public static void main(String[] args) {

        System.out.println(kthFactor(24, 4));
    }
    public static int kthFactor(int n, int k) {
        int sqrtN = (int) Math.sqrt(n);
        Heap heap = new Heap();

        for (int i = 1; i <= sqrtN; ++i) {
            if (n % i == 0) {
                heap.push(i, k);
                if (i != n/i) {
                    heap.push(n/i, k);
                }
            }
        }
        return heap.size() == k ? heap.poll(k) : -1;
    }
    static class Heap {
        Queue<Integer> heap;

        Heap() {
            heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        }
        void push(int val,int k) {
            heap.add(val);
            if (heap.size() > k) heap.poll();
        }
        int size() {
            return heap.size();
        }
        int poll(int k) {
            int tmp = -1;
            if (!heap.isEmpty() && heap.size() == k) {
                tmp = heap.poll();
            }
            return tmp;
        }
    }
}
