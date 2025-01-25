package binarysearch;

public class BisectLeft {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 9};

        System.out.println(bisectLeft(array, 1));
    }

    public static int bisectLeft(int[] array, int target) {
        int left = 0, right = array.length;

        while (left < right) {
            int mid = (left + right) >>> 1;
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // TODO : Trick to find the left most index
    }
}
