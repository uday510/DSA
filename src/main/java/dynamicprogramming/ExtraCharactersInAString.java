package dynamicprogramming;

public class ExtraCharactersInAString {
    public static void main(String[] args) {
        String s = "leetcode";
        String[] dictionary = { "leet", "code", "leetcode"};

        System.out.println(minExtraChar(s, dictionary));
    }
    public static int minExtraChar(String s, String[] dictionary) {
        int[] dp = new int[s.length() + 1];

        for (int i = s.length() - 1; i >= 0; --i) {
            dp[i] = s.length() - i; // Initialize to maximum possible extra characters

            for (String word : dictionary) {
                int len = word.length();
                if (i + len <= s.length() && s.substring(i, i + len).equals(word)) {
                    dp[i] = Math.min(dp[i], dp[i + len]);
                }
            }

            dp[i] = Math.min(dp[i], dp[i + 1] + 1); // Add 1 for the current character
        }

        return dp[0];
    }
}
