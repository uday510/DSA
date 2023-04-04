package Sorting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] array = {-5, 4, 3, -2, 6};

        int[] ans = solve(array);

        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int[] array) {
        //O(N+R) time | O(N+R) space where N is length, R is Range i.e max - min + 1

        // 1. Find Min and Max Element;

        int min = array[0], max = array[0];
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int currentNum = array[i];
            min = Math.min(min, currentNum);
            max = Math.max(max, currentNum);
        }

        // Build Frequency array
        int range = (max - min) + 1;
        int[] freqArray = new int[range];

        for (int val : array) {
            int idx = val - min;
            freqArray[idx]++;
        }

        // Build PREFIX array

        for (int i = 1; i < range; i++) {
            freqArray[i] = freqArray[i-1] + freqArray[i];
        }

        // Build answer array
        int[] ans = new int[n];

        System.out.println(Arrays.toString(freqArray));

        for (int i = n - 1; i > -1; i--) {
            int val = array[i];

            // get val idx
            int idx = freqArray[val - min] - 1;

            ans[idx] = val;

            // update frequency array
            freqArray[val - min]--;
        }


        System.arraycopy(ans, 0, array, 0, n);

        return array;
    }
}
