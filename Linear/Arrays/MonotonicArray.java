/**
 *

 You're given an array of integers and an integer. Write a function that moves all instances of that integer in the array to the end of the array and returns the array.

 The function should perform this in place (i.e., it should mutate the input array) and doesn't need to maintain the order of the other integers.
 Sample Input

 array = [2, 1, 2, 2, 2, 3, 4, 2]
 toMove = 2

 Sample Output

 [1, 3, 4, 2, 2, 2, 2, 2] // the numbers 1, 3, and 4 could be ordered differently


 */
public class MonotonicArray {
    public static void main(String[] args) {
        int[] array = {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};

        System.out.println(solve(array));
    }
    public static boolean solve(int[] array) {
        // O(n) time | O(1) space
        boolean isNonDecreasing = true;
        boolean isNonIncreasing = true;
        for(int i = 1; i < array.length; i++) {
            if(array[i] < array[i - 1]) isNonDecreasing = false;
            if(array[i] > array[i - 1]) isNonIncreasing = false;
        }
        return isNonDecreasing || isNonIncreasing;
    }
}
