/*
There are two types of soup: type A and type B. Initially, we have n ml of each type of soup. There are four kinds of operations:

Serve 100 ml of soup A and 0 ml of soup B,
Serve 75 ml of soup A and 25 ml of soup B,
Serve 50 ml of soup A and 50 ml of soup B, and
Serve 25 ml of soup A and 75 ml of soup B.
When we serve some soup, we give it to someone, and we no longer have it. Each turn, we will choose from the four operations with an equal probability 0.25. If the remaining volume of soup is not enough to complete the operation, we will serve as much as possible. We stop once we no longer have some quantity of both types of soup.

Note that we do not have an operation where all 100 ml's of soup B are used first.

Return the probability that soup A will be empty first, plus half the probability that A and B become empty at the same time. Answers within 10-5 of the actual answer will be accepted.



Example 1:

Input: n = 50
Output: 0.62500
Explanation: If we choose the first two operations, A will become empty first.
For the third operation, A and B will become empty at the same time.
For the fourth operation, B will become empty first.
So the total probability of A becoming empty first plus half the probability that A and B become empty at the same time, is 0.25 * (1 + 1 + 0.5 + 0) = 0.625.
Example 2:

Input: n = 100
Output: 0.71875


Constraints:

0 <= n <= 109
 */
package dp;

public class SoupServings {
    public static void main(String[] args) {
        System.out.println(soupServings(50));
    }
    public static double soupServings(int n) {
        if(n >= 5000) return 1.0; // if n is too large, the probability is almost 1 because the probability of A becoming empty first is almost 1
//        return soupServings(n, n, new Double[n+1][n+1]);

        return soupServings(n, n, new Double[n + 1][n + 1]);
    }
    public static double soupServings(int i, int j, Double[][] dp) {
        if(i <= 0 && j <= 0) return 0.5; // if both i and j are empty, return 0.5 because the probability of A and B becoming empty at the same time is 0.5
        if(i <= 0) return 1; // if i is empty, return 1 because the probability of A becoming empty first is 1
        if(j <= 0) return 0; // if j is empty, return 0 because the probability of A becoming empty first is 0
        if(dp[i][j] != null) return dp[i][j]; // if dp[i][j] is not null, return dp[i][j]

        dp[i][j] = 0.25 * (soupServings(i-100, j, dp) + // probability of serving 100 ml of soup A and 0 ml of soup B (i.e. serving 100 ml of soup A)
                           soupServings(i-75, j-25, dp) + // probability of serving 75 ml of soup A and 25 ml of soup B (i.e. serving 100 ml of soup B)
                           soupServings(i-50, j-50, dp) + // probability of serving 50 ml of soup A and 50 ml of soup B (i.e. serving 100 ml of soup A and 100 ml of soup B)
                           soupServings(i-25, j-75, dp)); // probability of serving 25 ml of soup A and 75 ml of soup B (i.e. serving 100 ml of soup B)

        return dp[i][j]; // return dp[i][j]
    }


}
