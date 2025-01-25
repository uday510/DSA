/**
 * Given three 2-digit integers, A, B, and C, find out the minimum number obtained by concatenating them in any order.
 *
 * Return the minimum result obtained.
 *
 *
 *
 * Problem Constraints
 * 10 <= A, B, C <= 99
 *
 *
 *
 * Input Format
 * The first argument of input contains an integer, A.
 *
 * The second argument of input contains an integer, B.
 *
 * The third argument of input contains an integer, C.
 *
 *
 *
 * Output Format
 * Return an integer representing the answer.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 10
 *  B = 20
 *  C = 30
 * Input 2:
 *
 *  A = 55
 *  B = 43
 *  C = 47
 *
 *
 * Example Output
 * Output 1:
 *
 *  102030
 * Output 2:
 *
 *  434755
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  10 + 20 + 30 = 102030
 * Explanation 2:
 *
 *  43 + 47 + 55 = 434755
 */

package math;

import java.util.Arrays;

public class ConcatenateThreeNumbers {
    public static void main(String[] args) {
        int num1 = 10, num2 = 20, num3 = 30;
        int res = solve(num1, num2, num3);

        System.out.println(res);
    }
    public static int solve (int num1, int num2, int num3) {

        int[] arr = {num1, num2, num3};

        Arrays.sort(arr);

        return 10000 * arr[0] + 100 * arr[1] + arr[2];

    }
}
