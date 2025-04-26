package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {

    String ans;

    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > ch) {
                k--;
                stack.pollLast();
            }

            stack.offerLast(ch);
        }

        while (!stack.isEmpty() && k > 0) {
            stack.pollLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) sb.append(stack.pollFirst());

        while (!sb.isEmpty() && sb.charAt(0) == '0') sb.deleteCharAt(0);

        return sb.isEmpty() ? "0" : sb.toString();
    }

    private String bruteForce(String num, int k) {
        ans = num;
        if (k == num.length()) return "0";
        dfs(0, num, new StringBuilder(), num.length(), k);
        if (ans.startsWith("0")) {
            int idx = 0;
            while (idx < ans.length() && ans.charAt(idx) == '0') idx++;
            ans = ans.substring(idx);
        }

        return ans.isEmpty() ? "0" : ans;
    }


    private void dfs(int i, String s, StringBuilder sb, int n, int k) {
        if (sb.length() > n - k) return;
        if (sb.length() == n - k) {
            if (!sb.isEmpty() && sb.toString().compareTo(ans) < 0) {
                ans = sb.toString();
            }
            return;
        }

        for (int idx = i; idx < n; ++idx) {
            sb.append(s.charAt(idx));
            dfs(idx + 1, s, sb, n, k);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
