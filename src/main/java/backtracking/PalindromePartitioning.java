/**
 * Given a string s, partition s such that every
 * substring
 *  of the partition is a
 * palindrome
 * . Return all possible palindrome partitioning of s.
 */
package backtracking;

import java.util.ArrayList;

public class PalindromePartitioning {
    public static void main(String[] args) {

    }
    public static void partition(String s, int index, ArrayList<String> temp,
                          ArrayList<ArrayList<String>> res) {

        if (index == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < s.length(); ++i) {
            String substring = s.substring(index, i + 1);
            if (isPalindrome(substring)) {
                temp.add(substring);
                partition(s, i + 1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public static boolean isPalindrome(String s) {
        int i = 0; int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
