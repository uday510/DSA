package binarysearch.solutionspace;

public class SplitArrayLargestSum {

    public int splitArray(int[] arr, int k) {

        int l = 0, r = 0;
        for (int x : arr) {
            l = Math.max(l, x);
            r += x;
        }

        while (l < r) {

            int m = l + ( ( r - l) >> 1);

            if (canSplit(arr, m, k)) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    private boolean canSplit(int[] arr, int limit, int k) {
        int sum = 0, splits = 1;

        for (int x : arr) {

            if (sum + x > limit) {
                sum = 0;
                splits++;
            }

            sum += x;

            if (splits > k) return false;

        }

        return true;
    }

}
