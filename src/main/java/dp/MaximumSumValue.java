/**
 * Problem Description
 *
 * You are given an array A of N integers and three integers B, C, and D.
 *
 * You have to find the maximum value of A[i]*B + A[j]*C + A[k]*D, where 1 <= i <= j <= k <= N.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 105
 *
 * -10000 <= A[i], B, C, D <= 10000
 *
 *
 *
 * Input Format
 *
 * First argument is an array A
 * Second argument is an integer B
 * Third argument is an integer C
 * Fourth argument is an integer D
 *
 *
 *
 * Output Format
 *
 * Return an Integer S, i.e maximum value of (A[i] * B + A[j] * C + A[k] * D), where 1 <= i <= j <= k <= N.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 5, -3, 4, -2]
 *  B = 2
 *  C = 1
 *  D = -1
 * Input 2:
 *
 *  A = [3, 2, 1]
 *  B = 1
 *  C = -10
 *  D = 3
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  18
 * Output 2:
 *
 *  -4
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  If you choose i = 2, j = 2, and k = 3 then we will get
 *  A[2]*B + A[2]*C + A[3]*D = 5*2 + 5*1 + (-3)*(-1) = 10 + 5 + 3 = 18
 * Explanation 2:
 *
 *  If you choose i = 1, j = 3, and k = 3 then we will get
 *  A[1]*B + A[3]*C + A[3]*D = (3*1) + (-10*1) + (3*1) = 3 - 10 + 3 = -4
 */
package dp;

public class MaximumSumValue {
    public static void main(String[] args) {
        int[] array = {1, 5, -3, 4, -2};

        int ans = solve(array, 2, 1, -1);
        System.out.println(ans);
    }
    public static int solve(int[] A, int B, int C, int D) {
        int n = A.length;
        int[] prefixB = new int[n];
        prefixB[0] = A[0]*B;
        int temp = prefixB[0];

        for (int i = 1; i < n; ++i) {
            temp = Math.max(temp, A[i]*B);
            prefixB[i] = temp;
        }

        int[] prefixD = new int[n];
        prefixD[0] = A[0]*D;
        temp = prefixD[0];
        for (int i = n - 1; i > -1; --i) {
            temp = Math.max(temp, A[i]*D);
            prefixD[i] = temp;
        }

        int res = -(int) 1e9;
        for (int i = 0; i < n; ++i) {
            res = Math.max(res, prefixB[i]+ A[i]*C + prefixD[i]);
        }
        return res;
    }
    public static int bruteForce(int[] A, int B, int C, int D) {
        int res = -(int) 1e9;
        int n = A.length;

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                for (int k = j; k < n; ++k) {
                    res = Math.max(res, A[i]*B + A[j]*C + A[k]*D);
                }
            }
        }
        return res;
    }
}
