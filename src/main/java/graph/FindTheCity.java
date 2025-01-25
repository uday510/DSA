package graph;

import java.util.*;

public class FindTheCity {
    private static Map<Integer, List<int[]>> graph;
    private static final int INF = (int) 1e9;;
    private static int distanceThreshold;
    private static int n;

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};
        int distanceThreshold = 2;
        System.out.println(findTheCity(n, edges, distanceThreshold)); // 0
    }

    public static int findTheCity(int len, int[][] edges, int distance) {
        graph = new HashMap<>();
        distanceThreshold = distance;
        n = len;

        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int cost = edge[2];

            graph.computeIfAbsent(src, x -> new ArrayList<>()).add(new int[]{dest, cost});
            graph.computeIfAbsent(dest, x -> new ArrayList<>()).add(new int[]{src, cost});
        }

        int res = -1;
        int minCities = INF;

        for (int i = 0; i < n; ++i) {
            int cities = dijsktra(i);
            if (cities <= minCities) {
                res = i;
                minCities = cities;
            }
        }

        return res;
    }
    public static int dijsktra(int start) {
        int[] distFromSrc = new int[n];
        Arrays.fill(distFromSrc, INF);

        distFromSrc[start] = 0;

        PriorityQueue<Edge> minHeap = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        minHeap.offer(new Edge(start, 0));

        while (!minHeap.isEmpty()) {
            Edge edge = minHeap.poll();
            int node = edge.dest;
            int cost = edge.cost;

            if (cost > distFromSrc[node] || graph.get(node) == null)
                continue;

            for (int[] next : graph.get(node)) {
                int nextNode = next[0];
                int nextCost = next[1];
                int accCost = cost + nextCost;

                if (distFromSrc[nextNode] <= accCost)
                    continue;

                distFromSrc[nextNode] = accCost;
                minHeap.offer(new Edge(nextNode, accCost));
            }
        }

        int cnt = 0;

        for (int i = 0; i < n; ++i) {
            if (i != start && distFromSrc[i] <= distanceThreshold) {
                ++cnt;
            }
        }
        return cnt;
    }
}
class Edge {
    int dest;
    int cost;

    Edge (int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }
}