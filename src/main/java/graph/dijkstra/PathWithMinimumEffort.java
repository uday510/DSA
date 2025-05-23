package graph.dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    private final int[][] directions = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };

    public int minimumEffortPath(int[][] heights) {
        int[][] dirs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };
        int m = heights.length, n = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        int[][] dists = new int[m][n];
        int INF = (int) 1e9;
        for (int[] row : dists) Arrays.fill(row, INF);
        pq.offer(new int[]{0, 0, 0});
        dists[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], d = curr[2];

            if (dists[r][c] < d) continue;

            for (int[] dir : dirs) {
                int R = dir[0] + r, C = dir[1] + c;

                if (R < 0 || R >= m || C < 0 || C >= n) continue;

                int D = Math.abs(heights[R][C] - heights[r][c]);
                D = Math.max(d, D);

                if (D < dists[R][C]) {
                    dists[R][C] = D;
                    pq.offer(new int[] {R, C, D});
                }
            }
        }

        return dists[m - 1][n - 1];
    }
}
