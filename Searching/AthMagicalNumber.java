/**
 * Problem Description
 * You are given three positive integers, A, B, and C.
 *
 * Any positive integer is magical if divisible by either B or C.
 *
 * Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 109
 *
 * 2 <= B, C <= 40000
 *
 *
 *
 * Input Format
 * The first argument given is an integer A.
 *
 * The second argument given is an integer B.
 *
 * The third argument given is an integer C.
 *
 *
 *
 * Output Format
 * Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 1
 *  B = 2
 *  C = 3
 * Input 2:
 *
 *  A = 4
 *  B = 2
 *  C = 3
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  6
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  1st magical number is 2.
 * Explanation 2:
 *
 *  First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
 */
package Searching;

public class AthMagicalNumber {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3;
        int ans = solve(a, b, c);
        System.out.println(ans);
    }
    public static int solve(int a, int b, int c) {
        // O(Log(a*min(b,c))) time | O(1) space

        int left = Math.min(b, c); // or simply min = 1
        int right = a * Math.min(b, c);
        int ans = 0;

        int lcm = getLcm(b, c);

        while (left <= right) {
            int middle = left + (right - left)/2;
            int count = getMagicalNumsCount(b, c, middle, lcm);
            System.out.println(left + " " + right + " " + middle +  " " + count );

            if (count == a) {
                ans = middle;
                right = middle - 1;
            } else if (count > a) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        } return ans;
    }
    public static int getLcm(int a, int b) {

        /**
         * lcm(a, b) * gcd(a, b) = a * b
         * lcm(a, b) = (a * b) / gcd(a, b)
         */

        int divisor = a;
        int divident = b;
        while (divident % divisor != 0) {
            int reminder = divident % divisor;
            divident = divisor;
            divisor = reminder;
        }
        int gcd = divisor;

        return (a * b) / gcd; // return lcm
    }
    public static int getMagicalNumsCount(int a, int b, int middle, int lcm) {

        return ( (middle/a) + (middle/b) - (middle/lcm) );
    }
}
