package string;

public class Test {
    public static void main(String[] args) {
        String s = "babad";

        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {

        int maxLen = 0;
        String longestPalindrome = "";
        int N = s.length();

        for (int i = 0; i < N; ++i) {
            for (int j = i; j < N; ++j) {
                StringBuilder sb = new StringBuilder();
                for (int k = i; k <= j; ++k) {
                    sb.append(s.charAt(k));
                }

                if (isPalindrome(sb.toString())) {
                    if (sb.length() > maxLen) {
                        longestPalindrome = sb.toString();
                        maxLen = sb.length();
                    }
                }
            }
        }
        return longestPalindrome;
    }
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            ++i;
            --j;
        }
        return true;
    }
}
