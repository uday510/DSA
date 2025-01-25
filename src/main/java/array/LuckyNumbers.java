package array;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbers {
    public static void main(String[] args) {

    }
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (isLucky(matrix, i, j)) {
                    result.add(matrix[i][j]);
                }
            }
        }
        return result;
    }
    public boolean isLucky(int[][] matrix, int row, int col) {
        int minRow = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;


        for (int i = 0; i < matrix[row].length; ++i) {
            minRow = Math.min(minRow, matrix[row][i]);
        }

        if (matrix[row][col] != minRow) {
            return false;
        }

        for (int i = 0; i < matrix.length; ++i) {
            maxCol = Math.max(maxCol, matrix[i][col]);
        }

        return matrix[row][col] == maxCol;
    }
}
