package dfs;

import java.util.HashMap;
import java.util.Map;

public class SlidingPuzzle {
    public static void main(String[] args) {
        int[][] board = {{1, 2, 3}, {4, 0, 5}};
        System.out.println(slidingPuzzle(board));
    }

    static int[][] DIRs;
    static StringBuilder START;
    static String END;
    static Map<String, Integer> vis;
    static int slidingPuzzle(int[][] board) {
        initialize(board);

        dfs(START.toString(), START.indexOf("0"), 0);

        return vis.getOrDefault(END, -1);
    }
    private static void dfs(String currStr, int currPos, int currMov) {

        if (vis.containsKey(currStr) && vis.get(currStr) < currMov + 1) {
            return;
        }

        vis.put(currStr, currPos);

        for (int nextPos : DIRs[currPos]) {
            String nextStr = swap(currStr, currPos, nextPos);

            dfs(nextStr, nextPos, currMov + 1);
        }
    }
    private static String swap(String string, int idx1, int idx2) {
        StringBuilder stringBuilder = new StringBuilder(string);

        stringBuilder.setCharAt(idx1, string.charAt(idx2));
        stringBuilder.setCharAt(idx2, string.charAt(idx1));

        return stringBuilder.toString();
    }

    static void initialize(int[][] board) {
        DIRs = new int[][] {
                {1, 3},
                {0, 2, 3},
                {1, 5},
                {0, 4},
                {3, 5, 1},
                {2, 4}
        };
        END = "123450";
        vis = new HashMap<>();
        START = new StringBuilder();

        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                START.append(board[i][j]);
            }
        }

    }
}
