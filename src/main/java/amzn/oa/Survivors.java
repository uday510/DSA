package amzn.oa;

import java.util.*;

public class Survivors {

    public static void main(String[] args) {
        int[] arr = {1, 6,2, 7, 2};

       int[] result = findSurvivors(arr.length, arr);
       System.out.println(Arrays.toString(result));
    }

    // https://leetcode.com/discuss/post/6516892/amazon-oa-by-anonymous_user-128m/
    //https://leetcode.com/discuss/post/6517334/amazon-oa-test-sde-ii-by-mr_shah-daz3/
    private static int[] findSurvivors(int n, int[] robots) {
        Integer[] idx = new Integer[n];

        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (i, j) -> Integer.compare(robots[j], robots[i]));

        int sum = Arrays.stream(robots).sum();
        List<Integer> result = new ArrayList<>();

        for (int i : idx) {
            result.add(i + 1);
            sum -= robots[i];

            if (sum < robots[i]) {
                break;
            }
        }

        Collections.sort(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
