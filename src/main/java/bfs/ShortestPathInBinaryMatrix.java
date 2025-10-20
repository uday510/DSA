package bfs;

import java.util.ArrayDeque;
import java.util.Queue;

// https://leetcode.com/problems/shortest-path-in-binary-matrix/?envType=study-plan-v2&envId=graph-theory
public class ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        int n = grid.length;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 1});
        grid[0][0] = 2;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dx = cur[0], dy = cur[1], w = cur[2];

            if (dx == n - 1 && dy == n - 1) return w;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (Math.abs(i) + Math.abs(j) == 0) continue;

                    int nx = dx + i, ny = dy + j;

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || grid[nx][ny] != 0) continue;

                    queue.offer(new int[] {nx, ny, w + 1});
                    grid[nx][ny] = 2;
                }
            }
        }

        return -1;
    }
}
