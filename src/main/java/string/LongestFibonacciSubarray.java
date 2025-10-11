package string;

public class LongestFibonacciSubarray {

    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;

        int curr = 2, longest = 2;

        for (int i = 2; i < n; i++) {
            if (nums[i] == nums[i - 1] + nums[i - 2]) {
                curr += 1;
            } else {
                curr = 2;
            }

            longest = Math.max(longest, curr);
        }

        return longest;
    }
}
