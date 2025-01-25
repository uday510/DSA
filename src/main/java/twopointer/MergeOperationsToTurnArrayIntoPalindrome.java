package twopointer;

public class MergeOperationsToTurnArrayIntoPalindrome {
    public static void main(String[] args) {
        int[] nums = {4,3,2,1,2,3,1};
    }
    public static int minimumOperations(int[] nums) {

        int i = 0, j = nums.length - 1;
        int left = nums[i], right = nums[j];
        int minOperations = 0;

        while (i < j) {
            if (left == right) {
                ++i;
                --j;
                left = nums[i];
                right = nums[j];
                minOperations += 1;
            } else if (left < right) {
                left += nums[i];
                ++i;
            } else {
                right += nums[j];
                --j;
            }
        }
        return minOperations;
    }
}
