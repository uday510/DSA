/**
 * Problem Description
 * Given an one-dimensional integer array A of size N and an integer B.
 *
 * Count all distinct pairs with difference equal to B.
 *
 * Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 104
 *
 * 0 <= A[i], B <= 105
 *
 *
 *
 * Input Format
 * First argument is an one-dimensional integer array A of size N.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the count of all distinct pairs with difference equal to B.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 5, 3, 4, 2]
 *  B = 3
 * Input 2:
 *
 *  A = [8, 12, 16, 4, 0, 20]
 *  B = 4
 * Input 3:
 *
 *  A = [1, 1, 1, 2, 2]
 *  B = 0
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  5
 * Output 3:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  There are 2 unique pairs with difference 3, the pairs are {1, 4} and {5, 2}
 * Explanation 2:
 *
 *  There are 5 unique pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20}
 * Explanation 3:
 *
 *  There are 2 unique pairs with difference 0, the pairs are {1, 1} and {2, 2}.
 */
package Linear.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairsWithGivenDifference {
    public static void main(String[] args) {
        int[] array = { 2, 5, 1, 2, 8, 1, 3, 5, 7, 1 };
        int k = 2;
        int ans = solve(array, k);
        System.out.println(ans);
    }
    public static int solve(int[] nums, int k) {


        Arrays.sort(nums); // sort the given array

        int pairs = 0;

        // --- BRUTE FORCE --- O(N^2) time | O(1) space

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) continue;

                if (Math.abs(nums[i] - nums[j]) == k) {
                    pairs++;
                }
            }
        }

        // -- Two pointer approach O(NLogN) time | O(1) space

        int left = 0, right = 1;

        while (left < nums.length && right < nums.length) {
            if (left == right || nums[right] - nums[left] < k) {
                right++;
            } else if (nums[right] - nums[left] > k) {
                left++;
            } else {
                left++;
                pairs++;
                while (left < nums.length && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }

        // --- HASHMAP ---
        // testCase: [1, 3, 1, 4, 5] CRITICAL

        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry <Integer, Integer> entry: counter.entrySet()) {
            int x = entry.getKey();
            int val = entry.getValue();
            if (k > 0 && counter.containsKey(x + k)) {
                pairs++;
            } else if (k == 0 && val > 1) {
                pairs++;
            }
         }
        return pairs;
    }


}
