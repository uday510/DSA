package BinarySearch;

public class dummy {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {3, 4};

        double ans = findMedianSortedArrays(nums1, nums2);
        System.out.println(ans);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2= nums2.length;

        if (len1 == 0 && len2 == 0) {
            return 0;
        }

        if (len1 == 0 && len2 == 1) {
            return nums2[0]*1.0;
        }

        if (len1 == 1 && len2 == 0) {
            return nums1[0]*1.0;
        }

        int min;
        int max;

        if (len1 == 0) {
            min = nums2[0];
            max = nums2[len2 - 1];
        }
        else if (len2 == 0) {
            min = nums1[0];
            max = nums1[len1 - 1];
        } else {
            min = Math.min(nums1[0], nums2[0]);
            max = Math.max(nums1[len1 - 1], nums2[len2 - 1]);
        }

        int median = (len1 + len2) / 2;

        if (median % 2 == 0) {
            double ans1 = applyBinarySearch(nums1, nums2, median, min, max);
            double ans2 = applyBinarySearch(nums1, nums2, median + 1, min, max);
            return (ans1 + ans2) / 2.0;
        } else {
            return applyBinarySearch(nums1, nums2, median, min, max);
        }
    }
    public static double applyBinarySearch(int[] nums1, int[] nums2, int target, int left, int right) {
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            int count1 = getCountOfSmallerElements(nums1, mid);
            int count2 = getCountOfSmallerElements(nums2, mid);

            int count = count1 + count2;

            if (count <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans*1.0;
    }
    public static int getCountOfSmallerElements(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int count = 0;


        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] <= target) {
                if (mid == target) {
                    count = mid;
                    right = mid - 1;
                } else {
                    count = mid + 1;
                    left = mid + 1;

                }
            } else {
                right = mid - 1;
            }
        }
        return count;
    }
}
