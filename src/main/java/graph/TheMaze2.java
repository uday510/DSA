/**
 * There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 *
 * Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol] and destination = [destinationrow, destinationcol], return the shortest distance for the ball to stop at the destination. If the ball cannot stop at destination, return -1.
 *
 * The distance is the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included).
 *
 * You may assume that the borders of the maze are all walls (see examples).
 *
 *
 * Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
 * Output: 12
 * Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
 * The length of the path is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12
 *
 * Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [3,2]
 * Output: -1
 * Explanation: There is no way for the ball to stop at the destination. Notice that you can pass through the destination but you cannot stop there.
 */
package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TheMaze2 {
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
        System.out.println(shortestDistance(maze, start, destination));
    }
    public static int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // TODO: Logic failing for 69th Test case in Leetcode
        Queue<int[]> queue = new java.util.LinkedList<>();
        queue.offer(new int[] {start[0], start[1], 0});

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            // Check if we have reached the target cell
            if (row == destination[0] && col == destination[1]) {
                return cell[2];
            }

            // Otherwise, process all the neighboring cells
            for (int[] neighbor : getNeighbors(row, col, cell[2], maze)) {
                int neighborRow = neighbor[0];
                int neighborCol = neighbor[1];
                int distance = neighbor[2];

                // If the neighbor is not visited
                if (!visited[neighborRow][neighborCol]) {
                    queue.offer(new int[] {neighborRow, neighborCol, distance});
                    visited[neighborRow][neighborCol] = true;
                }
            }
        }
        // The target cell was unreachable
        return -1;
    }
    private static List<int[]> getNeighbors(int row, int col, int distance, int[][] grid) {
        List<int[]> neighbors = new ArrayList<>();
        for (int[] direction : directions) {
            int neighborRow = row + direction[0];
            int neighborCol = col + direction[1];
            int count = 0;

            while (neighborRow >= 0 && neighborRow < grid.length &&
                    neighborCol >= 0 && neighborCol < grid[0].length &&
                    grid[neighborRow][neighborCol] == 0) {
                neighborRow += direction[0];
                neighborCol += direction[1];
                count++;
            }
            if (count > 0) {
                neighbors.add(new int[] {neighborRow - direction[0], neighborCol - direction[1], count});
            }
        }
        return neighbors;
    }
}
