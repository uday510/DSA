package backtracking;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 51, n = 9;

        int ans = solve(m, n);
        System.out.println(ans);

    }
    public static int solve(int m, int n) {

        if (m == 1 || n == 1) return 1;

        return solve(m-1, n) + solve(m, n-1);
    }
}
