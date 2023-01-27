package ScalerContest1;

import java.util.Arrays;

/**
 * Given an array of A of length B
 */

public class SpiralMatrix {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5 ,6, 7, 8, 9};
        int numRows = 3;
        int numCols = 3;
        int[][] ans = solve(array, numRows, numCols);
        System.out.println(Arrays.deepToString(ans));
    }
    public static int[][] solve(int[] array, int numRows, int numCols) {

        if(array.length == 0) return new int[][]{};

        int[][] result = new int[numRows][numCols];
        var startRow = 0;
        var endRow = numRows;
        int endCol = numCols;
        int count = 0;

        while (startRow < endRow) {
            for (int col = 0; col < endCol; col++) {
                result[startRow][col] = array[count++];
            }
            startRow++;
        }
        return result;
    }
}
