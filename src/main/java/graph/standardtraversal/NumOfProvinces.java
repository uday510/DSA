package graph.standardtraversal;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumOfProvinces {

    int[][] arr;
    int[] vis;

    public int findCircleNum(int[][] arr) {
        vis = new int[arr.length];
        this.arr = arr;
        int cnt = 0;

        for (int city = 0; city < arr.length; ++city) {

            if (vis[city] == 1) continue;

            cnt++;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(city);
            vis[city] = 1;
            while (!queue.isEmpty()) {
                int i = queue.poll();

                for (int j = 0; j < arr[i].length; ++j) {
                    if (arr[i][j] == 0 || vis[j] == 1) continue;
                    vis[j] = 1;
                    queue.offer(j);
                }
            }
        }

        return cnt;
    }

    private void dfs(int i) {
        if (vis[i] == 1) return;

        vis[i] = 1;
        for (int j = 0; j < arr[i].length; ++j) {
            if (arr[i][j] == 0) continue;

            dfs(j);
        }
    }

}
