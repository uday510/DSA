package string;

public class StringToInteger {

    private final int MAX = Integer.MAX_VALUE;
    private final int MIN = Integer.MIN_VALUE;

    public int myAtoi(String s) {
        int i = 0, sign = 1, n = s.length();
        long num = 0;

        while (i < n && s.charAt(i) == ' ') i++;

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i++) == '-') sign = -1;
        }

        while (i < n && s.charAt(i) == '0') i++;

        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            num = num * 10 + s.charAt(i) - '0';

            if (sign == 1 && num > MAX) return MAX;
            if (sign == -1 && -num < MIN) return MIN;
            i++;
        }

        return sign * (int) num;
    }
}
