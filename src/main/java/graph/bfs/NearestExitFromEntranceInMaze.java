package graph.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {

    private final char WALL = '+';
    private final char PATH = '.';
    private final int[][] DIRECTIONS = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };

    public int nearestExit(char[][] maze, int[] entrance) {
        return bfs(maze, entrance);
    }
    private int bfs(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] {entrance[0], entrance[1], 0});
        visited[entrance[0]][entrance[1]] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1], distance = curr[2];

            if (isBorderCell(row, col, rows, cols) && distance != 0) return distance;

            for (int[] direction : DIRECTIONS) {
                int newRow = direction[0] + row;
                int newCol = direction[1] + col;

                if (!isValid(newRow, newCol, rows, cols, maze, visited)) {
                    continue;
                }

                visited[newRow][newCol] = true;
                queue.offer(new int[] {newRow, newCol, distance + 1});
            }

        }

        return -1;
    }

    private boolean isValid(int row, int col, int rows, int cols, char[][] maze, boolean[][] visited) {
        return (row > -1 && row <= rows - 1 && col > -1 && col <= cols - 1 && !visited[row][col] && maze[row][col] == '.');
    }

    private boolean isBorderCell(int row, int col, int rows, int cols) {
        return (row == 0 || row == rows - 1 || col == 0 || col == cols - 1);
    }

}
