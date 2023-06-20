/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.



Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false


Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
 */

import java.util.HashMap;

public class ContainsDuplicates2 {
    public static void main(String[] args) {

    }
    public static boolean solve(int[] nums, int k) {
        if (k == 0) return false;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (hashMap.containsKey(num) && i - hashMap.get(num) <= k) return true;
            hashMap.put(num, i);
        }
        return false;
    }
}
