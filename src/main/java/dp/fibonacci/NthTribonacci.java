package dp.fibonacci;

public class NthTribonacci {

    public int tribonacci(int n) {
        if (n < 0) return 0;
        if (n == 1 || n == 2) return 1;

        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    public int tribonacci2(int n) {
        if (n < 2) return n;

        int t0 = 0, t1 = 1, t2 = 1;

        for (int i = 3; i <= n; ++i) {
            int t3 = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = t3;
        }

        return t2;
    }

}
