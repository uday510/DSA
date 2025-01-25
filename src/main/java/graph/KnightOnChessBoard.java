/**
 * Problem Description
 * Given any source point, (C, D) and destination point, (E, F) on a chess board of size A x B, we need to find whether Knight can move to the destination or not.
 *
 * The above figure details the movements for a knight ( 8 possibilities ).
 *
 * If yes, then what would be the minimum number of steps for the knight to move to the said point. If knight can not move from the source point to the destination point, then return -1.
 *
 * NOTE: A knight cannot go out of the board.
 *
 *
 *
 * Problem Constraints
 * 1 <= A, B <= 500
 *
 * nput Format
 * The first argument of input contains an integer A.
 * The second argument of input contains an integer B.
 * The third argument of input contains an integer C.
 * The fourth argument of input contains an integer D.
 * The fifth argument of input contains an integer E.
 * The sixth argument of input contains an integer F.
 *
 *
 *
 * Output Format
 * If it is possible to reach the destination point, return the minimum number of moves.
 * Else return -1.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 8
 *  B = 8
 *  C = 1
 *  D = 1
 *  E = 8
 *  F = 8
 * Input 2:
 *
 *  A = 2
 *  B = 4
 *  C = 2
 *  D = 1
 *  E = 4
 *  F = 4
 *
 *
 * Example Output
 * Output 1:
 *
 *  6
 * Output 2:
 *
 *  -1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The size of the chessboard is 8x8, the knight is initially at (1, 1) and the knight wants to reach position (8, 8).
 *  The minimum number of moves required for this is 6.
 * Explanation 2:
 *
 *  It is not possible to move knight to position (4, 4) from (2, 1)
 */
package graph;

import java.util.Queue;

public class KnightOnChessBoard {
    int[][] knightDirections = new int[][] {
            {2, 1},
            {2, -1},
            {-2, 1},
            {-2, -1},
            {1, 2},
            {1, -2},
            {-1, 2},
            {-1, -2}
    };
    public static void main(String[] args) {
        KnightOnChessBoard knightOnChessBoard = new KnightOnChessBoard();
        System.out.println(knightOnChessBoard.knight(8, 8, 1, 1, 8, 8));
    }
    public int knight(int A, int B, int C, int D, int E, int F) {
        // O(A * B) time complexity | O(A * B) space complexity
        Queue<Edge> queue = new java.util.LinkedList<>(); // BFS
        queue.offer(new Edge(C, D, 0)); // cost = 0

        boolean[][] visited = new boolean[A + 1][B + 1]; // visited array
        visited[C][D] = true; // mark as visited

        while (!queue.isEmpty()) { // BFS
            Edge edge = queue.poll(); // poll the edge
            int r = edge.row; // row
            int c = edge.col; // col
            int cost = edge.cost; // cost

            if (r == E && c == F) { // if we reach the destination
                return cost;
            }

            for (int[] direction : knightDirections) { // for all the directions
                int newR = r + direction[0]; // new row
                int newC = c + direction[1]; // new col

                if (newR >= 1 && newR <= A && newC >= 1 && newC <= B && !visited[newR][newC]) {
                    queue.offer(new Edge(newR, newC, cost + 1));
                    visited[newR][newC] = true; // mark as visited
                }
            }
        }
        return -1; // if we cannot reach the destination
    } static class Edge {
        int row;
        int col;
        int cost;

        public Edge(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
}
