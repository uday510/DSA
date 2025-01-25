package string;

public class LongestStringChain {
    public static void main(String[] args) {
        String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};

        System.out.println(longestStrChain(words));
    }

    public static int longestStrChain(String[] words) {

        int n = words.length;
        int longest = 1;

        for (int i = 0; i < n; ++i) {
            String sequence = words[i];
            int len = 1;
            for (int j = i + 1; j < n; ++j) {
                if (isSubsequence(sequence, words[j])) {
                    sequence = words[j];
                    len++;
                }
            }
            longest = Math.max(longest, len);
        }
        return longest;
    }
    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}

