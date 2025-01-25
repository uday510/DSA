package tree;

import java.util.*;

public class MinimumCostToConvertStringI {
    static private Map<Character, List<Edge>> graph;
    static private long INF = (long) 1e9;
    static private int n;
    public static void main(String[] args) {
        String source = "abcd";
        String target = "acbe";
        char[] original = {'a', 'b', 'c', 'd', 'e', 'd'};
        char[] changed = {'b', 'c', 'b', 'e', 'b', 'e'};
        int[] cost = {2, 5, 5, 1, 2, 20};

        System.out.println(minCost(source, target, original, changed, cost));
    }
    public static long minCost(String source, String target, char[] original, char[] changed, int[] cost) {
        n = source.length();
        graph = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            char from  = original[i];
            char to = changed[i];
            int c = cost[i];
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new Edge(to, c));
        }

        long minCost = 0;

        for (int i = 0; i < n; ++i) {
            char from = source.charAt(i);
            char to = target.charAt(i);
            if (from == to) continue;
            minCost += dijkstra(from, to);
        }
        return minCost;
    }
    public static long dijkstra(char src, char dest) {
        long[] dist = new long[26];
        Arrays.fill(dist, INF);

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.cost, o2.cost));
        pq.offer(new Edge(src, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            char u = cur.to;
            long w = cur.cost;

            if (w > dist[getIdx(u)] || graph.get(u) == null) continue;

            for (Edge e : graph.get(u)) {
                char v = e.to;
                long c = e.cost;

                if (dist[getIdx(v)] < w + c) continue;

                dist[getIdx(v)] = w + c;
                pq.offer(new Edge(v, w + c));
            }
        }
        return dist[getIdx(dest)];
    }
    public static int getIdx(char c) {
        return c - 'a';
    }

    static class Edge {
        char to;
        long cost;
        Edge(char to, long cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
