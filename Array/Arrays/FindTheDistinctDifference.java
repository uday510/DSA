package Array.Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindTheDistinctDifference {
    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 4, 2};

        int[] ans = solve(arr);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int pf[] = new int[n];
        int sf[] = new int[n+1];
        Set<Integer> set = new HashSet<>();

        set.add(arr[0]);
        pf[0] = 1;

        for (int i = 1; i < n; i++) {
            int num = arr[i];
            if(!set.contains(num)) {
                pf[i] = pf[i-1] + 1;
                set.add(num);
            } else {
                pf[i] = pf[i-1];
            }
        }

        set.clear();
        set.add(arr[n-1]);
        sf[n-1] = 1;
        for (int i = n-2; i > -1; i--) {
            int num = arr[i];
            if(!set.contains(num)) {
                sf[i] = sf[i+1] + 1;
                set.add(num);
            } else {
                sf[i] = sf[i+1];
            }
        }
        for (int i = 0; i < n; i++) {
            ans[i] = pf[i] - sf[i+1];
        }
        return ans;
    }
}
