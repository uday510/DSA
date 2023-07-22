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
 * 1 <= |A|,|A[0]| <= 1000
 *
 * A[i][j] = 'X' or 'O'
 *
 *
 *
 * Input Format
 * The First and only argument is character matrix A.
 *
 *
 *
 * Output Format
 * Return a single integer denoting number of black shapes.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [ [X, X, X], [X, X, X], [X, X, X] ]
 * Input 2:
 *
 *  A = [ [X, O], [O, X] ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  All X's belong to single shapes
 * Explanation 2:
 *
 *  Both X's belong to different shapes
 */
package Graph;

public class dummy {
    private static final int[][] directions = new int[][] { {0,1}, {1,0}, {0,-1}, {-1,0} };

    public static void main(String[] args) {
        String[] A = { "XOOOOOXXOX", "OOXXXXOOXX", "XXOXXOOXXO",
        "OXOXXXXXXO", "XOXXOXOXXX", "OOOOOOOXOO", "XOXXXOOXOX", "XXXOXOXXXO"};

        int ans = black(A);
        System.out.println(ans);
    }
    public static int black (String[] A) {
        char[][] grid = new char[A.length][A[0].length()];

        for(int i=0; i<A.length; i++) {
            for(int j=0; j<A[0].length(); j++) {
                grid[i][j] = A[i].charAt(j);
            }
        }

        for (char[] row : grid) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

        int[][] visited = new int[grid.length][grid[0].length];
//        visited[0][0] = 1;
        int numIslands = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length;j++) {
                if(grid[i][j] == 'X' && visited[i][j] == 0) {
                    numIslands++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return numIslands;
    }
    public static void dfs(char[][] grid, int[][] visited, int i, int j) {
        visited[i][j] = 1;

        for (int[] direction : directions) {
            int newRow = i + direction[0];
            int newCol = j + direction[1];

            if (newRow >= 0 && newRow < grid.length &&
                    newCol >= 0 && newCol < grid[0].length &&
                    grid[newRow][newCol] == 'X' &&
                    visited[newRow][newCol] == 0) {

                dfs(grid, visited, newRow, newCol);
            }
        }
    }

}
