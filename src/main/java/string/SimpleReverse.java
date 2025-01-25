/**
 * Given a string A, you are asked to reverse the string and return the reversed string.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 105
 *
 * String A consist only of lowercase characters.
 *
 *
 *
 * Input Format
 * First and only argument is a string A.
 *
 *
 *
 * Output Format
 * Return a string denoting the reversed string.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "scaler"
 * Input 2:
 *
 *  A = "academy"
 *
 *
 * Example Output
 * Output 1:
 *
 *  "relacs"
 * Output 2:
 *
 *  "ymedaca"
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Reverse the given string.
 */

package string;

public class SimpleReverse {

    public static void main(String[] args) {
        String string = "maang";

        String res = solve(string);

        System.out.println(res);
    }
    public static String solve(String string) {
        StringBuilder res = new StringBuilder();
        int len = string.length() - 1;

        while (len > -1) {
            char currentChar = string.charAt(len--);
            res.append(currentChar);
        }
        return String.valueOf(res);
    }
}
