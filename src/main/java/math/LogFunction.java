package math;

import java.util.Arrays;

public class LogFunction {
    public static void main(String[] args) {
        int a = 10;

        int[] ans = solve(a);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int n) {
        int[] log2 = new int[n + 1];
        int currLogAnswer = -1;
        int currPower2 = 1;
        for (int i = 1; i <= n; i++) {
            if (currPower2 == i) {
                currLogAnswer++;
                currPower2 *= 2;
            }
            log2[i] = currLogAnswer;
        }
        return log2;
    }
}
