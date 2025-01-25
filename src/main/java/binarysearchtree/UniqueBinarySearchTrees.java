/*
Given an integer n,
return the number of structurally unique BST's
(binary search trees) which has exactly n nodes of unique values from 1 to n.

Input: n = 3
Output: 5
Example 2:

Input: n = 1
Output: 1


Constraints:

1 <= n <= 19
 */
package binarysearchtree;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(numTrees(n));
    }
    public static int numTrees(int n) {

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;


        for (int i = 1; i <= n; ++i) {
            int sum = 0;
            for (int j = 1; j <= i; ++j) {
                sum += dp[j - 1] * dp[i - 1];
            }
            dp[i] = sum;
        }

        return dp[n];
    }

}
