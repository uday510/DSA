package bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class JumpGame3 {

    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        int dest = 0;
        int n = arr.length;
        boolean[] vis = new boolean[n];
        vis[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (arr[cur] == dest) return true;

            for (int next : new int[] {cur + arr[cur], cur - arr[cur]}) {
                if (next < 0 || next >= n || vis[next]) continue;
                vis[next] = true;
                queue.offer(next);
            }
        }

        return false;
    }

}
