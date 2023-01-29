/**
 * Ram is very fond of patterns. Once, his teacher gave him a pattern to solve. He gave Ram an integer n and asked him to build a pattern.
 *
 * Help Ram build a  pattern.
 *
 *
 *
 * Example 1:
 *
 * Input: 5
 *
 * Output:
 * *        *
 * **      **
 * ***    ***
 * ****  ****
 * **********
 * ****  ****
 * ***    ***
 * **      **
 * *        *
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

public class Pattern20 {
    public static void main(String[] args) {

        int i = 5;
        solve(i);
    }
    public static void solve(int num) {
        for(int i = 1; i <= num; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for(int k = (num - i) * 2; k >= 1; k--) {
                System.out.print(" ");
            }
            for(int l = 1; l <= i; l++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = num - 1; i >= 1; i--) {
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for(int k = 2 * (num - i); k >= 1; k--) {
                System.out.print(" ");
            }
            for(int l = i; l >=1; l--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
