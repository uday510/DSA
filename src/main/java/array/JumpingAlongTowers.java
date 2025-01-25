/**
 * Problem Description
 * You are given a one-dimensional integer array A of size N denoting the heights of N towers labelled from 1 to N.
 *
 * You are initially standing at tower 1 and your goal is to reach tower N, you can perform two different kind of jumps:
 *
 * Jump from ith tower to (i+1)thtower and this will cost you B * | A[i+1] - A[i] | dollars.
 * Jump from ith tower to (i+2)thtower and this will cost you C * | A[i+2] - A[i] | dollars.
 * Find and return the minimum possible total cost incurred to reach the tower N.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 30
 *
 * 1 <= A[i] <= 100
 *
 * 1 <= B, C <= 100
 *
 *
 *
 * Input Format
 * First argument is an integer array A of size N.
 *
 * Second argument is an integer B.
 *
 * Third argument is an integer C.
 *
 *
 *
 * Output Format
 * Return an single integer denoting the minimum possible total cost incurred to reach the tower N.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3]
 *  B = 2
 *  C = 3
 * Input 2:
 *
 *  A = [10, 100]
 *  B = 20
 *  C = 30
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  1800
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The minimum total cost path looks like: Tower 1 -> Tower 2 -> Tower 3
 *  Which will cost B*|A[2]-A[1]| + B*|A[3]-A[2]| = 2*|2-1| + 2*|3-2| = 4
 * Explanation 2:
 *
 *  There is only one possible way to reach tower 2 i.e jump from 1 to 2 and it will cost B*|A[2]-A[1]| = 20*|100-10| = 1800
 */
package array;

public class JumpingAlongTowers {
    // https://www.scaler.com/test/9bed7bdf7b/#/problem_1
    public static void main(String[] args) {
        int[] a = {17, 19, 96};
        int b = 83;
        int c = 22;

        int ans = solve(a, b, c);
        System.out.println(ans);
    }
    public static int solve(int[] A, int B, int C) {

       int ans = minCost(A, 0, B, C);
       return ans;
    }
    public static int minCost(int[] array, int i, int b, int c) {
        if (i == array.length - 1) return 0;

        int temp1 = Integer.MAX_VALUE;
        int temp2 = Integer.MAX_VALUE;

        if (i + 1 < array.length) {
            temp1 = b * Math.abs(array[i+1] - array[i]) +
                                minCost(array, i + 1, b, c);
        }
        if (i + 2 < array.length) {
            temp2 = c * Math.abs(array[i+2] - array[i]) +
                                    minCost(array, i + 2, b, c);
        }
        return Math.min(temp1, temp2);
    }
}
