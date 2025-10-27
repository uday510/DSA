package graph.shortest_path;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinCostToMakeAtleastOneValidPathInGrid {

    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int[][] dists = new int[m][n];
        int INF = (int) 1e9;
        for (int[] row : dists) Arrays.fill(row, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] {0, 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], d = curr[2];

            if (dists[r][c] < d) continue;

            for (int i = 0; i < dirs.length; ++i) {
                int[] dir = dirs[i];
                int R = dir[0] + r;
                int C = dir[1] + c;
                int D = d;

                if (R < 0 || R >= m || C < 0 || C >= n) continue;

                boolean RIGHT = i == 0;
                boolean LEFT = i == 2;
                boolean DOWN = i == 1;
                boolean UP = i == 3;

                if (RIGHT) {
                    if (grid[R][C] != 1) D++;
                } else if (LEFT) {
                    if (grid[R][C] != 2) D++;
                } else if (DOWN) {
                    if (grid[R][C] != 3) D++;
                } else if (UP) {
                    if (grid[R][C] != 4) D++;
                }

                if (D < dists[R][C]) {
                    pq.offer(new int[] {R, C, D});
                }
            }
        }

        return dists[m - 1][n - 1] == INF ? -1 : dists[m - 1][n - 1];
    }
}
