/**
 * roblem Description
 * Given a string A, partition A such that every string of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of A.
 *
 * Ordering the results in the answer : Entry i will come before Entry j if :
 * len(Entryi[0]) < len(Entryj[0]) OR
 * (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR * * *
 * (len(Entryi[0]) == len(Entryj[0]) AND ... len(Entryi[k] < len(Entryj[k]))
 *
 *
 * Problem Constraints
 * 1 <= len(A) <= 15
 *
 *
 *
 * Input Format
 * First argument is a string A of lowercase characters.
 *
 *
 *
 * Output Format
 * Return a list of all possible palindrome partitioning of s.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = "aab"
 * Input 2:
 *
 * A = "a"
 *
 *
 * Example Output
 * Output 1:
 *
 *  [
 *     ["a","a","b"]
 *     ["aa","b"],
 *   ]
 * Output 2:
 *
 *  [
 *     ["a"]
 *   ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * In the given example, ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa").
 * Explanation 2:
 *
 * In the given example, only partition possible is "a" .
 */
package binarysearch;

import java.util.ArrayList;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";

        ArrayList<ArrayList<String>> res = solve(s);
        System.out.println(res);
    }
    public static ArrayList<ArrayList<String>> solve(String s) {


        ArrayList<ArrayList<String>> res = new ArrayList<>();

        partition(s, 0, new ArrayList<>(), res);
        return res;
    }
    public static void partition(String s, int index, ArrayList<String> temp, ArrayList<ArrayList<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); ++i) {
            String substring = s.substring(index, i+1);
            if (isPalindrome(substring)) {
                temp.add(substring);
                partition(s, i + 1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
