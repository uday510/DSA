package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;

public class ValidSubstrings {

    public static void main(String[] args) {
        System.out.println(validSubstrings("abaa"));
    }

    /**
     * This problem is about counting all valid contiguous substrings in a string (where the string only has letters 'a' to 'g').
     *
     * A substring is only valid if:
     *
     * For every character in that substring, each char's count does not exceed the total number of distinct characters in that substring.
     *
     * e.g. "abaa" only has "a", "b", "a", "a", "ab", "ba", "aba", "baa" so it returns 8.
     *
     * Only knows how to brute force it, is there any optimizations?

     */

    private static int validSubstrings(String str) {
        int len = str.length();
        int count = 0;

        for (int i = 0; i < len; ++i) {
            HashMap<Character, Integer> map = new HashMap<>();
            int distinctCount = 0;

            for (int j = i; j < len; ++j) {
                char ch = str.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (map.get(ch) == 1) {
                    distinctCount++;
                }

                if (map.get(ch) > distinctCount) {
                    break;
                }

                count++;
            }
        }

        return count;
    }

    public static int numberOfSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); ++i) {
            var map = new HashMap<Character, Integer>();
            for (int j = i; j < s.length(); ++j) {
                char ch = s.charAt(j);
                map.merge(ch, 1, Integer::sum);
                if (map.size() == 3) count++;
            }
        }

        return count;
    }
}
