package recursion;

public class NumPaths {
    public static void main(String[] args) {
        System.out.println(dfs(0, 0, 4));
    }

    private static int dfs(int i, int j, int n) {
        if (i == n - 1 && j == n - 1) {
            System.out.println(1);
            return 1;
        }

        if (i >= n || j >= n || i < j) {
            System.out.println(0);
            return 0;
        }

        return dfs(i, j + 1, n) + dfs(i + 1, j, n);
    }
}
