package bfs;

import java.util.*;

public class CutOffTrees {

    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static List<List<Integer>> forest;
    static int rows;
    static int cols;
    public int cutOffTree(List<List<Integer>> forest) {

        List<int[]> trees = new ArrayList<>();
        rows = forest.size();
        cols = forest.getFirst().size();
        CutOffTrees.forest = forest;

        for (int i = 0; i < forest.size(); ++i) {
            for (int j = 0; j < forest.get(i).size(); ++j) {
                int curr = forest.get(i).get(j);
                if (curr > 1) {
                    trees.add(new int[]{i, j, curr});
                }
            }
        }

        trees.sort((o1, o2) -> o1[2] - o2[2]);
        int cnt = 0;
        int[] start = {0, 0};
        for (int[] tree : trees) {
            int count = bfs(tree, start);
            if (count == -1) return -1;
            cnt += count;
            start = new int[]{tree[0], tree[1]};
        }

        return cnt;
    }

    private int bfs(int[] tree, int[] end) {
        Set<String> seen = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();
        seen.add(tree[0] + "_" + tree[1]);

        queue.offer(new int[]{tree[0], tree[1], 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            if (curr[0] == end[0] && curr[1] == end[1]) {
                return curr[2];
            }

            for (int[] dir : dirs) {
                int R = dir[0] + curr[0];
                int C = dir[1] + curr[1];
                int N = curr[2] + 1;
                String K = R + "_" + C;

                if (R < 0 || R >= rows || C < 0 || C >= cols || seen.contains(K) || forest.get(R).get(C) < 1) {
                    continue;
                }

                seen.add(K);

                queue.offer(new int[]{R, C, N});
            }
        }

        return -1;
    }

}
