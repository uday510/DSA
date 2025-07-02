package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestBridge {

    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    Queue<int[]> queue;
    boolean[][] visited;
    int[][] grid;
    int n;
    int m;
    public int shortestBridge(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];
        queue = new ArrayDeque<>();
        this.grid = grid;
        boolean found = false;

        for (int i = 0; i < n && !found; ++i) {
            for (int j = 0; j < m && !found; ++j) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    found = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] dir : dirs) {
                int R = dir[0] + curr[0];
                int C = dir[1] + curr[1];

                if (!isValid(R, C)) continue;

                if (grid[R][C] == 0) return curr[2];

                visited[R][C] = true;

                queue.offer(new int[]{R, C, curr[2] + 1});
            }
        }
        return -1;
    }

    private void dfs(int row, int col) {
        if (!isValid(row, col) || grid[row][col] == 0) return;

        visited[row][col] = true;
        queue.offer(new int[] {row, col, 0});
        for (int[] dir : dirs) {
            int R = dir[0] + row;
            int C = dir[1] + col;

            dfs(R, C);
        }
    }

    private boolean isValid(int row, int col) {
        return (row < 0 || row >= n || col < 0 || col >= m || visited[row][col]);
    }

}
