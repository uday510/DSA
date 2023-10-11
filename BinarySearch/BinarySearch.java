package BinarySearch;

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
        int left = 0, right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;

            if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
