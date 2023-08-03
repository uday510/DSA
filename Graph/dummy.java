/*
Problem Statement
Alice has a directed graph consisting of N nodes and M edges. The nodes are numbered from 1 through N.
Alice is currently standing at node 1 and wants to go to node u. Clearly, she will take the path in which she has to traverse through the minimum number of edges. Since Alice owns the graph, she can further decrease her travel distance by reversing any single edge in the graph.
Based on this information, you have to answer Q queries. In each query, you will be given a node u and you have to find the minimum number of edges Alice has to travel in order to reach node u if she is allowed to reverse at most 1 edge from the graph.
Input Format
• The first line contains 2 space-separated integers N and M.
• The next M lines contain 2 space-separated integers a and b denoting that there is a directed edge from a to b. Each directed edge is present exactly once.
• The next line contains a single integer Q.
• The next Q lines contain a single integer u. The ith line denotes the ith query.
Constraints
• 1 <= N, M, Q <= 105
• 1 <= a, b <= N
• a l= b
• 1<= u <* N
3:39
• 1 <= N, M, Q <= 105
• 1 <= a, b <= N
• a!= b
●1<=u<=N
Output Format
• For each query, If node u is reachable from node 1 then output the minimum distance Alice has to travel else output -1 in a new

 */
package Graph;

import java.util.*;

public class dummy {
    public static void main(String[] args) {

        int[][] edges = {{1,3}, {1, 2}, {3, 5}, {4, 2}, {5, 1}, {6, 4}};


        int n = 6;

        int result = findShortestPath(edges, n, 1, 5);

        System.out.println(result);
    }
    public static int findShortestPath(int[][] edges, int n, int start, int end) {

        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> reverseGraph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            reverseGraph.get(edge[1]).add(edge[0]);
        }


        int[] distance = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            distance[i] = -1;
        }

        distance[start] = 0;

        boolean[] visited = new boolean[n + 1];
        visited[start] = true;

        Queue<Edge> queue = new LinkedList<>();

        queue.offer(new Edge(start, start, 0, false));


        while (!queue.isEmpty()) {

            Edge e = queue.poll();

            int node = e.dist;
            int cost = e.weight;
            boolean isReversed = e.isReversed;

            if (!isReversed) {
                for (int next : reverseGraph.get(node)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        distance[next] = cost + 1;
                        queue.offer(new Edge(node, next, cost + 1, true));
                    }
                }
            }

            if (node == end) {
                return cost;
            }

            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = cost + 1;
                    queue.offer(new Edge(node, next, cost + 1, false));
                }

            }

        }
        return -1;

    }

    static class Edge {
        int src;
        int dist;
        int weight;
        boolean isReversed;

        Edge (int src, int dist, int weight, boolean isReversed) {
            this.src = src;
            this.dist = dist;
            this.weight = weight;
            this.isReversed = isReversed;
        }
    }
}
