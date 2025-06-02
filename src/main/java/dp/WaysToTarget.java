package dp;

public class WaysToTarget {

    final int MOD = 1000000007;

    int waysToTarget(Integer[][] memo, int diceIndex, int n, int currSum, int target, int k) {
        // All the n dice are traversed, the sum must be equal to target for valid combination
        if (diceIndex == n) {
            return currSum == target ? 1 : 0;
        }

        // We have already calculated the answer so no need to go into recursion
        if (memo[diceIndex][currSum] != null) {
            return memo[diceIndex][currSum];
        }

        int ways = 0;
        // Iterate over the possible face value for current dice
        for (int i = 1; i <= Math.min(k, target - currSum); i++) {
            ways = (ways + waysToTarget(memo, diceIndex + 1, n, currSum + i, target, k)) % MOD;
        }
        return memo[diceIndex][currSum] = ways;
    }

    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] memo = new Integer[n + 1][target + 1];
        return waysToTarget(memo, 0, n, 0, target, k);
    }
}
