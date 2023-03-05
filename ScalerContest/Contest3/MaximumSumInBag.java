package ScalerContest.Contest3;

public class MaximumSumInBag {
    public static void main(String[] args) {
//        int[] a = {16, 3, 3, 6, 7, 8, 17, 13, 7};
//        int [] b = {0, 1, 0, 1, 0, 0, 1, 1, 0};
          int[] a = {1, 4, 2, 8};
          int [] b = {0, 0, 0, 1};
          int c = 2;

        int ans = solve(a, b, c);
        System.out.println(ans);
    }

    public static int solve(int[] a, int[] b, int window) {

        int sum = 0;
        int ans = 0;

        for(int i = 0; i < b.length; i++) {
            if (b[i] == 1) sum += a[i];
        }

        int left = 0, n = a.length;

        for (int right = 0; right < a.length; right++) {

            if (b[right] == 0) {
                sum += a[right];
            }

            if ( (right - left + 1) > window) {
                if (b[left] == 0) {
                    sum -= a[left];
                }
                left++;
            }

            if ((right - left + 1) == window) {
                ans = Math.max(sum, ans);
            }
        }
        return ans;

    }
//    public static int solve(int[] a, int[] b, int c) {
//        int ans = 0;
//        // O(N) time | O(N) space
//
//        // Prefix sum
//        int[] pf = new int[a.length];
//        int[] pf1 = new int[a.length];
//
//        pf[0] = a[0];
//        if (b[0] == 1) pf1[0] = a[0];
//
//        for (int i = 1; i < a.length; i++) {
//            pf[i] = pf[i-1] + a[i];
//            if (b[i] == 1) pf1[i] = pf1[i-1] + a[i];
//            else pf1[i] = pf1[i-1];
//        }
//
//        System.out.println(Arrays.toString(pf));
//        System.out.println(Arrays.toString(pf1));
//        int l = 0, r = c-1, n = a.length;
//
//        while (r < n) {
//            int sum = 0;
//
//            //Middle
//            if (l == 0) {
//                sum = pf[r];
//            } else {
//                sum = pf[r] - pf[l-1];
//            }
//
//            //Left
//            if (l == 0) sum += pf1[0];
//            else sum += pf1[l-1];
//
//            // right
//            sum += pf1[n-1] - pf1[r+1-1];
//
//            ans = Math.max(ans, sum);
//
//            l++; r++;
//        }
//        return ans;
//     }
}
