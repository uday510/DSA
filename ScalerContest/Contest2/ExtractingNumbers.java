package ScalerContest.Contest2;

public class ExtractingNumbers {
    public static void main(String[] args) {
        String str = "a12b34c";
        long ans = solve(str);
        System.out.println(ans);
    }
    public static long solve(String A) {
        long ans = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) >= '0' && A.charAt(i) <= '9') {
                long val = 0;
                while (i < A.length() && A.charAt(i) >= '0' && A.charAt(i) <= '9') {
                    int digit = A.charAt(i) - '0';
                    val = val * 10 + digit;
                    i++;
                }
                ans += val;
            }
        }
        return ans;
    }
}
