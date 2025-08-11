package binarysearch.standardsearch;

public class SearchIn2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int r = 0;
        int c = m - 1;

        while (r > -1 && r < n && c > -1 && c < m) {
            int curr = matrix[r][c];

            if (curr == target) return true;

            if (curr > target) c--;
            else r++;
        }

        return false;
    }

}
