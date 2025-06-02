package dp.fibonacci;

public class ClimbingStairs {

    public int climbStairs(int n) {
        int climb0 = 0, climb1 = 1;

        for (int i = 1; i <= n; ++i) {
            int climb2 = climb0 + climb1;
            climb0 = climb1;
            climb1 = climb2;
        }

        return climb1;

//        return dfs(0, n);
    }

    private int dfs (int i, int n) {
        if (i >= n) return 0;

        return 1 + dfs(i + 1, n) + dfs(i + 2, n);
    }
}
