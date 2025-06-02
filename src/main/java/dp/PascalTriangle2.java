/**
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * Example 1:
 *
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * Example 2:
 *
 * Input: rowIndex = 0
 * Output: [1]
 * Example 3:
 *
 * Input: rowIndex = 1
 * Output: [1,1]
 *
 *
 * Constraints:
 *
 * 0 <= rowIndex <= 33
 */
package dp;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {
    public static void main(String[] args) {
        int rowIndex = 4;

        List<Integer> res = getRow(rowIndex);
        System.out.println(res);
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex + 1) { { add(1); } };

        for (int i = 0; i < rowIndex; ++i) {
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j-1));
            }
            row.add(1);
        }
        return row;
    }
}
