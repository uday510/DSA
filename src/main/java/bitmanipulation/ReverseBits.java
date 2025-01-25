/**
 * Problem Description
 * Reverse the bits of an 32 bit unsigned integer A.
 *
 *
 *
 * Problem Constraints
 * 0 <= A <= 232
 *
 *
 *
 * Input Format
 * First and only argument of input contains an integer A.
 *
 *
 *
 * Output Format
 * Return a single unsigned integer denoting the decimal value of reversed bits.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  0
 * Input 2:
 *
 *  3
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  3221225472
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *         00000000000000000000000000000000
 * =>      00000000000000000000000000000000
 * Explanation 2:
 *
 *         00000000000000000000000000000011
 * =>      11000000000000000000000000000000
 */

package bitmanipulation;

public class ReverseBits {
    public static void main(String[] args) {
         long num = 3;
         long res = solve(num);
         System.out.println(res);
    }
    public static long solve(long A) {
        long rev = 0;

        for (int i = 0; i < 32; i++) {

            if ((A & (1 << i)) != 0) { // check bit
                // if bit is set, then set at the position
                rev = rev | (1L << 31 - i);
            }
        }
        return rev;
        /**
         * long rev = 0;
         *
         * 	    for (int i = 0; i < 32; i++) {
         * 	        rev <<= 1;
         * 	        if ((A & (1 << i)) != 0)
         * 	            rev |= 1;
         *                }
         *
         * 	    return rev;
         */
    }
}
