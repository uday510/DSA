package array;

public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };
        gameOfLife(board);
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(STR."\{cell} ");
            }
            System.out.println();
        }
    }
    static int[][] dirs = {
            {0, 1}, // right
            {0, -1}, // left
            {1, 0}, // down
            {-1, 0}, // up
            {1, 1}, // down right
            {1, -1}, // down left
            {-1, 1}, // up right
            {-1, -1} // up left
            };
    private static void gameOfLife(int[][] board) {
        int M = board.length;
        int N = board[0].length;
        int[][] copy = new int[M][N];

        for (int i = 0; i < M; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, N);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int live = 0;
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && x < M && y >= 0 && y < N && copy[x][y] == 1) {
                        live++; // count live neighbors
                    }
                }
                if (copy[i][j] == 1) { // live cell
                    if (live < 2 || live > 3) { // die
                        board[i][j] = 0; // die
                    }
                } else {
                    if (live == 2 || live == 3) { // live
                        board[i][j] = 1; // if dead cell has 3 live neighbors, it becomes live
                    }
                }
            }
        }
    }
}
