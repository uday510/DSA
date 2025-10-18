package design;

import java.util.ArrayList;
import java.util.List;

class MRUQueue {
    List<Integer> queue;
    public MRUQueue(int n) {
        queue = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
    }

    public int fetch(int k) {
        int v = queue.remove(k - 1);
        queue.add(v);
        return v;
    }
}
