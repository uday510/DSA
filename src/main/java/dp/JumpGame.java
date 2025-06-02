package dp;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {

        /**
         * Approach 1: Backtracking
         * Time Complexity: O(2^n)
         *
         * Approach 2: Dynamic Programming Top Down
         * Time Complexity: O(n^2)
         *
         * Approach 3: Dynamic Programming Bottom Up
         * Time Complexity: O(n^2)
         *
         * Approach 4: Greedy
         * Time Complexity: O(n)
         */

        // Approach 1
//        return canJumpFromPosition(0, nums);

        // Approach 2

       boolean[] memo = new boolean[nums.length];
       memo[nums.length-1] = true;

//       return canJumpFromPosition(0, nums, memo);

          // Approach 3
//        boolean[] dp = new boolean[nums.length];
//
//        dp[nums.length-1] = true;
//
//        for (int i = nums.length-2; i > -1; --i) {
//            int farthestJump = Math.min(i + nums[i], nums.length - 1);
//            for (int j = i+1; j <= farthestJump; ++j) {
//                if (dp[j]) {
//                    dp[i] = true;
//                    break;
//                }
//            }
//        }
//        return dp[0];

        // Approach 4
        int lastPos = nums.length - 1;
        for (int i = nums.length - 2; i > -1; --i) {
            if (i + nums[i] >= lastPos)
                lastPos = i;
        }
        return lastPos == 0;
    }
    public static boolean canJumpFromPosition(int pos, int[] nums, boolean[] memo) {
        if (memo[pos])
            return memo[pos];

        int farthestJump = Math.min(pos + nums[pos], nums.length - 1);

        for (int nextPos = pos + 1; nextPos <= farthestJump; ++nextPos) {
            if (canJumpFromPosition(nextPos, nums, memo)) {
                memo[pos] = true;
                return true;
            }
        }
        memo[pos] = false;
        return false;

    }
    public static boolean canJumpFromPosition(int pos, int[] nums) {
        if (pos == nums.length-1)
            return true;

        int farthestJump = Math.min(pos + nums[pos], nums.length - 1);

        for (int nextPost = pos + 1; nextPost <= farthestJump; ++nextPost) {
            if (canJumpFromPosition(nextPost, nums))
                return true;
        }
        return false;
    }
    private static boolean dfs(int pos, int[] nums, int[] dp) {
        if (pos >= nums.length-1)
            return true;

        if (dp[pos] != -1)
            return dp[pos] == 1;

        int farthestJump = Math.min(pos + nums[pos], nums.length - 1);

        for (int nextPos = pos + 1; nextPos <= farthestJump; ++nextPos) {

            if (dfs(nextPos, nums, dp)) {
                dp[pos] = 1;
                return true;
            }
        }
        dp[pos] = 0;
        return false;
    }
    private static boolean dfs(int[] nums) {
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[len-1] = true;

        for (int i = len -2; i > -1; --i) {
            int farthestJump = Math.min(i + nums[i], len - 1);
            for (int j = i+1; j <= farthestJump; ++j) {
                if (dp[j])  {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

}
