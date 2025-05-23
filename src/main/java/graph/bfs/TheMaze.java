package graph.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class TheMaze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] vis = new boolean[m][n];

        queue.offer(new int[] {start[0], start[1]});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1];

            if (row == destination[0] && col == destination[1]) return true;

            for (int[] dir : dirs) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                while (
                        nextRow >= 0 && nextRow < m &&
                                nextCol >= 0 && nextCol < n &&
                                maze[nextRow][nextCol] == 0
                ) {
                    nextRow += dir[0];
                    nextCol += dir[1];
                }

                nextRow -= dir[0];
                nextCol -= dir[1];

                if (vis[nextRow][nextCol]) continue;

                queue.offer(new int[] {nextRow, nextCol});
                vis[nextRow][nextCol] = true;
            }
        }

        return false;
    }
}
