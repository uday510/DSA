package sort;

public class MinDifference {
    public static void main(String[] args) {
        int[] arr = {1, 15, 10};
        System.out.println(STR."Minimum difference is: \{getMinDifference(arr)}");

    }
    public static int getMinDifference(int[] arr) {
        int N = arr.length;

        if (N <= 4) {
            return 0;
        }

        java.util.Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        /**
         * We need to find the minimum difference between the last 4 elements and the first 4 elements.
         * We can do this by comparing the difference between the last 4 elements and the first 4 elements.
         *
         */

        for (int i = 0; i <= 3; i++) {
            minDiff = Math.min(minDiff, arr[N - 4 + i] - arr[i]);
        }

        return minDiff;

    }
}
