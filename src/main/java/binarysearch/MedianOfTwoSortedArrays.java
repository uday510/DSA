package binarysearch;

public class MedianOfTwoSortedArrays {

    /**
     * Finds the median of two sorted arrays using an optimized binary search partitioning approach.
     *
     * <p>This algorithm partitions both arrays into left and right halves such that:
     * <pre>
     *     max(l1, l2) <= min(r1, r2)
     * </pre>
     * Once this partition condition is met, the median can be computed directly
     * without merging the two arrays.
     *
     * <h3>Approach</h3>
     * <pre>
     * - Always perform binary search on the smaller array (nums1 after swapping).
     * - The combined left and right partitions together contain all elements.
     *
     * Definitions:
     * n1 = length of nums1 (smaller array)
     * n2 = length of nums2 (larger array)
     * total  = n1 + n2
     * left = (total + 1) / 2  → number of elements in the combined left half
     *
     * p1 = partition index in nums1 (binary search variable)
     * p2 = left - p1           (remaining elements needed from nums2)
     *
     * l1 = last element on the left side of nums1 → nums1[p1 - 1]
     * r1 = first element on the right side of nums1 → nums1[p1]
     * l2 = last element on the left side of nums2 → nums2[p2 - 1]
     * r2 = first element on the right side of nums2 → nums2[p2]
     *
     * ✅ Valid partition condition:
     *     l1 <= r2 && l2 <= r1
     *
     * Once valid:
     * - If total is odd  → median = max(l1, l2)
     * - If total is even → median = (max(l1, l2) + min(r1, r2)) / 2.0
     * </pre>
     *
     * <h3>Example Dry Run (Binary Search on Smaller Array):</h3>
     * <pre>
     * nums1 = [5, 7, 9, 11]   ← smaller array → binary search happens here
     * nums2 = [1, 2, 3, 4, 6, 8, 10]
     *
     * n1 = 4, n2 = 7 → total = 11 → left = 6
     *
     * ---------------------------------------------------------------
     * Step 1:
     *   l = 0, r = 4
     *   p1 = (0 + 4) / 2 = 2
     *   p2 = left - p1 = 6 - 2 = 4
     *
     *   Partition points:
     *   nums1 → [5, 7 | 9, 11]
     *   nums2 → [1, 2, 3, 4 | 6, 8, 10]
     *
     *   l1 = nums1[p1 - 1] = 7
     *   r1 = nums1[p1]     = 9
     *   l2 = nums2[p2 - 1] = 4
     *   r2 = nums2[p2]     = 6
     *
     *   Check:
     *   l1 <= r2 → 7 <= 6 ❌ → too many from nums1 → move left
     *   → r = p1 - 1 = 1
     *
     * ---------------------------------------------------------------
     * Step 2:
     *   l = 0, r = 1
     *   p1 = (0 + 1) / 2 = 0
     *   p2 = left - p1 = 6 - 0 = 6
     *
     *   nums1 → [ | 5, 7, 9, 11]
     *   nums2 → [1, 2, 3, 4, 6, 8 | 10]
     *
     *   l1 = -∞ (no elements on left)
     *   r1 = nums1[0] = 5
     *   l2 = nums2[p2 - 1] = 8
     *   r2 = nums2[p2]     = 10
     *
     *   l1 <= r2 ✅ but l2 <= r1 ❌ → too few from nums1 → move right
     *   → l = p1 + 1 = 1
     *
     * ---------------------------------------------------------------
     * Step 3:
     *   l = 1, r = 1
     *   p1 = 1
     *   p2 = left - p1 = 6 - 1 = 5
     *
     *   nums1 → [5 | 7, 9, 11]
     *   nums2 → [1, 2, 3, 4, 6 | 8, 10]
     *
     *   l1 = nums1[p1 - 1] = 5
     *   r1 = nums1[p1]     = 7
     *   l2 = nums2[p2 - 1] = 6
     *   r2 = nums2[p2]     = 8
     *
     *   Check:
     *   l1 <= r2 → 5 <= 8 ✅
     *   l2 <= r1 → 6 <= 7 ✅
     *   ✅ Valid partition found
     *
     * ---------------------------------------------------------------
     * Median Calculation:
     * total = 11 (odd)
     * → median = max(l1, l2) = max(5, 6) = 6
     *
     * ---------------------------------------------------------------
     * Visualization:
     * nums1: [5 | 7, 9, 11]
     * nums2: [1, 2, 3, 4, 6 | 8, 10]
     *
     * Left half  = [1, 2, 3, 4, 5, 6]
     * Right half = [7, 8, 9, 10, 11]
     *
     * ✅ Median = 6
     * ---------------------------------------------------------------
     *
     * <h3>Intuition</h3>
     * - Binary search runs on the smaller array (nums1 after swapping).
     * - Each iteration adjusts how many elements come from nums1.
     * - If l1 > r2 → move left (too many from nums1)
     * - If l2 > r1 → move right (too few from nums1)
     * - When both cross-boundary checks hold, we’ve found the correct partition.
     *
     * <h3>Complexity</h3>
     * <pre>
     * Time  → O(log(min(n1, n2)))   // binary search on smaller array
     * Space → O(1)                  // constant space
     * </pre>
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length)
            return findMedianSortedArrays(nums2, nums1); // ensure nums1 is smaller

        int n1 = nums1.length, n2 = nums2.length;
        int total = n1 + n2;
        int left = (total + 1) >> 1; // total elements in left half

        int l = 0, r = n1;

        while (l <= r) {
            int p1 = (l + r) >> 1;       // partition in nums1 (smaller)
            int p2 = left - p1;          // corresponding partition in nums2

            // Get boundary values safely
            int l1 = safeGet(p1 - 1, nums1), r1 = safeGet(p1, nums1);
            int l2 = safeGet(p2 - 1, nums2), r2 = safeGet(p2, nums2);

            // ✅ Found valid partition
            if (l1 <= r2 && l2 <= r1) {
                int midOdd = Math.max(l1, l2);
                if ((total & 1) == 1) return midOdd; // odd total → direct median
                return (midOdd + Math.min(r1, r2)) / 2.0; // even → average of two middles
            }
            // Too many from nums1 → move left
            else if (l1 > r2) r = p1 - 1;
                // Too few from nums1 → move right
            else l = p1 + 1;
        }

        return -1; // should never reach here
    }

    // Utility to safely access array bounds
    private int safeGet(int i, int[] nums) {
        if (i < 0) return Integer.MIN_VALUE;
        if (i >= nums.length) return Integer.MAX_VALUE;
        return nums[i];
    }
}