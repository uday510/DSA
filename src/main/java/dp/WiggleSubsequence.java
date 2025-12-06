package dp;

public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {

        int n = nums.length;

        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = down[0] = 1;

        for (int i = 1; i < n; i++) {
            up[i] = down[i] = 1;

            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], down[j] + 1);
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i], up[j] + 1);
                }

            }

        }

        return Math.max(up[n - 1], down[n - 1]);
    }

}
