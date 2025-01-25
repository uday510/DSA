package binarysearch;

public class BisectRight {

    public static void main(String[] args) {
        int[] array = {1, 3, 3, 3, 3, 3, 4, 5, 6};

        System.out.println(bisectRight(array, 3));
    }

    public static int bisectRight(int[] array, int target) {

        target = target + 1; // TODO : Trick to find the right most index
        int left = 0, right = array.length;

        while (left < right) {
            int mid = (left + right) >>> 1;

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left-1; // TODO : Trick to find the right most index
    }
}
