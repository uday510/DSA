package dynamicprogramming;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int longest = 0;

        for (int i = 1; i < n; ++i) {
            if (s.charAt(i) == '(') continue;

            if (s.charAt(i - 1) == '(') {
                dp[i] = (i - 1 > 0 ? dp[i - 2] : 0) + 2;
            } else {
                if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] - 1 > 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }

            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }
}



/**

i       0   1   2   3   4   5
char    )   (   (   (   )   )
dp      0   0   0   0   2   4

 */