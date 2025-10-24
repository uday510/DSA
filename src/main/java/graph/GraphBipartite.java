package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class GraphBipartite {

    int n;
    int[] color;
    int[][] adj;

    public boolean isBipartite(int[][] graph) {
        this.n = graph.length;
        this.color = new int[n];
        this.adj = graph;

        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                color[i] = 0;

                Queue<Integer> queue = new ArrayDeque<>();
                queue.offer(i);

                while (!queue.isEmpty()) {
                    int u = queue.poll();

                    for (int v : adj[u]) {
                        if (color[v] == -1) {
                            color[v] = 1 - color[u];
                            queue.offer(v);
                        } else if (color[u] == color[v]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    private boolean dfs(int u) {
        for (int v : adj[u]) {
            if (color[v] == -1) {
                color[v] = 1 - color[u];
                if (!dfs(v)) return false;
            } else if (color[u] == color[v]) {
                return false;
            }
        }

        return true;
    }

}
