package dp.trees;

public class UniqueBSTs {

    public int numTrees(int n) {
        // int[] dp = new int[n + 1];
        // dp[0] = dp[1] = 1;

        // for (int i = 2; i <= n; ++i) { // root i
        //     for (int j = 1; j <= i; ++j) {
        //         int l = dp[j - 1]; // left bsts, root j
        //         int r = dp[i - j]; // right bsts, root j

        //         dp[i] += l * r;
        //     }
        // }

        // return dp[n];

        // catalon number
        long c = 1; // co = 1, cn+1 = 2(2n + 1)c/(n + 2)

        for (int i = 0; i < n; ++i) {
            c = (c * 2 * (2 * i + 1)) / (i + 2);
        }

        return (int) c;
    }

}
