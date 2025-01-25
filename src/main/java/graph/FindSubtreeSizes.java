package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSubtreeSizes {
    public static void main(String[] args) {
        int[] parent = {-1, 0, 0, 1, 1, 1};
        String s = "abaabc";
        System.out.println(Arrays.toString(subtreeSizes(parent, s)));  // Expected Output: [6, 3, 1, 1, 1, 1]
    }

    private static int[] subtreeSizes(int[] parent, String s) {
        int len = parent.length;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i < len; i++) {
            adj.get(parent[i]).add(i);
        }

        int[] res = new int[len];
        dfs(adj, res, 0);

        int[] newParent = parent.clone();
        for (int idx = 1; idx < len; idx++) {
            int node = parent[idx];
            while (node != -1) {
                if (s.charAt(node) == s.charAt(idx)) {
                    newParent[idx] = node;
                    break;
                }
                node = parent[node];
            }
        }

        adj.clear();
        for (int i = 0; i < len; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i < len; i++) {
            adj.get(newParent[i]).add(i);
        }

        Arrays.fill(res, 0);
        dfs(adj, res, 0);

        return res;
    }

    private static int dfs(List<List<Integer>> adj, int[] res, int node) {
        int currSize = 1;
        for (int child : adj.get(node)) {
            currSize += dfs(adj, res, child);
        }
        res[node] = currSize;
        return currSize;
    }
}
