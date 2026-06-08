package graph.shortest_path;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class TheMaze3 {

    private final static int[][] dirs = { {0, 1}, {0, -1}, {-1, 0}, {1, 0},  };
    private final static String[] pathDirs = {"r", "l", "u", "d"};
    private final static int UNKNOWN = Integer.MAX_VALUE;
    private final static String IMPOSSIBLE = "impossible";

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {

        Queue<State> pq = new PriorityQueue<>(
                (o1, o2) ->
                        o1.w != o2.w ? Integer.compare(o1.w, o2.w)
                                : o1.path.compareTo(o2.path)
        );

        int n = maze.length, m = maze[0].length;
        int[][] dists = new int[n][m];
        String[][] paths = new String[n][m];

        for (int[] r : dists) {
            Arrays.fill(r, UNKNOWN);
        }

        paths[ball[0]][ball[1]] = "";
        dists[ball[0]][ball[1]] = 0;
        pq.offer(new State(ball[0], ball[1], 0, ""));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int x = cur.x, y = cur.y, w = cur.w;
            String path = cur.path;

            if (x == hole[0] && y == hole[1]) return path;

            if (dists[x][y] < w) continue;

            for (int i = 0; i < dirs.length; i++) {
                int[] dir = dirs[i];
                int nx = dir[0], ny = dir[1];
                int cnt = 0;


                while (
                        nx > -1 && nx < n &&
                                ny > -1 && ny < m &&
                                maze[nx][ny] == 0
                ) {

                    nx += dir[0];
                    ny += dir[1];
                    cnt++;

                    if (nx == hole[0] && ny == hole[1]) {
                        break;
                    }

                }

                String newPath = path + pathDirs[i];
                int w1 = w + cnt;

                if (
                        w1 < dists[nx][ny] || (w1 == dists[nx][ny] && (paths[nx][ny] == null || paths[nx][ny].compareTo(newPath) < 0))
                ) {
                    dists[nx][ny] = w1;
                    paths[nx][ny] = newPath;
                    pq.offer(new State(nx, ny, w1, newPath));
                }
            }
        }

        return IMPOSSIBLE;
    }


}

class State {
    final int x;
    final int y;
    final int w;
    final String path;

    public State(int x, int y, int w, String path) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.path = path;
    }

}
