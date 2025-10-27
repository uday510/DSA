package graph.shortest_path;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumTimeToReachLastRoom1 {

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        long[][] dists = new long[n][m];
        long INF = Long.MAX_VALUE;

        for (long[] row : dists) Arrays.fill(row, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] {0, 0, 0});
        dists[0][0] = 0;

        int[][] dirs = {{0,1}, {1, 0}, {-1, 0}, {0, -1}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], d = curr[2];

            if (dists[r][c] < d) continue;

            for (int[] dir : dirs) {
                int R = dir[0] + r;
                int C = dir[1] + c;

                if (R < 0 || R >= n || C < 0 || C >= m) continue;

                int w = Math.max(d, moveTime[R][C]) + 1;

                if (w < dists[R][C]) {
                    dists[R][C] = w;
                    pq.offer(new int[] {R, C, w});
                }
            }
        }

        return (int) dists[n - 1][m - 1];
    }
}
