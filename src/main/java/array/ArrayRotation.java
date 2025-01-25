package array;

import java.util.*;

/**
 * Given an integer array A of size N and an integer B,
 * you have to return the same array after rotating it B times towards the right.
 *
 *input:  A = [1, 2, 3, 4]
 *        B = 2
 *       output: [3,4,1,2]
 *       Rotate towards the right 2 times
 *       --> [1, 2, 3, 4] => [4, 1, 2, 3] => [3, 4, 1, 2]
 */
public class ArrayRotation {
    public static void main(String[] args) {
        int[] array = {88, 17, 36, 79, 60, 11, 69, 49, 93, 63, 86, 59, 15, 92, 66, 9, 70, 72, 92, 83, 45, 5, 21, 66, 66, 68, 9, 74, 16, 89, 30, 54, 68, 49, 57, 99, 68, 39, 67, 69, 31,
                88, 46, 64, 100, 27, 81, 44, 70, 45, 59, 19, 45, 18, 57, 37,
                32, 94, 35, 47, 29, 9, 91, 17, 24, 39, 46, 42, 36, 45, 69, 99, 93, 83, 42, 60, 56 };
        int k = 84;
        solve(array, k);
        System.out.println(Arrays.toString(array));
    }
    public static void solve(int[] array, int k) {
        // O(n) time | O(1) space
        /**
         * 1. Reverse the complete array.
         * 2. Reverse the first K elements.
         * 3. Reverse the N-K elements. N = Length of array.
         */
        if (k > array.length) k = k % array.length;
        reverse(0, array.length - 1, array);
        reverse(0, k - 1, array);
        reverse(k, array.length - 1, array);
    }
    public static void reverse(int startIdx, int endIdx, int[] array) {
        int midIdx = (int) Math.floor(endIdx - (endIdx - startIdx) / 2);
        while(startIdx < midIdx) {
            swap(startIdx, endIdx, array);
            startIdx++;
            endIdx--;
        }
    }
    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
