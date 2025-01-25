package graph;

public class MaximumElementAfterDecreasingAndIncreasing {
    // https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        java.util.Arrays.sort(arr);
        int N = arr.length;
        int curr, prev;
        arr[0] = Math.min(1, arr[0]);
        for (int i = 1; i < N; ++i) {
            curr = arr[i];
            prev = arr[i-1];
            if (!isValid(curr, prev)) {
                arr[i] = prev+1;
            }
            prev = arr[i];
        }
        return arr[N-1];
    }
    public boolean isValid(int curr, int prev) {
        return (curr - prev) <= 1;
    }
}
