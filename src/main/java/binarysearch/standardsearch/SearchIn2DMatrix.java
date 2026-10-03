package binarysearch.standardsearch;

public class SearchIn2DMatrix {

    public boolean searchMatrix(int[][] arr, int t) {
       int n = arr.length, m = arr[0].length;
       int l = 0, r = n * m - 1;

       while (l < r) {

           int mid = l + ((r - l) >> 1);
           int cur = arr[mid / m][mid % m];

           if (cur == t) return true;

           if (cur < t) l = mid + 1;
           else r = mid - 1;
       }
        return false;
    }

}
