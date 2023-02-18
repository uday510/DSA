package ScalerContest1;

import java.util.Arrays;

/**
 * Given an array of A of length B
 */

public class SpiralMatrix {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5 ,6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int numRows = 1;
        int numCols = 4;
        int[][] ans = solve(array, numRows, numCols);

        for (int[] num : ans) {
            System.out.println(Arrays.toString(num));
        }
    }
    public static int[][] solve(int[] array, int numRows, int numCols) {

        if(array.length == 0) return new int[][]{};

        int[][] result = new int[numRows][numCols];
        int startRow = 0,
         startCol = 0,
         endRow = numRows - 1,
         endCol = numCols - 1,
         count = 0;

        while (startRow <= endRow && startCol <= endCol) {

            for (int col = startCol; col <= endCol; col++)
                result[startRow][col] = array[count++];

            for (int row = startRow + 1; row <= endRow; row++)
                result[row][endCol] = array[count++];

            if (count >= array.length) break;

            for (int col = endCol - 1; col >= startCol; col--)
                result[endRow][col] = array[count++];

            for (int row = endRow - 1; row > startRow; row--)
                result[row][startCol] = array[count++];

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return result;
    }
}
