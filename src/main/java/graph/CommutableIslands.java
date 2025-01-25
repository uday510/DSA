/**
 * Problem Description
 * There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.
 *
 * We need to find bridges with minimal cost such that all islands are connected.
 *
 * It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.
 *
 *
 *
 * Problem Constraints
 * 1 <= A, M <= 6*104
 *
 * 1 <= B[i][0], B[i][1] <= A
 *
 * 1 <= B[i][2] <= 103
 *
 *
 *
 * Input Format
 * The first argument contains an integer, A, representing the number of islands.
 *
 * The second argument contains an 2-d integer matrix, B, of size M x 3 where Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].
 *
 *
 *
 * Output Format
 * Return an integer representing the minimal cost required.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 4
 *  B = [  [1, 2, 1]
 *         [2, 3, 4]
 *         [1, 4, 3]
 *         [4, 3, 2]
 *         [1, 3, 10]  ]
 * Input 2:
 *
 *  A = 4
 *  B = [  [1, 2, 1]
 *         [2, 3, 2]
 *         [3, 4, 4]
 *         [1, 4, 3]   ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  6
 * Output 2:
 *
 *  6
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.
 * Explanation 2:
 *
 *  We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred will be (1 + 2 + 3) = 6.
 */
package graph;

import java.util.PriorityQueue;

public class CommutableIslands {
    public static void main(String[] args) {
        int A = 3;
        int[][] B = {{1, 2, 10},
                    {2, 3, 5},
                     {1, 3, 9}};
        System.out.println(solve(A, B));
    }
    public static int solve(int A, int[][] B) {
         // Kruskal's Algorithm
        // O(ElogE) time complexity
        if (A == 0) {
            return 0;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        for (int[] edge : B) {
            pq.add(new Edge(edge[0], edge[1], edge[2]));
        }
        UnionFind dsu = new UnionFind(A + 1);

        int res = 0;
        int count = A - 1;
        while (!pq.isEmpty() && count > 0) {
            Edge edge = pq.poll();
            System.out.println(edge.from + " " + edge.to + " " + edge.cost);
            if (dsu.isConnected(edge.from, edge.to)) {
                continue;
            }
            count--;
            dsu.union(edge.from, edge.to);
            res += edge.cost;
        }
        return res;

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
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootY] > rank[rootX]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
