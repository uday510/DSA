package graph.bfs;

import java.util.*;

// https://leetcode.com/problems/water-and-jug-problem/
public class WaterAndJugProblem {

    public boolean canMeasureWater(int x, int y, int target) {
        if (target > x + y) return false;

        if (target == 0 || x + y == target || x == target || y == target) return true;

        Set<String> vis = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();

        vis.add(getKey(0, 0));
        queue.offer(new int[] {0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dx = cur[0], dy = cur[1];

            if (dx + dy == target || dx == target || dy == target) return true;

            List<int[]> states = new ArrayList<>();

            states.add(new int[] {x, dy});
            states.add(new int[] {dx, y});

            states.add(new int[] {dx, 0});
            states.add(new int[] {0, dy});

            int xy = Math.min(dx, y - dy);
            states.add(new int[] {dx - xy, dy + xy});

            int yx = Math.min(x - dx, dy);
            states.add(new int[] {dx + yx, dy - yx});

            for (int[] s : states) {
                if (vis.add(getKey(s[0], s[1]))) {
                    queue.offer(s);
                }
            }
        }

        return false;
    }

    private String getKey(int x, int y) {
        return x + "-" + y;
    }

}
