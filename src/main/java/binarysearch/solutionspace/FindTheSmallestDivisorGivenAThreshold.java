package binarysearch.solutionspace;

public class FindTheSmallestDivisorGivenAThreshold {

    public int smallestDivisor(int[] arr, int t) {
        int l = 1, r = 1;
        for (int x : arr) r = Math.max(r, x);

        while (l < r) {

            int m = l + ( (r - l) >> 1 );

            if (!isValid(arr, m, t)) l = m + 1; // increase m, so it will decrease threshold
            else r = m;
        }

        return l;
    }

    private boolean isValid(int[] arr, int y, int limit) {
        int cur = 0;

        for (int x : arr) {
            if (cur > limit) break;
            cur += (x + y - 1) / y;
        }

        return cur <= limit;
    }

}
