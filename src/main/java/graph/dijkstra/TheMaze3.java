package graph.dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheMaze3 {

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int[][] dirs = { {0, 1}, {0, -1}, {-1, 0}, {1, 0} };
        String[] pathDirs = { "r", "l", "u", "d" };
        int m = maze.length, n = maze[0].length;
        int[][] dists = new int[m][n];
        String[][] paths = new String[m][n];
        int INF = (int) 1e9;
        for (int[] row : dists) Arrays.fill(row, INF);
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> a.dist != b.dist ? Integer.compare(a.dist, b.dist) : a.path.compareTo(b.path));
        pq.offer(new State(ball[0], ball[1], 0, ""));
        paths[ball[0]][ball[1]] = "";
        dists[ball[0]][ball[1]] = 0;

        while (!pq.isEmpty()) {
            State state = pq.poll();

            if (state.row == hole[0] && state.col == hole[1]) return state.path;

            if (dists[state.row][state.col] < state.dist) continue;

            for (int i = 0; i < 4; ++i) {
                int[] dir = dirs[i];
                int r = state.row, c = state.col;
                int cnt = 0;
                while (
                        r + dir[0] >= 0 && r + dir[0] < m &&
                        c + dir[1] >= 0 && c + dir[1] < n &&
                        maze[r + dir[0]][c + dir[1]] == 0
                ) {
                    r += dir[0];
                    c += dir[1];
                    cnt++;

                    if (r == hole[0] && c == hole[1]) break;
                }

                String newPath = state.path + pathDirs[i];
                int d = cnt + state.dist;

                if (d < dists[r][c] ||
                        (d == dists[r][c] && (paths[r][c] == null || paths[r][c].compareTo(newPath) > 0))
                ) {
                    dists[r][c] = d;
                    paths[r][c] = newPath;

                    pq.offer(new State(r, c, d, newPath));
                }
            }


        }

        return "impossible";
    }

    class State {
        int row;
        int col;
        int dist;
        String path;

        State (int row, int col, int dist, String path) {
            this.row = row;
            this.col = col;
            this.dist = dist;
            this.path = path;
        }
    }
}
