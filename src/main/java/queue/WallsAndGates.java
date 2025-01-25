package queue;/*
You are given an m x n grid rooms initialized with these three possible values.

-1 A wall or an obstacle.
0 A gate.
INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to
represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate,
it should be filled with INF.

Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
Example 2:

Input: rooms = [[-1]]
Output: [[-1]]


Constraints:

m == rooms.length
n == rooms[i].length
1 <= m, n <= 250
rooms[i][j] is -1, 0, or 231 - 1.

 */
//package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    private static final int[][] directions = new int[][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
    public static void main(String[] args) {
        int[][] rooms = {{2147483647,-1,0,2147483647},
                         {2147483647,2147483647,2147483647,-1},
                         {2147483647,-1,2147483647,-1},
                         {0,-1,2147483647,2147483647}};

        wallsAndGates(rooms);

        for(int i=0; i<rooms.length; i++) {
            for(int j=0; j<rooms[0].length; j++) {
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;

        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rooms[i][j] == 0) {
                    queue.add(new Pair(i, j, 0));
                    visited[i][j] = true;
                }

            }
        }

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int x = p.x;
            int y = p.y;
            int dist = p.dist;

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY] || rooms[newX][newY] == -1) {
                    continue;
                }

                rooms[newX][newY] = Math.min(rooms[newX][newY], dist + 1);
                queue.add(new Pair(newX, newY, dist + 1));
                visited[newX][newY] = true;

            }
        }

    }
    static class Pair {
        int x;
        int y;
        int dist;

        Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
