package greedy;

public class RemoveDigits {
    public String removeDigit(String number, char digit) {
        String str = "";
        int len = number.length();

        for (int idx = 0; idx < len; ++idx) {
            if (number.charAt(idx) != digit) continue;

            StringBuilder sb = new StringBuilder();

            sb.append(number, 0, idx);
            sb.append(number, idx + 1, len);

            String curr = sb.toString();

            if (curr.compareTo(str) > 0) {
                str = curr;
            }

        }

        return str;
    }
}
