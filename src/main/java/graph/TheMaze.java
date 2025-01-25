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
 *
 * Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [3,2]
 * Output: false
 * Explanation: There is no way for the ball to stop at the destination. Notice that you can pass through the destination but you cannot stop there.
 */
package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TheMaze {
    private static final int[][] directions =
            new int[][] { {-1, 0}, {0, -1},
                    {0, 1}, {1, 0} };

    public static void main(String[] args) {
        int[][] maze = new int[][] {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        int[] start = new int[] {0, 4};
        int[] destination = new int[] {4, 4};
        System.out.println(hasPath(maze, start, destination));
    }
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> queue = new java.util.LinkedList<>();
        queue.offer(new int[] {start[0], start[1]});

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            // Check if we have reached the target cell
            if (row == destination[0] && col == destination[1]) {
                return true;
            }

            // Otherwise, process all the neighboring cells
            for (int[] neighbor : getNeighbors(row, col, maze)) {
                int neighborRow = neighbor[0];
                int neighborCol = neighbor[1];
                // If the neighbor is not visited
                if (!visited[neighborRow][neighborCol]) {
                    queue.offer(new int[] {neighborRow, neighborCol});
                    visited[neighborRow][neighborCol] = true;
                }
            }
        }
        // The target cell was unreachable
        return false;
    }
    private static List<int[]> getNeighbors(int row, int col, int[][] grid) {
        List<int[]> neighbors = new ArrayList<>();
        for (int[] direction : directions) {
            int neighborRow = row + direction[0];
            int neighborCol = col + direction[1];

            while (neighborRow >= 0 && neighborRow < grid.length &&
                    neighborCol >= 0 && neighborCol < grid[0].length &&
                    grid[neighborRow][neighborCol] == 0) {
                neighborRow += direction[0];
                neighborCol += direction[1];
            }
            // One step back
            neighborRow -= direction[0]; //
            neighborCol -= direction[1];
            neighbors.add(new int[] {neighborRow, neighborCol});

        }
        return neighbors;
    }
}
