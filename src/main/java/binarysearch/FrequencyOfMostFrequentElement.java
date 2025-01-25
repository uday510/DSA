package binarysearch;

import java.util.Arrays;

public class FrequencyOfMostFrequentElement {
    public static void main(String[] args) {

    }
    public static int solve(int[] nums, int k) {
        Arrays.sort(nums);

        long[] pref = new long[nums.length];
        pref[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            pref[i] = pref[i-1] + nums[i];
        }

        int ans = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int l = 0;
//            int h = i;
//            while (l <= h) {
//                int mid = (l+h) / 2;
//                long sum = pref[i];
//
//                if (mid - 1 >= 0) {
//                    sum -= pref[mid-1];
//                }
//                if (1L*nums[i]*(i-mid+1)-sum <= k) {
//                    ans = Math.max(ans, i-mid+1);
//                    h = mid-1;
//                } else {
//                    l = mid + 1;
//                }
//            }
//        }
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            long sum = pref[j];
            if (i-1 >= 0) {
                sum -= pref[i-1];
            }
            if (1L*nums[j]*(j-i+1)-sum>k) {
                i++;
            } else {
                ans = Math.max(ans, (j-i+1));
                j++;
            }
        }
        return ans;
    }
}
