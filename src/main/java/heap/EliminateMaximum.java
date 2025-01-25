package heap;

import java.util.BitSet;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class EliminateMaximum {
    public static void main(String[] args) {

    }
    public int eliminateMaximum(int[] dist, int[] speed) {
        int N = dist.length;
        PriorityQueue<Double> heap = new PriorityQueue<>();
        for (int i = 0; i < N; ++i) {
            heap.offer((double) dist[i]/speed[i]);
        }
        int monstersKilledSoFar = 0;

        while (!heap.isEmpty() && heap.peek() - monstersKilledSoFar > 0) {
            heap.poll();
            monstersKilledSoFar+=1;
        }

        return monstersKilledSoFar;
    }
}
