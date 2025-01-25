package graph;
import java.util.*;

public class RestoreArrayFromAdjPairs {
    public static void main(String[] args) {

        int[][] adjacentPairs = {{2,1},{3,4},{3,2}};
        restoreArray(adjacentPairs);
    }
    public static int[] restoreArray(int[][] adjacentPairs) {
       Map<Integer, List<Integer>> graph = new HashMap<>();

       for (int[] e : adjacentPairs) {
           int u = e[0];
           int v = e[1];

           if (!graph.containsKey(u)) {
               graph.put(u, new ArrayList<>());
           }

           if (!graph.containsKey(v)) {
               graph.put(v, new ArrayList<>());
           }

           graph.get(u).add(v);
           graph.get(v).add(u);
       }

       int root = -1;
       for (int k : graph.keySet()) {
           if (graph.get(k).size() == 1) {
               root = 0;
               break;
           }
       }
       int[] res = new int[graph.size()];
       dfs(root, -1000000, graph, res, 0);
       return res;
    }
    public static void dfs(int node, int prev, Map<Integer, List<Integer>> graph, int[] res, int i) {
        res[i] = node;

        for (int adj : graph.get(node)) {
            if (adj != prev)
                dfs(adj, node, graph, res, i+1);
        }
    }
}
