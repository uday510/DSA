/**
 * Problem Description
 * You are given two strings, A and B, of size N and M, respectively.
 *
 * You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.
 *
 *
 *
 * Problem Constraints
 * 1 <= N < M <= 105
 *
 *
 *
 * Input Format
 * Given two arguments, A and B of type String.
 *
 *
 *
 * Output Format
 * Return a single integer, i.e., number of permutations of A present in B as a substring.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "abc"
 *  B = "abcbacabc"
 * Input 2:
 *
 *  A = "aca"
 *  B = "acaa"
 *
 *
 * Example Output
 * Output 1:
 *
 *  5
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Permutations of A that are present in B as substring are:
 *     1. abc
 *     2. cba
 *     3. bac
 *     4. cab
 *     5. abc
 *     So ans is 5.
 * Explanation 2:
 *
 *  Permutations of A that are present in B as substring are:
 *     1. aca
 *     2. caa
 */
package Linear.Arrays;

public class PermutationsOfAInB {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abcbacabc";

        int ans = solve(a, b);
        System.out.println(ans);
    }
    public static int solve(String a, String b) {
        // O(N) time | O(N) space
        int count = 0;
        int n = a.length();
        int m = b.length();
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];

        //count frequency of each char in a
        for (int i = 0; i < n; i += 1) {
            hash1[a.charAt(i) - 'a'] += 1;
        }

        // count frequency of each pair in first window of size n in b
        for (int i = 0; i < n; i += 1) {
            hash2[b.charAt(i) - 'a'] += 1;
        }

        count += check(hash1, hash2);
        // move current window 1 step ahead
        for (int i = n, j = 0; i < m; i += 1, j += 1) {
            hash2[b.charAt(j) - 'a'] -= 1;
            hash1[b.charAt(i) - 'a'] += 1;
            count += check(hash1, hash2);
        }
        return count;
    }
    public static int check(int[] hash1, int[] hash2) {
        for (int i = 0; i < 26; i += 1) {
            if (hash1[i] != hash2[i]) {
                return 0; // not a permutation of a
            }
        }
        return 1; // got a permutation of A in b.
    }
}
