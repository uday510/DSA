/**
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
 *
 * One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
 *
 * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
 *
 * Note: You cannot rotate an envelope.
 *
 *
 *
 * Example 1:
 *
 * Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * Example 2:
 *
 * Input: envelopes = [[1,1],[1,1],[1,1]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= envelopes.length <= 105
 * envelopes[i].length == 2
 * 1 <= wi, hi <= 105
 */
package dynamicprogramming;

import java.util.Arrays;

public class RussianDollEnvelopes {
    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println(maxEnvelopes(envelopes));
    }
    public static int maxEnvelopes(int[][] array) {
        int max = 0;
        int n = array.length;
        Pair[] envelopes = new Pair[array.length];

        for (int i = 0; i < n; ++i) {
            Pair envelop = new Pair(array[i][0], array[i][1]);
            envelopes[i] = envelop;
        }
        Arrays.sort(envelopes, (a, b) -> {
            if (a.height == b.height) {
                return a.width - b.width;
            }
            return a.height - b.height;
        });
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((envelopes[i].height > envelopes[j].height) && (envelopes[i].width > envelopes[j].width)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    static class Pair {
        int height;
        int width;
        Pair(int height, int width) {
            this.height = height;
            this.width = width;
        }
    }
}
