/**
 * Problem Description
 * You are in a chocolate shop that sells N number of different chocolates.
 * You are given that the price of each chocolate is B[i] and the sweetness of each chocolate is C[i].
 *
 * You have decided that the total price of your purchases will be atmost A.
 * You can buy each chocolate at most once.
 * What is the maximum sweetness we can get using atmost A rupees?
 * Please read the examples given below carefully to better understand the problem
 *
 *
 * Problem Constraints
 * 1 <= N <= 103
 *
 * 1 <= A <= 105
 *
 * 1 <= B[i] <= 103
 *
 * 1 <= C[i] <= 103
 *
 *
 * Input Format
 * First argument A is an integer.
 *
 * Second argument B is an array of integers denoting the price of each chocolate.
 *
 * Third argument C is an array of integers denoting the sweetness of each chocolate.
 *
 *
 * Output Format
 * Return an integer denoting the maximum amount of sweetness.
 *
 *
 * Example Input
 * Input 1:
 *
 *
 * A = 10
 * B = [4, 8, 5, 3]
 * C = [5, 12, 8, 1]
 *
 *
 * Input 2:
 *
 *
 * A = 4
 * B = [4, 5, 1]
 * C = [1, 2, 3]
 *
 *
 * Example Output
 * Output 1:
 *
 *
 * 13
 *
 *
 * Output 2:
 *
 *
 * 3
 *
 *
 * Example Explanation
 * Example 1:
 *
 *
 * You can buy two chocolates whose sum of their prices are less than 10.
 * For the maximum possible sweetness by chocolates 1 and 3 whose total price is 4+5 which is less that 10
 * The sweetness obatined is 5+8 = 13
 * Example 2:
 *
 *
 * Here are two chocolates which have price less than or equal to 4.
 * If we select the chocolate with cost 4, the possible sweetness is 1. And if we select the chocolate with cost 1, the possible sweetness is 3.
 * So the maximum possible sweetness is 3
 */
package Graph;

public class dummy2 {
    public static void main(String[] args) {
        int A = 4;
        int[] B = {4, 5, 1};
        int[] C = {1, 2, 3};

        System.out.println(solve(A, B, C));
    }
    public static int solve(int A, int[] B, int[] C) {
//        int[][] dp = new int[B.length+1][A+1];
//        for(int i=1; i<=B.length; i++) {
//            for(int j=1; j<=A; j++) {
//                if(B[i-1] <= j) {
//                    dp[i][j] = Math.max(dp[i-1][j], C[i-1] + dp[i-1][j-B[i-1]]);
//                } else {
//                    dp[i][j] = dp[i-1][j];
//                }
//            }
//        }
//        return dp[B.length][A];

        int[] dp = new int[A+1];
        for(int i=0; i<B.length; i++) {
            for(int j=A; j>=B[i]; j--) {
                dp[j] = Math.max(dp[j], C[i] + dp[j-B[i]]);
            }
        }
        return dp[A];
    }
}
