package graph.topologicalsort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/largest-color-value-in-a-directed-graph/?envType=study-plan-v2&envId=graph-theory
public class LargestColorValueInDirectedGraph {
    final int ALPHABET = 26;
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<Integer>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        int[] indegree = new int[n];
        for (int[] e : edges) {
            adjList[e[0]].add(e[1]);
            indegree[e[1]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        int visited = 0, max = 0;
        int[][] dp = new int[n][ALPHABET];

        while (!q.isEmpty()) {
            int u = q.poll();
            ++visited;

            int colorIdx = colors.charAt(u) - 'a';
            ++dp[u][colorIdx];

            max = Math.max(max, dp[u][colorIdx]);

            for (int v : adjList[u]) {
                for (int c = 0; c < ALPHABET; c++) {
                    dp[v][c] = Math.max(dp[v][c], dp[u][c]);
                }
                if (--indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        return visited == n ? max : -1;
    }

}


/**


 colors = "abaca"

 0 -> 1, 2
 1 ->
 2 -> 3
 3 -> 4
 4 ->

 dp[0]: a
 [a] = 1
 [b] = 0
 [c] = 0

 dp[1]: b
 [a] = 1
 [b] = 1
 [c] = 0

 dp[2]: a
 [a] = 2
 [b] = 0
 [c] = 0

 dp[3]: c
 [a] = 2
 [b] = 0
 [c] = 1

 dp[4]: a
 [a] = 3
 [b] = 0
 [c] = 1

 vis = 0, 1, 2, 3

 queue:

 poll:


 */