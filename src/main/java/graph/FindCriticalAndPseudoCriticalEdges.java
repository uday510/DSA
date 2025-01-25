/*
Given a weighted undirected connected graph with n vertices numbered from 0 to n - 1, and an array edges where edges[i] = [ai, bi, weighti] represents a bidirectional and weighted edge between nodes ai and bi. A minimum spanning tree (MST) is a subset of the graph's edges that connects all vertices without cycles and with the minimum possible total edge weight.

Find all the critical and pseudo-critical edges in the given graph's minimum spanning tree (MST). An MST edge whose deletion from the graph would cause the MST weight to increase is called a critical edge. On the other hand, a pseudo-critical edge is that which can appear in some MSTs but not all.

Note that you can return the indices of the edges in any order.

Input: n = 5, edges = [[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]
Output: [[0,1],[2,3,4,5]]
Explanation: The figure above describes the graph.
The following figure shows all the possible MSTs:

Notice that the two edges 0 and 1 appear in all MSTs, therefore they are critical edges, so we return them in the first list of the output.
The edges 2, 3, 4, and 5 are only part of some MSTs, therefore they are considered pseudo-critical edges. We add them to the second list of the output.

 */
package graph;

import java.util.ArrayList;
import java.util.List;

public class FindCriticalAndPseudoCriticalEdges {
    public static void main(String[] args) {
        int[][] edges = {{0,1,1},{1,2,1},{2,3,2},{0,3,2},{0,4,3},{3,4,3},{1,4,6}};
        int n = 5;
        System.out.println(findCriticalAndPseudoCriticalEdges(n, edges));
    }

    public static List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
           List<Integer> critical = new ArrayList<>();
           List<Integer> pseudoCritical = new ArrayList<>();

           /*
               1. Sort the edges by weight
               2. Find the MST using Kruskal's algorithm
               3. For each edge, check if it is critical or pseudo-critical
            */
        List<Edge> edgeList = new ArrayList<>();

        for(int i = 0; i < edges.length; i++) {
            edgeList.add(new Edge(edges[i][0], edges[i][1], edges[i][2]));
        }

        edgeList.sort((a, b) -> a.cost - b.cost);

        int minCost = 0;

        UnionFind uf = new UnionFind(n);

        for(Edge edge : edgeList) {
            if(uf.isConnected(edge.from, edge.to)) continue;

            minCost += edge.cost;
            uf.union(edge.from, edge.to);
        }

        for(int i = 0; i < edgeList.size(); i++) {
            // Check if the edge is critical
            UnionFind uf1 = new UnionFind(n);
            int cost = 0;

            for(int j = 0; j < edgeList.size(); j++) {
                if(i == j) continue;

                Edge edge = edgeList.get(j);

                if(uf1.isConnected(edge.from, edge.to)) continue;

                cost += edge.cost;
                uf1.union(edge.from, edge.to);
            }

            if(cost != minCost) {
                critical.add(i);
                continue;
            }

            // Check if the edge is pseudo-critical
            UnionFind uf2 = new UnionFind(n);
            uf2.union(edgeList.get(i).from, edgeList.get(i).to);
            cost = edgeList.get(i).cost;

            for(int j = 0; j < edgeList.size(); j++) {
                if(i == j) continue;

                Edge edge = edgeList.get(j);

                if(uf2.isConnected(edge.from, edge.to)) continue;

                cost += edge.cost;
                uf2.union(edge.from, edge.to);
            }

            if(cost == minCost) {
                pseudoCritical.add(i);
            }
        }

        return new ArrayList<>(List.of(critical, pseudoCritical));
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
