/**
 * Problem Description
 * There is a rectangle with left bottom as (0, 0) and right up as (x, y).
 *
 * There are N circles such that their centers are inside the rectangle.
 *
 * Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.
 *
 * Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.
 *
 *
 *
 * Problem Constraints
 * 0 <= x , y, R <= 100
 *
 * 1 <= N <= 1000
 *
 * Center of each circle would lie within the grid
 *
 *
 *
 * Input Format
 * 1st argument given is an Integer x , denoted by A in input.
 *
 * 2nd argument given is an Integer y, denoted by B in input.
 *
 * 3rd argument given is an Integer N, number of circles, denoted by C in input.
 *
 * 4th argument given is an Integer R, radius of each circle, denoted by D in input.
 *
 * 5th argument given is an Array A of size N, denoted by E in input, where A[i] = x cordinate of ith circle
 *
 * 6th argument given is an Array B of size N, denoted by F in input, where B[i] = y cordinate of ith circle
 *
 *
 *
 * Output Format
 * Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  x = 2
 *  y = 3
 *  N = 1
 *  R = 1
 *  A = [2]
 *  B = [3]
 * Input 2:
 *
 *  x = 3
 *  y = 3
 *  N = 1
 *  R = 1
 *  A = [0]
 *  B = [3]
 *
 *
 * Example Output
 * Output 1:
 *
 *  NO
 * Output 2:
 *
 *  YES
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  There is NO valid path in this case
 * Explanation 2:
 *
 *  There is many valid paths in this case.
 *  One of the path is (0, 0) -> (1, 0) -> (2, 0) -> (3, 0) -> (3, 1) -> (3, 2) -> (3, 3).
 */
package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ValidPath {
    private static final int[][] directions =
            new int[][] { {-1, -1}, {-1, 0}, {-1, 1}
                    , {0, -1}, {0, 1}
                    , {1, -1}, {1, 0}, {1, 1} };
    public static void main(String[] args) {
        int x = 3, y = 3, N = 1, R = 1;
        int[] A = {0}, B = {3};
        System.out.println(solve(x, y, N, R, A, B));
    }
    public static String solve(int A, int B, int C, int D, int[] E, int[] F) {
    int[][] grid = new int[A+1][B+1];
    for (int i = 0; i < E.length; ++i) {
        grid[E[i]][F[i]] = 1;
    }
        if (!isValid(0, 0, D, E, F) || !isValid(A, B, D, E, F)) {
            return "NO";
        }

        // Set up the BFS
        Queue<int[]> queue = new java.util.LinkedList<>();
        // Since we are given the start and target cell, we don't need to find the start cell
        // queue contains the cell's row, column, and distance from the start cell
        queue.offer(new int[] {0, 0, 1});
        // created a visited array to keep track of the visited cells to
        //avoid infinite looping around cycles
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        // Mark the start cell as visited
        visited[0][0] = true;


        // Start BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            int distance = cell[2];

            // Check if we have reached the target cell
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return "YES";
            }

            // Otherwise, process all the neighboring cells
            for (int[] neighbor : getNeighbors(row, col, D, E, F, grid)) {
                int neighborRow = neighbor[0];
                int neighborCol = neighbor[1];
                if (visited[neighborRow][neighborCol]) {
                    // If the neighbor was already visited, skip it
                    continue;
                }
                // Mark the neighbor as visited
                visited[neighborRow][neighborCol] = true;
                queue.add(new int[] {neighborRow, neighborCol, distance + 1});
            }
        }
        // The target cell was unreachable
        return "NO";
    }
    private static List<int[]> getNeighbors(int row, int col, int D, int[] E, int[] F, int[][] grid) {
        List<int[]> neighbors = new ArrayList<>();
        for (int i = 0; i < directions.length; ++i) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];
            if (newRow < 0 || newCol < 0 || newRow >= grid.length ||
                    newCol >= grid[0].length || grid[newRow][newCol] != 0) {
                continue;
            }
            if (isValid(newRow, newCol, D, E, F)) {
                neighbors.add(new int[] {newRow, newCol});
            }
        }
        return neighbors;
    }
    public static boolean isValid(int row, int col, int D, int[] E, int[] F) {
        boolean isExists = true;

        for (int i = 0; i < E.length; ++i) {
            int dist = (row - E[i])*(row - E[i]) + (col - F[i])*(col - F[i]);
            if (dist <= D * D) {
                isExists = false;
                break;
            }
        }
        return isExists;
    }
}
