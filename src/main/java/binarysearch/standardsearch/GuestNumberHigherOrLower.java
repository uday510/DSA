package binarysearch.standardsearch;

public class GuestNumberHigherOrLower {

    // https://leetcode.com/problems/guess-number-higher-or-lower/?envType=study-plan-v2&envId=binary-search
    public int guessNumber(int n) {
        int l = 1;
        int r = n;

        while (l < r) {
            int m = (l + r) >>> 1;
//            if (guess(m) == 1) l = m + 1;
//            else r = m;
        }

        return l;
    }

}
