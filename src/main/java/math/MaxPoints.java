import java.util.HashMap;
import java.util.Map;

public static void main(String[] args) {
    int[][] points = {{1, 1}, {2, 2}, {3, 3}};
    System.out.println(maxPoints(points));
}

private static int maxPoints(int[][] points) {

    int max = 1;
    int N = points.length;

    for (int i = 0; i < N; ++i) {
        int[] p1 = points[i];
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = i + 1; j < N; ++j) {
            int[] p2 = points[j];

            int slope;
            if (p1[0] == p2[0]) {
                slope = Integer.MAX_VALUE;
                if (p1[1] == p2[1]) {
                    slope = 0;
                }
            } else {
                slope = (p1[1] - p2[1]) / (p1[0] - p2[0]);
            }
            map.put(slope, map.getOrDefault(slope, 0) + 1);

            max = Math.max(max, map.get(slope) + 1); // +1 for the current point
        }
    }

    return max;
}
