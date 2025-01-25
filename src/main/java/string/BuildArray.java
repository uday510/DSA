package string;

import java.util.*;

public class BuildArray {
    public static void main(String[] args) {
        int[] target = {4, 5};
        int n = 5;

        System.out.println(buildArray(target, n));
    }
    public static List<String> buildArray(int[] target, int n) {
        ArrayList<String> res = new ArrayList<>();
        int N = target.length;
        int idx = 0;
        for (int i = 1; i <= n && idx < N ; ++i) {
            if (target[idx] == i) {
                res.add("Push");
                idx++;
                continue;
            }
            res.add("Push");
            res.add("Pop");

        }
        return res;
    }
}
