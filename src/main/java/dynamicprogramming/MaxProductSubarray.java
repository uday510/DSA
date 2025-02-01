/**
 * Problem Description
 * Given an integer array A of size N. Find the contiguous subarray within the given array (containing at least one number) which has the largest product.
 *
 * Return an integer corresponding to the maximum product possible.
 *
 * NOTE: Answer will fit in 32-bit integer value.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 5 * 105
 *
 * -100 <= A[i] <= 100
 *
 *
 *
 * Input Format
 * First and only argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return an integer corresponding to the maximum product possible.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [4, 2, -5, 1]
 * Input 2:
 *
 *  A = [-3, 0, -5, 0]
 *
 *
 * Example Output
 * Output 1:
 *
 *  8
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  We can choose the subarray [4, 2] such that the maximum product is 8.
 * Explanation 2:
 *
 *  0 will be the maximum product possible.
 */
package dynamicprogramming;



public class MaxProductSubarray {
    public static void main(String[] args) {
        int[] array = {0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        int res = solve(array);
        System.out.println(res);
    }
    public static int solve(int[] nums) {
        if (nums.length == 0) return 0;

        int prefix = 1;
        int suffix = 1;
        int n = nums.length;
        int max =  Integer.MIN_VALUE;

        for (int i = 0; i < n; ++i) {
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            prefix = prefix * nums[i];
            suffix = suffix * nums[n - i - 1];
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;

//        int res = nums[0];
//        for (int i = 0; i < nums.length; ++i) {
//            int curr = 1;
//            for (int j = i; j < nums.length; ++j) {
//                curr *= nums[j];
//                res = Math.max(res, curr);
//            }
//        }
//        return res;
    }
}
