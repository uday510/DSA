package dp;

public class MaxDotProduct {

    public static void main(String[] args) {
        int[] nums1 = {2, 1, -2, 5};
        int[] nums2 = {3, 0, -6};

        System.out.println(maxDotProduct(nums1, nums2));
    }
    public static int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m =nums2.length;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int product = nums1[i] * nums2[j];
                dp[i][j] = product;

                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                }
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.max(dp[i][j], product + dp[i-1][j-1]);
                }
            }
        }
        return dp[n-1][m-1];
    }
}
