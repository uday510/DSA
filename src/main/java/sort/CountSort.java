/**
 * Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 105
 * 1 <= A[i] <= 105
 *
 *
 * Input Format
 * The first argument is an integer array A.
 *
 *
 * Output Format
 * Return an integer array that is the sorted array A.
 *
 *
 * Example Input
 * Input 1:
 * A = [1, 3, 1]
 * Input 2:
 * A = [4, 2, 1, 3]
 *
 *
 * Example Output
 * Output 1:
 * [1, 1, 3]
 * Output 2:
 * [1, 2, 3, 4]
 *
 *
 * Example Explanation
 * For Input 1:
 * The array in sorted order is [1, 1, 3].
 * For Input 2:
 * The array in sorted order is [1, 2, 3, 4].
 */

package sort;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] array = {4, 2, 1, 3};

        int[] res = solve(array);
        System.out.println(Arrays.toString(res));
    }
    public static int[] solve(int[] array) {
        // O(N) time | O(N) - where N is the length of the array
        int len = array.length;
        int maxNum = -1;
        int[] res = new int[len];

        for (int currentNum : array) {
            maxNum = Math.max(currentNum, maxNum);
        }

        int[] frequencyArray = new int[maxNum + 1];
        for (int j : array) frequencyArray[j] += 1;

        int currentSize = 0;
        for (int i = 0; i <= maxNum; i++)
            for (int j = 0; j < frequencyArray[i]; j++)
                res[currentSize++] = i;

        return res;
    }
}
