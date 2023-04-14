/**
 * Problem Description
 * You are given 3 sorted arrays A, B and C.
 *
 * Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
 *
 * Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).
 *
 *
 *
 * Problem Constraints
 * 1 <= len(A), len(B), len(c) <= 106
 *
 * 0 <= A[i], B[i], C[i] <= 107
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 * Second argument is an integer array B.
 *
 * Third argument is an integer array C.
 *
 *
 *
 * Output Format
 * Return an single integer denoting the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 4, 10]
 *  B = [2, 15, 20]
 *  C = [10, 12]
 * Input 2:
 *
 *  A = [3, 5, 6]
 *  B = [2]
 *  C = [3, 4]
 *
 *
 * Example Output
 * Output 1:
 *
 *  5
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  With 10 from A, 15 from B and 10 from C.
 * Explanation 2:
 *
 *  With 3 from A, 2 from B and 3 from C.
 */
package Linear.Arrays;

import java.util.Arrays;

public class Array3Pointers {
    public static void main(String[] args) {
        int[] array1 = {1, 4, 10};
        int[] array2 = {2, 15, 20};
        int[] array3 = {10, 12};

        int ans = solve(array1, array2, array3);
        System.out.println(ans);
    }
    public static int solve(int[] array1, int[] array2, int[] array3) {

        int i = 0, j = 0, k = 0;
        Arrays.sort(array1);
        Arrays.sort(array2);
        Arrays.sort(array3);

        int diff = Integer.MAX_VALUE;
        while (i < array1.length && j < array2.length && k < array3.length) {

            int max = Math.max(Math.abs(array1[i]), Math.abs(array2[j]));
            max = Math.max(max, Math.abs(array3[k]));

            int min = Math.min(Math.abs(array1[i]), Math.abs(array2[j]));
            min = Math.min(min, Math.abs(array3[k]));

            if (max - min < diff) {
                diff = max - min;
            }
            if (array1[i] <= array2[j] && array1[i] <= array3[k]) {
                i++;
            } else if (array2[j] <= array1[i] && array2[j] <= array3[k]) {
                j++;
            } else {
                k++;
            }

        }

        return diff;
    }
}
