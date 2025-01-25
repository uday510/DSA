/**
 * Problem Description
 * Given a graph with A nodes and C weighted edges. Cost of constructing the graph is the sum of weights of all the edges in the graph.
 *
 * Find the minimum cost of constructing the graph by selecting some given edges such that we can reach every other node from the 1st node.
 *
 * NOTE: Return the answer modulo 109+7 as the answer can be large.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 100000
 * 0 <= C <= 100000
 * 1 <= B[i][0], B[i][1] <= N
 * 1 <= B[i][2] <= 109
 *
 *
 *
 * Input Format
 * First argument is an integer A.
 * Second argument is a 2-D integer array B of size C*3 denoting edges. B[i][0] and B[i][1] are connected by ith edge with weight B[i][2]
 *
 *
 *
 * Output Format
 * Return an integer denoting the minimum construction cost.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 3
 * B = [   [1, 2, 14]
 *         [2, 3, 7]
 *         [3, 1, 2]   ]
 * Input 2:
 *
 * A = 3
 * B = [   [1, 2, 20]
 *         [2, 3, 17]  ]
 *
 *
 * Example Output
 * Output 1:
 *
 * 9
 * Output 2:
 *
 * 37
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * We can take only two edges (2 -> 3 and 3 -> 1) to construct the graph.
 * we can reach the 1st node from 2nd and 3rd node using only these two edges.
 * So, the total cost of costruction is 9.
 * Explanation 2:
 *
 * We have to take both the given edges so that we can reach the 1st node from 2nd and 3rd node.
 */
package graph;

import java.util.PriorityQueue;

public class ConstructionCost {
    public static void main(String[] args) {
        int A = 3;
        int[][] B = {{1, 2, 14}, {2, 3, 7}, {3, 1, 2}};
        System.out.println(solve(A, B));
    }
    public static int solve(int A, int[][] B) {
        if ( A == 0) {
            return 0;
        }
        int MOD = (int) 1e9 + 7;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        UnionFind dsu = new UnionFind(A + 1);

        for (int i = 0; i < B.length; ++i) {
            pq.offer(new Edge(B[i][0], B[i][1], B[i][2]));
        }

        int count = A - 1;
        int res = 0;

        while (!pq.isEmpty() && count > 0) {
            Edge edge = pq.poll();
            int u = edge.src;
            int v = edge.dest;
            int cost = edge.cost;

            if (dsu.isConnected(u, v)) {
                continue;
            }
            dsu.union(u, v);
            res += cost;
            res %= MOD;
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
    static class UnionFind {
        int[] root;
        int[] rank;

        public UnionFind(int n) {
            root = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; ++i) {
                root[i] = i;
                rank[i] = 1;
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
                root[rootY] = rootX;
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
