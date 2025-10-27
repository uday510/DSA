package graph.shortest_path;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/swim-in-rising-water/description/?envType=problem-list-v2&envId=2c451k8e
public class SwimInRaisingWater {

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dists = new int[n][n];
        int INF = (int) 1e9;

        for (int[] row : dists) Arrays.fill(row, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] {0, 0, grid[0][0]});
        dists[0][0] = grid[0][0];

        int[][] dirs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], d = curr[2];

            if (r == n - 1 && c == n - 1) return d;
            if (dists[r][c] < d) continue;

            for (int[] dir : dirs) {
                int R = dir[0] + r;
                int C = dir[1] + c;

                if (R < 0 || R >= n || C < 0 || C >= n) continue;

                int D = Math.max(d, grid[R][C]);

                if (D < dists[R][C]) {
                    dists[R][C] = D;
                    pq.offer(new int[] {R, C, D} );
                }
            }
        }

        return dists[n - 1][n - 1];
    }
}
