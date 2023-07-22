/**
 * Problem Description
 * Alice visits the land of amusement parks. There are a total of A amusement parks numbered from 1 to A. Some amusement parks are connected to each other by bidirectional bridges given by array B.
 *
 *
 * Alice hates to cross these bridges as they require a lot of effort. He is standing at amusement park 1 and wants to reach amusement park A. Find the minimum number of bridges that he shall have to cross, if he takes the optimal route.
 *
 * Return -1 if it is not possible to reach amusement park A.
 *
 * Please look at the examples below for better understanding of the problem.
 *
 *
 * Problem Constraints
 * 1 <= A <= 104
 *
 * 1 <= B.size() <= 105
 *
 *
 *
 * Input Format
 * First argument is an integer A.
 * Second argument is an 2-d integer array B.
 *
 *
 * Output Format
 * Return an integer denoting the minimum number of bridges that he shall have to cross, if Alice takes the optimal route.
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 4
 * B = [
 *         [1, 2]
 *         [2, 4]
 *         [1, 3]
 *     ]
 * Input 2:
 *
 * A = 3
 * B = [
 *         [1, 2]
 *     ]
 *
 *
 * Example Output
 * Ouput 1:
 *
 * 2
 * Output 2:
 *
 * -1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Starting from park 1 we can go to park 2 and from park 2 we can go to park 4. Hence, the minimum number of bridges required
 * to reach Ath park is equal to 2.
 * Explanation 2:
 *
 * It is never possible to reach Ath park. Hence, -1 is returned as the output.
 */
package Graph;

import java.util.ArrayList;
import java.util.List;

public class dummy3 {
    public static void main(String[] args) {
        int A = 3;
        int[][] B = {{1, 2}};

        System.out.println(solve(A, B));
    }
    public static int solve(int A, int[][] B) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= A; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < B.length; ++i) {
            int[] edge = B[i];
            graph.get(edge[0]).add(new int[] {edge[1], 1});
            graph.get(edge[1]).add(new int[] {edge[0], 1});
        }

        int[] dist = new int[A + 1];

        for (int i = 0; i <= A; ++i) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[1] = 0;

        boolean[] visited = new boolean[A + 1];

        for (int i = 0; i < A; ++i) {
            int u = -1;

            for (int j = 1; j <= A; ++j) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }

            visited[u] = true;

            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int w = edge[1];

                if (!visited[v] && dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }
         return dist[A] == Integer.MAX_VALUE ? -1 : dist[A];
    }
}
