package binarysearch;

public class ValidPerfectSquare {

    public static boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;

        while (left < right) {
            long mid = (left + right) >>> 1;
            long val = (mid * mid);

            if (val < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left * left == num;
    }
}
