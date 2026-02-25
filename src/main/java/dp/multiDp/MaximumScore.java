package dp.multiDp;

public class MaximumScore {


    private Integer[][] dp;
    private int[] nums, multi;
    private int n, m;

    public int maximumScore(int[] nums, int[] multipliers) {

        this.nums = nums;
        this.multi = multipliers;
        this.n = nums.length;
        this.m = this.multi.length;

        dp = new Integer[m][m];

        return this.dfs(0, 0);
    }


    // 1 2 3 4 5
    private int dfs(int l, int i) {
        int r = n - 1 - (i - 1);
    }

}
