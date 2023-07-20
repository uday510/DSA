package DynamicProgramming;

public class JumpGame {
    enum index {
        GOOD, BAD, UNKNOWN
    }
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
//         index[] memo = new index[nums.length];
//
//         Arrays.fill(memo, index.UNKNOWN);
//
//         memo[memo.length - 1] = index.GOOD;
//         return canJumpFromPosition(0, nums, memo);

        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if(i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;

    }
    public static boolean canJumpFromPosition(int position, int[] nums, index[] memo) {
        if (memo[position] != index.UNKNOWN) {
            return memo[position] == index.GOOD ? true : false;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);

        for (int nextPosition = position + 1; nextPosition <= furthestJump; ++nextPosition) {
            if (canJumpFromPosition(nextPosition, nums, memo)) {
                memo[position] = index.GOOD;
                return true;
            }
        }
        memo[position] = index.BAD;
        return false;
    }
}
