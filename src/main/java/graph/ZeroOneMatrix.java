/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is
 *
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 */
package graph;

import java.util.Queue;

public class ZeroOneMatrix {
    static int[][] directions = new int[][] {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };
    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] res = updateMatrix(mat);
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] updateMatrix(int[][] A) {
        int[][] res = new int[A.length][A[0].length];

        Queue<Edge> queue = new java.util.LinkedList<>();

        boolean[][] visited = new boolean[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0 ; j < A[0].length; j++) {
                if (A[i][j] == 0) queue.add(new Edge(i, j, 0));
            }
        }

        while (!queue.isEmpty()) {
            Edge e = queue.poll();

            if (A[e.x][e.y] == 0) {
                res[e.x][e.y] = 0;
            } else {
                res[e.x][e.y] = e.dist;
            }

            for (int[] dir : directions) {
                int x = e.x + dir[0];
                int y = e.y + dir[1];

                if (x < 0 || x >= A.length || y < 0 || y >= A[0].length || visited[x][y]) continue;

                visited[x][y] = true;
                queue.add(new Edge(x, y, e.dist + 1));
            }
        }
        return res;
    }
    static class Edge {
        int x;
        int y;
        int dist;
        public Edge(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
