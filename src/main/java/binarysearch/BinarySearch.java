package binarysearch;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String args[]) {
        int[] array = {1, 2, 3, 3, 3, 3, 4, 5, 6};
        int target = 3;
        Arrays.sort(array);
        System.out.println(binarySearch(array, target));
    }

    //TODO: STANDARD BINARY SEARCH TEMPLATE

    public static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length;

        while (left < right) {
            int midIdx = (left + right) >>> 1;

            if (array[midIdx] < target) {
                left = midIdx + 1;
            } else {
                right = midIdx;
            }
        }

        return (left < array.length && array[left] == target) ? left : -1;
    }
}
