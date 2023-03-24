package Recursion;

public class FastPowerFunction {
    public static void main(String[] args) {
        int a = 5, n = 2;
        int ans = solve(a, n);
        System.out.println(ans);
    }
    public static int solve(int a, int n) {
        if (n == 0) return 1;
        if (a == 0) return 0;

        long temp = solve(a, n/2);
        if (n%2 == 0) return (int) (temp*temp);
        else return (int) (temp*temp*a);
    }
}
