/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 */
package dp;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'},
                          {'S', 'F', 'C', 'S'},
                          {'A', 'D', 'E', 'E'}};

        boolean res = exist(board, "ABCCEDGC");
        System.out.println(res);
    }
    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == word.charAt(0) && search(i, j, 0, word, board, visited))
                    return true;
            }
        }
        return false;
    }
    public static boolean search(int i, int j, int index, String word, char[][] board, boolean[][] visited) {

        if (index == word.length()) return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length
                || board[i][j] != word.charAt(index) || visited[i][j]) return false;


        visited[i][j] = true;
        index++;

        if (
                search(i+1,j, index, word, board, visited) ||
                search(i-1,j, index, word, board, visited) ||
                search(i, j-1, index, word, board, visited) ||
                search(i, j+1, index, word, board, visited)

        )
            return true;

        visited[i][j] = false;

        return false;
    }
}
