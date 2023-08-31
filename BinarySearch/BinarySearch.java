package BinarySearch;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String args[]) {
        int[] array = {56, 27, 18, 92, 25, 18, 24, 77, 86, 48};
        int target = 86;
        Arrays.sort(array);
        System.out.println(binarySearch(array, target, 0, array.length - 1));
    }
    public static int binarySearch(int[] array, int target, int left, int right) {
        System.out.println("hi");
        // O(log(n)) time | O(1) space
        while(left <= right) {
            int mid = left + (right - left) >> 1;
            int potentialMatch = array[mid];
            System.out.println(mid);
            if(target == potentialMatch) return mid;
            else if(target < potentialMatch) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
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
