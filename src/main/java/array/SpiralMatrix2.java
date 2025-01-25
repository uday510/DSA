/**
 * Given a positive integer n, generate an n x n matrix filled with
 * elements from 1 to n2 in spiral order.
 *
 *
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 *
 */
package array;

import java.util.Arrays;

public class SpiralMatrix2 {
    public static void main(String[] args) {

        int[][] ans = solve(3);
        for (int[] arr : ans) {
            System.out.print(Arrays.toString(arr) + " ");
        }
    }
    public static int[][] solve(int n) {
        // O(N*N) time | O(N*N) space

        int[][] res = new int[n][n];
        int startRow = 0, startCol = 0, endRow = n-1, endCol = n-1;
        int cnt = 0;

        while (startRow <= endRow && startCol <= endCol) {

            // Direction 1 : left -> right
            for (int col = startCol; col <= endCol; col += 1) {
                res[startRow][col] = ++cnt;
            }
            // Direction 2 : top -> bottom
            for (int row = startRow + 1; row <= endRow; row += 1) {
                res[row][endCol] = ++cnt;
            }
            // Direction 3 : right -> left
            for (int col = endCol - 1; col >= startCol; col -= 1) {
                res[endRow][col] = ++cnt;
            }
            // Direction 4 : bottom -> top
            for (int row = endRow - 1; row > startRow; row -= 1) {
                res[row][startCol] = ++cnt;
            }
            startRow += 1;
            startCol += 1;
            endRow -= 1;
            endCol -= 1;
        }

        return res;
    }
}
