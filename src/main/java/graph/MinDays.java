package graph;

public class MinDays {
    private final int[][] directions = {
            {0,1},
            {1,0},
            {-1,0},
            {0,-1}
    };

    public static void main(String[] args) {
        MinDays minDays = new MinDays();
        int[][] grid = {
            {1,1,1,1,1},
            {1,0,0,0,1},
            {1,0,1,0,1},
            {1,0,0,0,1},
            {1,1,1,1,1}
        };
        System.out.println(minDays.minDays(grid));
    }
    public int minDays(int[][] grid) {

        int N = grid.length;
        int M = grid[0].length;
        int numIslands = islands(grid);
        if(numIslands > 1 || numIslands == 0) {
            return 0;
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    numIslands = islands(grid);
                    if(numIslands > 1 || numIslands == 0) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;

    }
    public int islands(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int numIslands = 0;
        boolean[][] vis = new boolean[N][M];

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length;j++) {
                if(grid[i][j] == 1 && !vis[i][j]) {
                    numIslands++;
                    dfs(grid, vis, i, j);
                }
            }
        }
        return numIslands;
    }
    public void dfs(int[][] grid, boolean[][] vis, int i, int j) {
        if (i < 0 || i >= grid.length
                || j < 0 || j >= grid[0].length ||
                grid[i][j] == 0 || vis[i][j]) {
            return;
        }

        vis[i][j] = true;
        for (int[] dir : directions) {
            int newRow = dir[0] + i;
            int newCol = dir[1] + j;
            dfs(grid, vis, newRow, newCol);
        }
    }
}
