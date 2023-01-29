/**
 * Geek is very fond of patterns. Once, his teacher gave him a pattern to solve. He gave Geek an integer n and asked him to build a pattern.
 *
 * Help Geek to build the pattern.
 *
 *
 *
 * Example 1:
 *
 * Input: 4
 *
 * Output:
 * ****
 * *  *
 * *  *
 * ****
 *
 *
 * Your Task:
 *
 * You don't need to input anything. Complete the function printSquare() which takes  an integer n  as the input parameter and print the pattern.
 *
 * Constraints:
 *
 * 1<= N <= 20
 */
package Patterns;

public class Pattern21 {
    public static void main(String[] args) {
        int i = 4;
        solve(i);
    }
    public static void solve(int n) {

        int i, j;

        // This is upper half of pattern
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= (2 * n); j++) {

                // Left part of pattern
                if (i < j)
                    System.out.print(" ");
                else
                    System.out.print("*");

                // Right part of pattern
                if (i <= ((2 * n) - j))
                    System.out.print(" ");
                else
                    System.out.print("*");
            }

            System.out.println("");
        }

        // This is lower half of pattern
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= (2 * n); j++) {

                // Left part of pattern
                if (i > (n - j + 1))
                    System.out.print(" ");
                else
                    System.out.print("*");

                // Right part of pattern
                if ((i + n) > j)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }

            System.out.println("");
        }
    }
}
