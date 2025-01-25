/**
 * There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 *
 * Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol] and destination = [destinationrow, destinationcol], return true if the ball can stop at the destination, otherwise return false.
 *
 * You may assume that the borders of the maze are all walls (see examples).
 *
 * Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
 * Output: true
 * Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
 */
package backtracking;

import java.util.Arrays;

public class TheMaze {
    static int[] positionArray1 = {-1, 0, 1, 0};
    static int[] positionArray2 = {0, -1, 0, 1};
    public static void main(String[] args) {
        int[][] maze = { {0,0,1,0,0},
                         {0,0,0,0,0},
                         {0,0,0,1,0},
                         {1,1,0,1,1},
                         {0,0,0,0,0}};

        int[] start = {0, 4};
        int[] destination = {1, 2};

        boolean res = solve(start, destination, maze);
        for (int[] a: maze) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println(res);
    }
    public static boolean solve(int[] start, int[] destination, int[][] maze) {
        boolean res = helper(start[0], start[1], destination[0], destination[1], maze);
        return res;
    }
    public static boolean helper(int i, int j, int n, int m, int[][] maze) {
        if (i == n && j == m) return true;

        maze[i][j] = 2;

        for (int k = 0; k < 4; ++k) {
            int newI = i + positionArray1[k];
            int newJ = j + positionArray2[k];

            if (newI > -1 && newI <= n &&
                    newJ > -1 && newJ <= m &&
                    maze[newI][newJ] == 0) {

                System.out.println("i j " +  newI + " " + newJ);

                boolean pathExists = helper(newI, newJ, n, m, maze);


                if (pathExists) return true;
            }
        }
        return false;
    }
//    public static boolean helper(int[] start, int[] destination, int[][] maze) {
//        if (start[0] == destination[0] && start[1] == destination[1]) return true;
//
//        maze[start[0]][start[1]] = 2;
//
//        for (int i = 0; i < 4; ++i) {
//            int newStartRow = start[0] + positionArray1[i];
//            int newStartCol = start[1] + positionArray2[i];
//
//
//            if (newStartRow > -1 && newStartRow <= destination[0] &&
//                    newStartCol > -1 && newStartCol <= destination[1] &&
//                maze[newStartRow][newStartCol] == 0) {
//                start[0] = newStartRow;
//                start[1] = newStartCol;
//                System.out.println("NEW START " + Arrays.toString(start));
//                boolean pathExists = helper(start, destination, maze);
//
//                if (pathExists) return true;
//
//            }
//        }
//        return false;
//
//    }
}
