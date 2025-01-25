package bitmanipulation;

import java.util.Arrays;

public class Contest {

    public static void main(String[] args) {
        int[] nums = {2,12,1,11,4,5};
        int k = 6;

        System.out.println(findKOr(nums, k));
    }

    public static int findKOr(int[] nums, int k) {
        int n = nums.length;
        int result = 0;
        int maxBit = 0;

        // Find the maximum bit position in the numbers
        for (int num : nums) {
            maxBit = Math.max(maxBit, Integer.toBinaryString(num).length());
            System.out.println(Integer.toBinaryString(num) + " " + Integer.toBinaryString(num).length());
        }

        for (int bit = 0; bit < maxBit; bit++) {
            int count = 0;

            // Count the numbers with the current bit set
            for (int num : nums) {
                if (((num >> bit) & 1) == 1) {
                    count++;
                }
            }

            // If at least k numbers have the bit set, set the bit in the result
            if (count >= k) {
                result |= (1 << bit);
            }
        }

        return result;
    }
}
