package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int N = profits.length;
        List<NODE> ipos = new ArrayList<>();

        for (int index = 0; index < N; ++index) {
            ipos.add(new NODE(profits[index], capital[index]));
        }

        ipos.sort(Comparator.comparingInt(o -> o.capital));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

        int i = 0;
        for (int index = 0; index < k; ++index) {

            while (i < N && ipos.get(i).capital <= w) {
                priorityQueue.offer(ipos.get(i).profit);
                i++;
            }

            if (priorityQueue.isEmpty()) {
                break;
            }

            w += priorityQueue.poll();
        }

        return w;
    }
    private class NODE {
        int profit;
        int capital;

        NODE(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
}
