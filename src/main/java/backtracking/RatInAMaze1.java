/**
 * Check if it is possible to go from top-left to bottom-right
 * cell in a maze with blocked cell.
 * 1 -> blocked
 * 0 -> empty
 */
package backtracking;

public class RatInAMaze1 {
        static int[] positionArray1 = {-1, 0, 1, 0};
        static int[] positionArray2 = {0, -1, 0, 1};
    public static void main(String[] args) {
        int[][] maze = { {0, 0, 0, 1, 0, 0, 0},
                         {0, 1, 0, 1, 0, 1, 0},
                         {0, 1, 0, 0, 1, 0, 0},
                         {0, 0, 1, 0, 1, 0, 1},
                         {1, 0, 1, 0, 0, 0, 0},
                         {0, 0, 0, 1, 0, 1, 0} };


        boolean res = solve2(0, 0, maze.length, maze[0].length, maze);
        System.out.println(res);
    }
    public static boolean solve1(int i, int j, int n, int m, int[][] maze) {
        if (i == n-1 && j == m-1) return true;

        if (i < 0 || j < 0 ||
                i >=n || j >= m ||
                maze[i][j] == 1 ||
                maze[i][j] == 2) return false;

        maze[i][j] = 2; // mark i,j as visited

        return ( solve1(i-1, j, n, m, maze) ||
                 solve1(i, j-1, n, m, maze) ||
                 solve1(i+1, j, n, m, maze) ||
                solve1(i, j+1, n, m, maze) );
    }
    public static boolean solve2(int i, int j, int n, int m, int[][] maze) {
        if (i == n-1 && j == m-1) return true;

        maze[i][j] = 2;

        for (int k = 0; k < 4; ++k) {
            int newI = i + positionArray1[k];
            int newJ = j + positionArray2[k];

            if (newI > -1 && newI < n &&
                newJ > -1 && newJ < m &&
                maze[newI][newJ] == 0) {

                boolean pathExists = solve2(newI, newJ, n, m, maze);

                if (pathExists) return true;
            }
        }
        return false;
    }
}
