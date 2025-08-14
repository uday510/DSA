package binarysearch.tool;

import java.util.Random;

public class RandomPickWithWeight {

    int[] w;
    int[] psum;
    int n;

    public RandomPickWithWeight(int[] w) {
        this.w = w;
        n = w.length;
        psum = new int[n];
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += w[i];
            psum[i] = sum;
        }
    }

    public int pickIndex() {
        int val = new Random().nextInt(psum[psum.length - 1]) + 1;

        int l = 0, r = n;
        // while (l < n && psum[l] < val) l++;

        while (l < r) {
            int m = (l + r) >> 1;
            if (psum[m] < val) l = m + 1;
            else r = m;
        }

        return l;
    }

}
