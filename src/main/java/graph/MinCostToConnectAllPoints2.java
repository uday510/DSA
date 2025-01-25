/**
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 *
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 *
 * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
 *
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * Output: 20
 */
package graph;

import java.util.PriorityQueue;

public class MinCostToConnectAllPoints2 {
    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(minCostConnectPoints(points));
    }
    public static int minCostConnectPoints(int[][] points) {
        // Prim's Algorithm
        // Time Complexity: O(ElogE) where E is the number of edges
        if (points == null || points.length == 0) {
            return 0;
        }
        int n = points.length;
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        boolean[] visited = new boolean[n];
        int count = n - 1;
        int res = 0;

        // Add all edges from points[0] vertices
        int[] coordinate1 = points[0];
        for (int j = 1; j < n; ++j) {
            // Calculate the distance between points[0] and points[j]
            int[] coordinate2 = points[j];
            int cost = Math.abs(coordinate1[0] - coordinate2[0]) + Math.abs(coordinate1[1] - coordinate2[1]);
            Edge edge = new Edge(0, j, cost);
            pq.offer(edge);
        }
        visited[0] = true; // Mark points[0] as visited

        while (!pq.isEmpty() && count > 0) {
            Edge edge = pq.poll();
            int src = edge.src;
            int dest = edge.dest;
            int cost = edge.cost;

            if (visited[dest]) {
                continue;
            }

            for (int j = 0; j < n; ++j) {
                if (visited[j]) {
                    continue;
                }
                int distance = Math.abs(points[dest][0] - points[j][0]) + Math.abs(points[dest][1] - points[j][1]);
                pq.offer(new Edge(dest, j, distance));

            }
            visited[dest] = true;
            res += cost;
            count--;
        }
        return res;
    }
    static class Edge {
        int src;
        int dest;
        int cost;

        Edge(int s, int d, int c) {
            src = s;
            dest = d;
            cost = c;
        }
    }
}
