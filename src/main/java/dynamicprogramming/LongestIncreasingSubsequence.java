/**Given an integer array nums, return the length of the longest strictly increasing
 subsequence
 .



 Example 1:

 Input: nums = [10,9,2,5,3,7,101,18]
 Output: 4
 Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 */
package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};

        System.out.println(lengthOfLIS(nums));
    }
    static Integer[][] dp;
    public static int lengthOfLIS(int[] nums) {

        /**
         * Algorithm
         *
         * Initialize an array dp with length nums.length and all elements equal to 1. dp[i] represents the length of the longest increasing subsequence that ends with the element at index i.
         *
         * Iterate from i = 1 to i = nums.length - 1. At each iteration, use a second for loop to iterate from j = 0 to j = i - 1 (all the elements before i). For each element before i, check if that element is smaller than nums[i]. If so, set dp[i] = max(dp[i], dp[j] + 1).
         *
         * Return the max value from dp.
         */

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int longest = 1;

        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            longest = Math.max(longest, dp[i]);
        }
        return longest;


//        dp = new Integer[nums.length + 1][nums.length];
//        return dfs(-1, 0, nums);
    }

    public static int optimized(int[] nums) {
        /**
         * Approach 2: Intelligently Build a Subsequence
         Intuition

         As stated in the previous approach, the difficult part of this problem is deciding if an element is worth using or not.
         Consider the example nums = [8, 1, 6, 2, 3, 10]. Let's try to build an increasing subsequence starting with an empty one: sub = [].

         At the first element 8, we might as well take it since it's better than nothing, so sub = [8].

         At the second element 1, we can't increase the length of the subsequence since 8 >= 1,
         so we have to choose only one element to keep. Well, this is an easy decision,
         let's take the 1 since there may be elements later on that are greater than 1 but less than 8, now we have sub = [1].

         At the third element 6, we can build on our subsequence since 6 > 1, now sub = [1, 6].

         At the fourth element 2, we can't build on our subsequence since 6 >= 2,
         but can we improve on it for the future? Well, similar to the decision we made at the second element,
         if we replace the 6 with 2, we will open the door to using elements that are greater than 2 but less than 6 in the future, so sub = [1, 2].

         At the fifth element 3, we can build on our subsequence since 3 > 2.
         Notice that this was only possible because of the swap we made in the previous step, so sub = [1, 2, 3].

         At the last element 10, we can build on our subsequence since 10 > 3,
         giving a final subsequence sub = [1, 2, 3, 10]. The length of sub is our answer.

         It appears the best way to build an increasing subsequence is:
         for each element num, if num is greater than the largest element in our subsequence,
         then add it to the subsequence. Otherwise, perform a linear scan through the subsequence
         starting from the smallest element and replace the first element that is greater than or equal
         to num with num. This opens the door for elements that are greater than num but less than the
         element replaced to be included in the sequence.

         One thing to add: this algorithm does not always generate a valid subsequence of the input,
         but the length of the subsequence will always equal the length of the longest increasing subsequence.
         For example, with the input [3, 4, 5, 1], at the end we will have sub = [1, 4, 5], which isn't a subsequence,
         but the length is still correct. The length remains correct because the length only changes when a new element
         is larger than any element in the subsequence. In that case, the element is appended to the subsequence
         instead of replacing an existing element.

         Algorithm

         Initialize an array sub which contains the first element of nums.

         Iterate through the input, starting from the second element. For each element num:

         If num is greater than any element in sub, then add num to sub.
         Otherwise, iterate through sub and find the first element that
         is greater than or equal to num. Replace that element with num.
         Return the length of sub.
         */

        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        int ans = 0;

        for (int i = 1; i < nums.length; ++i) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                // Find the first element in sub that is greater than or equal to num
                int j = 0;
                while (num > sub.get(j)) {
                    ++j;
                }
                sub.set(j, num);
//                int j = binarySearch(sub, num);
//                sub.set(j, num);

            }
        }
        return ans;
    }

    public static int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (sub.get(mid) == num) {
                return mid;
            }

            if (sub.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static int dfs(int prevIdx, int currIdx, int[] nums) {
        if (currIdx >= nums.length) {
            return 0;
        }

        if (dp[prevIdx + 1][currIdx] != null) {
            return dp[prevIdx + 1][currIdx];
        }

        int skip = dfs(prevIdx, currIdx + 1, nums);

        int take = 0;
        if (prevIdx == -1 || nums[prevIdx] < nums[currIdx]) {
            take = 1 + dfs(currIdx, currIdx + 1, nums);
        }

        return dp[prevIdx + 1][currIdx] = Math.max(skip, take);
    }
}
