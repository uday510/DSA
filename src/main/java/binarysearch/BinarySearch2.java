package binarysearch;

public class BinarySearch2 {
    public static void main(String[] args) {
        int[] array = {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        int target = 33;
        System.out.println(binarySearch(array, target));
    }
    public static int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) return -1;

        int left = 0, right = array.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (array[mid] == target) return mid;

            if (array[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        if (array[left] == target) return left; // check for either left or right it doesn't matter

        return -1;
    }

}
