package bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        int minutes = -1;
        int numRows = grid.length;
        int numCols = grid[0].length;
        boolean[][] vis = new boolean[numRows][numCols];
        Queue<int[]> queue = new ArrayDeque<>();
        int freshOranges = 0;
        int[][] dirs = {{0, 1},{1, 0},{-1, 0}, {0, -1}};

        for (int row = 0; row < numRows; ++row) {
            for (int col = 0; col < numCols; ++col) {
                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                    vis[row][col] = true;
                } else if (grid[row][col] == 1) {
                    ++freshOranges;
                }
            }
        }

        if (freshOranges == 0) return 0;
        // queue.offer(new int[] {-1, -1});

        while (!queue.isEmpty()) {
            // int[] curr = queue.poll();
            // if (curr[0] == -1 && curr[1] == -1) {
            //     ++minutes;
            //     if (!queue.isEmpty()) queue.offer(curr);
            //     continue;
            // }
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    assert curr != null;
                    int R = dir[0] + curr[0];
                    int C = dir[1] + curr[1];
                    if (R < 0 || R >= numRows || C < 0 || C >= numCols || vis[R][C] || grid[R][C] != 1)
                        continue;

                    --freshOranges;
                    queue.offer(new int[] {R, C});
                    vis[R][C] = true;
                }
            }
            ++minutes;
        }
        return freshOranges == 0 ? minutes : -1;
    }

}
