/**
 * Given n cuboids where the dimensions of the ith cuboid is cuboids[i] = [widthi, lengthi, heighti] (0-indexed). Choose a subset of cuboids and place them on each other.
 *
 * You can place cuboid i on cuboid j if widthi <= widthj and lengthi <= lengthj and heighti <= heightj. You can rearrange any cuboid's dimensions by rotating it to put it on another cuboid.
 *
 * Return the maximum height of the stacked cuboids.
 *
 * Input: cuboids = [[50,45,20],[95,37,53],[45,23,12]]
 * Output: 190
 * Explanation:
 * Cuboid 1 is placed on the bottom with the 53x37 side facing down with height 95.
 * Cuboid 0 is placed next with the 45x20 side facing down with height 50.
 * Cuboid 2 is placed next with the 23x12 side facing down with height 45.
 * The total height is 95 + 50 + 45 = 190.
 * Example 2:
 *
 * Input: cuboids = [[38,25,45],[76,35,3]]
 * Output: 76
 * Explanation:
 * You can't place any of the cuboids on the other.
 * We choose cuboid 1 and rotate it so that the 35x3 side is facing down and its height is 76.
 * Example 3:
 *
 * Input: cuboids = [[7,11,17],[7,17,11],[11,7,17],[11,17,7],[17,7,11],[17,11,7]]
 * Output: 102
 * Explanation:
 * After rearranging the cuboids, you can see that all cuboids have the same dimension.
 * You can place the 11x7 side down on all cuboids so their heights are 17.
 * The maximum height of stacked cuboids is 6 * 17 = 102.
 *
 *
 * Constraints:
 *
 * n == cuboids.length
 * 1 <= n <= 100
 * 1 <= widthi, lengthi, heighti <= 100
 */
package dp;
import java.util.Arrays;

public class MaxHeightByStackingCuboids {
    public static void main(String[] args) {
        int[][] cuboids = {{38,25,45},{76,35,3}};
        System.out.println(maxHeight(cuboids));

    }
    public static int maxHeight(int[][] cuboids) {
        int max = 0;
        int n = cuboids.length;
        Pair[] envelopes = new Pair[cuboids.length];

        for (int[] row : cuboids) Arrays.sort(row);

        for (int i = 0; i < n; ++i) {
            Pair envelop = new Pair(cuboids[i][0], cuboids[i][1], cuboids[i][2]);
            envelopes[i] = envelop;
        }
        Arrays.sort(envelopes, (a, b) -> {
            if (a.length == b.length) {
                if (a.width == b.width) {
                    return a.height - b.height;
                }
                return a.width - b.width;
            }
            return a.length - b.length;
        });
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = envelopes[i].height;
        }
        max = dp[0];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if ((envelopes[i].height >= envelopes[j].height)
                        && (envelopes[i].width >= envelopes[j].width) &&
                        (envelopes[i].length >= envelopes[j].length)) {
                    dp[i] = Math.max(dp[i], dp[j] + envelopes[i].height);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    static class Pair {
        int width;
        int length;
        int height;
        Pair(int w, int l, int h) {
            width = w;
            length = l;
            height = h;
        }
    }
}
