package binarysearch.solutionspace;

import java.util.Arrays;

public class KokoEatingBananas {


    /**
     * In the problem, Koko is given n piles of bananas, represented by an integer array of length n. She eats bananas at a constant speed, for example, x bananas per hour. The time taken to eat a pile of y bananas is y/x after rounding up to the closest integer. For example, if she eats 3 bananas per hour, it takes her 2 hours to eat a pile of 4 bananas.
     *
     * The first constraint of the problem is that Koko has to eat all the piles within h hours, where h is no less than the number of piles. We can imagine that with a fast speed, Koko spends 1 hour on each pile, therefore, she can always finish all the piles within h hours. Let's call this kind of speed workable speed. Likewise, let any eating speed at which Koko can't eat all the piles be unworkable speed.
     *
     * However, we have another constraint that Koko would like to eat as slow as possible, therefore, among all the workable eating speeds, we need to find out the minimum one.
     * @param piles
     * @param h
     * @return
     */

    public int minEatingSpeed(int[] piles, int h) {

        int minBananasPerHr = 1;
        int maxBananasPerHr = Arrays.stream(piles).max().getAsInt();

        while (minBananasPerHr < maxBananasPerHr) {

            int k = (minBananasPerHr + maxBananasPerHr) >> 1;

            if (canEatAllBananasWithKPerHr(piles, k, h)) maxBananasPerHr = k; // reduce time
            else minBananasPerHr = k + 1;
        }

        return minBananasPerHr;
    }
    private boolean canEatAllBananasWithKPerHr(int[] piles, int k, int reqHrs) {
        int currHrs = 0;

        for (int pile : piles) {
            currHrs += (int) Math.ceil(( (double) pile / k));
            if (currHrs > reqHrs) return false;
        }

        return currHrs <= reqHrs;
    }

}
