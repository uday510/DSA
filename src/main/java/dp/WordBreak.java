package dp;

import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String s = "cars";
        List<String> wordDict = List.of("car","ca","rs");
        WordBreak wb = new WordBreak();
        System.out.println(wb.wordBreak(s, wordDict));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true; // wordBreak for empty string is true

        for (int i = s.length() - 1; i > -1; --i) {

            for (String word : wordDict) {

                if (i + word.length() <= s.length() && s.substring(i, i + word.length()).equals(word)) {
                    dp[i] = dp[i + word.length()]; // dp[i] = dp[i + word.length()] || dp[i] --> dp[i] = dp[i + word.length()]
                    // why here not break ? because we need to check all words in wordDict to see if dp[i] is true or not
                }

                if (dp[i]) {
                    break; // why ? because if dp[i] is true, then we don't need to check other words in wordDict
                }
            }
        }
        return dp[0];

//        Set<String> wordDictSet = Set.copyOf(wordDict);
//        Boolean[] dp = new Boolean[s.length() + 1];
//
//        dp[0] = true; // wordBreak for empty string is true
//
//        for (int i = 1; i <= s.length();) {
//            for (int j = 0; j < i; ++j) {
//                if (dp[j] &&
//                        wordDictSet.contains(s.substring(j, i))) {
//                    dp[i] = true;
//                    break;
//                }
//
//            }
//            ++i;
//        }
//       return dp[s.length()];
    }

    public static boolean wordDict(String s, Set<String> wordDict, int start, Boolean[] dp) {
        // O(n^3) time and O(n) space complexity
        // 1.n for recursion, 2.n for for-loop, 3.n for substring --> total O(n^3) time

        if (start == s.length()) {
            return true;
        }

        if (dp[start] != null) {
            return dp[start];
        }

        for (int end = start + 1; end <= s.length(); ++end) {

            if (wordDict.contains(s.substring(start, end)) && wordDict(s, wordDict, end, dp)) {
                return dp[start] = true;
            }
        }
        return dp[start] = false;
    }
}
