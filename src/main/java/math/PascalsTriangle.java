package math;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> ans = getRow(numRows);
        System.out.println(ans);
    }
    public static List<List<Integer>> getRow(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        //Base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; ++rowNum) {
            List<Integer> currRow = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            // The first row element is always 1.
            currRow.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; ++j) {
                currRow.add(prevRow.get(j-1) + prevRow.get(j));
            }
            currRow.add(1);

            triangle.add(currRow);
        }
        return triangle;
    }

}
