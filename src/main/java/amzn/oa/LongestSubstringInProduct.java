package amzn.oa;

public class LongestSubstringInProduct {

    public static void main(String[] args) {
        String s = "ecbdca";

        System.out.println(maxSubstringLength(s));
    }

    private static int maxSubstringLength(String s) {
        int len = s.length();
        int longest = 0;
        int minIndex = 0;

        for (int idx = 0; idx < len; ++idx) {
            if (s.charAt(minIndex) < s.charAt(idx)) {
                longest = Math.max(longest, idx - minIndex + 1);
            }

            if (s.charAt(idx) < s.charAt(minIndex)) {
                minIndex = idx;
            }
        }

        return longest > 1 ? longest : 0;
    }
}
