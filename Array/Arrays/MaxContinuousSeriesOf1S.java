/**Problem Description
 Given a binary array A, find the maximum sequence of continuous 1's that can be formed by replacing at-most B zeroes.

 For this problem, return the indices of maximum continuous series of 1s in order.

 If there are multiple possible solutions, return the sequence which has the minimum start index.



 Problem Constraints
 0 <= B <= 105

 1 <= size(A) <= 105

 0 <= A[i] <= 1



 Input Format
 First argument is an binary array A.

 Second argument is an integer B.



 Output Format
 Return an array of integers denoting the indices(0-based) of 1's in the maximum continuous series.



 Example Input
 Input 1:

 A = [1 1 0 1 1 0 0 1 1 1 ]
 B = 1
 Input 2:

 A = [1, 0, 0, 0, 1, 0, 1]
 B = 2


 Example Output
 Output 1:

 [0, 1, 2, 3, 4]
 Output 2:

 [3, 4, 5, 6]


 Example Explanation
 Explanation 1:

 Flipping 0 present at index 2 gives us the longest continous series of 1's i.e subarray [0:4].
 Explanation 2:

 Flipping 0 present at index 3 and index 5 gives us the longest continous series of 1's i.e subarray [3:6].
 *
 */
package Array.Arrays;

import java.util.Arrays;

public class MaxContinuousSeriesOf1S {
    public static void main(String[] args) {
        int[] array = {1, 1, 0, 1, 1, 0, 0, 1 ,1, 1};
        int b = 1;

        int[] ans = solve(array, b);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int[] array, int b) {

        // O(N) time | O(1) space

        int ans = 0;
        int count = b;
        int i = 0, j = 0;
        int left = -1, right = -1;

        while (j < array.length) {
            if (array[j] == 0) {
                count--;
            }
            while (count < 0) {
                if (array[i] == 0) {
                    count++;
                }
                i++;
            }

           if (j - i + 1 > ans) {
               ans = right - left + 1;
               left = i;
               right = j;
           }
            j++;
        }

        int[] arr = new int[right - left + 1];
        int idx = 0;

        for (int k = left; k <= right; k++) {
            arr[idx++] = k;
        }

        return arr;
    }
}
