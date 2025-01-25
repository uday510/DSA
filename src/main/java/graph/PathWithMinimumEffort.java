package graph;

import java.util.LinkedList;
import java.util.Queue;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(minimumEffortPath(heights));
    }
    public static int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] visited = new boolean[m][n];

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        int maxDiff = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,0,0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            maxDiff = Math.max(maxDiff, pair.diff);
            if (pair.row == m-1 && pair.col == n-1) {
                return maxDiff;
            }
            for (int[] dir : dirs) {
                int newRow = pair.row + dir[0];
                int newCol = pair.col + dir[1];
                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || visited[newRow][newCol]) {
                    continue;
                }
                int newDiff = Math.abs(heights[newRow][newCol] - heights[pair.row][pair.col]);
                if (newDiff < maxDiff) {
                    continue;
                }
                queue.add(new Pair(newRow, newCol, newDiff));
                visited[newRow][newCol] = true;
            }
        }
        return -1;

    } static class Pair {
        int row;
        int col;
        int diff;

        Pair(int row, int col, int diff) {
            this.row = row;
            this.col = col;
            this.diff = diff;
        }
    }
}
