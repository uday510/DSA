/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.


Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

Accepted
1.6M
Submissions
2.5M

 */
package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequent(nums,k);

        System.out.println(Arrays.toString(result));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        // O(nk) time complexity

        Map<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[k];

       for (int i = 0; i < k; ++i) {

           int maxCount = 0; // max count of a number
           int maxKey = 0; // number with max count

           for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

               if (entry.getValue() > maxCount) {
                   maxCount = entry.getValue();
                   maxKey = entry.getKey();
               }
            }
           result[i] = maxKey; // add the number with max count to the result
           map.remove(maxKey); // remove the number with max count
        }

        return result;
    }
}
