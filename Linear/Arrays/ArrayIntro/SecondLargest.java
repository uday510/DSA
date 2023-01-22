public class SecondLargest {

    public static void main(String[] args) {
        int[] nums = {10, 10, 9, 8, 1};
        System.out.println(solve(nums));
    }
    public static int solve(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (var num : nums) {
              firstMax = Math.max(num, firstMax);;
            }
        for (var num : nums ){
            if ( num != firstMax) {
                secondMax = Math.max(num, secondMax);
            }
        }
        return secondMax;
    }
}
