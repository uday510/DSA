/**
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 * Example 2:
 *
 * Input: grid = [[3,2],[1,0]]
 * Output: 0
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 *
 *
 * Follow up: Could you find an O(n + m) solution?
 */
package binarysearch;

public class CountNegativeNumbersInSortedMatrix {
    public static void main(String[] args) {
        int[][] grid = { {4, 3, 2, -1},
                         {3, 2, 1, -1},
                         {1, 1, -1, -2},
                         {-1, -1, -2, -3}};

        int ans = solve(grid);
        System.out.println(ans);
    }
    public static int solve(int[][] grid) {
        int res = 0;
        int row = 0;
        int col = grid[0].length - 1;

        while (row < grid.length && col >= 0) {

            if (grid[row][col] < 0) { // if negative, then all the elements in the same column are negative
                res += grid.length - row;
                col--; // move to the left, why ? because the elements in the same row are sorted in non-increasing order
            } else {
                row++; // move to the next row to find the negative elements
            }
        }

        return res;

    }
}
