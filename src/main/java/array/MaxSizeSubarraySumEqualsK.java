package array;

public class MaxSizeSubarraySumEqualsK {


    public int maxSubArrayLen(int[] nums, int k) {
        int prefixSum = 0;
        int currLongest = 0;
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();


        for (int i = 0; i < nums.length; ++i) {
            prefixSum += nums[i];
            if (prefixSum == k) {
                currLongest = i + 1;
            }

            if (map.containsKey(prefixSum - k)) {
                currLongest = Math.max(currLongest, i - map.get(prefixSum - k));
            }

            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        return currLongest;
    }
}
