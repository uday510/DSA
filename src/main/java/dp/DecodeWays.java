package dp;

import java.util.Map;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "2125";

        int res = numDecodings(s);
        System.out.println(res);
    }
    public static int numDecodings(String s) {
//        Map<Integer, Integer> memo = new HashMap<>();
//        return recursiveWithMemo(0, s, memo);
        if (s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int twoBack = 1;
        int oneBack = 1;
        for (int i = 1; i < n; ++i) {
            int current = 0;
            if (s.charAt(i) != 0) {
                current = oneBack;
            }
            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += twoBack;
            }
            twoDigit = oneBack;
            oneBack = current;
        }
        return oneBack;
    }

    public static int recursiveWithMemo(int index, String s, Map<Integer, Integer> memo) {
        // O(N) time | O(N) space
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (index == s.length() - 1) {
            return 1;
        }
        int res = recursiveWithMemo(index+1, s, memo);
        if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            res += recursiveWithMemo(index + 2, s, memo);
        }
        memo.put(index, res);
        return res;
    }
}
