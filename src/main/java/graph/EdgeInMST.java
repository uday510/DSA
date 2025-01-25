/**
 * Problem Description
 *
 * Given a undirected weighted graph with A nodes labelled from 1 to A with M edges given in a form of 2D-matrix B of size M * 3 where B[i][0] and B[i][1] denotes the two nodes connected by an edge of weight B[i][2].
 *
 * For each edge check whether it belongs to any of the possible minimum spanning tree or not , return 1 if it belongs else return 0.
 *
 * Return an one-dimensional binary array of size M denoting answer for each edge.
 *
 * NOTE:
 *
 * The graph may be disconnected in that case consider mst for each component.
 * No self-loops and no multiple edges present.
 * Answers in output array must be in order with the input array B output[i] must denote the answer of edge B[i][0] to B[i][1].
 *
 *
 * Problem Constraints
 *
 * 1 <= A, M <= 3*105
 *
 * 1 <= B[i][0], B[i][1] <= A
 *
 * 1 <= B[i][1] <= 103
 *
 *
 *
 * Input Format
 *
 * The first argument given is an integer A representing the number of nodes in the graph.
 *
 * The second argument given is an matrix B of size M x 3 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1] with weight B[i][2].
 *
 *
 *
 * Output Format
 *
 * Return an one-dimensional binary array of size M denoting answer for each edge.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = 3
 *  B = [ [1, 2, 2]
 *        [1, 3, 2]
 *        [2, 3, 3]
 *      ]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [1, 1, 0]
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Edge (1, 2) with weight 2 is included in the MST           1
 *                                                           /   \
 *                                                          2     3
 *  Edge (1, 3) with weight 2 is included in the same MST mentioned above.
 *  Edge (2,3) with weight 3 cannot be included in any of the mst possible.
 *  So we will return [1, 1, 0]
 */
package graph;

import java.util.Arrays;

public class EdgeInMST {
    public static void main(String[] args) {
        int[][] B = {{1, 2, 2}, {2, 3, 2}, {3, 2, 2}};
        int[] res = solve(3, B);
        System.out.println(Arrays.toString(res));
    }
    public static int[] solve(int A, int[][] B) {
        UnionFind dsu = new UnionFind(A+1);
        int[] res = new int[B.length];

        Edge[] edges = new Edge[B.length];

        for (int i = 0; i < B.length; i++) {
            edges[i] = new Edge(B[i][0], B[i][1], B[i][2], i);
        }

        Arrays.sort(edges, (a, b) -> a.cost - b.cost);


        int i = 0;
        int n = B.length;

       while (i < n) {
           int j = i;
           while (j < n && edges[i].cost == edges[j].cost) {
               j++;
           }
           for (int k = i; k < j; k++) {
               Edge e = edges[k];
               if (!dsu.isConnected(e.from, e.to)) {
                   res[e.idx] = 1;
               }
           }
           for (int k = i; k < j; k++) {
               Edge e = edges[k];
               dsu.union(e.from, e.to);
           }
           i = j;
       }
        return res;
    }
    static class Edge {
        int from;
        int to;
        int cost;
        int idx;

        public Edge(int from, int to, int cost, int idx) {
            this.from = from;
            this.to = to;
            this.cost = cost;
            this.idx = idx;
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
