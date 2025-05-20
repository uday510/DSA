package graph.dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    private final int[][] directions = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };

    public int minimumEffortPath(int[][] heights) {
        int m  = heights.length, n = heights[0].length;
        int[][] dists = new int[m][n];
        int INF = (int) 1e9;

        for (int[] row : dists) Arrays.fill(row, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Math.abs(a[2] - b[2]);
        });

        pq.offer(new int[] {0, 0, 0});
        dists[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], d = curr[1];

            if (dists[r][c] < d) continue;

            for (int[] direction : directions) {
                int newRow = direction[0] + r;
                int newCol = direction[1] + c;

                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) continue;

                int newWeight = Math.abs(heights[newRow][newCol] - d);

                if (newWeight < dists[newRow][newCol]) {
                    dists[newRow][newCol] = newWeight;
                    pq.offer(new int[] {newRow, newCol, d});
                }
            }
        }

        return dists[m - 1][n - 1] == INF ? -1 : dists[m - 1][n - 1];
    }
}
