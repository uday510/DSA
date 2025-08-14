/**
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
 *
 * One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
 *
 * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
 *
 * Note: You cannot rotate an envelope.
 *
 *
 *
 * Example 1:
 *
 * Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * Example 2:
 *
 * Input: envelopes = [[1,1],[1,1],[1,1]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= envelopes.length <= 105
 * envelopes[i].length == 2
 * 1 <= wi, hi <= 105
 */
package dp;

import java.util.Arrays;

public class RussianDollEnvelopes {

    int n;
    // int[][] env;
    // int[][] dp;

    public int maxEnvelopes(int[][] envelopes) {
        n = envelopes.length;
        // env = envelopes;
        // dp = new int[n][n];
        int longest = 1;
        Arrays.sort(envelopes, (a, b) -> {
            return a[0] - b[0];
        });

        // for (int[] row : dp) Arrays.fill(row, -1);
        int[] dp = new int[n];

        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (envelopes[i][0] > envelopes[j][0] &&
                        envelopes[i][1] > envelopes[j][1]) {

                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }

            longest = Math.max(longest, dp[i]);
        }

        System.out.println(Arrays.toString(dp));
        return longest;
        // return dfs(-1, 0);
    }

    // private int dfs(int prev, int curr) {
    //     if (curr >= n) return 0;

    //     if (dp[prev + 1][curr] != -1) return dp[prev + 1][curr];
    //     int skip = dfs(prev, curr + 1);

    //     int take = 0;
    //     if (prev == -1 || (env[prev][0] < env[curr][0] && env[prev][1] < env[curr][1])) {
    //         take = 1 + dfs (curr, curr + 1);
    //     }

    //     return dp[prev + 1][curr] = Math.max(skip, take);
    // }
}
