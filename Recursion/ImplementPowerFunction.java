/**
 * Problem Description
 * Implement pow(A, B) % C.
 * In other words, given A, B and C, Find (AB % C).
 *
 * Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.
 *
 *
 *
 * Problem Constraints
 * -109 <= A <= 109
 * 0 <= B <= 109
 * 1 <= C <= 109
 *
 *
 * Input Format
 * Given three integers A, B, C.
 *
 *
 * Output Format
 * Return an integer.
 *
 *
 * Example Input
 * A = 2, B = 3, C = 3
 *
 *
 * Example Output
 * 2
 *
 *
 * Example Explanation
 * 23 % 3 = 8 % 3 = 2
 */
package Recursion;

public class ImplementPowerFunction {
    public static void main(String[] args) {
        int a = 2, b = 3, c = 3;

        int res = solve(a, b, c);
        System.out.println(res);
    }
    public static int solve(int a, int n, int c) {
        // O(Log(N) time | Log(N) space
        if (a == 0) return 0;
        if (n == 0) return 1;
        long ans = solve(a, n/2, c);
        ans = (ans * ans) % c;
        if(n%2 == 1)
            ans = (ans * a);
        ans = (ans + c)%c;
        return (int) ans;
    }
}
