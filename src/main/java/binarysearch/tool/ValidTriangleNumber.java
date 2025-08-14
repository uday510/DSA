package binarysearch.tool;

import java.util.Arrays;

public class ValidTriangleNumber {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int cnt = 0, n = nums.length;

        for (int c = n - 1; c > 1; --c) {
            int a = 0, b = c - 1;

            while (a < b) {
                if (nums[a] + nums[b] > nums[c]) {
                    cnt += b-- - a;
                } else a++;
            }
        }

        return cnt;
    }

}

/**

 [2, 3, 4, 5, 6, 8]


 3 6 8
 4 6 8
 5 6 8

 4 5 8

 3 4 6
 2 5 6
 3 5 6
 4 5 6

 2 4 5
 3 4 5

 2 3 4


 */
