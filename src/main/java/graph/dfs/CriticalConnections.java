package graph.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CriticalConnections {

    List<Integer>[] adjList;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> cons) {
        List<List<Integer>> res = new ArrayList<>();
        adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        for (var e : cons) {
            int u = e.getFirst(), v = e.getLast();
            adjList[u].add(v);
            adjList[v].add(u);
        }

        Set<Integer> vis;
        for (var e : cons) {
            vis = new HashSet<>();
            dfs(0, e, vis);
            if (vis.size() != n) res.add(e);
        }

        return res;
    }

    private void dfs(int u, List<Integer> blocked, Set<Integer> vis) {
        vis.add(u);
        for (int v : adjList[u]) {
            if (
                    (u == blocked.getFirst() && v == blocked.getLast()) ||
                    (u == blocked.getLast() && v == blocked.getFirst()) ||
                    vis.contains(v)
                )
                continue;

            dfs(v, blocked, vis);
        }
    }

}
