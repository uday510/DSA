package Recursion;

public class PowerOfFour {
    public static void main(String[] args) {

        int n = 16;

        System.out.println(isPowerOfFour(n));
    }
    public static boolean isPowerOfFour(int n) {

        if (n == 1) return true;
        int i = 1, j = n;

        while (i < j) {
            int mid = (i + j) >> 1;
            if (pow(4, mid) < n) i = mid + 1;
            else j = mid;
        }
        return (i < n && Math.pow(4, i) == n);
    }
    public static int pow(int x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;


        int res = 1;
        while (n != 0) {
            if (n % 2 == 1) {
                res *= x;
                n -= 1;
            }
            x *= x;
            n = n / 2;
        }
        return res;
    }
}

