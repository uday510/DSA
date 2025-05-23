package graph.dijkstra;

// https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/?envType=problem-list-v2&envId=2c451k8e

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinCostToMakeAtLeastOneValidPath {

    public int minCost(int[][] grid) {
        final int m = grid.length, n = grid[0].length;
        final int[][] costs = new int[m][n];
        final int INF = (int) 1e9;

        for (int[] costRow : costs) Arrays.fill(costRow, INF);

        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });

        pq.offer(new int[] {0, 0, 0});
        costs[0][0] = 0;

        // Directions: right(1), left(2), down(3), up(4)
        final int[][] dirs = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int row = curr[0], col = curr[1], cost = curr[2];

            if (costs[row][col] < cost) continue;

            for (int dir = 0; dir < 4; ++dir) {
                int newRow = dirs[dir][0] + row;
                int newCol = dirs[dir][1] + col;

                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) continue;

                int newCost = cost + ( ( dir + 1 != grid[row][col] ) ? 1 : 0 );

                if (newCost < costs[newRow][newCol]) {
                    costs[newRow][newCol] = newCost;
                    pq.offer(new int[] { newRow, newCol, newCost });
                }
            }
        }


        return costs[m - 1][n - 1];
    }
}
