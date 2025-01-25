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

import java.util.LinkedList;

public class NearestExitFromEntranceInMaze {
    private static final int[][] DIRs = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) {
        char[][] maze = {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        int[] entrance = {1,0};
        System.out.println(nearestExit(maze, entrance));
    }
    public static int nearestExit(char[][] maze, int[] entrance) {
        var visited = new boolean[maze.length][maze[0].length];
        visited[entrance[0]][entrance[1]] = true;

        var queue = new LinkedList<Edge>();
        queue.add(new Edge(entrance[0], entrance[1], 0));

        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            int dist = e.distance;

            if ((e.row == 0 || e.row == maze.length - 1 || e.col == 0 ||
                    e.col == maze[0].length - 1)
                    && dist != 0) {
                return dist;
            }

            for (int[] dir : DIRs) {
                int newRow = e.row + dir[0];
                int newCol = e.col + dir[1];

                if (newRow >= 0 && newRow < maze.length && newCol >= 0 &&
                        newCol < maze[0].length && maze[newRow][newCol] == '.' &&
                        !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;
                    queue.add(new Edge(newRow, newCol, dist + 1));
                }
            }
        }
        return -1;
    }
    static class Edge {
        int row;
        int col;
        int distance;
        public Edge(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
}
