package dp.lis;

import java.util.Arrays;

public class LongestChain {

    public int findLongestChain(int[][] pairs) {
//        int n = pairs.length;
//        Arrays.sort(pairs, (p1, p2) -> Integer.compare(p1[1], p2[1]));
//        int[] dp = new int[n];
//        int longest = 0;
//
//        for (int i = 0; i < n; ++i) {
//            dp[i] = 1;
//            for (int j = 0; j < i; ++j) {
//                if (pairs[j][1] < pairs[i][0]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//
//            longest = Math.max(dp[i], longest);
//        }
//
//        return longest;
        Arrays.sort(pairs, (p1, p2) -> p1[1] - p2[1]);
        int min = Integer.MIN_VALUE;
        int cnt = 0;

        for (int[] pair : pairs) {
            if (min < pair[0]) {
                min = pair[1];
                cnt += 1;
            }
        }

        return cnt;
    }


}
