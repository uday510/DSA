package graph.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class TheMaze2 {

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        int m = maze.length, n = maze[0].length;
        int[][] dists = new int[m][n];
        int INF = (int) 1e9;
        for (int[] row : dists) Arrays.fill(row, INF);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {start[0], start[1], 0});
        dists[start[0]][start[1]] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1], d = curr[2];

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
                    queue.offer(new int[] {r, c, d + count});
                }
            }
        }

        return dists[destination[0]][destination[1]] == INF ? -1 : dists[destination[0]][destination[1]];
    }
}
