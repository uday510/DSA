package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestObstacleCourseAtEachPosition {

    public static void main(String[] args) {
        int[] obstacles = {1,2,3,2};

        int[] result = longestObstacleCourseAtEachPosition(obstacles);

        System.out.println(Arrays.toString(result));
    }
    public static int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
//        int len = obstacles.length;
//        int[] result = new int[len];
//
//        for (int right = 0; right < len; ++right) {
//            result[right] = 1;
//            for (int left = 0; left < right; ++left) {
//                if (obstacles[left] <= obstacles[right]) {
//                    result[right] = Math.max(result[right], result[left] + 1);
//                }
//            }
//        }
//        return result;

        int len = obstacles.length;
        int[] result = new int[len];
        List<Integer> lis = new ArrayList<>();

        for (int idx = 0; idx < len; ++idx) {
            int obstacle = obstacles[idx];

            if (lis.isEmpty() || obstacle >= lis.getLast()) {
                lis.add(obstacle);
                result[idx] = lis.size();
            } else {
                int j = bs(lis, obstacle);
                lis.set(j, obstacle);
                result[idx] = j + 1;
            }
        }
        return result;
    }

    private static int bs(List<Integer> lis, int num) {
        int left = 0;
        int right = lis.size();

        while (left < right) {
            int mid = (left + right) >> 1;

            if (lis.get(mid) <= num)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }
}
