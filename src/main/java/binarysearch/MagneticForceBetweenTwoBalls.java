package binarysearch;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {

    int[] position;
    int n, m;

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        this.position = position;
        n = position.length;
        this.m = m;

        int l = 1, r = position[n - 1];

        while (l < r) {
            int mid = (l + r) >> 1;

            if (canPlace(mid)) l = mid + 1;
            else r = mid;
        }

        return l - 1;
    }

    private boolean canPlace(int reqDist) {
        int curBalls = 1, prevBallPos = position[0];

        for (int i = 1; i < n && curBalls < m; i++) {
            int curBallPos = position[i];

            if (curBallPos - prevBallPos >= reqDist) {
                curBalls++;
                prevBallPos = curBallPos;
            }
        }
        return curBalls >= m;
    }

}

/**
 * This is exactly same as aggressive cows, just story is different
 *
 * position = [1, 2, 3, 4, 7], m = 3
 *
 *
 *
 * l = 1, r = 7
 *
 * m = (1+7)/2 = 4 -> not possible
 *
 * l = 1, r = 4
 * m = (1+4)/2 = 2 -> possible -> maximize it
 *
 * l = 3, r = 4
 * m = (3+4)/2 = 3 -> possible -> maximize it
 *
 * l = 4, r = 4
 * m = (4+4)/2 = 4 -> not possible -> l == r => return (l-1)
 *
 *
 * m = 3
 * balls = 1+1+1
 * pos = 7
 *
 *
 */
