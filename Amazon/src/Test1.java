import java.util.Arrays;

/*
Amazon is working on a new hashing approach that takes in the original string and a seed number.
Engineers decided that the seed can be generated from the same input string by counting the number of times a reverse of a substring of length k makes the new string lexicographically smaller. You are deployed with the task of developing a service that takes in a string s and an integer k, and returns the number of ways to reverse any substring of length k such that the resulting string is lexicographically smaller than the original string.
Notes:
• A substring is a contiguous sequence of characters within a string. For example, the string "zon" is a substring of "amazon",
"zone", etc. but is not a substring of "zoin", "zozo", etc.
• A string a is lexicographically smaller than string b if a[i] < b[i] at the first index where a and b differ. For example,
"amazon" is
lexicographically smaller than "amozan".
Example
S = "amazon"
k=3
 */
public class Test1 {
    public static void main(String[] args) {
        String s = "amazon";
        solve(s, 3);
    }
    public static void solve(String s, int k) {
        for (int i = 0; i < s.length()-k+1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i+k; ++j) {
                sb.append(s.charAt(j));
            }
            if (isValid(0, sb.length() - 1, sb)) {
                System.out.println("valid");
            }
        }
    }

    public static boolean isValid(int i, int j, StringBuilder s) {
        while (i < j) {
            if (s.charAt(i) <= s.charAt(j)) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }

}
