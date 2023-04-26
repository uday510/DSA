package Strings;

import java.util.Arrays;

public class KnuthMorrisPrattAlgorithm {
    public static void main(String[] args) {
        String string = "aefaefaefaedaefaedaefaefa";
        String substring = "aefaedaefaefa";

        Boolean ans = solve(string, substring);
        System.out.println(ans);
    }
    public static boolean solve (String string, String substring) {
        // O(N + M) time | O(M) space

        int[] pattern = buildPattern(substring);
        int i = 0; // string pointer
        int j = 0; // substring pointer

        while (i + substring.length() - j <= string.length()) { // or i < string.length()
            if (string.charAt(i) == substring.charAt(j)) {
                if (j == substring.length() - 1) // if j at last index,then match found return true
                    return true;
                i++;
                j++;
            } else if (j > 0) {
                j = pattern[j - 1] + 1; // go to last pattern match
            } else {
                i++; // increment only i
            }
        }
        return false;
    }
    public static int[] buildPattern(String substring) {
        int[] pattern = new int[substring.length()];
        Arrays.fill(pattern, -1); // fill with -1

        int j = 0; // prefix
        int i = 1; // suffix
        while (i < substring.length()) {
            if (substring.charAt(i) == substring.charAt(j)) {
                pattern[i] = j;
                i++;
                j++;
            } else if (j > 0) {
                 j = pattern[j - 1] + 1; // go to last matched pattern
            } else {
                i++; // increment i
            }
         }
        return pattern;
    }
}
