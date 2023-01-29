/**
 * Geek is very fond of patterns. Once, his teacher gave him a pattern to solve. He gave Geek an integer n and asked him to build a pattern.
 *
 * Help Geek to build a star pattern.
 *
 *
 *
 * Example 1:
 *
 * Input: 5
 *
 * Output:
 * 1
 * 0 1
 * 1 0 1
 * 0 1 0 1
 * 1 0 1 0 1
 *
 *
 * Your Task:
 *
 * You don't need to input anything. Complete the function printTriangle() which takes  an integer n  as the input parameter and print the pattern.
 *
 * Constraints:
 *
 * 1<= N <= 20
 */

package Patterns;

public class Pattern11 {
    public static void main(String[] args) {
        int i = 5;
        solve(i);
    }
    public static void solve(int n) {
        for (int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                System.out.print( (i + j) % 2 + " ");
            }
            System.out.println();
        }
    }
}
