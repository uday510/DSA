/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 */
package backtracking;
import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class NQueens {
    static boolean[] cols;
    static boolean[] diagonal;
    static boolean[] antiDiagonal;
    public static void main(String[] args) {
        int n = 4;

        Stopwatch timer = Stopwatch.createStarted();
        List<List<String>> res = solve(n);

        System.out.println(res);
        System.out.println("Runtime " + timer.stop());
    }
    public static List<List<String>> solve(int n) {
        // O(N!) time | O(N^2 + N) space
        List<List<String>> list = new ArrayList<>();

        String[][] matrix = new String[n][n];

        for (String[] row : matrix) Arrays.fill(row, ".");

        cols = new boolean[n];
        diagonal = new boolean[2 * n-1];
        antiDiagonal = new boolean[2 * n-1];

        solveNQueens(matrix, 0, n, list);

        return list;
    }
    public static void solveNQueens(String[][] matrix, int row, int n, List<List<String>> res) {
        if (row == n) {
            res.add(addPath(matrix));
            return;
        }
        for (int col = 0; col < n; ++col) {
            if (isQueenSafe(row, col, n)) {
                matrix[row][col] = "Q";
                cols[col] = true;
                antiDiagonal[row + col] = true;
                diagonal[row - col + n - 1] = true;
                solveNQueens(matrix, row + 1, n, res);
                matrix[row][col] = ".";
                cols[col] = false;
                antiDiagonal[row + col] = false;
                diagonal[row - col + n - 1] = false;
            }
        }
    }
    public static boolean isQueenSafe(int row, int col, int n) {
        // why row-col+n-1? because the diagonal array is 2n-1 in size and we need to map the row and col to the diagonal array
        return (!cols[col] && !diagonal[row - col + n - 1] && !antiDiagonal[row + col]);
    }
    public static boolean isQueenSafe(String[][] matrix, int row, int col, int n) {
        // check for every row above on same col;
        for (int i = 0; i < row; ++i) {
            if (Objects.equals(matrix[i][col], "Q")) return false;
        }
        // check for left diagonal
        for (int i = row - 1, j = col - 1; i > -1 && j > -1; --i, --j) {
            if (Objects.equals(matrix[i][j], "Q")) return false;
        }
        // check for right diagonal
        for (int i = row - 1, j = col + 1; i > -1 && j < n; --i, ++j) {
            if (Objects.equals(matrix[i][j], "Q")) return false;
        }
        return true;
    }
    public static List<String> addPath(String[][] matrix) {
        List<String> path = new ArrayList<>();
        for (String[] m : matrix) {
            String temp = String.join("", m);
            path.add(temp);
        }
        return path;
    }
}
