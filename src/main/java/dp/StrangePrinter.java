/*
There is a strange printer with the following two special properties:

The printer can only print a sequence of the same character each time.
At each turn, the printer can print new characters starting from and ending at any place and will cover the original existing characters.
Given a string s, return the minimum number of turns the printer needed to print it.



Example 1:

Input: s = "aaabbb"
Output: 2
Explanation: Print "aaa" first and then print "bbb".
Example 2:

Input: s = "aba"
Output: 2
Explanation: Print "aaa" first and then print "b" from the second place of the string, which will cover the existing character 'a'.


Constraints:

1 <= s.length <= 100
s consists of lowercase English letters.
 */
package dp;

public class StrangePrinter {
    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaa";
        s = removeDuplicates(s);
        System.out.println(strangePrinter(s));
    }
    public static int strangePrinter(String s) {

         return strangePrinter(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
    }
    public static int strangePrinter(String s, int i, int j, Integer[][]dp) {

        if(i > j) return 0; // base case

        if (i == j) return 1; // base case

       if (dp[i][j] != null) return dp[i][j];

        // worst case scenario, we print one character at a time
       int minPrints = strangePrinter(s, i + 1, j, dp) + 1; // why +1? because we are printing one character at a time

        // we try to find a better solution by trying to print
        // two characters at a time, or more if possible
        int k = i + 1;
        while (k <= j) {
            // if we find a character that is the same as the first character,
            // we can print it at the same time as the first character,
            // so we can print two characters at a time,
            // which is better than printing one character at a time

            if(s.charAt(i) == s.charAt(k)) {

                minPrints = Math.min(minPrints,
                                strangePrinter(s, i, k - 1, dp) +
                                strangePrinter(s, k + 1, j, dp));

                // why two recursive calls?
                // because we can print the first character and the character at k at the same time,
                // so we need to find the minimum number of turns to print the substring from i to k-1 and
                // the substring from k+1 to j

            }
           ++k;
        }

        dp[i][j] = minPrints;

        return minPrints;
    }
    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for (int i  = 0; i < n;) {
            char c = s.charAt(i);
            sb.append(c);

            int j = i + 1;
            while (j < n && s.charAt(j) == c) {
                ++j;
            }
            i = j;
        }
        return sb.toString();
    }
}
