package binarysearch;

public class FindInMountainArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 3, 1};

        System.out.println(findInMountainArray(array, 3));

    }

    public static int findInMountainArray(int[] array, int target) {
        int peak = findPeak(array);
        System.out.println(peak);

        int s = bs(0, peak, target, true, array);
        System.out.println(s);

        int e = bs(peak, array.length - 1, target, false, array);

        return e;

    }
    public static int bs(int left, int right, int target, boolean isAsc, int[] arr) {

        while (left <= right) {
            int mid = (left + right) >> 1;
            int midVal = arr[mid];

            if (midVal == target) {
                return mid;
            }
            else if ( (midVal < target && isAsc) || (midVal > target && !isAsc)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static int findPeak(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) >> 1;

            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

