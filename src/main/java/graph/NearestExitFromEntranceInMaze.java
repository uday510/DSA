/*
You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.

In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.

Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.

Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
Output: 1
Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
Initially, you are at the entrance cell [1,2].
- You can reach [1,0] by moving 2 steps left.
- You can reach [0,2] by moving 1 step up.
It is impossible to reach [2,3] from the entrance.
Thus, the nearest exit is [0,2], which is 1 step away.

 */
package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
    public static void main(String[] args) {
        char[][] maze = {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        int[] entrance = {1,0};
        System.out.println(nearestExit(maze, entrance));
    }

    private static final char WALL = '+';
    private static final char PATH = '.';
    private static int[][] DIRECTIONS = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };

    public static int nearestExit(char[][] maze, int[] entrance) {
        return bfs(maze, entrance);
    }

    private static int bfs(char[][] maze, int[] entrance) {
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

    private static boolean isValid(int row, int col, int rows, int cols, char[][] maze, boolean[][] visited) {
        return (row > -1 && row <= rows - 1 && col > -1 && col <= cols - 1 && !visited[row][col] && maze[row][col] == '.');
    }

    private static boolean isBorderCell(int row, int col, int rows, int cols) {
        return (row == 0 || row == rows - 1 || col == 0 || col == cols - 1);
    }
    
}
