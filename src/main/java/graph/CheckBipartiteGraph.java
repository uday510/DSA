package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckBipartiteGraph {
    public static void main(String[] args) {
        int A = 9;
        int[][] B = {{8,2}, {2,5}, {2,3}, {2,1}, {8,7}, {2,0}, {0,6}, {1,4}};
        System.out.println(solve(A, B));
    }
    public static int solve(int A, int[][] B) {
        int[] color = new int[A];

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < A; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : B) {
            graph.get(edge[0]).add(new int[]{edge[1]});
            graph.get(edge[1]).add(new int[]{edge[0]});
        }

        Arrays.fill(color, -1);

        for (int i = 0; i < A; i++) {
            if (color[i] == -1) {
                if (!dfs(i, graph, color, 0)) {
                    return 0;
                }
            }
        }
        return 1;
    }
    public static boolean dfs(int node, List<List<int[]>> graph, int[] color, int c) {
        color[node] = c;

        for (int[] edge : graph.get(node)) {
            if (color[edge[0]] == -1) {
                if (!dfs(edge[0], graph, color, 1 - c)) {
                    return false;
                }
            } else if (color[edge[0]] == c) {
                return false;
            }
        }
        return true;
    }
}
