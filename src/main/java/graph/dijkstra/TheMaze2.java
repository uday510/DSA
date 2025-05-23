package graph.dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheMaze2 {

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        int m = maze.length, n = maze[0].length;
        int[][] dists = new int[m][n];
        int INF = (int) 1e9;
        for (int[] row : dists) Arrays.fill(row, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] {start[0], start[1], 0});
        dists[start[0]][start[1]] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int row = curr[0], col = curr[1], d = curr[2];

            if (row == destination[0] && col == destination[1])
                return dists[destination[0]][destination[1]];

            if (dists[row][col] < d) continue;

            for (int[] dir : dirs) {
                int r = row, c = col;
                int count = 0;

                while (
                        r + dir[0] >= 0 && r + dir[0] < m &&
                                c + dir[1] >= 0 && c + dir[1] < n &&
                                maze[r + dir[0]][c + dir[1]]  == 0
                ) {
                    r += dir[0];
                    c += dir[1];
                    count++;
                }

                if (d + count < dists[r][c]) {
                    dists[r][c] = d + count;
                    pq.offer(new int[] {r, c, d + count});
                }
            }
        }

        return dists[destination[0]][destination[1]] == INF ? -1 : dists[destination[0]][destination[1]];
    }
}
