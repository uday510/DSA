import java.util.Arrays;

public class MaxFrequency {

    /**
     * You are given an integer array nums and two integers k and numOperations.
     *
     * You must perform an operation numOperations times on nums, where in each operation you:
     *
     * Select an index i that was not selected in any previous operations.
     * Add an integer in the range [-k, k] to nums[i].
     * Return the maximum possible frequency of any element in nums after performing the operations.
     *
     * The frequency of an element x is the number of times it occurs in the array.
     *
     *  
     *
     * Example 1:
     *
     * Input: nums = [1,4,5], k = 1, numOperations = 2
     *
     * Output: 2
     *
     * Explanation:
     *
     * We can achieve a maximum frequency of two by:
     *
     * Adding 0 to nums[1]. nums becomes [1, 4, 5].
     * Adding -1 to nums[2]. nums becomes [1, 4, 4].
     * Example 2:
     *
     * Input: nums = [5,11,20,20], k = 5, numOperations = 1
     *
     * Output: 2
     *
     * Explanation:
     *
     * We can achieve a maximum frequency of two by:
     *
     * Adding 0 to nums[1].
     *  
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 105
     * 0 <= k <= 105
     * 0 <= numOperations <= nums.length
     *
     * Note: Please do not copy the description during the contest to maintain the integrity of your submissions.
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {5, 11, 20, 20};
        int k = 5;
        int numOperations = 1;
        System.out.println(maxFrequency(nums, k, numOperations));
    }

    /**
     * Input
     * nums =
     * [88,53]
     * k =
     * 27
     * numOperations =
     * 2
     * Use Testcase
     * Stdout
     * 1
     * Output
     * 1
     * Expected
     * 2
     * @param nums
     * @param k
     * @param numOperations
     * @return
     */
    private static int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] diff = new int[n];
        for (int i = 1; i < n; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
        int res = 1;
        for (int i = 1; i < n; i++) {
            int sum = 0;
            for (int j = i; j > 0; j--) {
                sum += diff[j] * (i - j);
                if (sum > k) {
                    break;
                }
                res = Math.max(res, i - j + 1);
            }
        }
        return res;
    }
}
