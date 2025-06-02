package dp;

public class NumberOfArrays {



    public static void main(String[] args) {

//        System.out.println(numOfArrays(9, 1, 1));
    }

    static class Solution {
        private static final int MOD = (int) 1e9 + 7;
        static Integer[][][] dp;
        static int n, m, k;

        Solution(int n, int m, int k) {
            Solution.n = n;
            Solution.m = m;
            Solution.k = k;
        }

        public static void main(String[] args) {
            System.out.println(numOfArrays(9, 1, 1));
        }
        public static int numOfArrays(int n, int m, int k) {
            new Solution(n, m, k);

            dp = new Integer[n+1][m+1][k+1];

            return dfs(0, 0, 0);
        }
        public static int dfs(int index, int max, int cost) {
            if (index == n) {
                return cost == k ? 1 : 0;
            }

            if (dp[index][max][cost] != null) {
                return dp[index][max][cost];
            }
            int count = 0;

            for (int val = 1; val <= m; ++val) {
                int incre = val > max ? 1 : 0;
                count += dfs(index + 1, Math.max(val, max), cost + incre);
                count %= MOD;
            }

            dp[index][max][cost] = count;

            return count;
        }
    }

}

