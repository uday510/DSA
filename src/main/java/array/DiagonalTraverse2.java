package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraverse2 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> groups = new HashMap<>();

        int n = 0;
        for (int i = nums.size() - 1; i > -1; --i) {
            for (int j = 0; j < nums.get(i).size(); ++j) {
                int diagonal = i+j;
                if (!groups.containsKey(diagonal)) {
                    groups.put(diagonal, new ArrayList<>());
                }
                groups.get(diagonal).add(nums.get(i).get(j));
                n++;
            }
        }
        int[] res = new int[n];
        int diagonal = 0;
        int index = 0;

        while (groups.containsKey(diagonal)) {
            for (int val : groups.get(diagonal)) {
                res[index++] = val;
            }
            diagonal++;
        }
        return res;
    }
}
