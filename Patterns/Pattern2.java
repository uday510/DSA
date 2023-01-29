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
 *     Output:
 *     *
 *     * *
 *     * * *
 *     * * * *
 *     * * * * *
 *
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

public class Pattern2 {
    public static void main(String[] args) {
        int n = 5;
//        solve(n);
          solve1(n);
    }
    public static void solve(int n) {
        String star = "*";
        int idx = 0;
        while(idx < n) {
            System.out.println(star);
            if(idx == n - 1) star += "*";
            else star += " *";
            idx++;
        }
    }
    public static void solve1(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                    System.out.print("* ");
            }
            System.out.println();
        }
    }
}
