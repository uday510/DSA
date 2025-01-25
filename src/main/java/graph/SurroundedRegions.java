/**
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Notice that an 'O' should not be flipped if:
 * - It is on the border, or
 * - It is adjacent to an 'O' that should not be flipped.
 * The bottom 'O' is on the border, so it is not flipped.
 * The other three 'O' form a surrounded region, so they are flipped.
 * Example 2:
 *
 * Input: board = [["X"]]
 * Output: [["X"]]
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] is 'X' or 'O'.
 */
package graph;

public class SurroundedRegions {
    private static final int[][] directions = new int[][]
            {
                    {0, 1},  // right
                    {0, -1}, // left
                    {1, 0}, // down
                    {-1, 0} // up
            };
    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},
                          {'X','O','O','X'},
                          {'X','X','O','X'},
                          {'X','O','X','X'}};
        solve(board);
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
    public static void solve(char[][] board) {
        // O(N*M) time complexity | O(N*M) space complexity where N is the number of rows and M is the number of columns
        int numRows = board.length;
        int numCols = board[0].length;

        int[][] visited = new int[numRows][numCols];

        // check for boundary rows
        for (int col = 0; col < numCols; col++) {
            if (board[0][col] == 'O') {
                dfs(board, 0, col, visited);
            }
            if (board[numRows - 1][col] == 'O') {
                dfs(board, numRows - 1, col, visited);
            }
        }

        // check for boundary cols
        for (int row = 0; row < numRows; row++) {
            if (board[row][0] == 'O') {
                dfs(board, row, 0, visited);
            }
            if (board[row][numCols - 1] == 'O') {
                dfs(board, row, numCols - 1, visited);
            }
        }

        // flip the remaining 'O' to 'X' and '1' to 'O'
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numCols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (visited[i][j] == 1) {
                    board[i][j] = 'O';
                }
            }
        }
    }
    public static void dfs(char[][] board, int row, int col, int[][] visited) {
        visited[row][col] = 1;

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

           if (newRow >= 0 && newCol >= 0 && newRow < board.length && newCol < board[0].length &&
                   board[newRow][newCol] == 'O' && visited[newRow][newCol] == 0) {
                dfs(board, newRow, newCol, visited);
           }
        }
    }
}
