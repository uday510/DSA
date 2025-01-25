package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    private static final int[][] directions =
            new int[][] { {-1, -1}, {-1, 0}, {-1, 1}
                        , {0, -1}, {0, 1}
                        , {1, -1}, {1, 0}, {1, 1} };

    public static void main(String[] args) {
        int[][] grid = new int[][] { {0, 0, 0}
                                    , {1, 1, 0}
                                    , {1, 1, 0} };
        System.out.println(shortestPathBinaryMatrix(grid));
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
        // O(N) time | O(N) space - where N is the total number of cells in the grid

        // Firstly, we need to check that the start and target cells are open
        if (grid[0][0] != 0 || grid[grid.length - 1] [grid[0].length - 1] != 0) {
            return -1;
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
                return distance;
            }

            // Otherwise, process all the neighboring cells
//            for (int[] neighbor : getNeighbors(row, col, grid)) {
//                int neighborRow = neighbor[0];
//                int neighborCol = neighbor[1];
//                if (visited[neighborRow][neighborCol]) {
//                    // If the neighbor was already visited, skip it
//                    continue;
//                }
//                // Mark the neighbor as visited
//                visited[neighborRow][neighborCol] = true;
//                queue.add(new int[] {neighborRow, neighborCol, distance + 1});
//            }

            for (int[] dir: directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow < 0 || newCol < 0 || newRow >= grid.length ||
                        newCol >= grid[0].length || grid[newRow][newCol] != 0 || visited[newRow][newCol]) {
                    continue;
                }

                visited[newRow][newCol] = true;

                queue.add(new int[] {newRow, newCol, distance + 1});
            }
        }
        // The target cell was unreachable
        return -1;
    }
    private static List<int[]> getNeighbors(int row, int col, int[][] grid) {
        List<int[]> neighbors = new ArrayList<>();
        for (int i = 0; i < directions.length; ++i) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];
            if (newRow < 0 || newCol < 0 || newRow >= grid.length ||
                    newCol >= grid[0].length || grid[newRow][newCol] != 0) {
                continue;
            }
            neighbors.add(new int[] {newRow, newCol});
        }
        return neighbors;
    }
//    public static int shortestPathBinaryMatrix(int[][] grid) {
//        This approach manipulates the input grid
//        // Firstly, we need to check that the start and target cells are open
//        if (grid[0][0] != 0 || grid[grid.length - 1] [grid[0].length - 1] != 0) {
//            return -1;
//        }
//
//        // Set up the BFS
//        Queue<int[]> queue = new java.util.LinkedList<>();
//        grid[0][0] = 1;
//        queue.offer(new int[] {0, 01});
//
//        // Start BFS
//        while (!queue.isEmpty()) {
//            int[] cell = queue.poll();
//            int row = cell[0];
//            int col = cell[1];
//            int distance = grid[row][col];
//
//            // Check if we have reached the target cell
//            if (row == grid.length - 1 && col == grid[0].length - 1) {
//                return distance;
//            }

//            // Otherwise, process all the neighboring cells
//            for (int[] neighbor : getNeighbors(row, col, grid)) {
//                int neighborRow = neighbor[0];
//                int neighborCol = neighbor[1];
//                queue.add(new int[] {neighborRow, neighborCol});
//                grid[neighborRow][neighborCol] = distance + 1;
//            }
//        }
//        // The target cell was unreachable
//        return -1;
//    }
//    private static List<int[]> getNeighbors(int row, int col, int[][] grid) {
//        List<int[]> neighbors = new ArrayList<>();
//        for (int i = 0; i < directions.length; ++i) {
//            int newRow = row + directions[i][0];
//            int newCol = col + directions[i][1];
//            if (newRow < 0 || newCol < 0 || newRow >= grid.length ||
//                    newCol >= grid[0].length || grid[newRow][newCol] != 0) {
//                continue;
//            }
//            neighbors.add(new int[] {newRow, newCol});
//        }
//        return neighbors;
//    }
}
