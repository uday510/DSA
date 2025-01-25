/**
 * You are given a number A in the form of a string. Check if the number is divisible by eight or not.
 *
 * Return 1 if it is divisible by eight else, return 0.
 *
 *
 * Problem Constraints
 * 1 <= length of the String <= 100000
 * '0' <= A[i] <= '9'
 *
 *
 * Input Format
 * The only argument given is a string A.
 *
 *
 * Output Format
 * Return 1 if it is divisible by eight else return 0.
 *
 *
 * Example Input
 * Input 1:
 * A = "16"
 * Input 2:
 *
 * A = "123"
 *
 *
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *  16 = 8 * 2
 * Explanation 2:
 *
 * 123 = 15 * 8 + 3
 */

package math;

public class DivisibilityBy8 {
    public static void main(String[] args) {
        String str = "1234";

        int res = solve(str);

        System.out.println(res);
    }

    public static int solve(String str) {
        int len = str.length();

        if (len == 1) {
            if ( (str.charAt(0) - '0') %  8  == 0) return 1;
            return 0;
        }
        if (len == 2) {
            int num = (str.charAt(0) - '0') * 10 + (str.charAt(1) - '0');
            if ( (num % 8) == 0) return 1;
            return 0;
        }
        int num = (str.charAt(len - 3) - '0') * 100 + (str.charAt(len - 2) - '0') * 10 + (str.charAt(len - 1) - '0');
        if (num % 8 == 0) return 1;

        return 0;
    }
}
