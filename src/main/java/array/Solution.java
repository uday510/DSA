package array;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] array = {1, 4, 2, -2, -9, 10, 2, 12, 2, -4, -4, -4, 2, 6, 7};

        List<int[]> res = solve(array);
        for (int[] li : res) {
            System.out.println("INDEX -> " +  li[0] + " PEAK -> " + li[1]);
        }
    }

    public static List<int[]> solve(int[] array) {
        List<int[]> output = new ArrayList<>();
        int N = array.length;
        int peak = array[0];
        int index = 0;
        for (int x = 1; x < N-1; ++x) {
            if (array[x] * array[x - 1] > 0) {
                if (peak < 0 && array[x] < peak) {
                    peak = array[x];
                    index = x;
                }
                if (peak >= 0 && array[x] > peak) {
                    peak = array[x];
                    index = x;
                }
            } else {
                output.add(new int[]{index, peak});
                peak = array[x];
                index = x;
            }
        }
        return output;
    }
}
