package bfs;

import java.util.ArrayDeque;
import java.util.Queue;

// https://leetcode.com/problems/01-matrix/?envType=study-plan-v2&envId=graph-theory
public class BinaryMatrix {

    public int[][] updateMatrix(int[][] mat) {
        return highestPeak(mat);
    }

    private final static int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int[][] highestPeak(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        int[][] res = new int[m][n];

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    queue.offer(new int[] {i, j, 0});
                } else {
                    res[i][j] = -1;
                }
            }
        }

        if (queue.size() == m * n) return res;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dx = cur[0], dy = cur[1], w = cur[2];

            for (int[] dir : dirs) {
                int nx = dx + dir[0], ny = dy + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || res[nx][ny] >= 0) continue;
                queue.offer(new int[] {nx, ny, w + 1});
                res[nx][ny] = w + 1;

            }
        }


        return res;
    }
}
