/**
 * Problem Description
 * You are given an undirected unweighted graph consisting of A vertices and M edges given in a form of 2D Matrix B of size M x 2 where (B[i][0], B][i][1]) denotes two nodes connected by an edge.
 *
 * You have to write a number on each vertex of the graph. Each number should be 1, 2 or 3. The graph becomes Poisonous if for each edge the sum of numbers on vertices connected by this edge is odd.
 *
 * Calculate the number of possible ways to write numbers 1, 2 or 3 on vertices so the graph becomes poisonous. Since this number may be large, return it modulo 998244353.
 *
 * NOTE:
 *
 * Note that you have to write exactly one number on each vertex.
 * The graph does not have any self-loops or multiple edges.
 * Nodes are labelled from 1 to A.
 *
 *
 * Problem Constraints
 * 1 <= A <= 3*105
 *
 * 0 <= M <= 3*105
 *
 * 1 <= B[i][0], B[i][1] <= A
 *
 * B[i][0] != B[i][1]
 *
 *
 *
 * Input Format
 * First argument is an integer A denoting the number of nodes.
 *
 * Second argument is an 2D Matrix B of size M x 2 denoting the M edges.
 *
 *
 *
 * Output Format
 * Return one integer denoting the number of possible ways to write numbers 1, 2 or 3 on the vertices of given graph so it becomes Poisonous . Since answer may be large, print it modulo 998244353.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 2
 *  B = [  [1, 2]
 *      ]
 * Input 2:
 *
 *  A = 4
 *  B = [  [1, 2]
 *         [1, 3]
 *         [1, 4]
 *         [2, 3]
 *         [2, 4]
 *         [3, 4]
 *     ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  There are 4 ways to make the graph poisonous. i.e, writing number on node 1 and 2 as,
 *     [1, 2] , [3, 2], [2, 1] or [2, 3] repsectively.
 * Explanation 2:
 *
 *  There is no way to make the graph poisonous.
 */
package Graph;


import java.util.Queue;

public class PoisonousGraph {
    static int[][] directions = new int[][] {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public static void main(String[] args) {
        int[][] A = new int[][] {
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 0}
        };
        int[][] res = solve(A);
        for (int[] row : res) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }

    }
    public static int[][] solve(int[][] A) {
        // BFS
        // O(n * m) time | O(n * m) space
        int[][] res = new int[A.length][A[0].length];

        Queue<Edge> queue = new java.util.LinkedList<>();

        boolean[][] visited = new boolean[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0 ; j < A[0].length; j++) {
               if (A[i][j] == 1) queue.add(new Edge(i, j, 0));
            }
        }

        while (!queue.isEmpty()) {
            Edge e = queue.poll();


            if (A[e.x][e.y] == 1) {
                res[e.x][e.y] = 0;
            } else {
                res[e.x][e.y] = e.dist;
            }

            for (int[] dir : directions) {
                int x = e.x + dir[0];
                int y = e.y + dir[1];

                if (x < 0 || x >= A.length || y < 0 || y >= A[0].length || visited[x][y]) continue;

                visited[x][y] = true;
                queue.add(new Edge(x, y, e.dist + 1));
            }
        }
        return res;
    }
    static class Edge {
        int x;
        int y;
        int dist;
        public Edge(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
