/**
 * Geek is very fond of patterns. Once, his teacher gave him a square pattern to solve. He gave Geek an integer n and asked him to build a pattern.
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
 * 4 4 4 4 4 4 4
 * 4 3 3 3 3 3 4
 * 4 3 2 2 2 3 4
 * 4 3 2 1 2 3 4
 * 4 3 2 2 2 3 4
 * 4 3 3 3 3 3 4
 * 4 4 4 4 4 4 4
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

public class Pattern22 {
    public static void main(String[] args) {
        int i = 4;
        solve(i);
    }
    public static void solve(int num) {
        for (int i = 1; i < 2 * num; i++) {
            System.out.print("0 ");
        }
        System.out.println();
///
        int n = 2 * num - 2;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 2 * num; j++) {
                System.out.print("1 ");
            }
            System.out.println();
        }

        ///
        for (int i = 1; i < 2 * num; i++) {
            System.out.print("0 ");
        }
        }
    }
