package graph.topologicalsort;

import java.util.*;

// https://leetcode.com/problems/largest-color-value-in-a-directed-graph/?envType=daily-question&envId=2025-05-26
public class LargestColorValueInDirectedGraph {

    public static void main(String[] args) {
        String colors = "iiiiii";
        int[][] edges = {{0,1},{1,2},{2,3},{3,4},{4,5}};

        int ans = largestPathValue(colors, edges);
        System.out.println(ans);
    }

    public static int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[] inorder = new int[n];
        List<Integer>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjList[u].add(v);
            ++inorder[v];
        }

        Set<Integer> nodes = new HashSet<>();

        for (int i = 0; i < n; ++i) {
            if (inorder[i] == 0) nodes.add(i);
        }

        int max = 0;

        for (int node : nodes) {
            int[] in = new int[n];
            for (int i = 0; i < n; ++i) in[i] = inorder[i];

            Map<Character, Integer> map = new HashMap<>();
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(node);
            --in[node];
            int curr = 0;
            while (!queue.isEmpty()) {
                int currNode = queue.poll();
                char color = colors.charAt(currNode);
                map.merge(color, 1, Integer::sum);
                curr = Math.max(curr, map.get(color));

                for (int next : adjList[currNode]) {
                    --in[next];

                    if (in[next] == 0) {
                        queue.offer(next);
                    }
                }
            }

            max = Math.max(curr, max);
        }

        return max;
    }
}
