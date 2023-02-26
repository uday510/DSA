package ScalerContest.Contest3;

import java.util.Arrays;

public class MaximumSumInBag {
    public static void main(String[] args) {
        int[] a = {16, 3, 3, 6, 7, 8, 17, 13, 7};
        int [] b = {0, 1, 0, 1, 0, 0, 1, 1, 0};

        int ans = solve(a, b, 8);
        System.out.println(ans);
    }
    public static int solve(int[] a, int[] b, int c) {
        int ans = 0;
        int[] arr = new int[a.length];
        // find 1

        for (int i = 0; i < b.length; i++) {
            if (b[i] == 1) {
                ans += a[i];
                System.out.println(a[i]);
            }
            else {
                arr[i] = a[i];
            }
        }
        System.out.println(ans);
        System.out.println("BEFORE" + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        for (int i = arr.length - 1; i > arr.length - c - 2; i--) {
            System.out.print("ANS BEFORE" + ans);
            ans += arr[i];
            System.out.print("ANS AFTER" + ans);
        }

        return  ans;
    }
}
