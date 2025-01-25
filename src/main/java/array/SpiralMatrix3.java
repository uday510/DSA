package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix3 {
    public static void main(String[] args) {
        int[][] res = spiralMatrixIII(5, 6, 1, 4);
        for (int[] r : res) {
            System.out.println(r[0] + " " + r[1]);
        }
    }
    private static int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        List<int[]> result = new ArrayList<>();
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Add the starting point
        result.add(new int[]{r0, c0});

        if (R * C == 1) {
            return result.toArray(new int[1][2]);
        }

        int step = 1;
        int dirIndex = 0;

        while (result.size() < R * C) {
            // Two directions per cycle (right, down, left, up)
            for (int i = 0; i < 2; ++i) {
                // Number of steps in this direction
                for (int s = 0; s < step; ++s) {
                    r0 += directions[dirIndex][0];
                    c0 += directions[dirIndex][1];

                    // Check if the new point is inside the grid
                    if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) {
                        result.add(new int[]{r0, c0});
                    }
                }
                // Move to the next direction (right -> down -> left -> up)
                dirIndex = (dirIndex + 1) % 4;
            }
            // After two directions, the number of steps increase
            ++step;
        }
        return result.toArray(new int[R * C][2]);
    }
}
