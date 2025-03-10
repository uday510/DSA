package heap;

import java.util.*;

public class Survivors {

    public static void main(String[] args) {
        int[] arr = {1, 6,2, 7, 2};

       int[] result = findSurvivors(arr.length, arr);
       System.out.println(Arrays.toString(result));
    }

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
