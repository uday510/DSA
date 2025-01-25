package string;

public class StringToInteger {
    public static void main(String[] args) {
        String str = "123";
    }

    public static int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int i = 0;

        // remove leading and trailing whitespaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // check sign
        int sign = 1;

        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '+' ? 1 : -1;
            i++;
        }

        // convert number and avoid overflow

        int num = 0;

        while (i < s.length()) {
            int digit = s.charAt(i) - '0';

            if (digit < 0 || digit > 9) {
                break;
            }

            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            num = num * 10 + digit;
            i++;
        }

        return num * sign;

    }
}
