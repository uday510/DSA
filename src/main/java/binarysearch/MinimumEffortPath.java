package binarysearch;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumEffortPath {
    private static final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static void main(String[] args) {
        int[][] heights = {{1, 2, 3}, {3, 8, 4}, {5, 3, 5}};

        int res = minimumEffortPath(heights);
        System.out.println(res);
    }
    public static int minimumEffortPath(int[][] heights) {
        int left = 0;
        int right = 1000000;
        int res =  right;

        while (left <= right) {
            int midIdx = (left + right) / 2;
            if (canReach(heights, midIdx)) {
                res = Math.min(res, midIdx);
                right = midIdx - 1;
            } else {
                left = midIdx + 1;
            }
        }
        return res;
    }

    static boolean canReach(int[][] heights, int k) {
        int n = heights.length;
        int m = heights[0].length;

        Queue<Cell> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        queue.add(new Cell(0, 0));

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            int x = cell.x;
            int y = cell.y;

            if (x == n - 1 && y == m - 1) {
                return true;
            }

            for (int[] dir : directions) {

                int adjX = x + dir[0];
                int adjY = y + dir[1];


                if (isValid(adjX, adjY, n, m)) {

                    if (visited[adjX][adjY]) {
                        continue;
                    }

                    int currDiff = Math.abs(heights[adjX][adjY] - heights[cell.x][cell.y]);

                    if (currDiff <= k) {
                        visited[adjX][adjY] = true;
                        queue.offer(new Cell(adjX, adjY));
                    }
                }
            }
        }
        return false;
    }
    static boolean isValid(int x, int y, int row, int col) {
        return (x > -1 && x < row && y > -1 && y < col);
    }
}
class Cell {
    int x;
    int y;

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
