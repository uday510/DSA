/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100

 */
package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12}};

        List<Integer> ans = spiralOrder(matrix);
        System.out.println(ans);
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int startRow = 0;
        int endRow = matrix.length-1;
        int startCol = 0;
        int endCol = matrix[0].length-1;
        int idx;

        while (startRow <= endRow && startCol <= endCol) {
            for (idx = startCol; idx <= endCol; ++idx) {
                ans.add(matrix[startRow][idx]);
            }

            for (idx = startRow + 1; idx <= endRow; ++idx) {
                ans.add(matrix[idx][endCol]);
            }

            if (startRow == endRow) {
                break;
            }

            for (idx = endCol - 1; idx >= startCol; --idx) {
                ans.add(matrix[endRow][idx]);
            }

            if (startCol == endCol) {
                break;
            }
            for (idx = endRow - 1; idx > startRow; --idx) {
                ans.add(matrix[idx][startCol]);
            }

            ++startRow;
            --endRow;
            ++startCol;
            --endCol;
        }


        return ans;
    }

}
