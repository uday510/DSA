package binarysearch.solutionspace;

public class FindTheSmallestDivisorGivenAThreshold {

    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1, r = 1;
        for (int num : nums) {
            r = Math.max(num, r);
        }

        while (l < r) {
            int m = l + ((r - l) >> 1);

            if (canDivide(nums, m, threshold)) r = m;
            else l = m + 1;
        }

        return l;
    }

    private boolean canDivide(int[] nums, int m, int threshold) {
        int curr = 0;

        for (int num : nums) {
            if (curr > threshold) break;
            curr += ((num + m - 1) / m);
        }

        return curr <= threshold;
    }
}
