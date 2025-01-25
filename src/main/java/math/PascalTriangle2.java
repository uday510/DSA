package math;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);

        for (int i = 0; i < rowIndex; ++i) {
//            for (int j = i; j > 0; --j) {
//                res.set(j, res.get(j) + res.get(i-1));
//            }
//            res.add(1);
        }
        return res;
    }
}
