/**
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible,
 *
 * return -1.
 *
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 *
 *
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 */
package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {

        System.out.println(orangesRotting());
    }

    private static final int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
    private static final int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private static boolean[][] visited;
    private static int m;
    private static int n;
    private static int orangesRotting() {
        m = grid.length;
        n = grid[0].length;
        int freshOranges = 0;
        int minutes = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        visited = new boolean[m][n];

        for (int row = 0; row < m; ++row) {
            for (int col = 0; col < n; ++col) {
                int curr = grid[row][col];
                if (curr == 2) {
                    queue.offer(new int[]{row, col});
                    visited[row][col] = true;
                } else if (curr == 1) {
                    ++freshOranges;
                }
            }
        }

        if (freshOranges == 0) return -1;
        queue.offer(new int[]{-1, -1});

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();

            if (arr[0] == -1 && arr[1] == -1) {
                ++minutes;
                if (!queue.isEmpty()) {
                    queue.offer(new int[]{-1, -1});
                }
            }

            for (int[] dir : dirs) {
                int R = dir[0] + arr[0];
                int C = dir[1] + arr[1];

                if (!isValid(R, C)) continue;

                queue.offer(new int[]{R, C});
                visited[R][C] = true;
                --freshOranges;
            }
        }

        return freshOranges == 0 ? minutes : -1;
    }

    private static boolean isValid(int R, int C) {
        return !(R < 0 || R >= m || C < 0 || C >= n || grid[R][C] == 0 || visited[R][C]);
    }
}
