package ScalerContest;

import java.util.Arrays;
import java.util.Comparator;

public class AlexAndTreasures {
    public static void main(String[] args) {
        int[][] a = { {1, 2}, {1, 4}, {-1, 0}};
        int b = 2;

        int[][] ans = solve(a, b);
        System.out.println(Arrays.deepToString(ans));
    }
    public static int[][] solve (int[][] a, int b) {
          // O(NLogN) time | O(b) space

        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int dist1 = o1[0]*o1[0] + o1[1]*o1[1];
                int dist2 = o2[0]*o2[0] + o2[1]*o2[1];

                return dist2 - dist1;
            }
        });

        int[][] k = new int[b][2];

        System.out.println(Arrays.deepToString(a));

        for (int i = 0;  i < b; i++) {
            k[i][0] = a[i][0];
            k[i][1] = a[i][1];
        }

        return k;
    }
}
