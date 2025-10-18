package graph.scc;

import java.util.*;

public class KosarajuCriticalEdges {

    private List<Integer>[] adj, rev;
    private boolean[] vis;
    private Deque<Integer> stack;
    private int[] comp;

    public void findComponentBridges(int n, List<List<Integer>> edges) {
        adj = new ArrayList[n];
        rev = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            rev[i] = new ArrayList<>();
        }

        for (var e : edges) {
            int u = e.get(0), v = e.get(1);
            adj[u].add(v);
            rev[v].add(u);
        }

        vis = new boolean[n];
        stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++)
            if (!vis[i]) dfs1(i);

       Arrays.fill(vis, false);
       comp = new int[n];
       int compId = 0;
       while (!stack.isEmpty()) {
           int u = stack.pop();
           if (!vis[u]) dfs2(u, compId++);
       }

       Set<String> dagEdges = new HashSet<>();
       for (var e : edges) {
           int cu = comp[e.getFirst()], cv = comp[e.getLast()];
           if (cu != cv) dagEdges.add(cu + "->" + cv);
       }

        System.out.println("Number of SCCs: " + compId);
        System.out.println("Edges between SCCs (critical component links): " + dagEdges);
    }

    private void dfs1(int u) {
        vis[u] = true;
        for (int v : adj[u]) {
            if (!vis[v]) dfs1(v);
            stack.push(u);
        }
    }

    private void dfs2(int u, int compId) {
        vis[u] = true;
        comp[u] = compId;
        for (int v : rev[u]) if (!vis[v]) dfs2(v, compId);
    }

    static void main() {

        int n = 6;
        List<List<Integer>> edges = List.of(
                List.of(0, 1),
                List.of(1, 2),
                List.of(2, 0),
                List.of(2, 3),
                List.of(3, 4),
                List.of(4, 5),
                List.of(5, 3)
        );

        new KosarajuCriticalEdges().findComponentBridges(n, edges);
    }

}
