package Array.Arrays;

import java.util.Arrays;

public class AlexAndTreasures {
    public static void main(String[] args) {
        int[][] a = { {1, 5}, {2, 1}, {-1, -1}, {3, 1} };

        int b = 3;

        int[][] ans = solve(a, b);

        System.out.println(Arrays.deepToString(ans));
    }

    public static int[][] solve(int[][] a, int b) {
        int[][] ans = new int[b][2];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {

            for (int j = i + 1; (j + b) <= a.length; j++) {
                int c1 = a[i][0] - a[j][0];
                int c2 = a[i][1] - a[j][1];

                int sum = (int) Math.sqrt((c1 * c1 )+ (c2 * c2));

                if (sum > max) {
                    ans[0] = a[i];
                    ans[1] = a[j];
                    max = sum;
                }
            }
        }
        System.out.println(Arrays.deepToString(ans));
        return ans;
    }
}
