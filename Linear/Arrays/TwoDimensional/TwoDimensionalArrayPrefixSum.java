package Linear.Arrays.TwoDimensional;

import java.util.Arrays;

public class TwoDimensionalArrayPrefixSum {
    public static void main(String[] args) {
        int[][] array = { {1, 2, 3},
                          {4, 5, 6},
                          {7, 8, 9} };

        int[][] prefixSum = solve(array);
        for (int[] arr : prefixSum) {
            System.out.println(Arrays.toString(arr));
        }
    }
    public static int[][] solve(int[][] array) {
        // O(N*M) time | O(N*M) space
        int endRow = array.length, endCol = array[0].length;
        int[][] prefixSum = new int[endRow][endCol];

        /**
         * prefix[i][j] = sum from arr[0][0] to arr[i][j]
         */

        /**
         * Find 1. Row sum
         *      2. column sum  to get prefix sum
         */

        // row sum

        for (int row = 0; row < endRow; row++) {
            prefixSum[row][0] = array[row][0];
            for (int col = 1; col < endCol; col++) {
                    prefixSum[row][col] += prefixSum[row][col-1] + array[row][col];
            }
        }

        // col sum
        for (int row = 1; row < endRow; row++) {
            for (int col = 0; col < endCol; col++) {
                prefixSum[row][col] += prefixSum[row - 1][col];
            }
        }

        return prefixSum;
    }
}
