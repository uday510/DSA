package ScalerContest.Contest3;

import java.util.Arrays;

public class MaximumSumInBag {
    public static void main(String[] args) {
//        int[] a = {16, 3, 3, 6, 7, 8, 17, 13, 7};
//        int [] b = {0, 1, 0, 1, 0, 0, 1, 1, 0};
          int[] a = {1, 4, 2, 8};
          int [] b = {0, 0, 0, 1};

        int ans = solve(a, b, 2);
        System.out.println(ans);
    }
    public static int solve(int[] a, int[] b, int c) {
        int ans = 0;
        // O(N) time | O(N) space

        // Prefix sum
        int[] pf = new int[a.length];
        int[] pf1 = new int[a.length];

        pf[0] = a[0];
        if (b[0] == 1) pf1[0] = a[0];

        for (int i = 1; i < a.length; i++) {
            pf[i] = pf[i-1] + a[i];
            if (b[i] == 1) pf1[i] = pf1[i-1] + a[i];
            else pf1[i] = pf[i-1];
        }

        System.out.println(Arrays.toString(pf));
        System.out.println(Arrays.toString(pf1));
        int l = 0, r = c-1, n = a.length;

        while (r < n) {
            int sum = 0;

            //Middle
            if (l == 0) {
                sum = pf[r];
            } else {
                sum = pf[r] - pf[l-1];
            }

            //Left
            if (l == 0) sum += pf1[0];
            else sum += pf1[l-1];

            // right
            sum += pf1[n-1] - pf1[r+1-1];

            ans = Math.max(ans, sum);

            l++; r++;
        }
        return ans;
     }
}
