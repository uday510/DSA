package array;

public class FindWinnerOnTicTacToeGame {

    private int[][] b;
    private int n = 3;

    public String tictactoe(int[][] moves) {
        b = new int[n][n];
        int player = 1;

        for (int[] m : moves) {

            int r = m[0], c = m[1];

            b[r][c] = player;

            if (checkRow(r, player) ||
                    checkCol(c, player) ||
                    (r == c && checkDiag(player)) ||
                    (r + c == n - 1 && checkAntiDiag(player))
            ) {
                return player == 1 ? "A" : "B";
            }

            player *= -1;
        }

        return moves.length != n * n ? "Pending" : "Draw";
    }

    private boolean checkRow(int r, int p) {
        for (int c = 0; c < n; c++) {
            if (b[r][c] != p) return false;
        }
        return true;
    }

    private boolean checkCol(int c, int p) {
        for (int r = 0; r < n; r++) {
            if (b[r][c] != p) return false;
        }
        return true;
    }

    private boolean checkDiag(int p) {
        for (int r = 0; r < n; r++) {
            if (b[r][r] != p) return false;
        }
        return true;
    }

    private boolean checkAntiDiag(int p) {
        for (int r = 0; r < n; r++) {
            if (b[r][n-r-1] != p) return false;
        }
        return true;
    }

}
