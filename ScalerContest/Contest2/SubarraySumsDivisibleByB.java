package ScalerContest.Contest2;

import java.util.Arrays;
import java.util.HashMap;

public class SubarraySumsDivisibleByB {
    public static void main(String[] args) {
        int[] array = {-20, -11, -8, -4, 2, -12, 14, 1, -18};
        long ans = solve(array, 11);
        System.out.println(ans);
    }
    public static long solve(int[] A, int B) {
        long ans = 0;
        for (int i = 1; i < A.length; i++) {
            A[i] += A[i - 1];
        }
        System.out.println(Arrays.toString(A));
        for (int i = 0; i < A.length; i++) {
            A[i] %= B;
        }
        System.out.println(Arrays.toString(A));
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);

        for (int i = 0; i < A.length; i++) {
            if (hm.containsKey(A[i])) {
                ans += hm.get(A[i]);
            }
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
        }
        return ans;
    }
}
