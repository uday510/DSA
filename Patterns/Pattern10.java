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
 * *
 * * *
 * * * *
 * * * * *
 * * * * * *
 * * * * *
 * * * *
 * * *
 * *
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

public class Pattern10 {

    public static void main(String[] args) {
        int i = 10;
        solve(i);
    }
    public static void solve(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                if(j == i)
                    System.out.print("*");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
        for(int i = n - 1; i > -1; i--) {
            for(int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

