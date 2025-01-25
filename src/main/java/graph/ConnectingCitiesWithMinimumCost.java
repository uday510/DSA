/**
 * There are n cities labeled from 1 to n. You are given the integer n and an array connections where connections[i] = [xi, yi, costi] indicates that the cost of connecting city xi and city yi (bidirectional connection) is costi.
 *
 * Return the minimum cost to connect all the n cities such that there is at least one path between each pair of cities. If it is impossible to connect all the n cities, return -1,
 *
 * The cost is the sum of the connections' costs used.
 *
 * Input: n = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
 * Output: 6
 * Explanation: Choosing any 2 edges will connect all cities so we choose the minimum 2.
 */
package graph;

import java.util.PriorityQueue;

public class ConnectingCitiesWithMinimumCost {
    public static void main(String[] args) {
        int n = 3;
        int[][] connections = {{1,2,5},{1,3,6},{2,3,1}};
        System.out.println(minimumCost(n, connections));
    }
    public static int minimumCost(int n, int[][] connections) {
        // O(ElogE) time complexity | O(E) space complexity
        if (connections.length < n - 1) return -1;
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        UnionFind dsu = new UnionFind(n+1);

        for (int[] connection : connections) {
            pq.add(new Edge(connection[0], connection[1], connection[2]));
        }

        int minCost = 0;
        int cities = n - 1;

        while (!pq.isEmpty() && cities > 0) {
            Edge connectedCities = pq.poll();
            int src = connectedCities.from;
            int dest = connectedCities.to;
            int cost = connectedCities.cost;

            if (dsu.isConnected(src, dest)) {
                continue;
            }
            dsu.union(src, dest);
            cities--;
            minCost += cost;
        }
        return cities == 0 ? minCost : -1;
    }
    static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    static class UnionFind {
        int[] root;
        int[] rank;

        public UnionFind(int n) {
            root = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if(root[x] == x) return x;
            return root[x] = find(root[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) return;

            if(rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if(rank[rootY] > rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
