package dynamicprogramming;

public class MaxPoints {
    private static int N;
    private static int M;
    private static Long[][] dp;
    private static final long INF = Long.MAX_VALUE;
    public static void main(String[] args) {
        int[][] points = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(maxPoints(points));
    }
    public static long maxPoints(int[][] points) {
        N = points.length;
        M = points[0].length;

        dp = new Long[N][M];

        long maxpoints = -INF;

        for (int i = 0; i < M; i++) {
            maxpoints = Math.max(maxpoints, dfs(points, 0, i));
        }
        return maxpoints;
    }
    public static long dfs(int[][] points, int row, int col) {
        if(row == N) {
            return 0;
        }
        if(dp[row][col] != null) {
            return dp[row][col];
        }
        long max = -INF;
        for(int i = 0; i < M; i++) {
            int penalty = Math.abs(col - i);
            max = Math.max(max, points[row][i] - penalty +  dfs(points, row + 1, i));
        }
        return dp[row][col] = max;
    }
}
