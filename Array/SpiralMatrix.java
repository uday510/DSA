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
package Array;

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

        int startRow = 0,
                startCol = 0,
                endRow = matrix.length - 1,
                endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {


            // 1. left -> right
            for (int col = startCol; col <= endCol; ++col) {
                ans.add(matrix[startRow][col]);
            }

            // 2. top -> bottom

            for (int row = startRow + 1; row <= endRow; ++row) {
               ans.add(matrix[row][endCol]);
            }

            // 3. right -> left

            for (int col = endCol - 1; col >= startCol; --col) {
                if (startRow == endRow) break; // handle the edge case when there is only one row
                ans.add(matrix[startRow][col]);
            }

            // 4. bottom -> top

            for (int row = endRow - 1; row > startRow; --row) {
                if (startCol == endCol) break; // handle the edge case when there is only one column
                ans.add(matrix[row][startCol]);
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return ans;
    }
}
