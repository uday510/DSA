package graph;

import java.util.*;

public class SecondMinimum {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}};
        int time = 3;
        int change = 5;

        System.out.println(secondMinimum(n, edges, time, change));
    }
    public static int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int INF = (int) 1e9;

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
        }

        int[] dist1 = new int[n + 1];
        int[] dist2 = new int[n + 1];
        int[] freq = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            dist1[i] = dist2[i] = INF;
            freq[i] = 0;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{1, 0});
        freq[1] = 0;


        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int u = top[0];
            int d = top[1];

            ++freq[u];

            if (freq[u] == 2 && u == n) {
                return d;
            }

            if ((d/change) % 2 == 1) {
                d = change * (d / change + 1) + time;
            } else {
                d += time;
            }

            if (!graph.containsKey(u)) {
                continue;
            }

            for (int v : graph.get(u)) {

                if (freq[v] == 2) {
                    continue;
                }

                if (dist1[v] > d) {
                    dist2[v] = dist1[v];
                    dist1[v] = d;
                    pq.add(new int[]{v, d});
                } else if (dist2[v] > d && dist1[v] < d) {
                    dist2[v] = d;
                    pq.add(new int[]{v, d});
                }
            }
        }

        return 0;
    }

}
