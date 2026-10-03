package binarylifting;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/path-existence-queries-in-a-graph-ii/?envType=daily-question&envId=2026-07-10
public class PathExistence2 {

    public int[] pathExistenceQueries(int n, int[] arr, int maxDiff, int[][] queries) {

        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = arr[i];
            pairs[i][1] = i;
        }

        Arrays.sort(pairs, (Comparator.comparingInt(o -> o[0])));

        int[] pos = new int[n];
        int[] vals = new int[n];
        for (int i = 0; i < n; i++) {
            vals[i] = pairs[i][0];
            pos[pairs[i][1]] = i;
        }

        int[] brk = new int[n];
        for (int i = 1; i < n; i++) {
            brk[i] = brk[i - 1] + ((vals[i] - vals[i - 1] > maxDiff) ? 1 : 0);
        }

        int LOG = 32 - Integer.numberOfLeadingZeros(n);
        int[][] up = new int[LOG][n];

        int j = 0;
        for (int i = 0; i < n; i++) {
            j = Math.max(j, i);
            while (j + 1 < n && vals[j + 1] - vals[i] <= maxDiff) j++;
            up[0][i] = j;
        }

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                int mid = up[k - 1][i];
                up[k][i] = up[k - 1][mid];
            }
        }

        int m = queries.length;
        int[] res = new int[m];
        for (int q = 0; q < m; q++) {
            int u = pos[queries[q][0]];
            int v = pos[queries[q][1]];

            if (u < v) {
                int tmp = u;
                u = v;
                v = tmp;
            }

            if (u == v) {
                res[q] = 0;
                continue;
            }

            if (brk[u] - brk[v] > 0) {
                res[q] = -1;
                continue;
            }

            int steps = 0, cur = v;
            for (int k = LOG - 1; k > -1; k--) {
                if (up[k][cur] < u) {
                    cur = up[k][cur];
                    steps += 1 << k;
                }
            }

            res[q] = steps + 1;

        }

        return res;
    }

}
