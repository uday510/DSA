/**
 * You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.
 *
 * Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.
 *
 *
 *
 * Example 1:
 *
 * Input: letters = ["c","f","j"], target = "a"
 * Output: "c"
 * Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
 */
package binarysearch;

public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'g';

        char ans = solve(letters, target);
        System.out.println(ans);
    }
    public static char solve(char[] letters, char target) {

        int i = 0, j = letters.length-1;
        char ans = '%';

        while (j >= i) {

            int mid = (i+j) / 2;
            if (letters[mid] > target) {
                ans = letters[mid];
                j = mid-1;
            } else {
                i = mid + 1;
            }
        }
        return ans == '%' ? letters[0] : ans;
    }
}
