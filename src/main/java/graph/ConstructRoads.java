/**
 * Problem Description
 * A country consist of N cities connected by N - 1 roads. King of that country want to construct maximum number of roads such that the new country formed remains bipartite country.
 *
 * Bipartite country is a country, whose cities can be partitioned into 2 sets in such a way, that for each road (u, v) that belongs to the country, u and v belong to different sets. Also, there should be no multiple roads between two cities and no self loops.
 *
 * Return the maximum number of roads king can construct. Since the answer could be large return answer % 109 + 7.
 *
 * NOTE: All cities can be visited from any city.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 105
 *
 * 1 <= B[i][0], B[i][1] <= N
 *
 *
 *
 * Input Format
 * First argument is an integer A denoting the number of cities, N.
 *
 * Second argument is a 2D array B of size (N-1) x 2 denoting the initial roads i.e. there is a road between cities B[i][0] and B[1][1] .
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum number of roads king can construct.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 3
 *  B = [
 *        [1, 2]
 *        [1, 3]
 *      ]
 * Input 2:
 *
 *  A = 5
 *  B = [
 *        [1, 3]
 *        [1, 4]
 *        [3, 2]
 *        [3, 5]
 *      ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  We can't construct any new roads such that the country remains bipartite.
 * Explanation 2:
 *
 *  We can add two roads between cities (4, 2) and (4, 5).
 */
package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructRoads {
    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1, 3}, {1, 4}, {3, 2}, {3, 5}};
        System.out.println(solve(A, B));
    }
    public static int solve(int A, int[][] B) {
        int[] color = new int[A + 1];

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < A + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : B) {
            graph.get(edge[0]).add(new int[]{edge[1]});
            graph.get(edge[1]).add(new int[]{edge[0]});
        }

        Arrays.fill(color, -1);

        for (int i = 1; i < A + 1; i++) {
            if (color[i] == -1) {
                dfs(i, graph, color, 0);
            }
        }


        long count = 0;
        for (int i = 1; i < A + 1; i++) {
            if (color[i] == 0) {
                count++;
            }
        }

        long res = count * (A - count);
        res -= A - 1;
        long mod = 1000000007;
        res %= mod;
        return (int) res;
    }
    public static void dfs(int i, List<List<int[]>> graph, int[] color, int c) {
        color[i] = c;

        for (int[] edge : graph.get(i)) {
            if (color[edge[0]] == -1) {
                dfs(edge[0], graph, color, 1 - c);
            } else if (color[edge[0]] == c) {
                return;
            }
        }
    }
}
