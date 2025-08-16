package binarysearch.solutionspace;

public class MaximumValueAtAGivenIndexInBoundedArray {

    public int maxValue(int n, int index, int maxSum) {
        int l = 1, r = maxSum;
        int res = -1;

        while (l <= r) {
            int m = l + ((r - l) >> 1);

            if (cnt(n, m, index) <= (long) maxSum) {
                res = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }

    private long cnt(int n, int val, int i) {
        // AP sum formula:
        // S_n = n/2 * (a1 + an)

        long left;

        // left side length = i
        if (val <= i) {
            // We hit 1 before filling i slots:
            // sum(1..(val-1)) + remaining 1s
            left = (long) (val - 1) * val / 2 + (i - (val - 1));
        } else {
            // Pure AP from (val-1) down to (val-i), i terms
            left = (long) ((val - 1) + (val - i)) * i / 2;
        }

        long middle = val;

        // right side length
        int rlen = n - i - 1;
        long right;
        if (val <= rlen) {
            // 1 before filling rlen slots
            right = (long) (val - 1) * val / 2 + (rlen - (val - 1));
        } else {
            // Pure AP from (val-1) down to (val - rlen), rlen terms
            right = (long) ((val - 1) + (val - rlen)) * rlen / 2;
        }

        return left + middle + right;

    }
}
