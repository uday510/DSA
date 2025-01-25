package binarysearch;

public class bsInDecreasing {

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int target = 4;

        System.out.println(bs(arr, target));
    }
    public static int bs(int[] arr, int target) {
        int left = 0, right = arr.length;
        int sign = -1;
        target *= sign;

        while (left < right) {
            int mid = (left + right) >> 1;

            if (arr[mid]*sign < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[left];
    }
}
