import java.util.*;

public class WC370 {


    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {2, 4}, {4, 5}};
        int[] values = {5, 2, 5, 2, 1, 1};
        System.out.println(maximumScoreAfterOperations(edges, values));


    }

    public static long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = values.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        long[] maxScore = {0};
        boolean[] visited = new boolean[n];

        dfs(0, values, graph, visited, maxScore);

        return maxScore[0];
    }

    private static void dfs(int node, int[] values, List<List<Integer>> graph, boolean[] visited, long[] maxScore) {
        visited[node] = true;
        long currentScore = values[node];

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                currentScore += Math.max(0, values[neighbor]);
            }
        }

        maxScore[0] = Math.max(maxScore[0], currentScore);

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                values[neighbor] = Math.max(0, values[neighbor] + values[node]);
                dfs(neighbor, values, graph, visited, maxScore);
            }
        }
    }
}
