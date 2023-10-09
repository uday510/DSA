package BinarySearch;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String args[]) {
        int[] array = {1, 2, 3, 3, 3, 3, 4, 5, 6};
        int target = 3;
        Arrays.sort(array);
        System.out.println(binarySearch(array, target+1)-1);
    }

    //TODO: STANDARD BINARY SEARCH TEMPLATE

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length;

        while (left < right) {
            int midIdx = (left + right) / 2;
            if (array[midIdx] < target) {
                left = midIdx + 1;
            } else {
                right = midIdx;
            }
        }
        return left;
    }


//    public static int binarySearch(int[] array, int target, int left, int right) {
//        System.out.println("hi");
//        // O(log(n)) time | O(1) space
//        while(left <= right) {
//            int mid = left + (right - left) >> 1;
//            int potentialMatch = array[mid];
//            System.out.println(mid);
//            if(target == potentialMatch) return mid;
//            else if(target < potentialMatch) left = mid + 1;
//            else right = mid - 1;
//        }
//        return -1;
//    }
    public static int binarySearchRecursion(int array[], int target, int left, int right) {
        // O(log(n)) time | O(log(n)) space
        if(left > right) return -1;
        int mid = left + (right - left) / 2;
        int potentialMatch = array[mid];
        if(target == potentialMatch) return mid;
        else if(target < potentialMatch)
            return binarySearchRecursion(array, target, left, mid - 1);
        else
            return binarySearchRecursion(array, target, mid + 1, right);
    }
}
