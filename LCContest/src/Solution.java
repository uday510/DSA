class Solution {

    public static void main(String[] args) {
        String s = "100011001";
        int k = 3;

        System.out.println(shortestBeautifulSubstring(s, k));
    }
    public static String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        String result = "";
        int minLength = n + 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String substring = s.substring(i, j + 1);
                int onesCount = countOnes(substring);
                if (onesCount == k && substring.length() < minLength) {
                    result = substring;
                    minLength = substring.length();
                }
            }
        }
        return result;
    }
    private static int countOnes(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}