package backtracking;

import com.google.common.base.Stopwatch;

import java.util.Arrays;

public class SolveSudoku {
    static Stopwatch timer = Stopwatch.createStarted();
    public static void main(String[] args) {
        char[][] board = {
                            {'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}
                         };

        solve(board);
        for (char[] b : board) {
            System.out.println(Arrays.toString(b));
        }
    }
    public static void solve(char[][] board) {
        // O(N* (N^2)) time | O(N^2) space
        solveSudoku(board, 0, 0, board.length);
    }
    public static boolean solveSudoku(char[][] board, int i, int j, int n) {
        if (j == 9) {
            i += 1;
            j = 0;
        }
        if (i == 9) return true;

        if (board[i][j] != '.') {
            return solveSudoku(board, i, j + 1, n);
        } else {
            for (char x = 1; x <= 9; ++x) { // trying out all possibilities
                 char currNum = (char) (x + '0');
                if (isValidNum(board, i, j, currNum, n)) { // consider valid num
                    board[i][j] = currNum; // change
                    if (solveSudoku(board, i, j + 1, n)) {
                        return true;
                    }
                    board[i][j] = '.'; // undo change
                }
            }
        }
        return false;
    }
    public static boolean isValidNum(char[][] board, int row, int col, char num, int n) {
        for (int i = 0; i < n; ++i) {
            if (board[i][col] == num || board[row][i] == num) return false;
        }

        row = row - (row % 3); // row = (row/3) * 3
        col = col - (col % 3); // col = (col/3) * 3

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[row + i][col + j] == num) return false;
            }
        }
        return true;
    }
}
