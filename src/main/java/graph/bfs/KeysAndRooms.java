package graph.bfs;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> edges) {
        boolean[] vis = new boolean[edges.size()];
        int cnt = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        vis[0] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            cnt++;

            for (int v : edges.get(u)) {
                if(vis[v]) continue;
                vis[v] = true;
                queue.offer(v);
            }
        }


        return cnt == edges.size();
    }

}
