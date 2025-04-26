package stack;

public class RemoveKDigits {

    String ans;

    public String removeKdigits(String num, int k) {
        return bruteForce(num, k);
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
