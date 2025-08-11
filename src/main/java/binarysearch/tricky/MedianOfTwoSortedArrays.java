package binarysearch.tricky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MedianOfTwoSortedArrays {

    public double bruteForce(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums1) list.add(num);
        for (int num : nums2) list.add(num);
        Collections.sort(list);

        int m = nums1.length;
        int n = nums2.length;

        if ((m + n) % 2 == 0) {
            int t1 = list.get((m + n - 1) / 2);
            int t2 = list.get((m + n) / 2);
            return (double) (t1 + t2) / 2;
        }
        return (double) list.get((m + n) / 2);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        // Always binary search the smaller array
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int total = n1 + n2;
        int target = (total + 1) / 2;

        int l = 0, r = n1;
        while (l <= r) {
            int m1 = (l + r) >> 1;
            int m2 = target - m1;

            int left1  = safeGet(nums1, m1 - 1);
            int right1 = safeGet(nums1, m1);
            int left2  = safeGet(nums2, m2 - 1);
            int right2 = safeGet(nums2, m2);

            if (left1 <= right2 && left2 <= right1) {
                int medianValOdd = Math.max(left1, left2);
                if ((total & 1) == 1) return medianValOdd;
                return (medianValOdd + Math.min(right1, right2)) / 2.0;
            } else if (left1 > right2) {
                r = m1 - 1;
            } else { // left2 > right1
                l = m1 + 1;
            }
        }
        return -1;
    }

    private int safeGet(int[] nums, int idx) {
        if (idx < 0) return Integer.MIN_VALUE;
        if (idx >= nums.length) return Integer.MAX_VALUE;
        return nums[idx];
    }

    /* =========================
       DRY RUN / TRACE UTILITIES
       ========================= */

    public void dryRun(int[] nums1, int[] nums2) {
        System.out.println("===== Dry Run =====");
        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums2 = " + Arrays.toString(nums2));

        // We'll search on the smaller array but keep originals for display
        int[] a = nums1, b = nums2;
        boolean swapped = false;
        if (a.length > b.length) {
            a = nums2; b = nums1;
            swapped = true;
        }
        System.out.println("Searching on " + (swapped ? "nums2 (smaller)" : "nums1 (smaller)"));

        int n1 = a.length, n2 = b.length;
        int total = n1 + n2;
        int target = (total + 1) / 2;
        System.out.println("total = " + total + ", target(left-size) = " + target);
        System.out.println();

        int l = 0, r = n1;
        int step = 1;

        while (l <= r) {
            int m1 = (l + r) >> 1;
            int m2 = target - m1;

            int left1  = safeGet(a, m1 - 1);
            int right1 = safeGet(a, m1);
            int left2  = safeGet(b, m2 - 1);
            int right2 = safeGet(b, m2);

            System.out.println("Step " + (step++) + ":");
            System.out.println(String.format("  l=%d, r=%d, m1=%d, m2=%d", l, r, m1, m2));
            System.out.println(String.format("  a-left=%s, a-right=%s | b-left=%s, b-right=%s",
                    fmt(left1), fmt(right1), fmt(left2), fmt(right2)));

            if (left1 <= right2 && left2 <= right1) {
                int leftMax = Math.max(left1, left2);
                if ((total & 1) == 1) {
                    System.out.println("  ✓ Valid partition (odd total). Median = " + leftMax);
                    double brute = bruteForce(nums1, nums2);
                    System.out.println("  (brute-force check) = " + brute);
                    System.out.println("====================\n");
                    return;
                } else {
                    int rightMin = Math.min(right1, right2);
                    double median = (leftMax + rightMin) / 2.0;
                    System.out.println("  ✓ Valid partition (even total). Median = " + median);
                    double brute = bruteForce(nums1, nums2);
                    System.out.println("  (brute-force check) = " + brute);
                    System.out.println("====================\n");
                    return;
                }
            } else if (left1 > right2) {
                System.out.println("  left1 > right2 → move left (r = m1 - 1)");
                r = m1 - 1;
            } else { // left2 > right1
                System.out.println("  left2 > right1 → move right (l = m1 + 1)");
                l = m1 + 1;
            }
            System.out.println();
        }
        System.out.println("No median found (unexpected for valid inputs).");
        System.out.println("====================\n");
    }

    private static String fmt(int v) {
        if (v == Integer.MIN_VALUE) return "-∞";
        if (v == Integer.MAX_VALUE) return "+∞";
        return String.valueOf(v);
    }

    /* =========
       EXAMPLES
       ========= */
    public static void main(String[] args) {
        MedianOfTwoSortedArrays s = new MedianOfTwoSortedArrays();

        // Example 1: odd total (your given arrays)
        int[] A1 = {1, 2, 3, 4, 6, 8, 11};
        int[] B1 = {5, 7, 9, 10};
        s.dryRun(A1, B1); // expected median = 6.0

        // Example 2: even total
        int[] A2 = {1, 3, 8, 9};
        int[] B2 = {2, 7, 10, 12};
        s.dryRun(A2, B2); // expected median = (7 + 8) / 2 = 7.5
    }
}