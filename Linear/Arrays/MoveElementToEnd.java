import java.util.Arrays;

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
public class MoveElementToEnd {
    public static void main(String[] args) {
        int[] array = {2, 1, 2, 2, 2, 3, 4, 2};
        int toMove = 2;
        System.out.println(Arrays.toString(solve(array, toMove)));
    }
    public static int[] solve(int[] array, int toMove) {
        int i = 0;
        int j = array.length - 1;
        while(i < j) {
            while(i < j && array[j] == toMove) j--;
            if(array[i] == toMove) swap(i, j, array);
            i++;
        }
        return array;
    }
    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
