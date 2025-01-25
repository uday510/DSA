/**
 * Problem Description
 * Given two integers A and B. Find the value of A-1 mod B where B is a prime number and gcd(A, B) = 1.
 *
 * A-1 mod B is also known as modular multiplicative inverse of A under modulo B.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 109
 * 1<= B <= 109
 * B is a prime number
 *
 *
 *
 * Input Format
 * First argument is an integer A.
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the modulor inverse
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 3
 *  B = 5
 * Input 2:
 *
 *  A = 6
 *  B = 23
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  4
 */
package math;

public class PrimeModuloInverse {
    public static void main(String[] args) {
        int a = 6, b = 13;

        int ans = solve(a, b);
        System.out.println(ans);
    }
    public static int solve(int A, int B) {

        // Modular inverse of A Modulo B = pow(A, B - 2, B)

        return (int) power(A, B - 2, B);

    }

    public static long power(long x, long y, long p) {
            long res = 1; // Initialize result
            x = x % p; // Update x if it is more than or equal to p
            while (y > 0) {
                // If y is odd, multiply x with result
                if ((y & 1) == (long) 1)
                    res = (res * x) % p;
                y = y >> 1;
                x = (x * x) % p;
            }
            return res;
    }
}
