package dynamicprogramming;

public class NthTribonacciNumber {
    public static void main(String[] args) {
        int n = 25;

        int res = tribonacci(n);
        System.out.println(res);
    }
    public static int tribonacci(int n) {
        if (n < 3) return n - 1;
        int t0, t1, t2;
        t0 = 0;
        t1 = 1;
        t2 = 1;

        for (int i = 3; i <= n; ++i) {
            int current = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = current;
        }
        return t2;
    }
}
