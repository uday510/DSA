package graph.dfs;

import java.util.Arrays;

public class TheMaze2 {

    private final int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    int[][] dists;
    int[] destination;
    int m, n;
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        this.destination = destination;
        int INF = (int) 1e9;
        dists = new int[m][n];

        for (int[] row : dists) Arrays.fill(row, INF);

        dfs(maze, start[0], start[1], 0);

        return dists[destination[0]][destination[1]] == INF ? -1 : dists[destination[0]][destination[1]];
    }
    private void dfs(int[][] maze, int row, int col, int dist) {
        if (dist >= dists[row][col]) return;

        dists[row][col] = dist;

        for (int[] dir : dirs) {
            int r = row, c = col;
            int count = 0;

            while ( r + dir[0] >= 0 && r + dir[0] < m &&
                    c + dir[1] >= 0 && c + dir[1] < n &&
                    maze[r + dir[0]][c + dir[1]] == 0) {

                r += dir[0];
                c += dir[1];
                count++;
            }

            dfs(maze, r, c, count + dist);
        }
    }
}
