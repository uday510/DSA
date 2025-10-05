package array;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        Set<Character>[] rows = new HashSet[N];
        Set<Character>[] cols = new HashSet[N];
        Set<Character>[] boxes = new HashSet[N];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;

                int boxIdx = (r / 3) * 3 + (c / 3);
                if (!rows[r].add(ch) || !cols[c].add(ch) || !boxes[boxIdx].add(ch))
                    return false;
            }
        }

        return true;
    }

}
