package graph.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class PathWithMinimumEffort {

    private final int[][] directions = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };

    public int minimumEffortPath(int[][] heights) {

        int left = 0, right = (int) 1e6;

        while (left < right) {
            int mid = (left + right) >> 1;

            boolean pathExists = isPathExists(heights, mid);
            if (!pathExists) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private boolean isPathExists(int[][] heights, int k) {
        int rows = heights.length, columns = heights[0].length;
        boolean[][] vis = new boolean[rows][columns];
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] {0, 0});
        vis[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1];

            if (row == rows - 1 && col == columns - 1) return true;

            for (int[] direction : directions) {
                int nextRow = direction[0] + row;
                int nextCol = direction[1] + col;

                if (nextRow < 0 || nextRow >= rows ||
                        nextCol < 0 || nextCol >= columns || vis[nextRow][nextCol]) continue;

                int newDifference = Math.abs(heights[nextRow][nextCol] - heights[row][col]);

                if (newDifference > k) continue;

                vis[nextRow][nextCol] = true;

                queue.offer(new int[] {nextRow, nextCol});
            }
        }
        return false;
    }

}
