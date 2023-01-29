/**
 * Geek is very fond of patterns. Once, his teacher gave him a  pattern to solve. He gave Ram an integer n and asked him to build a pattern.
 *
 * Help Ram build a pattern.
 *
 *
 *
 * Example 1:
 *
 * Input: 5
 *
 * Output:
 *     *
 *    ***
 *   *****
 *  *******
 * *********
 * Your Task:
 * You don't need to input anything. Complete the function printTriangle() which takes  an integer n  as the input parameter and print the pattern.
 *
 * Constraints:
 *
 * 1<= N <= 20
 */
package Patterns;

public class Pattern7 {
    public static void main(String[] args) {
        int n = 5;
        solve(n);
    }
    public static void solve(int n) {
        for(int i = 1; i <= n; i++) {
            for(int l = i; l < n; l++)
                System.out.print(" ");
                for(int j = 1; j <= (2 * i) - 1; j++)
                    System.out.print("*");
            System.out.println();
        }
    }
}
