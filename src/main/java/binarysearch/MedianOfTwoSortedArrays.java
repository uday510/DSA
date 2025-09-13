package binarysearch;

import static array.MergeSortedSubArrays.merge;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length)
            return findMedianSortedArrays(nums2, nums1);

        int n1 = nums1.length, n2 = nums2.length;

        int total = n1 + n2;
        int left = (total+ 1) >> 1;
        int l = 0, r = n1;


        while (l <= r) {
            int m1 = (l + r) >> 1;
            int m2 = left - m1;

            int l1 = safeGet(m1 - 1, nums1), l2 = safeGet(m2 - 1, nums2);
            int r1 = safeGet(m1, nums1), r2 = safeGet(m2, nums2);

            if (l1 <= r2 && l2 <= r1) {
                int midOdd = Math.max(l1, l2);
                if ((total & 1) == 1) return midOdd;

                return (midOdd + Math.min(r1, r2)) / 2.0;
            }
            else if (l1 > r2) r = m1 - 1;
            else if (l2 > r1) l = m1 + 1;

        }

        return -1;
    }

    private int safeGet(int i, int[] nums) {
        if (i < 0) return Integer.MIN_VALUE;
        if (i >= nums.length) return Integer.MAX_VALUE;

        return nums[i];
    }

    public double findMedianSortedArraysWithMergeAlgorithm(int[] a1, int[] a2) {
        int n = a1.length, m = a2.length;
        int[] a = merge(a1, a2);

        if (((n + m) & 1) == 0) {
            int idx = (n + m) / 2;
            return (a[idx - 1] + a[idx]) / 2.0;
        }

        return a[(n + m) / 2];
    }

}