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
package graph;

import java.util.PriorityQueue;

public class dummy {
    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(minCostConnectPoints(points));
    }
    public static int minCostConnectPoints(int[][] points) {

        int n = points.length;
        UnionFind dsu = new UnionFind(n);
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        for (int i = 0; i < n; ++i) {
            int[] coordinate1 = points[i];
            for (int j = i+1; j < n; ++j) {
                int[] coordinate2 = points[j];
                int cost = Math.abs(coordinate1[0] - coordinate2[0]) +
                        Math.abs(coordinate1[1] - coordinate2[1]);

                Edge edge = new Edge(i, j, cost);
                pq.offer(edge);
            }
        }
        int minCost = 0;
        int edges = n - 1;

        while (!pq.isEmpty() && edges > 0) {
            Edge edge = pq.poll();
            int x = edge.x;
            int y = edge.y;
            int dist = edge.dist;

            if (!dsu.isConnected(x, y)) {
                dsu.union(x, y);
                minCost += dist;
                --edges;
            }

        }

        return minCost;
    }
    static class Edge {
        int x;
        int y;

        int dist;

        Edge(int p1, int p2, int d) {
            x = p1;
            y = p2;
            dist = d;
        }
    }
    static class UnionFind {
        int[] root;
        int[] rank;

        UnionFind(int n) {
            root = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; ++i) {

                rank[i] = 1;
                root[i] = i;
            }
        }

        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootY] > rank[rootX]) {
                rank[rootX] = rootY;
            } else {
                root[rootX] = rootY;
                rank[rootY]++;
            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
