/**
 * Find the number of occurrences of bob in string A consisting of lowercase English alphabets.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 1000
 *
 *
 * Input Format
 * The first and only argument contains the string A, consisting of lowercase English alphabets.
 *
 *
 * Output Format
 * Return an integer containing the answer.
 *
 *
 * Example Input
 * Input 1:
 *
 *   "abobc"
 * Input 2:
 *
 *   "bobob"
 *
 *
 * Example Output
 * Output 1:
 *
 *   1
 * Output 2:
 *
 *   2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *   The only occurrence is at second position.
 * Explanation 2:
 *
 *   Bob occures at first and third position.
 */

package Strings;

public class CountOccurrences {
    public static void main(String[] args) {
        String string = "bobobo";

        int res = solve(string);
        System.out.println(res);
    }
    public static int solve(String string) {
        int countB = 0, countO = 0;

        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if (currentChar == 'b') countB++;
            if (currentChar == 'o') countO++;
        }

        System.out.println(countB);
        System.out.println(countO);
        return  (countB + countO) / 2;
    }
}
