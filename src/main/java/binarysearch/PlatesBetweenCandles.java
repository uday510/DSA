package binarysearch;

import java.util.Arrays;

public class PlatesBetweenCandles {
    public static void main(String[] args) {
        String s = "**|**|***|";
        int[][] queries = {{2,5},{5,9}};

        System.out.println(platesBetweenCandles(s, queries));
    }
    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int N = s.length();
        int[] pf = new int[N];
        int plates = 0;

        if (s.charAt(0) == '|') pf[0] = 1;

        for (int i = 1; i < N; ++i) {
            if (s.charAt(i) == '|') {
                pf[i] = pf[i-1] + 1;
            } else {
                pf[i] = pf[i-1];
            }
        }
        System.out.println(Arrays.toString(pf));

        for (int[] q : queries) {
            int candles = pf[q[1]] - pf[q[0]];
        }


        return new int[]{};
    }
}
