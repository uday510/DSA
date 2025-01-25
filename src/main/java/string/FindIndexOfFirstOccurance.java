package string;

public class FindIndexOfFirstOccurance {
    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(findIndexOfFirstOccurance(haystack, needle));
    }
    public static int findIndexOfFirstOccurance(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        for (int i = 0; i < haystack.length(); ++i) {
            int j = 0;
            while (j < needle.length() && i + j < haystack.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                ++j;
            }
            if (j == needle.length()) return i;
        }
        return -1;
    }

}
