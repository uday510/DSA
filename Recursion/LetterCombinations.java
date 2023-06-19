/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 *
 * https://assets.leetcode.com/uploads/2022/03/15/1200px-telephone-keypad2svg.png
 *
 * The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.
 *
 * NOTE: Make sure the returned strings are lexicographically sorted.
 *
 * Problem Constraints
 * 1 <= |A| <= 10
 *
 *
 *
 * Input Format
 * The only argument is a digit string A.
 *
 *
 *
 * Output Format
 * Return a string array denoting the possible letter combinations.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "23"
 * Input 2:
 *
 *  A = "012"
 *
 *
 * Example Output
 * Output 1:
 *
 *  ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 * Output 2:
 *
 *  ["01a", "01b", "01c"]
 */
package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LetterCombinations {
    static Map<Character, String[]> DIGIT_LETTERS = new HashMap<>();
    static {
        DIGIT_LETTERS.put('0', new String[] {"0"});
        DIGIT_LETTERS.put('1', new String[] {"1"});
        DIGIT_LETTERS.put('2', new String[] {"a", "b", "c"});
        DIGIT_LETTERS.put('3', new String[] {"d", "e", "f"});
        DIGIT_LETTERS.put('4', new String[] {"g", "h", "i"});
        DIGIT_LETTERS.put('5', new String[] {"j", "k", "l"});
        DIGIT_LETTERS.put('6', new String[] {"m", "n", "o"});
        DIGIT_LETTERS.put('7', new String[] {"p", "q", "r", "s"});
        DIGIT_LETTERS.put('8', new String[] {"t", "u", "v"});
        DIGIT_LETTERS.put('9', new String[] {"w", "x", "y", "x"});
    }
    public static void main(String[] args) {
        String digits = "23";

        ArrayList<String> res = solve(digits);
        System.out.println(res);
    }
    public static ArrayList<String> solve(String digits) {
        // O(4^n * n) time | O(4^n * n) space

        String[] curr = new String[digits.length()];

        ArrayList<String> res = new ArrayList<>();
        helper(0, digits, curr, res);

        return res;
    }
    public static void helper(int i, String digits, String[] curr, ArrayList<String> res) {

        if (i == digits.length()) {
            String temp = String.join("", curr);
            res.add(temp);
            return;
        }
        char digit = digits.charAt(i);
        String[] digitLetters = DIGIT_LETTERS.get(digit);
        for (String letter : digitLetters) {
            curr[i] = letter;
            helper(i+1, digits, curr, res);
        }
    }
}
