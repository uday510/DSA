package twopointer;

public class PartitionArrayAccordingToPivot {
}

// https://leetcode.com/problems/partition-array-according-to-given-pivot/?envType=daily-question&envId=2026-06-08
class Solution {
    public int[] pivotArray(int[] arr, int p) {
        int n = arr.length;
        int[] res = new int[n];
        int l = 0, r = n - 1;

        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (arr[i] < p) {
                res[l++] = arr[i];
            }

            if (arr[j] > p) {
                res[r--] = arr[j];
            }
        }

        while (l <= r) {
            res[l++] = p;
        }

        return res;
    }
}
