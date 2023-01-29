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
 * A
 * BB
 * CCC
 * DDDD
 * EEEEE
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

public class Pattern16 {
    public static void main(String[] args) {
        int i = 5;
        solve(i);
    }
    public static void solve(int num) {
        for(int i = 1; i <= num; i++) {
            int ascii = 64 + i;
            for(int j = 1; j <= i; j++) {
                System.out.print( (char) ascii + " ");
            }
            System.out.println();
        }

    }
}
