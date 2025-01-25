package binarysearch;

public class bsWithSign {
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int target = 4;
        System.out.println(increasing(arr1, target));

        System.out.println(decreasing(arr2, target));
    }
    public static int decreasing(int[] arr, int target) {
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
        return left;
    }
    public static int increasing(int[] arr, int target) {
        int sign = 1;
        int left = 0, right = arr.length;
        target *= sign;

        while (left < right) {
            int mid = (left + right) >> 1;

            if (arr[mid]*sign < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
