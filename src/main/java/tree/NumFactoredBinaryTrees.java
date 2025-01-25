package tree;

import java.sql.Array;
import java.util.*;

public class NumFactoredBinaryTrees {
    public static void main(String[] args) {

        int[] arr = {2, 4, 5, 10};

        System.out.println(numFactoredBinaryTrees(arr));
    }

    public static int numFactoredBinaryTrees(int[] arr) {
        Map<Integer, Long> numFactors = new HashMap<>();
        long MOD = 1_000_000_007;
        long res = 0L;
        int N = arr.length;

        // 1. every number as 1 factor, i.e itself
        for (int num : arr) numFactors.put(num, 1L);

        for (int i = 0; i < N; ++i) {

            // 2. find factors
            int j = 0;
            List<List<Integer>> factors = new ArrayList<>();
            for (; j < i ;) {
                int factor = arr[i] / arr[j];
                boolean isFactor = arr[i] % arr[j] == 0;
                if (isFactor && numFactors.containsKey(factor)) {
                    factors.add(new ArrayList<>(List.of(arr[j], factor)));
                }
                ++j;
            }

            // 3. count factors for every number
            long tmp = 1L;

            for (List<Integer> currFactor : factors) {
                long cnt1 = numFactors.get(currFactor.get(0));
                long cnt2 = numFactors.get(currFactor.get(1));
                tmp = (tmp + (cnt1 * cnt2) % MOD) % MOD;
            }
            numFactors.put(arr[i], tmp);
            res += tmp;
        }
        return (int) (res % MOD);
    }
}
