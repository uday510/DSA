import java.util.HashSet;

public class ZeroSumSubArray {

    public static void main(String[] args) {
        int[] nums = {-5, -5, 2, 3, -2};

        System.out.println(solve(nums));
    }
    public static boolean solve(int[] nums) {
        // O(n) time | O(n) space

        /**
         * [1, 2, 3, X, 6, 8, ... Y,...]
         * if sum from 0 to X == sum of  0 to Y then,
         * X+1 to Y always becomes 0
         * Eg: [4, -3, 2, 4, -1, -5, 7]
         * index from 0 to 1 sum == 0, let say index 1 is X ,
         * index from 2 to 5 sum == 0, let say index 5 is Y,
         * Here From index X + 1 to index 5 sum becomes 0.
         *
         * Test Case : [4, -3, 2, 4, -1, -5, 7]
         */
        HashSet<Integer> sums = new HashSet<>();
        sums.add(0);
        int currentSum = 0;
        for (var num: nums) {
            currentSum += num;
            if (sums.contains(currentSum)) return true;
            sums.add(currentSum);
        }
        return false;
    }
}
