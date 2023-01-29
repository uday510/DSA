/**
 * Geek is very fond of patterns. Once, his teacher gave him a pattern to solve. He gave Geek an integer n and asked him to build a pattern.
 *
 * Help Geek to build the pattern.
 *
 *
 *
 * Example 1:
 *
 * Input: 5
 *
 * Output:
 * 1                 1
 * 1 2             2 1
 * 1 2 3         3 2 1
 * 1 2 3 4     4 3 2 1
 * 1 2 3 4 5 5 4 3 2 1
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

public class Pattern12 {
    public static void main(String[] args) {
        int n = 4;
        solve(n);
    }
    public static void solve(int n) {

       for(int i = 1; i <= n; i++) {
           for(int j = 1; j <= i; j++) System.out.print(j);
           for(int k = 2 * (n - i); k > 0; k--) System.out.print(" ");
           for(int l = i; l >= 1; l--) System.out.print(l);
           System.out.println();
       }
    }
}
