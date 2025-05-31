package graph.dijkstra;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SnakesAndLadders {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Map<Integer, int[]> pos = new HashMap<>();
        generatePositions(pos, n);

        return dijsktra(pos, n, board);
    }

    private int dijsktra(Map<Integer, int[]> pos, int n, int[][] board) {
        int INF = (int) 1e9;
        int LAST_POS = n * n;
        int[] dists = new int[(n + 1) * (n + 1)];
        Arrays.fill(dists, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {1, 0});
        dists[1] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], w = curr[1];

            if (u == LAST_POS) return w;
            if (dists[u] < w) continue;

            for (int next = u + 1; next <= Math.min(u + 6, LAST_POS); ++next) {
                int[] coord = pos.get(next);
                int row = coord[0], col = coord[1];
                int v = next;

                if (board[row][col] != -1) v = board[row][col];

                if ((w + 1) < dists[v]) {
                    dists[v] = w + 1;
                    pq.offer(new int[] {v, w + 1});
                }
            }
        }

        return -1;
    }

    private void generatePositions(Map<Integer, int[]> map, int n) {
        boolean movingRight = true;
        int currPos = 1;

        for (int i = n - 1; i > -1; --i) {

            if (movingRight) {
                for (int j = 0; j < n; ++j) {
                    map.put(currPos++, new int[] {i, j});
                }
            } else {
                for (int j = n - 1; j > -1; --j) {
                    map.put(currPos++, new int[] {i, j});
                }
            }
            movingRight = !movingRight;
        }
    }
}
