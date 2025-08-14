package binarysearch.tool;

import java.util.Arrays;

public class SuccessfulePairOfSpellsAndPotions {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int[] res = new int[n];
        Arrays.sort(potions);

        for (int i = 0; i < n; ++i) {
            long spell = spells[i];

            int l = 0, r = potions.length;

            while (l < r) {
                int m = (l + r) >> 1;

                if ((long) spell * potions[m] < success) l = m + 1;
                else r = m;
            }
            res[i] = potions.length - l;
        }

        return res;
    }

}
