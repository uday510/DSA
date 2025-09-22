package graph.dsu;

import java.util.*;

public class EvaluateDivision {

    Map<String, List<Pair>> adjList;
    int n;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        n = equations.size();
        adjList = new HashMap<>();

        for (int i = 0; i < n; i++) {
            var eq = equations.get(i);

            String u = eq.get(0), v = eq.get(1);
            double d = values[i];

            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair(v, d));
            adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair(u, 1.0/d));
        }

        double[] dist = new double[queries.size()];

        for (int i = 0; i < dist.length; i++) {
            String u = queries.get(i).get(0), v = queries.get(i).get(1);

            dist[i] = dfs(u, v, new HashSet<>());
        }

        return dist;
    }

    private double dfs(String u, String v, Set<String> vis) {
        if (!adjList.containsKey(u) || !adjList.containsKey(v) || !vis.add(u)) return -1.0;

        if (u.equals(v)) return 1.0;

        for (Pair nei : adjList.get(u)) {
            double d = dfs(nei.v, v, vis);

            if (d != -1.0) return nei.d * d;
        }

        return -1.0;
    }

}

class Pair {
    String v;
    Double d;

    public Pair(String v, Double d) {
        this.v = v;
        this.d = d;
    }
}
