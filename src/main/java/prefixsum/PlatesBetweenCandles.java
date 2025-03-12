package prefixsum;

import java.util.Arrays;

public class PlatesBetweenCandles {

    public static void main(String[] args) {

        int[] result = platesBetweenCandles("**|**|***|", new int[][]{{2, 5}, {5, 9}});
        System.out.println(Arrays.toString(result));
    }

    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int len = s.length();
        int[] leftMost = new int[len];
        int[] rightMost = new int[len];
        int[] prefix = new int[len];
        int[] result = new int[queries.length];
        int last = -1;
        int count = 0;

        for (int idx = 0; idx < len; ++idx) {
            if (s.charAt(idx) == '|') last = idx;
            leftMost[idx] = last;
        }

        last = -1;
        for (int idx = len - 1; idx > -1; --idx) {
            if (s.charAt(idx) == '|') last = idx;
            rightMost[idx] = last;
        }

        for (int idx = 0; idx < len; ++idx) {
            if (s.charAt(idx) == '*') count++;
            prefix[idx] = count;
        }

        for (int idx = 0; idx < queries.length; ++idx) {
            int[] query = queries[idx];
            int left = rightMost[query[0]];
            int right = leftMost[query[1]];

            result[idx] = (left != -1 && right != -1 && left < right) ? prefix[right] - (left == 0 ? 0 : prefix[left - 1]) : 0;
        }

        return result;
    }
}
