package dp.fibonacci;

public class HouseRobber {

    public int rob(int[] nums) {

        int rob1 = 0, rob2 = 0;

        for (int num : nums) {
            int curr = Math.max(rob1 + num, rob2);
            rob1 = rob2;
            rob2 = curr;
        }

        return Math.max(rob1, rob2);
    }

    private int dfs(int i, int[] nums) {
        if (i >= nums.length) return 0;

        int rob = nums[i] + dfs(i + 2, nums);
        int dont = dfs(i + 1, nums);

        return Math.max(rob, dont);
    }

}
