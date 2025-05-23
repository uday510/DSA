package graph.dfs;

// https://leetcode.com/problems/the-maze/

public class TheMaze {

    boolean[][] vis;
    int[] destination;
    int m, n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) return false;
        m = maze.length;
        n = maze[0].length;
        vis = new boolean[m][n];
        this.destination = destination;
        return dfs(maze, start[0], start[1]);
    }

    final private int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    private boolean dfs(int[][] maze, int row, int col) {
        if (row == destination[0] && col == destination[1]) return true;

        if (vis[row][col]) return false;

        vis[row][col] = true;

        for (int[] dir : dirs) {
            int nextRow = dir[0] + row;
            int nextCol = dir[1] + col;

            while (nextRow >= 0 && nextRow < m &&
                    nextCol >= 0 && nextCol < n &&
                    maze[nextRow][nextCol] == 0
            ) {
                nextRow += dir[0];
                nextCol += dir[1];
            }

            nextRow -= dir[0];
            nextCol -= dir[1];

            if (dfs(maze, nextRow, nextCol)) {
                return true;
            }
        }

        return false;
    }
}
