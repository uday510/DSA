package greedy;

import java.util.ArrayList;

public class Seats {
    public static void main(String[] args) {
        String A = "....x..xx...x..";

        int ans = solve(A);
        System.out.println(ans);
    }
    public static int solve(String A) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < A.length(); ++i) {
            char c = A.charAt(i);

            if (c != '.') list.add(i);
        }
        System.out.println(list);
        int m = list.size();
        int mid = m / 2;
        System.out.println(mid);
        int left = mid - 1, right = mid + 1, k = 1;
        int res = 0;

        while (left > -1) {
            res += list.get(mid) - k - list.get(left);
            --left;
            ++k;
        }
        k = 1;
        while (right < m) {
            res += list.get(right) - k - list.get(mid);
            ++right;
            ++k;
        }
       return res;
    }
}
