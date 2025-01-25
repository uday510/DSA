package bfs;

import java.util.*;

public class SnakesAndLadders {
    public static void main(String[] args) {
        int[][] board = {
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 35, -1, -1, 13, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 15, -1, -1, -1, -1}
        };
        System.out.println(snakesAndLadders(board));
    }
    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        Map<Integer, int[]> positionMap = createPositionMap(board, n);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        Set<Integer> visited = new HashSet<>();
        visited.add(1);

        int moves = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ++moves;

            for (int i = 0; i < levelSize && !queue.isEmpty(); ++i) {
                int currentPosition = queue.poll();

                for (int nextMove = 1; nextMove <= 6; ++nextMove) {
                    int nextPosition = currentPosition + nextMove;

                    if (nextPosition > n * n) {
                        break;
                    }

                    if (visited.contains(nextPosition)) {
                        continue;
                    }

                    visited.add(nextPosition);
                    int[] nextCoordinates = positionMap.get(nextPosition);
                    int row = nextCoordinates[0];
                    int col = nextCoordinates[1];

                    int finalPosition = board[row][col] == -1 ? nextPosition : board[row][col];

                    if (finalPosition == n * n) {
                        return moves;
                    }

                    queue.offer(finalPosition);
                }
            }
        }
        return -1;
    }
     private static Map<Integer, int[]> createPositionMap(int[][] board, int n) {
         Map<Integer, int[]> positionMap = new HashMap<>();
         int currentPosition = 1;
         boolean moveRight = true;

         for (int i = n - 1; i > -1; --i) {
             if (moveRight) {
                 for (int j = 0; j < n; ++j) {
                     positionMap.put(currentPosition++, new int[]{i, j});
                 }
             } else {
                 for (int j = n - 1; j > -1; --j) {
                     positionMap.put(currentPosition++, new int[]{i, j});
                 }
             }
             moveRight = !moveRight;
         }
         return positionMap;
     }
}
