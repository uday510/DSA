package Array.Arrays;

public class MaximumProductofThreeNumbers {
    public static void main(String[] args) {

    }
    public static int maximumProduct(int[] nums) {
        int infinity = Integer.MAX_VALUE;
        int min1 = infinity, min2 = infinity;
        int max1 = -infinity, max2 = -infinity, max3 = -infinity;

        for (int num : nums) {
            if (num <= min1) {
                min2 = min1;
                min1 = num;
            } else if (num <= min2) {
                min2 = num;
            }
            if (num >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num >= max2) {
                max3 = max2;
                max2 = num;
            } else if (num >= max3) {
                max3 = num;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
