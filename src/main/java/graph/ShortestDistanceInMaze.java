/**
 * Problem Description
 * Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls.
 *
 * 1 represents a wall in a matrix and 0 represents an empty location in a wall.
 *
 * There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall (maze boundary is also considered as a wall). When the ball stops, it could choose the next direction.
 *
 * Given two array of integers of size B and C of size 2 denoting the starting and destination position of the ball.
 *
 * Find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the starting position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
 *
 *
 *
 * Problem Constraints
 * 2 <= N, M <= 100
 *
 * 0 <= A[i] <= 1
 *
 * 0 <= B[i][0], C[i][0] < N
 *
 * 0 <= B[i][1], C[i][1] < M
 *
 *
 *
 * Input Format
 * The first argument given is the integer matrix A.
 *
 * The second argument given is an array of integer B.
 *
 * The third argument if an array of integer C.
 *
 *
 *
 * Output Format
 * Return a single integer, the minimum distance required to reach destination
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [ [0, 0],
 *       [0, 0] ]
 * B = [0, 0]
 * C = [0, 1]
 * Input 2:
 *
 * A = [ [0, 1],
 *       [1, 0] ]
 * B = [0, 0]
 * C = [1, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  -1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Go directly from start to destination in distance 1.
 * Explanation 2:
 *
 *  It is impossible to reach the destination from (0, 0) to (1, 1) as there are walls at (1, 0) and (0, 1)
 */
package graph;

import java.util.*;

public class ShortestDistanceInMaze {
    private static final int[][] directions =
            new int[][] { {-1, 0}, {0, -1}
                        , {1, 0}, {0, 1} };
    public static void main(String[] args) {
        int[][] grid = new int[][] { {0, 0, 0}
                , {1, 1, 0}
                , {1, 1, 0} };
        int[] start = new int[] {0, 0};
        int[] end = new int[] {2, 2};
        System.out.println(shortestDistance(grid, start, end));
    }
    public static int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] distance = new int[maze.length][maze[0].length]; // distance[i][j] = min distance from start to (i, j)
        for (int[] row: distance) {
            Arrays.fill(row, Integer.MAX_VALUE); // set all distance to be max value
        }

        distance[start[0]][start[1]] = 0; // set start distance to be 0
        dfs(maze, start, distance); // dfs to find min distance
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }
    public static void dfs(int[][] maze, int[] start, int[][] distance) {
        int[][] dirs={{0,1}, {0,-1}, {-1,0}, {1,0}}; // four directions
        for (int[] dir: dirs) { // for each direction
            int x = start[0] + dir[0];
            int y = start[1] + dir[1];
            int count = 0;
            while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) { // while not hit wall
                x += dir[0];
                y += dir[1];
                count++;
            }
            if (distance[start[0]][start[1]] + count < distance[x - dir[0]][y - dir[1]]) { // if new distance is smaller
                distance[x - dir[0]][y - dir[1]] = distance[start[0]][start[1]] + count;
                dfs(maze, new int[]{x - dir[0],y - dir[1]}, distance);
            }
        }
    }
}
