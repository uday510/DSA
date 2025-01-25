package slidingwindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/length-of-the-longest-valid-substring/description/
public class LengthOfLongestValidSubstring {
    public static void main(String[] args) {
        String word = "cbaaaabc";

       List<String> forbidden = new ArrayList<>(List.of("aaa", "cb"));

        System.out.println(longestValidSubstring(word, forbidden));
    }
    public static int longestValidSubstring(String word, List<String> forbidden) {
        int N = word.length();
        int longest = 1;
        HashSet<String> invalid = new HashSet<>(forbidden);
        int right = N - 1;

        for (int i = N-1; i > -1; --i) {
            for (int j = i; j <= Math.min(i+10, right); ++j) {
                String tmp = word.substring(i, j);
                if (invalid.contains(tmp)) {
                    right = j-1;
                }
            }
            longest = Math.max(longest, right - i + 1);
        }
        return longest;
    }
}
