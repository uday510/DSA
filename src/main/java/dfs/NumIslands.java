package dfs;

public class NumIslands {
    public static void main(String[] args) {
        NumIslands obj = new NumIslands();
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println(obj.numIslands(grid));
    }
    public int numIslands(char[][] grid) {
        int islands, m, n;
        islands = 0;
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '0')
                    continue;
                ++islands;
                dfs(grid, i, j);
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (!isValid(grid, i, j) || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
    private boolean isValid(char[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;
        return i >= 0 && j >= 0 && i < row && j < col;
    }
}
