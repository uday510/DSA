package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArrayByParity {

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};

        System.out.println(Arrays.toString(sortArrayByParity(nums)));
    }

    public static int[] sortArrayByParity(int[] nums) {

        int n = nums.length;
        int evenIdx = 0, oddIdx = n - 1;

        while (evenIdx < oddIdx) {

            if ((nums[evenIdx] & 1) > (nums[oddIdx] & 1)) {
                int temp = nums[evenIdx];
                nums[evenIdx] = nums[oddIdx];
                nums[oddIdx] = temp;
            }

            if ((nums[evenIdx] & 1) == 0) evenIdx++;
            if ((nums[oddIdx] & 1) != 0) oddIdx--;
        }
        return nums;
    }
}
