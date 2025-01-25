/**
 * You are given an empty 2D binary grid grid of size m x n. The grid represents a map where 0's represent water and 1's represent land. Initially, all the cells of grid are water cells (i.e., all the cells are 0's).
 *
 * We may perform an add land operation which turns the water at position into a land. You are given an array positions where positions[i] = [ri, ci] is the position (ri, ci) at which we should operate the ith operation.
 *
 * Return an array of integers answer where answer[i] is the number of islands after turning the cell (ri, ci) into a land.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 * Input: m = 3, n = 3, positions = [[0,0],[0,1],[1,2],[2,1]]
 * Output: [1,1,2,3]
 * Explanation:
 * Initially, the 2d grid is filled with water.
 * - Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land. We have 1 island.
 * - Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land. We still have 1 island.
 * - Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land. We have 2 islands.
 * - Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land. We have 3 islands.
 *
 * Constraints:
 *
 * 1 <= m, n, positions.length <= 104
 * 1 <= m * n <= 104
 * positions[i].length == 2
 * 0 <= ri < m
 * 0 <= ci < n
 *
 *
 * Follow up: Could you solve it in time complexity O(k log(mn)), where k == positions.length?
 */
package graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands2 {
    private static final int[][] directions = new int[][] { {0,1}, {1,0}, {0,-1}, {-1,0} };
    public static void main(String[] args) {
        int n = 3, m = 3;
        int[][] positions = {{0,0},{0,1},{1,2},{2,1}};
        List<Integer> ans = numIslands2(m, n, positions);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        // Here, m and n are the number of rows and columns in the given grid, and lll is the size of positions.
        // O(mn + l) solution | k = positions.length | m = grid.length | n = grid[0].length

        List<Integer> ans = new ArrayList<>();
//        for (int[] position : positions) {
//            grid[position[0]][position[1]] = 1;
//            int islands = numIslands(grid);
//            if (islands == 0) {
//                ans.add(1);
//            } else {
//                ans.add(islands);
//            }
//        }

        UnionFind dsu = new UnionFind(m*n);

        for (int[] position : positions) {
            int x = position[0];
            int y = position[1];

            int landPosition = x*n + y; // convert 2D position to 1D position

            dsu.addLand(landPosition); // add land at position landPosition

            for (int[] direction : directions) {
                int neighborX = x + direction[0];
                int neighborY = y + direction[1];

                int newLandPosition = neighborX*n + neighborX; // convert 2D position to 1D position

                if (isValidNeigbhor(neighborX, neighborY, newLandPosition, m, n, dsu)) {
                    dsu.union(landPosition, newLandPosition);
                }
            }
            ans.add(dsu.numberOfIslands()); // add number of islands to ans
        }
        return ans; // return ans
    }
    public static boolean isValidNeigbhor(int row, int col, int position, int m, int n, UnionFind dsu) {
        return (row >= 0 && col >= 0 && row < m && col < n && dsu.isLand(position));
    }

    static class UnionFind {
        int[] parent; // parent[i] = parent of i
        int[] rank; // rank[i] = rank of subtree rooted at i (never more than 31)
        int count; // number of components

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            count = 0;
            for (int i = 0; i < size; i++) {
                parent[i] = -1;
                rank[i] = 1;
            }
        }
        public void addLand(int x) { // add land at position x
            if (parent[x] >= 0) { // if land already exists at position x
                return;
            }
            parent[x] = x; // add land at position x
            count++;
        }
        public boolean isLand(int x)  {
            if (parent[x] >= 0) { // if land already exists at position x
                return true;
            }
            return false;
        }
        public int numberOfIslands() { // return number of islands
            return count;
        }
        public int find(int x) { // path compression
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }
        public void union(int x, int y) { // union by rank
            int xset = find(x);
            int yset = find(y);

            if (xset == yset) {
                return;
            }

            if (rank[xset] > rank[yset]) {
                parent[yset] = xset;
            } else if (rank[xset] < rank[yset]) {
                parent[xset] = yset;
            } else {
                parent[yset] = xset;
                rank[xset]++;
            }
            count--;
        }
    }
    public static int numIslands(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        visited[0][0] = 1;
        int numIslands = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length;j++) {
                if(grid[i][j] == 1 && visited[i][j] == 0) {
                    numIslands++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return numIslands;
    }
    public static void dfs(int[][] grid, int[][] visited, int i, int j) {
        visited[i][j] = 1;

        for (int[] direction : directions) {
            int newRow = i + direction[0];
            int newCol = j + direction[1];

            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1 && visited[newRow][newCol] == 0) {
                dfs(grid, visited, newRow, newCol);
            }
        }
    }
}
