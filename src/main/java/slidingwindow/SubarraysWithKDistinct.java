package slidingwindow;

// https://leetcode.com/problems/subarrays-with-k-different-integers/
public class SubarraysWithKDistinct {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(arr, k));
    }
    public static int subarraysWithKDistinct(int[] nums, int k) {
        int len = nums.length;
        int left = 0, right;
        int count = 0;

        for(; left < len; ++left) {
            int[] freq = new int[len + 1];
            int distinct = 0;
            for(right = left; right < len; ++right) {
                if(freq[nums[right]] == 0) {
                    ++distinct;
                }
                ++freq[nums[right]];
                if(distinct == k) {
                    ++count;
                }
                if(distinct > k) {
                    break;
                }
            }
        }
        return count;
    }
}
