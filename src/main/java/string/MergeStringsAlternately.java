package string;

public class MergeStringsAlternately {

    public static void main(String[] args) {
    }

    public static String mergeAlternately(String word1, String word2) {
        final StringBuilder merged = new StringBuilder();
        int i = 0, j = 0;
        final int n = word1.length(), m = word2.length();

        while (i < n || j < m) {
            if (i < n) merged.append(word1.charAt(i++));
            if (j < m) merged.append(word2.charAt(j++));
        }

        return merged.toString();
    }
}
