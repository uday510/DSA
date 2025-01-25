/**
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible,
 *
 * return -1.
 *
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 *
 *
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 */
package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};

        System.out.println(orangesRotting(grid));
    }
    public static int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new ArrayDeque<>();

        // build the initial set of rotten oranges
        int freshOranges = 0;
        int ROWS = grid.length, COLS = grid[0].length;

        for (int r = 0; r < ROWS; ++r) {
            for (int c = 0; c < COLS; ++c) {
                if (grid[r][c] == 2) {
                    // add the rotten orange's coordinates to the queue
                    queue.add(new Pair(r, c));
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }

        // Mark the round / level, _i.e_ the ticker of timestamp
        queue.add(new Pair(-1, -1));

        // start the rotting process via BFS
        int minutesElapsed = -1;
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int row = p.row;
            int col = p.col;

            if (row == -1) {
                // We finish one round of processing
                minutesElapsed++;
                // to avoid the endless loop
                if (!queue.isEmpty()) {
                    queue.add(new Pair(-1, -1));
                }
            } else {
                // this is a rotten orange
                // then it would contaminate its neighbors
                for (int[] d : directions) {
                    int neighborRow = row + d[0];
                    int neighborCol = col + d[1];
                    if (neighborRow >= 0 && neighborRow < ROWS && neighborCol >= 0 && neighborCol < COLS) {
                        if (grid[neighborRow][neighborCol] == 1) {
                            // this orange would be contaminated
                            grid[neighborRow][neighborCol] = 2;
                            freshOranges--;
                            // this orange would then contaminate other oranges
                            queue.add(new Pair(neighborRow, neighborCol));
                        }
                    }
                }
            }
        }
        // return elapsed minutes if no fresh orange left
        return freshOranges == 0 ? minutesElapsed : -1;
    }
    static class Pair{
        Integer row;
        Integer col;
        Pair(Integer x, Integer y){
            this.row = x;
            this.col = y;
        }
    }
}
