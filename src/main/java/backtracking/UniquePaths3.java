/**
 * Problem Description
 * Given a matrix of integers A of size N x M . There are 4 types of squares in it:
 *
 * 1. 1 represents the starting square.  There is exactly one starting square.
 * 2. 2 represents the ending square.  There is exactly one ending square.
 * 3. 0 represents empty squares we can walk over.
 * 4. -1 represents obstacles that we cannot walk over.
 * Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 *
 * Note: Rows are numbered from top to bottom and columns are numbered from left to right.
 *
 *
 *
 * Problem Constraints
 * 2 <= N * M <= 20
 * -1 <= A[i] <= 2
 *
 *
 *
 * Input Format
 * The first argument given is the integer matrix A.
 *
 *
 *
 * Output Format
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [   [1, 0, 0, 0]
 *         [0, 0, 0, 0]
 *         [0, 0, 2, -1]   ]
 * Input 2:
 *
 * A = [   [0, 1]
 *         [2, 0]    ]
 *
 *
 * Example Output
 * Output 1:
 *
 * 2
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * Explanation 1:
 *
 * Answer is evident here.
 */
package backtracking;

import java.util.Arrays;

public class UniquePaths3 {
    static int res = 0;

    public static void main(String[] args) {
//        int[][] maze = { {1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        int[][] maze = { {0, 1}, {2, 0}};

        int ans = solve(maze);
        System.out.println(ans);
        System.out.println(Arrays.deepToString(maze));
    }
    public static int solve(int[][] maze) {
        int[] startPoint = findStartingPath(maze);

        findPaths(maze, startPoint[0], startPoint[1]);
        return res;
    }
    public static void findPaths(int[][] maze, int i, int j) {

        if (i < 0 || j < 0|| i > maze.length - 1 ||
                j > maze[0].length - 1 ||
                maze[i][j] == -1 ||
                maze[i][j] == 3) return;

        if (maze[i][j] == 2) {
            res += 1;
            return;
        }

        maze[i][j] = 3;

        findPaths(maze, i-1, j);
        findPaths(maze, i, j-1);
        findPaths(maze, i+1, j);
        findPaths(maze, i, j+1);
    }
    public static int[] findStartingPath(int[][] maze) {

        int n = maze.length;
        int m = maze[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 1) return new int[] {i, j};
            }
        }
        return new int[] {-1, -1};
    }
}
