package ScalerContest1;

import java.util.Arrays;

public class HighestProduct {
    public static void main(String[] args) {
        int[] arr = {0, -1, 3, 100, -70, -50};
        int ans = solve(arr);
        System.out.println(ans);
    }
    public static int solve (int[] nums) {
         //O(N) time | O(1) space
        int[] threeLargest = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] twoMinimum = {Integer.MAX_VALUE, Integer.MAX_VALUE};

        for (int num : nums) {
            updateLargest(threeLargest, num);
            updateMinimum(twoMinimum, num);
        }

        System.out.println(Arrays.toString(threeLargest));
        System.out.println(Arrays.toString(twoMinimum));

        int product1 = threeLargest[0] * threeLargest[1] * threeLargest[2];
        int product2 = twoMinimum[0] * twoMinimum[1] * threeLargest[2];

        return Math.max(product1, product2);
    }

    public static void updateLargest(int[] threeLargest, int num) {
        if (num > threeLargest[2]) {
            shiftAndUpdate(threeLargest, num, 2);
        } else if (num > threeLargest[1]) {
            shiftAndUpdate(threeLargest, num, 1);
        } else if (num > threeLargest[0]) {
            shiftAndUpdate(threeLargest, num, 0);
        }
    }
    public static void updateMinimum(int[] twoMinimum, int num) {
        if (num < twoMinimum[1]) {
            shiftAndUpdate(twoMinimum, num, 1);
        } else if (num < twoMinimum[0]) {
            shiftAndUpdate(twoMinimum, num, 0);
        }
    }

    public static void shiftAndUpdate(int[] array, int num, int idx) {
        for (int i = 0; i <= idx; i++) {
            if (i == idx) array[i] = num;
            else array[i] = array[i + 1];
        }
    }
}
