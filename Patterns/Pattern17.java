/**
 * Geek is very fond of patterns. Once, his teacher gave him a pattern to solve. He gave Geek an integer n and asked him to build a pattern.
 *
 * Help Geek to build the pattern.
 *
 * Example 1:
 *
 * Input: 4
 * Output:
 *    A
 *   ABA
 *  ABCBA
 * ABCDCBA
 * Your Task:
 *
 * You don't need to input anything. Complete the function printTriangle() which takes an integer n  as the input parameter and prints the pattern.
 *
 * Constraints:
 *
 * 1<= N <= 20
 */
package Patterns;

public class Pattern17 {
    public static void main(String[] args) {
        int  i = 4;
        solve(i);
    }
    public static void solve(int num) {
        for(int i = 1; i <= num; i++) {
            for(int j = i; j < num; j++) {
                System.out.print(" ");
            }
            int ascii = 65;
            for(int k = num - i; k < num; k++) {
                System.out.print( (char) ascii++);
            }
            --ascii;
            for(int l = 1; l < i; l++) {
                System.out.print( (char) --ascii);
            }
            System.out.println();
        }
    }
}
