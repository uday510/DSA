package binarysearch.tricky;

public class KthMissingPositiveNumber {

    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int l = 0, r = n;

        while (l < r) {
            int m = (l + r) >> 1;

            if (arr[m] - m - 1 < k) l = m + 1;
            else r = m;
        }

        return l + k;
    }

}
