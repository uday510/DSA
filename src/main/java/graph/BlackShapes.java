/**
 * Problem Description
 *
 * Given character matrix A of O's and X's, where O = white, X = black.
 *
 * Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= |A|,|A[0]| <= 1000
 *
 * A[i][j] = 'X' or 'O'
 *
 *
 *
 * Input Format
 *
 * The First and only argument is character matrix A.
 *
 *
 *
 * Output Format
 *
 * Return a single integer denoting number of black shapes.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [ [X, X, X], [X, X, X], [X, X, X] ]
 * Input 2:
 *
 *  A = [ [X, O], [O, X] ]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  All X's belong to single shapes
 * Explanation 2:
 *
 *  Both X's belong to different shapes
 */
package graph;

public class BlackShapes {
    private static final int[][] directions = new int[][] {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    public static void main(String[] args) {;
        String[] A = {"OOOXOOO", "OOXXOXO", "OXOOOXO"};
        System.out.println(black(A));
    }
    public static int black(String[] s) {
        int count = 0;
        if (s == null || s.length == 0) return count;
        int m = s.length;
        int n = s[0].length();

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            char[] c = s[i].toCharArray();
            for (int j = 0; j < n; j++) {
                if (c[j] == 'X' && !visited[i][j]) {
                    dfs(s, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfs(String[] s, int row, int col, boolean[][] visited) {
        if (visited[row][col]) return;

        visited[row][col] = true;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < s.length && newCol >= 0 && newCol < s[0].length() && s[newRow].charAt(newCol) == 'X') {
                dfs(s, newRow, newCol, visited);
            }
        }
    }
}
