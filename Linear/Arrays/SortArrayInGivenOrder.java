/**
 * Problem Description
 * Given two arrays of integers A and B, Sort A in such a way that the relative order among the elements will be the same as those are in B.
 * For the elements not present in B, append them at last in sorted order.
 *
 * Return the array A after sorting from the above method.
 *
 * NOTE: Elements of B are unique.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array A <= 100000
 *
 * 1 <= length of the array B <= 100000
 *
 * -10^9 <= A[i] <= 10^9
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 * The second argument given is the integer array B.
 *
 *
 *
 * Output Format
 * Return the array A after sorting as described.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 3, 4, 5]
 * B = [5, 4, 2]
 * Input 2:
 *
 * A = [5, 17, 100, 11]
 * B = [1, 100]
 *
 *
 * Example Output
 * Output 1:
 *
 * [5, 4, 2, 1, 3]
 * Output 2:
 *
 * [100, 5, 11, 17]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Simply sort as described.
 * Explanation 2:
 *
 *  Simply sort as described.
 */
package Linear.Arrays;

import java.util.*;

public class SortArrayInGivenOrder {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 1, 5, 2, 6, 5, 4 };
        int[] array2 = { 5, 4, 2 };

        int[] ans = solve(array1, array2);
        System.out.println(Arrays.toString(ans));

    }

    public static int[] solve(int[] arr, int[] b) {
        // O(NlogN) time | O(N) space
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // stores the frequency of the elements of arr
        for (int val : arr) {
            if (!map.containsKey(val)) {
                map.put(val, 1);
            } else {
                map.put(val, map.get(val) + 1);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int val : b) {
            // checks it val exists in arr
            if (map.containsKey(val)) {
                while (map.get(val) > 0) {
                    ans.add(val);
                    map.put(val, map.get(val) - 1);
                }
            }
        }

        // append the elements that are not present in b
        for (Integer key : map.keySet()) {
            int val = map.get(key);
            while (val > 0) {
                ans.add(key);
                val--;
            }
        }
        return ans.stream().mapToInt( i -> i).toArray();
    }
}
