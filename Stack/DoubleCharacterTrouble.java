/**
 * Problem Description
 * You are given a string A.
 *
 * An operation on the string is defined as follows:
 *
 * Remove the first occurrence of the same consecutive characters. eg for a string "abbcd", the first occurrence of same consecutive characters is "bb".
 *
 * Therefore the string after this operation will be "acd".
 *
 * Keep performing this operation on the string until there are no more occurrences of the same consecutive characters and return the final string.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 *
 *
 * Input Format
 * First and only argument is string A.
 *
 *
 *
 * Output Format
 * Return the final string.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = abccbc
 * Input 2:
 *
 *  A = ab
 *
 *
 * Example Output
 * Output 1:
 *
 *  "ac"
 * Output 2:
 *
 *  "ab"
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Remove the first occurrence of same consecutive characters. eg for a string "abbc",
 * the first occurrence of same consecutive characters is "bb".
 * Therefore the string after this operation will be "ac".
 * Explanation 2:
 *
 *  No removals are to be done.
 */
package Stack;

public class DoubleCharacterTrouble {
    // DAY: 59
    public static void main(String[] args) {
        String string = "abccbc";

        String ans = solve(string);
        System.out.println(ans);
    }
    public static String solve(String string) {
        // O(N) time | O(N) space
//        Stack<Character> stack = new Stack<>();
//
//        for (int i = string.length() - 1; i > -1; i--) {
//            char c = string.charAt(i);
//
//        if (stack.empty() || c != stack.peek()) {
//                stack.push(c);
//            } else {
//                stack.pop();
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//
//        while (!stack.empty()) {
//            sb.append(stack.pop());
//        }
//        return sb.toString();

        StringBuilder sb = new StringBuilder();
        int sbLength = 0;

        for (char c: string.toCharArray()) {
            if (sbLength != 0 && c == sb.charAt(sbLength - 1)) {
                sb.deleteCharAt(sbLength-- -1);
//                sbLength--;
            } else {
                sb.append(c);
                sbLength++;
            }
        }
        return sb.toString();

    }
    /**
     * public class Solution {
     *     public String solve(String A) {
     *         // we maintain a stack for the characters of the string
     *         Stack < Character > st = new Stack < Character > ();
     *         for (int i = 0; i < A.length(); i++) {
     *             // if the current character is equal to the top of the stack then they form
     *             // a pair of consecutive similar characters therefore we pop from the stack,
     *             // else we push the charcter in the stack
     *             if (!st.empty() && st.peek() == A.charAt(i)) {
     *                 st.pop();
     *             } else st.push(A.charAt(i));
     *         }
     *         StringBuilder sb = new StringBuilder();
     *         while (!st.empty()) {
     *             sb.append(st.peek());
     *             st.pop();
     *         }
     *         sb.reverse();
     *         return sb.toString();
     *     }
     * }
     */
}
