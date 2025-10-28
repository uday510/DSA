package graph.shortest_path;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TheMaze2 {

    private static final int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    static final int inf = Integer.MAX_VALUE;

    public int shortestDistance(int[][] maze, int[] st, int[] en) {
        int m = maze.length, n = maze[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, inf);

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(k -> k[2]));
        queue.offer(new int[] {st[0], st[1], 0});
        dist[st[0]][st[1]] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], w = cur[2];

            if (x == en[0] && y == en[1]) return dist[x][y];

            if (dist[x][y] < w) continue;

            for (int[] dir : dirs) {
                int dx = x + dir[0], dy = y + dir[1];
                int cnt = 0;

                while (dx >= 0 && dx < m && dy >= 0 && dy < n && maze[dx][dy] == 0) {
                    dx += dir[0];
                    dy += dir[1];
                    cnt++;
                }

                dx -= dir[0];
                dy -= dir[1];

                if (cnt + w < dist[dx][dy]) {
                    dist[dx][dy] = cnt + w;
                    queue.offer(new int[] {dx, dy, cnt + w});
                }
            }
        }

        return -1;
    }

}
