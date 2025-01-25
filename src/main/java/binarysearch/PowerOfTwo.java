package binarysearch;

import com.google.common.base.Stopwatch;

public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 16;

        Stopwatch time = Stopwatch.createStarted();

        System.out.println(isPowerOfTwo(n));

        System.out.println(time.stop());

    }
    public static boolean isPowerOfTwo(int n) {
        int i = 1, j = n;

        while (i < j) {
            int mid = (i + j) >> 1;
            if ((int) Math.pow(2, mid) < n) i = mid + 1;
            else j = mid;
        }
        return (i < n && Math.pow(2, i) == n);
    }
    public double dfs(double x, long n) {
        if (n <= 0) return 1.0;
        double val = dfs(x, n/2);
        val *= val;
        if (n%2 != 0) {
            val *= x;
        }
        return val;
    }
}
