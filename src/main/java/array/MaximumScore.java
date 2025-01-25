package array;

public class MaximumScore {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 7, 4, 5};
        int k = 3;

        System.out.println(maximumScore(nums, k));
    }
    public static int maximumScore(int[] nums, int k) {
        int maxScore = 0;
        int N = nums.length;
        int i = k, j = N - 1;

        while (i > -1 && i <= j && j < N) {
            int tmp = Math.min(nums[i], nums[j]) * (j - i + 1);

            maxScore = Math.max(tmp, maxScore);

            if (nums[i] < nums[j]) {
                --j;
            } else {
                ++i;
            }
        }
        return maxScore;
    }
}
