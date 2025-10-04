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
package backtracking;

import java.util.*;

public class LetterCombinations {
//    static Map<Character, String[]> DIGIT_LETTERS = new HashMap<>();
//    static ArrayList<String> res = new ArrayList<>();
//    static {
//        DIGIT_LETTERS.put('0', new String[] {"0"});
//        DIGIT_LETTERS.put('1', new String[] {"1"});
//        DIGIT_LETTERS.put('2', new String[] {"a", "b", "c"});
//        DIGIT_LETTERS.put('3', new String[] {"d", "e", "f"});
//        DIGIT_LETTERS.put('4', new String[] {"g", "h", "i"});
//        DIGIT_LETTERS.put('5', new String[] {"j", "k", "l"});
//        DIGIT_LETTERS.put('6', new String[] {"m", "n", "o"});
//        DIGIT_LETTERS.put('7', new String[] {"p", "q", "r", "s"});
//        DIGIT_LETTERS.put('8', new String[] {"t", "u", "v"});
//        DIGIT_LETTERS.put('9', new String[] {"w", "x", "y", "x"});
//    }
//    public static void main(String[] args) {
//        String digits = "23";
//        dfs(0, digits, new StringBuilder());
//        System.out.println(res);
//    }
//    public static void dfs(int i, String digits, StringBuilder sb) {
//        if (i == digits.length()) {
//            res.add(sb.toString());
//            return;
//        }
//
//        char digit = digits.charAt(i);
//
//        String[] digitLetters = DIGIT_LETTERS.get(digit);
//
//        for (String letter : digitLetters) {
//            sb.append(letter);
//            dfs(i+1, digits, sb);
//            sb.deleteCharAt(sb.length()-1);
//        }
//    }
//    public static ArrayList<String> solve(String digits) {
//        // O(4^n * n) time | O(4^n * n) space
//
////        String[] curr = new String[digits.length()];
//
//        ArrayList<String> res = new ArrayList<>();
////        helper(0, digits, curr, res);
//        // solve using iterative approach
//
//        Stack<Character> stack = new Stack<>();
//
//        for (char digit : digits.toCharArray()) { // add all digits to stack
//            stack.push(digit);
//        }
//
//
//        while (!stack.isEmpty()) {
//            char digit = stack.pop();
//            String[] digitLetters = DIGIT_LETTERS.get(digit);
//
//            if (res.size() == 0) {
//                res.addAll(Arrays.asList(digitLetters)); // add all letters of first digit to res
//                continue;
//            }
//
//            ArrayList<String> temp = new ArrayList<>();
//            for (String letter: digitLetters) {
//                for (String str : res) { // add all letters of current digit to all strings in res
//                    temp.add(letter + str); // add to temp
//                }
//            }
//            res = temp; // update res
//        }
//
//        return res;
//    }
//    public static void helper(int i, String digits, String[] curr, ArrayList<String> res) {
//
//        if (i == digits.length()) {
//            String temp = String.join("", curr);
//            res.add(temp);
//            return;
//        }
//        char digit = digits.charAt(i);
//        String[] digitLetters = DIGIT_LETTERS.get(digit);
//        for (String letter : digitLetters) {
//            curr[i] = letter;
//            helper(i+1, digits, curr, res);
//        }
//    }

static Map<Character, char[]> map = new HashMap<>();
    static {
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});
    }
    List<String> res;
    String digits;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        this.digits = digits;

        dfs(0, new StringBuilder());
        return res;
    }

    private void dfs(int i, StringBuilder sb) {
        if (i >= digits.length()) {
            if (!sb.isEmpty()) res.add(sb.toString());
            return;
        }

        for (char ch : map.get(digits.charAt(i))) {
            sb.append(ch);
            dfs(i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
