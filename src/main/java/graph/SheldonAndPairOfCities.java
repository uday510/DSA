/**
 * Problem Description
 * Sheldon lives in a country with A cities (numbered from 1 to A) and B bidirectional roads.
 *
 * Roads are denoted by integer array D, E and F of size M, where D[i] and E[i] denotes the cities and F[i] denotes the distance between the cities.
 *
 * Now he has many lectures to give in the city and is running short of time, so he asked you C queries, for each query i, find the shortest distance between city G[i] and H[i].
 *
 * If the two cities are not connected then the distance between them is assumed to be -1.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 200
 *
 * 1 <= B <= 200000
 *
 * 1 <= C <= 100000
 *
 * 1 <= F[i] <= 1000000
 *
 * 1 <= D[i], E[i], G[i], H[i] <= A
 *
 *
 *
 * Input Format
 * First argument is an integer A.
 * Seocnd argument is an integer B.
 * Third argument is an integer C.
 * Fourth argument is an integer array D.
 * Fifth argument is an integer array E.
 * Sixth argument is an integer array F.
 * Seventh argument is an integer array G.
 * Eight argument is an integer array H.
 *
 *
 *
 * Output Format
 * Return an integer array of size C, for each query denoting the shortest distance between the given two vertices.
 * If the two vertices are not connected then output -1.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 4
 *  B = 6
 *  C = 2
 *  D = [1, 2, 3, 2, 4, 3]
 *  E = [2, 3, 4, 4, 1, 1]
 *  F = [4, 1, 1, 1, 1, 1]
 *  G = [1, 1]
 *  H = [2, 3]
 * Input 2:
 *
 *  A = 3
 *  B = 3
 *  C = 2
 *  D = [1, 2, 1]
 *  E = [2, 3, 3]
 *  F = [3, 1, 1]
 *  G = [2, 1]
 *  H = [3, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [2, 1]
 * Output 2:
 *
 *  [1, 2]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Distance between (1,2) will 2 if we take path 1->4->2.
 *  Distance between (1,3) will 1 if we take path 1->3.
 * Explanation 2:
 *
 *  Distance between (2,3) will 1 if we take path 1->3.
 *  Distance between (1,2) will 2 if we take path 1->3->2.
 */
package graph;

import java.util.Arrays;

public class SheldonAndPairOfCities {
    public static void main(String[] args) {
        int A = 3;
        int B = 3;
        int C = 2;
        int[] D = {1, 2, 1};
        int[] E = {2, 3, 3};
        int[] F = {3, 1, 1};
        int[] G = {2, 1};
        int[] H = {3, 2};

        System.out.println(Arrays.toString(solve(A, B, C, D, E, F, G, H)));
    }
    public static int[] solve(int A, int B, int C, int[] D, int[] E, int[] F, int[] G, int[] H) {
        long[][] graph = new long[205][205];

        long INF = (long) 1e18;
        for (int i = 0; i < 205; ++i) {
            graph[i][i] = 0;
            for (int j = 0; j < 205; ++j) {
                if (i != j) {
                    graph[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < B; ++i) {
            int u = D[i] - 1; // 0 based indexing
            int v = E[i] - 1; // 0 based indexing
            int w = F[i];
            graph[u][v] = Math.min(graph[u][v], w);
            graph[v][u] = Math.min(graph[v][u], w);
        }

        floydWarshall(graph);

        int[] ans = new int[C];

        for (int i = 0; i < C; ++i) {
            int u = G[i] - 1; // 0 based indexing
            int v = H[i] - 1; // 0 based indexing
            ans[i] = (int) (graph[u][v] == INF ? -1 : graph[u][v]);
        }
        return ans;
    }
    public static void floydWarshall(long[][] graph) {
        // Time: O(V^3), Space: O(1)
        int n = graph.length;

        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {

                    if (graph[i][k] != Long.MAX_VALUE && graph[k][j] != Long.MAX_VALUE) {
                        if (graph[i][j] == Long.MAX_VALUE) {
                            graph[i][j] = graph[i][k] + graph[k][j];
                        } else {
                            graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                        }
                    }
                }
            }
        }
    }
}
