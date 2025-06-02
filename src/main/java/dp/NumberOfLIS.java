package dp;

public class NumberOfLIS {

    public static void main(String[] args) {

        int[] nums = {0, 2, 1, 7};
        int result = findNumberOfLIS(nums);
        System.out.println(result);
    }

    private static int findNumberOfLIS(int[] nums) {

        /**
         *
         *
         *  0   2   1   7
         *  1   1   1   1
         *  1   1   1   1
         *
         *
         *  idx = 1
         *
         * 0    2   1   7
         * 1    2   1   1
         * 1    1   1   1
         *
         * idx = 2
         * 0    2   1   7
         * 1    2   2   1
         * 1    1   1   1
         *
         * idx = 3
         * 0    2   1   7
         * 1    2   2   3
         * 1    1   1   2
         *
         */

        int len = nums.length;
        int[] length = new int[len];
        int[] count = new int[len];
        int longest = -1;

        for (int i = 0; i < len; ++i) {
            length[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    if (nums[j] + 1 < nums[i]) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    } else if (nums[j] + 1 == nums[i]) {
                        count[i] += count[j];
                    }
                }
            }
            longest = Math.max(longest, length[i]);
        }


        int result = 0;
        for (int i = 0; i < len; ++i) {
            if (length[i] == longest) {
                result += count[i];
            }
        }

        return result;
    }
}
