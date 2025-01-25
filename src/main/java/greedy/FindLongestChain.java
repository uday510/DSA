package greedy;

import java.util.Arrays;

public class FindLongestChain {
    public static void main(String[] args) {
        int[][] pairs = {{1,2}, {2,3}, {3,4}};
        System.out.println(findLongestChain(pairs));
    }
    public static int findLongestChain(int[][] pairs) {

        int n = pairs.length;
        int res = 0;

        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int curr = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            if(curr < pairs[i][0]) {
                curr = pairs[i][1];
                res++;
            }
        }

        return res;

    }
}
